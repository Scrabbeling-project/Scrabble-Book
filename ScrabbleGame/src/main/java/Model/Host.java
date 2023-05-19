package Model;

import java.net.Socket;
import java.util.List;


// The first player
public class Host implements MyModel
{
    Socket hostSocket;
    MyServer hostServer;
    HostHandle hosthandle;
    Board hostBoard;
//    Model.Tile.Bag getBag;
    List<Player> playerList;
    Player player;
    DictionaryManager dictionaryManager;
    CacheManager cacheManager;
    IOSearcher ioSearcher;
    @Override
    public void startGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startGame'");
    }
    @Override
    public void endGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'endGame'");
    }
    @Override
    public void passTurn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'passTurn'");
    }
}
