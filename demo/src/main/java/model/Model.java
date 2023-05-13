package model;

import model.backend.MyServer;
import viewmodel.ViewModel;

public class Model {

    private static void startServer() {
        MyServer server = new MyServer(1234, new MyServer.ClientHandler1());
        server.start();
    }

    public static void main(String args[])
    {
        startServer();
    }


    public void addObserver(ViewModel viewModel) {
    }
}
