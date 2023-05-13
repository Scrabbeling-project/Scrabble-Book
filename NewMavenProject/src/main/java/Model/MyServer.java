package Model;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServer
{

    int port;
    ClientHandler ch;
    boolean stop;

    public MyServer(int port, ClientHandler ch)
    {
        this.port = port;
        this.ch = ch;
    }


    public void start()
    {
        stop = false;
        new Thread(()->startServer()).start();
    }

    private void startServer()
    {
        try
        {
            ServerSocket server = new ServerSocket(port);
            server.setSoTimeout(1000);
            while (!stop)
            {
                try
                {
                    Socket client = server.accept();
                    System.out.println("Client accepted");
                    ch.handleClient(client.getInputStream(),client.getOutputStream());
                    ch.close();
                    client.close();
                }
                catch (SocketTimeoutException e)
                {

                }
            }
            server.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        stop = true;
    }
	
}
