package Model;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import Backend.ClientHandler;

public class HostHandle implements ClientHandler{


    @Override
    public void handleClient(InputStream inFromclient, OutputStream outToClient) {
        Scanner scanner = new Scanner(inFromclient);
        PrintWriter out = new PrintWriter(outToClient);

        while(scanner.hasNextLine()) {
            String request = scanner.nextLine();
            String response = processRequest(request);

            // Send the response back to the client
            out.println(response);
            out.flush();
        }
    }

    private String processRequest(String request) {
        
        switch (request) {
            case (""):
            break;

        }
        
    }

    @Override
    public void close() {

    }
}
