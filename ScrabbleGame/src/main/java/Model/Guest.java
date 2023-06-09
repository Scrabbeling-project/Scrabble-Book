package Model;

import Backend.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Guest implements MyModel {

    Socket socket;
    private Board board;
    private String playerName;

    public Guest(String playerName) {
        this.board=Backend.Board.getBoard();
        this.playerName=playerName;
    }


    public void start_game(String host) {
        try {
            socket = new Socket(host, 3001);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String command = playerName+";connect;"+host+";3001";
        String response = sendCommand(command);

    }

    public String sendCommand(String command) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
           //"name;function;data;data...."
            writer.println(command);
            writer.flush();

            Scanner scanner = new Scanner(new InputStreamReader(socket.getInputStream()));
            String response = scanner.nextLine();

            writer.close();
            scanner.close();

            return response;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean endTurn(Word word, boolean challenge) {
        // endTurn
        String command = playerName+";"+"endTurn;"+word+";"+word.getRow()+";"+word.getCol()+";"+word.isVertical()+";"+challenge;
        String response = sendCommand(command);
        boolean isOK = Boolean.parseBoolean(response);
        return isOK;
    }

    @Override
    public void passTurn() {
        //passTurn
        String command = playerName+";"+"passTurn";
        String response = sendCommand(command);
    }


}