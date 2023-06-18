package com.example.demo;

import Backend.Tile;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.layout.VBox;

import java.util.Random;


public class ScrabbleGameUI extends Application {

    private Button[] tileButtons;

    private static final int BOARD_SIZE = 15;
    private static final int TILE_SIZE = 40;
    private Label randomTileLabel;

    @Override
    public void start(Stage primaryStage) {


        primaryStage.setTitle("Scrabble Game");

        // Create player sections
        VBox player1Box = createPlayerSection("Player 1");
        VBox player2Box = createPlayerSection("Player 2");

        // Create board section
        GridPane boardGrid = createBoardPane();

        // Create tiles section
        GridPane tilesGrid = createTilesSection();

        // Create actions section
        VBox actionsBox = createActionsSection();

        randomTileLabel = new Label("");


        // Create main layout
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));
        layout.setTop(new HBox(createTitle()));
        layout.setLeft(player1Box);
        layout.setRight(player2Box);
        layout.setCenter(boardGrid);
        layout.setBottom(new HBox(tilesGrid, actionsBox));

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createPlayerSection(String playerName) {
        VBox playerBox = new VBox();
        playerBox.setAlignment(Pos.CENTER);
        playerBox.setSpacing(10);

        Text playerNameText = new Text(playerName);
        playerNameText.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        Text scoreText = new Text("Score: 0");
        scoreText.setFont(Font.font("Arial", FontWeight.NORMAL, 16));

        playerBox.getChildren().addAll(playerNameText, scoreText);
        return playerBox;
    }

    private char[][] createBoardColor() {
        char[][] boardColor = new char[BOARD_SIZE][BOARD_SIZE];

        boardColor[7][7] = 'c';

        boardColor[0][0] = boardColor[0][7] = boardColor[0][14] = boardColor[7][0] =
                boardColor[7][14] = boardColor[14][0] = boardColor[14][7] = boardColor[14][14] = 'r';

        boardColor[1][1] = boardColor[2][2] = boardColor[3][3] = boardColor[4][4] =
                boardColor[13][1] = boardColor[12][2] = boardColor[11][3] = boardColor[10][4] =
                        boardColor[4][10] = boardColor[3][11] = boardColor[2][12] = boardColor[1][13] =
                                boardColor[10][10] = boardColor[11][11] = boardColor[12][12] = boardColor[13][13] = 'y';

        boardColor[0][3] = boardColor[0][11] = boardColor[2][6] = boardColor[2][8] = boardColor[3][0] = boardColor[3][7] = boardColor[3][14] =
                boardColor[6][2] = boardColor[6][6] = boardColor[6][8] = boardColor[6][12] = boardColor[7][3] = boardColor[7][11] =
                        boardColor[8][2] = boardColor[8][6] = boardColor[8][8] = boardColor[8][12] = boardColor[11][0] = boardColor[11][7] = boardColor[11][14] =
                                boardColor[12][6] = boardColor[12][8] = boardColor[14][3] = boardColor[14][11] = 'w';

        boardColor[1][5] = boardColor[1][9] = boardColor[5][1] = boardColor[5][5] = boardColor[5][9] = boardColor[5][13] =
                boardColor[9][1] = boardColor[9][5] = boardColor[9][9] = boardColor[9][13] = boardColor[13][5] = boardColor[13][9] = 'b';

        return boardColor;
    }

    private GridPane createBoardPane() {
        GridPane board = new GridPane();
        board.setAlignment(Pos.CENTER);
        board.setPadding(new Insets(5));
        board.setHgap(1);
        board.setVgap(1);
        board.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        char[][] boardColor = createBoardColor();

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
                char color = boardColor[row][col];
                switch (color) {
                    case 'b':
                        tile.setFill(Color.BLUE);
                        break;
                    case 'w':
                        tile.setFill(Color.DEEPSKYBLUE);
                        break;
                    case 'g':
                        tile.setFill(Color.GREEN);
                        break;
                    case 'y':
                        tile.setFill(Color.YELLOW);
                        break;
                    case 'r':
                        tile.setFill(Color.RED);
                        break;
                    case 'c':
                        tile.setFill(Color.TRANSPARENT);
                        Label starLabel = new Label("★");
                        starLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                        starLabel.setTextFill(Color.BLACK);
                        StackPane.setAlignment(starLabel, Pos.CENTER);
                        StackPane.setMargin(starLabel, new Insets(4));
                        StackPane stackPane = new StackPane(tile, starLabel);
                        board.add(stackPane, col, row);
                        break;


                    default:
                        tile.setFill(Color.GREEN);
                }
                tile.setStroke(Color.BLACK);
                tile.setStrokeWidth(1);
                board.add(tile, col, row);
            }
        }

        return board;
    }

    private GridPane createTilesSection() {
        GridPane tilesGrid = new GridPane();
        tilesGrid.setAlignment(Pos.CENTER);
        tilesGrid.setHgap(5);
        tilesGrid.setVgap(5);

        // Add tiles (example)
        String[] tiles = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        tileButtons = new Button[tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            Button tileButton = new Button(tiles[i]);
            tileButton.setPrefSize(40, 40);
            tileButton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000;");
            tileButtons[i] = tileButton; // store the button in the array
            tilesGrid.add(tileButton, i, 0);
        }

        return tilesGrid;
    }



    private Text createTitle() {
        Text titleText = new Text("SCRABBLE GAME");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        return titleText;
    }     // Create bag instance
    Tile.Bag bag = Tile.Bag.getBag();

    // Create a button to get a random tile from the bag

    private VBox createActionsSection() {
        VBox actionsBox = new VBox();
        actionsBox.setAlignment(Pos.CENTER);
        actionsBox.setSpacing(10);

        Button submitButton = new Button("Submit Word");
        submitButton.setPrefWidth(120);

        Button passButton = new Button("Pass");
        passButton.setPrefWidth(120);

        Button getRandomTileButton = new Button("Get Random Tile");
        getRandomTileButton.setPrefWidth(120);
        getRandomTileButton.setOnAction(event -> {
            // Get a random tile from the bag
            Tile randomTile = bag.getRand();

            // Get a random index to update a tile button
            int randomIndex = new Random().nextInt(tileButtons.length);
            Button tileButton = tileButtons[randomIndex];

            // Update the tile button label
            tileButton.setText(randomTile.toString());
        });



        actionsBox.getChildren().addAll(submitButton, passButton, getRandomTileButton);
        return actionsBox;
    }











    public static void main(String[] args) {
        launch(args);
    }
}


