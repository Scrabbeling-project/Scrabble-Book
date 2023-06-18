package ViewModel;

import Backend.MyServer;
import Model.HostModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import static Backend.MyServer.startServer;

public class HostViewModel {

   public static class GameState {
        enum gameState {
            gameOver,
            inprocess,

            passTurn,
            HOST_SERVER_CONNECTED,
            Client_CONNECTED
        }
    }

    private final PropertyChangeSupport pcs;
    private HostModel hostModel;


    public HostViewModel(PropertyChangeSupport propertyChangeSupport) {
        this.pcs = propertyChangeSupport;

    }
    public void addPropertyListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }
    public void removePropertyChangeListener(PropertyChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }


    public PropertyChangeListener[] updatePropertyChangeListener(PropertyChangeListener l){
       return pcs.getPropertyChangeListeners();
    }

    public void connect() {
        MyServer server = new MyServer(8080, new MyServer.ClientHandler1());
        startServer();
    }

    public GameState getGameStatus() {

        return getGameStatus();
    }


    public static String moveTurn() {
        return "move turn";
    }



}