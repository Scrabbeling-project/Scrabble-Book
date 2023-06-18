package ViewModel;


//
//
//package ViewModel;
//
//import Model.Data.Tile;
//import Model.Guest.Client;
//
//import java.beans.PropertyChangeListener;
//import java.beans.PropertyChangeSupport;
//import java.net.Socket;
//import java.util.HashMap;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//
//public class ClientViewModel {
//
//    private Client client = null;
//
//    ExecutorService executorService= Executors.newFixedThreadPool(1);
//
//    private Socket socketClient=null;
//    private final PropertyChangeSupport propertyChangeSupport;
//
//    public static final String BOARD_TILES_PROPERTY = "boardTiles";
//    public static final String SCORE_MAP_PROPERTY = "scoreMap";
//    public static final String TILES_PROPERTY = "tiles";
//    public static final String TURN_PROPERTY = "turn";
//    public static final String MESSAGE_PROPERTY = "message";
//
//
//    public ClientViewModel() {
//        client = new Client("");
//        propertyChangeSupport = new PropertyChangeSupport(this);
//    }
//
//    public void connectToServer() {
//
//        Future<Client> clientFuture=executorService.submit(client);//run the client
//        socketClient=client.getSocketClient();
//    }
//
//    public void sendRequestToServer(String request) {
//        Client.sendRequestToServer(socketClient,request);
//    }
//
//    public Tile[][] getBoardTiles() {
//        return Client.getBoardTiles();
//    }
//
//    public HashMap<String, Integer> getScoreMap() {
//        return Client.getScoreMap();
//    }
//
//    public List<Tile> getTiles() {
//        return Client.getTiles();
//    }
//
//    public String getTurn() {
//        return Client.getTurn();
//    }
//
//    public String getMessage() {
//        return client.getMessage();
//    }
//
//    public void addPropertyChangeListener(PropertyChangeListener listener) {
//        propertyChangeSupport.addPropertyChangeListener(listener);
//    }
//
//    public void removePropertyChangeListener(PropertyChangeListener listener) {
//        propertyChangeSupport.removePropertyChangeListener(listener);
//    }
//
//    private void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
//        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
//    }
//}

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

//    public int getScoreOfClient(){
//
//        return getScore();
//    }

    void connectHost() throws IOException {
        Client client = new Client("localhost", 8080);
        client.start();
    }



}
