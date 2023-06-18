package Model;

import Backend.*;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class GuestHandler implements ClientHandler {
    HostModel host;

    public GuestHandler(HostModel host) {
        this.host = host;
    }

    @Override
    public void handleClient(InputStream inFromHost, OutputStream outToHost) {
        // implement
        Scanner scanner = new Scanner(new InputStreamReader(inFromHost));
        PrintWriter writer = new PrintWriter(outToHost);
        String[] details = scanner.nextLine().split(";"); //"name;function;data...."
        String playerName = details[0];
        String function = details[1];

        switch(function){
            case("connect"):
                connectToGuestMode(playerName,details);
                break;
            case("endTurn"):
                endGuestTurn(playerName,details,writer);
                break;
            case("skipTurn"):
                skipGuestTurn(playerName,writer);
                break;
            default:System.out.println("not a valid function!!");
        }
        scanner.close();
        writer.close();
    }

    private void skipGuestTurn(String name, PrintWriter out) {
        host.passTurn();
        Player p = host.getPlayer(name);
        p.getTilesInHand();
        // out.println(); Print Player's tiles to show him his tiles 
        out.flush();
        
    }

    private void endGuestTurn(String name,String[] commands,PrintWriter out) {
        String word = commands[2];
        int row = Integer.parseInt(commands[3]);
        int col = Integer.parseInt(commands[4]);
        boolean vertical = Boolean.parseBoolean(commands[5]);
        boolean challenge = Boolean.parseBoolean(commands[6]);

        List<Tile> wordTiles = host.getPlayerTiles(name, word);
        boolean isTurnSuccess = host.endTurn(new Word(wordTiles.toArray(new Tile[0]), row, col, vertical), challenge);
        if (!isTurnSuccess) {
            out.println(false);
            out.flush();
            return;
        }
        host.removePlayerTiles(name, word);
        out.println(true);
        out.flush();
        return;
    }

    private void connectToGuestMode(String name, String[] commands) {
        Player p = new Player(name,true);
        p.setGuest(true);
        String hostToGuest= commands[2];
        int port = Integer.parseInt(commands[3]);
        try {
            p.setSocket(new Socket(hostToGuest,port));
        } catch (IOException e) {}
        host.addPlayer(p);
        return;
    }

    @Override
    public void close() {

    }
}