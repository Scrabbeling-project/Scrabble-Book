package model.backend;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int score ;
    private List<Tile> tile;

    public Player(String name, int score, Tile[] tile) {
        this.name = name;
        this.score = score;
        this.tile = new ArrayList<Tile>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Tile> getTile() {
        return tile;
    }

    public void setTile(List<Tile> tile) {
        this.tile = tile;
    }
    


}



