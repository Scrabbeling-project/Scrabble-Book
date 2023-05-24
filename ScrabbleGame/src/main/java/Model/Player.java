package Model;

import java.util.ArrayList;
import java.util.List;

import Backend.Tile;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Tile> tilesInHand;
    private String name;
    private int score;
    private boolean isGuest;
    private Socket socket;

    public Player(String name) {
        this.tilesInHand = new ArrayList<>();
        this.name = name;
        this.isGuest = false;
        this.score = 0;
    }


    public void updateScore(int score) {
        this.score += score;
    }

    public void addTile() {
        Tile tile = Tile.Bag.getBag().getRand();
        this.tilesInHand.add(tile);
    }

    public List<Tile> getTilesInHand() {
        return tilesInHand;
    }

    public void removeFromHand(String word) {
        if (word == null) return;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < tilesInHand.size(); j++) {
                if( c == tilesInHand.get(j).letter) {
                    tilesInHand.remove(j);
                }

            //find tile in player_tiles
            //remove tile from player_tiles
        }
    }
}
    public List<Tile> getWordTiles(String word) { //HEY
        if (word == null) return null;
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //find tile in player_tiles
            for (int j = 0; j < tilesInHand.size(); j++) {
                if( c == tilesInHand.get(j).letter){
                    tiles.add(tilesInHand.get(j));
                    tilesInHand.remove(j);
                    break;
                }    
            }
            //add tile to tiles
        }
        return tiles;

        ///  tiles in hand : A H B E Y
        ///  word : H E Y 
    }


    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }


    public boolean isGuest() {
        return isGuest;
    }

    public void setGuest(boolean guest) {
        isGuest = guest;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket guestSocket) {
        this.socket = guestSocket;
    }
}