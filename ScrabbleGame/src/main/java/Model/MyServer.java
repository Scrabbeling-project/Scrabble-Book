package Model;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class MyServer {

    static int port;
    static boolean stop;
    static ClientHandler clientHandler;

    public MyServer(int port, ClientHandler clientHandler) {
        this.port = port;
        this.clientHandler = clientHandler;
    }

    public static void start() {
        stop = false;
        new Thread(() -> startServer()).start();
    }

    public static void startServer() {
        try {
            ServerSocket server = new ServerSocket(port);
            server.setSoTimeout(1000);
            while (!stop) {
                try {
                    Socket client = server.accept();
                    System.out.println("new client Connected");
                    clientHandler.handleClient(client.getInputStream(), client.getOutputStream());
                    clientHandler.close();
                    client.close();
                } catch (SocketTimeoutException e) {
                }
            }
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public void close() {
        stop = true;
    }

    public static class ClientHandler1 implements ClientHandler{
        PrintWriter out;
        Scanner in;
        @Override
        public void handleClient(InputStream inFromclient, OutputStream outToClient) {
            out=new PrintWriter(outToClient);
            in=new Scanner(inFromclient);
            String text = in.next();
            out.println(new StringBuilder(text).reverse().toString());
            out.flush();
        }

        @Override
        public void close() {
            in.close();
            out.close();
        }

    }
    public static void main(String args[])
    {
        MyServer server=new MyServer(8080,new ClientHandler1());
        startServer();
    }

}