package Backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Client(String serverAddress, int port) throws IOException {
        socket = new Socket(serverAddress, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void start() throws IOException {
        String input;
        while ((input = in.readLine()) != null) {
            System.out.println(input);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 8080);
        client.start();
    }
}
