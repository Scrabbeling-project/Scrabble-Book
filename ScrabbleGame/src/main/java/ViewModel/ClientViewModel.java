package ViewModel;


import Backend.Board;
import Backend.Client;
import Backend.Tile;
import Backend.Word;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClientViewModel {
    private Client client = null;


    ExecutorService executorService= Executors.newFixedThreadPool(1);


    public static final String BOARD_TILES_PROPERTY = "boardTiles";
    public static final String SCORE_MAP_PROPERTY = "scoreMap";
    public static final String TILES_PROPERTY = "tiles";
    public static final String TURN_PROPERTY = "turn";
    public static final String MESSAGE_PROPERTY = "message";

    ClientViewModel() throws IOException {
        client = new Client("localhost",8080);
    }

    public void connect() throws IOException {
        client.start();
    }
    public void sendRequestToServer(String request) {
        client.sendMessage(request);
    }

    public Tile[][] getBoardTiles(){
        return Board.getBoard().getTiles();
    }



    void connectHost() throws IOException {
        Client client = new Client("localhost", 8080);
        client.start();
    }



}
