package tests;
import java.util.*;

import Backend.*;
import Model.*;

public class PlayerTest {
    static Player player;

    private  PlayerTest() {
        player = new Player("Alice",true);
        testremoveFromHand();
        testAddTile();
        testGetWordTiles();
    }
    
    static void testAddTile() {
        int count = player.getTilesInHand().size();
        player.addTile();
        count++;
        if(count != player.getTilesInHand().size()) {System.out.println("problem in addTile");}
    }

    static void testremoveFromHand() {
        String word= "HI";
        player.getTilesInHand().add(Tile.Bag.getBag().getTile('H'));
        player.getTilesInHand().add(Tile.Bag.getBag().getTile('I'));
        player.removeFromHand(word);
        if(!player.getTilesInHand().isEmpty()){
            System.out.println("Failed removeFromHand");
        }
    }

    static void testGetWordTiles() {
        String word= "AB";
        Tile tile1= Tile.Bag.getBag().getTile('A');
        Tile tile2= Tile.Bag.getBag().getTile('B');
        List<Tile> tiles = new ArrayList<>();
        tiles= player.getWordTiles(word);
        System.out.println(tiles.get(0).letter+"+"+tiles.get(1).letter);
        if(!(tiles.contains(tile1) && tiles.contains(tile2))){
            System.out.println("Failed GetWordTiles");
        }
    }






    public static void main(String[] args) {
        PlayerTest pt = new PlayerTest();
        System.out.println("player tests done");

    }
}
