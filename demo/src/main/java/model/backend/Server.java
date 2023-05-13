package model.backend;//package model.backend;


import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<ScrabbleClientHandler> clients;
    private ServerSocket serverSocket;
    private int port;

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Scrabble server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                ScrabbleClientHandler clientHandler = new ScrabbleClientHandler(clientSocket, this);
                clients.add(clientHandler);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcast(String message) {
        for (ScrabbleClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public void removeClient(ScrabbleClientHandler client) {
        clients.remove(client);
    }

    public static void main(String[] args) {
        Server server = new Server(1234);
        server.start();
    }
}
