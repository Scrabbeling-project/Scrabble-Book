package Model;

import java.net.Socket;
import java.util.List;


// The first player
public class Host implements MyModel{
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
}
