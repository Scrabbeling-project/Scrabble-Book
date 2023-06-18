package tests;
import Backend.*;
import Model.*;

public class HostModelTest {
    static HostModel hm;
    public HostModelTest(){
        try {
            hm = new HostModel();
        } catch (Exception e) {
           System.out.println("failed in HostModel Constructor");
        }
    }
   

    static void testAddAndGetPlayer() {
        hm.addPlayer(new Player("yakov",true));
        Player p = hm.getPlayer("yakov");
        if(p==null) { System.out.println("player doesnt exist");}
    }

    static void testStartGame_testTileDivision(){
        hm.addPlayer(new Player("victor",true));
        hm.addPlayer(new Player("erlich",true));
        hm.addPlayer(new Player("yakov",true));
        hm.addPlayer(new Player("shimshon",true));
        hm.startGame();
        if(Board.getBoard() == null) { System.out.println("problem in create board");}
        if(Tile.Bag.getBag() == null) { System.out.println("problem in create bag");}
        for(Player p : hm.getPlayers()) {
            if(p.getTilesInHand().size() != 7){
                System.out.println("tileDivition problem, less then 7 tiles");
            }
        }
    }

    static void testCreateMessage() {
        Tile tile1= Tile.Bag.getBag().getTile('H');
        Tile tile2= Tile.Bag.getBag().getTile('O');
        Tile tile3= Tile.Bag.getBag().getTile('M');
        Tile tile4= Tile.Bag.getBag().getTile('E');
        Tile[] tiles = new Tile[]{tile1 , tile2 ,tile3,tile4};
        Word word = new Word(tiles, 1, 1, true);

        String expectedMessage = "C;book1;book2;book3;HOME";
        String actualMessage = hm.createMessage(word, true);
        System.out.println(actualMessage);
        if (!actualMessage.equals(expectedMessage)) {
            System.out.println("HostModelTest.testCreateMessage: failed");
        } else {
            System.out.println("HostModelTest.testCreateMessage: passed");
        }
    }
    static void testEndGame_testUpdateScore(){
        int score = 100;
        int[] scores = {20,50,60,90};
        hm.getPlayers().get(0).updateScore(scores[0]);
        hm.getPlayers().get(1).updateScore(scores[1]);
        hm.getPlayers().get(2).updateScore(scores[2]);
        hm.getPlayers().get(3).updateScore(scores[3]);
        if(hm.getPlayers().get(0).getScore() != 20){System.out.println("wrong updateScore");}

        hm.end_game();
        for(int i=0; i<4; i++) {
            if(hm.getPlayers().get(i).getScore() != scores[scores.length-(i+1)]) {
                System.out.println("wrong updateScore + endGame");
            }
        }
    }

    public static void main(String[] args) {
        HostModelTest hmt = new HostModelTest();
        testStartGame_testTileDivision();
        testAddAndGetPlayer();
        testCreateMessage();
        testEndGame_testUpdateScore();
    }

}
