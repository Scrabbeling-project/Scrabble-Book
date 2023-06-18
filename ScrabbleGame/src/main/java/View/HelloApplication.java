package View;

import java.net.*;
import java.util.Enumeration;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;


import java.io.IOException;
import java.net.InetAddress;
import java.util.Optional;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        // Create a welcome message
        Text welcomeText = new Text("Welcome to Scrabble!");
        welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        welcomeText.setStyle("-fx-fill: black; -fx-font-weight: bold; -fx-alignment: center;");

        // Create a button to start a new game as a Host
        Button newGameHostButton = new Button("New Game Host");
        newGameHostButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));


        // Set an action for the newGameHostButton
        newGameHostButton.setOnAction(event -> {

            Enumeration<NetworkInterface> interfaces = null;
            try {
                interfaces = NetworkInterface.getNetworkInterfaces();
            } catch (SocketException e) {
                throw new RuntimeException(e);
            }
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                try {
                    if (iface.isLoopback() || !iface.isUp())
                        continue;
                } catch (SocketException e) {
                    throw new RuntimeException(e);
                }
                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (addr.getHostAddress().indexOf(":") > -1) // IPv6
                        continue;
//                    System.out.println("IP address: " + addr.getHostAddress()); // check mi ip wifi address
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("New Game Host");
                    alert.setHeaderText(null);
                    alert.setContentText("Your IP address is: " + addr.getHostAddress() + "\n\nClick OK to start the server.");
                    alert.showAndWait();
                }

            }


        });


        // Create a button to start a new game as a guest
        Button newGameGuestButton = new Button("New Game Guest");
        askForIp(newGameGuestButton);


        // Create a button to start a new multiplayer game
        Button multiplayerButton = new Button("Multiplayer");
        askForIp(multiplayerButton);


        // Create a horizontal box to hold the buttons
        HBox buttonBox = new HBox(newGameHostButton, newGameGuestButton, multiplayerButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(20);

        // Create a border pane to hold the welcome message and buttons
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(welcomeText);
        borderPane.setCenter(buttonBox);

        // Set the background image
        Image backgroundImage = new Image("file:src/main/java/View/scrabblePhoto.jpg");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        borderPane.setBackground(new Background(background));

        // Create a text object to display the credits
        Text creditsText = new Text("By Tal, Shay, Ori");
        creditsText.setFont(Font.font("Arial", FontWeight.BOLD, 21));
        creditsText.setStyle("-fx-fill: yellow; -fx-font-weight: bold; -fx-alignment: center;");

        // Create a VBox to hold the credits text and align it to the left
        VBox creditsBox = new VBox(creditsText);
        creditsBox.setAlignment(Pos.BOTTOM_LEFT);
        creditsBox.setPadding(new Insets(0, 0, 10, 10)); // Add padding to the bottom and left

        // Add the credits VBox to the BorderPane
        borderPane.setBottom(creditsBox);

        // Create a scene and set it on the stage
        Scene scene = new Scene(borderPane, 800, 600); // increase the size of the scene to fit the image
        primaryStage.setScene(scene);
        primaryStage.setTitle("Scrabble");
        primaryStage.show();


    }

    private void askForIp(Button ipButton) {
        ipButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        ipButton.setOnAction(e -> {
            // Create a dialog
            Dialog<Pair<String, Integer>> dialog = new Dialog<>();
            dialog.setTitle("Connect to Server");
            dialog.setHeaderText("Enter IP and Port");

            // Set the button types
            ButtonType connectButtonType = new ButtonType("Connect", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(connectButtonType, ButtonType.CANCEL);

            // Create the IP and port fields
            GridPane gridPane = new GridPane();
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            gridPane.setPadding(new Insets(20, 150, 10, 10));
            TextField ipField = new TextField();
            ipField.setPromptText("IP Address");
            TextField portField = new TextField();
            portField.setPromptText("Port");
            gridPane.add(new Label("IP Address:"), 0, 0);
            gridPane.add(ipField, 1, 0);
            gridPane.add(new Label("Port:"), 0, 1);
            gridPane.add(portField, 1, 1);

            // Enable/disable Connect button depending on whether both fields are filled in
            Node connectButton = dialog.getDialogPane().lookupButton(connectButtonType);
            connectButton.setDisable(true);
            ipField.textProperty().addListener((observable, oldValue, newValue) -> {
                connectButton.setDisable(newValue.trim().isEmpty() || portField.getText().trim().isEmpty());
            });
            portField.textProperty().addListener((observable, oldValue, newValue) -> {
                connectButton.setDisable(newValue.trim().isEmpty() || ipField.getText().trim().isEmpty());
            });

            dialog.getDialogPane().setContent(gridPane);

            // Convert the result to an IP/port pair when the Connect button is clicked
            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == connectButtonType) {
                    String ip = ipField.getText().trim();
                    int port = Integer.parseInt(portField.getText().trim());
                    return new Pair<>(ip, port);
                }
                return null;
            });

            Optional<Pair<String, Integer>> result = dialog.showAndWait();
            if (result.isPresent()) {
                // Connect to the server using the IP and port
                String ip = result.get().getKey();
                int port = result.get().getValue();
                // TODO: Connect to server using IP and port
            }
        });
    }
}

