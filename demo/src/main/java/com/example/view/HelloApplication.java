
///////////////////////////
package com.example.view;

        import model.backend.Client;
        import model.backend.Server;
        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.geometry.Insets;
        import javafx.geometry.Pos;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.layout.HBox;
        import javafx.scene.layout.VBox;
        import javafx.scene.text.Font;
        import javafx.stage.Stage;

        import java.io.IOException;

public class HelloApplication extends Application {

    // Constants
    private static final String GAME_TITLE = "Scrabble";
    private static final String BACKGROUND_IMAGE_PATH = "file:src/main/java/com/example/view/scrabble-background.jpg";
    private static final String BUTTON_STYLE = "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16pt;";
    private static final String BUTTON_STYLE_2 = "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16pt;";

    @Override
    public void start(Stage primaryStage) {
        // Load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // Create the main layout
        BorderPane root = new BorderPane();

        // Set the background image
        Image photo = new Image(BACKGROUND_IMAGE_PATH);
        ImageView photoView = new ImageView(photo);
        photoView.setFitWidth(500);
        photoView.setPreserveRatio(true);
        root.setLeft(photoView);

        // Create the title label and set its font
        Label titleLabel = new Label(GAME_TITLE);
        titleLabel.setFont(new Font("Arial", 36));
        Label middleTitleLabel = new Label("By Jonathan, Shay, Tal, Ori");
        middleTitleLabel.setFont(new Font("Arial", 22));

        root.setTop(titleLabel);
        root.setBottom(middleTitleLabel);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);
        BorderPane.setMargin(titleLabel, new Insets(20));

        // Create the button for starting a new game with one player
        Button singlePlayerButton = new Button("Against 1 player (Host)");
        singlePlayerButton.setStyle(BUTTON_STYLE);
        singlePlayerButton.setOnAction(e -> {
            try {
                // Start a new game with single player - host
                Server server = new Server(55558);
                // TODO: Handle starting a new game with single player
            } catch (Exception ex) {

                // TODO: Handle exception
            }
        });




        // Create the button for loading a saved game
        Button newGameButton_Guests = new Button("new game(guest)");
        newGameButton_Guests.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16pt;");
        newGameButton_Guests.setOnAction(e -> {
            // TODO: Handle starting a new game with 2-4 players

            try {
                // Start a new game with single player - guest
                Client client = new Client("localhost", 55559);

                // TODO: Handle starting a new game with single player
            } catch (Exception ex) {
                // TODO: Handle exception
            }
        });

        // Create the button for exiting the game
        Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16pt;");
        exitButton.setOnAction(e -> primaryStage.close());

        // Create the layout for the buttons
        HBox buttonBox = new HBox(20);
        buttonBox.getChildren().addAll(singlePlayerButton , newGameButton_Guests, exitButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Create the layout for the entire screen
        VBox centerBox = new VBox(20);
        centerBox.getChildren().addAll(buttonBox);
        centerBox.setAlignment(Pos.CENTER);
        root.setCenter(centerBox);

        // Create the scene and show the stage
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Scrabble");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

        public static void main (String[]args){
            launch(args);
        }
    }

