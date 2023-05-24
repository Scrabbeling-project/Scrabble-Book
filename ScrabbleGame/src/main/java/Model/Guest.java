package Model;

import java.net.Socket;
import java.util.Observable;

import Backend.Tile;

public class Guest extends Observable implements MyModel{

    Socket socket;
    Tile[][] boardStatus;
    String[] score;
    int bagSize; //Tiles left in bag
    Player player;


    public Guest(Socket socket, Tile[][] boardStatus, String[] score, int bagSize, Player player) {
        this.socket = socket;
        this.boardStatus = boardStatus;
        this.score = score;
        this.bagSize = bagSize;
        this.player = player;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Tile[][] getBoardStatus() {
        return boardStatus;
    }

    public void setBoardStatus(Tile[][] boardStatus) {
        this.boardStatus = boardStatus;
    }

    public String[] getScore() {
        return score;
    }

    public void setScore(String[] score) {
        this.score = score;
    }

    public int getBagSize() {
        return bagSize;
    }

    public void setBagSize(int bagSize) {
        this.bagSize = bagSize;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void startGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startGame'");
    }


    
    @Override
    public void endGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'endGame'");
    }

    @Override
    public void passTurn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'passTurn'");
    }
}
