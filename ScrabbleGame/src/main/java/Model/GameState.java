package Model;

import Model.Player;
import Backend.*;

import java.util.List;

public class GameState {
    private List<Player> players;
    private Board board;
    private String currentPlayerName;
    private Word lastAddedWord;

    public GameState(List<Player> players, String currentPlayerName, Word lastAddedWord) {
        this.players = players;
        this.currentPlayerName = currentPlayerName;
        this.board = Board.getBoard();
        this.lastAddedWord = lastAddedWord;
        // consider creating a singleton and update the state on every move
    }
    public GameState(String gameState) {
        
        //create the object
        //split...
        //<currentPlayerName>#<playerName1:score1>,<playerName2:score2>#<lastWord, row, col, vertical>
    }

    public String toString() {

        String playerScores = "";
        for (Player player : players) {
            playerScores += String.format("%s:%s,", player.getName(), player.getScore());
        }
        playerScores = playerScores.substring(0, playerScores.length() - 1);

        String word = "";
        for (Tile tile : lastAddedWord.getTiles()) {
            word += tile.letter;
        }
        String lastWord = String.format("%s,%s,%s,%s", word, lastAddedWord.getRow(), lastAddedWord.getCol(), lastAddedWord.isVertical());

        //<currentPlayerName>#<playerName1:score1>,<playerName2:score2>#<lastWord, row, col, vertical>
        String state = String.format("%s#%s#%s", this.currentPlayerName, playerScores, lastWord);
        return state;
    }
}