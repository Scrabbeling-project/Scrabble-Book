package com.example.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ScrabbleBoard extends Application {

    private static final int BOARD_SIZE = 15;
    private static final int CELL_SIZE = 40;
    private static final Color BOARD_COLOR = Color.web("#ECECEC");
    private static final Color DOUBLE_LETTER_SCORE_COLOR = Color.web("#6FB7BF");
    private static final Color DOUBLE_WORD_SCORE_COLOR = Color.web("#F9A66C");
    private static final Color TRIPLE_LETTER_SCORE_COLOR = Color.web("#B8E1F2");
    private static final Color TRIPLE_WORD_SCORE_COLOR = Color.web("#FF7777");
    private static final Color LETTER_COLOR = Color.web("#0B0B61");

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create a GridPane to hold the cells
        GridPane board = new GridPane();
        board.setAlignment(Pos.CENTER);
        board.setHgap(1);
        board.setVgap(1);

        // Create cells for the board and add them to the GridPane
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE, BOARD_COLOR);
                StackPane stackPane = new StackPane(cell);
                stackPane.setAlignment(Pos.CENTER);
                if (row == col || row == 14 - col || row == 7 && col == 7) {
                    // Center square and diagonal double-letter-score squares
                    cell.setFill(DOUBLE_LETTER_SCORE_COLOR);
                } else if ((row == 0 || row == 14) && (col == 3 || col == 11) ||
                        (row == 2 || row == 12) && (col == 6 || col == 8) ||
                        (row == 3 || row == 11) && (col == 0 || col == 7 || col == 14) ||
                        (row == 6 || row == 8) && (col == 2 || col == 6 || col == 8 || col == 12)) {
                    // Triple-letter-score squares
                    cell.setFill(TRIPLE_LETTER_SCORE_COLOR);
                } else if ((row == 1 || row == 13) && (col == 5 || col == 9) ||
                        (row == 5 || row == 9) && (col == 1 || col == 5 || col == 9 || col == 13)) {
                    // Double-word-score squares
                    cell.setFill(DOUBLE_WORD_SCORE_COLOR);
                } else if (row == 0 || row == 7 || row == 14 || col == 0 || col == 7 || col == 14) {
                    // Regular word score squares
                    cell.setFill(TRIPLE_WORD_SCORE_COLOR);
                } else {
                    // Regular letter squares
                    cell.setFill(LETTER_COLOR);
                }
                board.add(stackPane, col, row);
            }
        }

        // Create the scene and set it on the stage
        Scene scene = new Scene(board, BOARD_SIZE * CELL_SIZE, BOARD_SIZE * CELL_SIZE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Scrabble Board");
        primaryStage.show();
    }



        public static void main(String[] args) {
        launch(args);
    }
}
