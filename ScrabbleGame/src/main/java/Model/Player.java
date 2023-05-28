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

    public Player(String name,boolean isGuest) {
        this.tilesInHand = new ArrayList<>();
        this.name = name;
        this.isGuest = isGuest;
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
        if (word == null) return; // T,I,H,E,G,S,K
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < tilesInHand.size(); j++) {
                if( c == tilesInHand.get(j).letter) {
                    tilesInHand.remove(j);
                }
        }
    }
}
    public List<Tile> getWordTiles(String word) { //HEY
        if (word == null) return null;
        List<Tile> tiles = new ArrayList<>();
        System.out.println(word.length());
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Tile tile = Tile.Bag.getBag().getTile(c);
            if(tile != null) {
                tiles.add(tile);
            }
        }
        return tiles;
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