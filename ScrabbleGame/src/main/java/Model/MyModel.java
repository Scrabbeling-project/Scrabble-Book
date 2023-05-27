package Model;

import Backend.Word;

public interface MyModel {
    
    boolean endTurn(Word word, boolean challenge);
    void passTurn();

}
