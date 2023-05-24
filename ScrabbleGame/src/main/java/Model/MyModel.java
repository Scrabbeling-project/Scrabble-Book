package Model;

import Backend.Word;

public interface MyModel {
    
    void startGame();
    void endTurn(Word word, boolean challenge);
    void passTurn();

}
