package Model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Backend.Board;
import Backend.BookScrabbleHandler;
import Backend.ClientHandler;
import Backend.MyServer;
import Backend.Tile;
import Backend.Word;

public class HostModel implements MyModel{

    private List<Player> players;
    private Board board;
    private Tile.Bag bag;
    private int currentPlayerIndex;
    private Socket socket;
    private MyServer server;
    private MyServer hostServer;

    public HostModel() {
        server = new MyServer(3000, new BookScrabbleHandler());
        server.start();
        connectToPTM1("localhost", 3000);
        
        hostServer = new MyServer(3001, new GuestHandler(this));
        hostServer.start();


        this.players = new ArrayList<>();
        this.board = null;
        this.bag = null;
        this.currentPlayerIndex = 0;
    }

    public void connectToPTM1(String serverAddress, int serverPort) {
        try {
            socket = new Socket(serverAddress, serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Player getPlayer(String playerName) {
        for (Player p : players) {
            if (p.getName().equals(playerName)) {
                return p;
            }
        }
        return null;
    }

   
    public List<Tile> getPlayerTiles(String playerName, String word) {
        Player player = getPlayer(playerName);
        return player.getWordTiles(word);
    }

    public void removePlayerTiles(String playerName, String word) {
        Player player = getPlayer(playerName);
        player.removeFromHand(word);
    }

    public void sendToServer(String message) {
        try {
            PrintWriter outToServer = new PrintWriter(socket.getOutputStream());
            outToServer.println(message);
            outToServer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String receiveFromPTM1() {
        try {
            Scanner in = new Scanner(socket.getInputStream());
            String response = in.next();
            in.close();
            return response;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void closeConnection() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public void startGame() {
        this.board = Board.getBoard();
        this.bag = Tile.Bag.getBag();
        setPlayersOrder();
        for (int indexPlayer = 0; indexPlayer < 4; indexPlayer++) {
            tileDivision(indexPlayer);
        }
    }

    public void addPlayer(Player player) { 
        players.add(player);
    }

    public void setPlayersOrder() {
        for (Player player : players) {
            player.addTile();
        }
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player player1, Player player2) {
                return Character.compare(player1.getTilesInHand().get(0).letter, player2.getTilesInHand().get(0).letter);
            }
        });
        
        for (Player p : players) {
            bag.put(p.getTilesInHand().get(0));
            p.getTilesInHand().remove(0);
        }
        
    }

    public void tileDivision(int indexOfPlayer) {
        int numOfTiles = players.get(indexOfPlayer).getTilesInHand().size();
        if (numOfTiles < 7) {
            for (int i = 0; i < 7 - numOfTiles; i++) {
                players.get(indexOfPlayer).addTile();
            }
        }
    }

    @Override
    public boolean endTurn(Word word, boolean challenge) {
        String message = createMessage(word, challenge);
        sendToServer(message);
        String result = receiveFromPTM1();
        boolean isInDictionary = result == "true" ? true : false;
        if (!isInDictionary) {
            return false;
        }
        int score = board.tryPlaceWord(word);
        if (score == 0) {
            return false;
        }
        notifyState(word);

        players.get(currentPlayerIndex).updateScore(score);
        tileDivision(currentPlayerIndex);
        setCurrentPlayerIndex((this.currentPlayerIndex + 1) % 3);
        if (bag.size() == 0) {
            end_game();
        }
        return true;
    }

    public void notifyState(Word word) {
        //the host need to notify to the guests for updates after every turn
        GameState gameState=new GameState(players,players.get(currentPlayerIndex).getPlayer_name(),word);
        //loop of players socket to send them massage
        //"<function>,<data>,<data>,<data>.."
        //"updateGameState,gameState.toString()"

        // loop on Guest sockets
        for(Player p :players){
            if(p.isGuest()){
                //p.getGuestSocket()
            }
        }

    }
    

    @Override
    public void passTurn() {
        // players.get(currentPlayerIndex).addTile();
        setCurrentPlayerIndex((this.currentPlayerIndex + 1) % 3);
    }

    public void end_game() {
        Collections.sort(players, (p1, p2) -> p2.getScore() - p1.getScore());
    }

    public String createMessage(Word word, boolean challenge) {
        String message = challenge ? "C;" : "Q;";
        String w = "";

        for (int i = 0; i < word.getTiles().length; i++) {
            w += word.getTiles()[i].letter;
        }

        //add the name of the books

        message += ";book1;book2;book3;" + w;

        return message;
    }


}
