package Model;

import Model.Tile;
import Model.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Board {
    // SKNXcsadncndsakcn

    private static HashMap<String, String> bonusBoard = new HashMap<>();
    private ArrayList<String> specials = new ArrayList<>();


    private static Board singleBoard;
    Tile[][] board = new Tile[15][15];


    public static Board getBoard()
    {
        if (singleBoard == null) {
            singleBoard = new Board();
            initBonusBoard();
        }

        return singleBoard;
    }

    private static void initBonusBoard() {

        bonusBoard.put("01", "green");
        bonusBoard.put("02", "green");
        bonusBoard.put("04", "green");
        bonusBoard.put("05", "green");
        bonusBoard.put("06", "green");
        bonusBoard.put("08", "green");
        bonusBoard.put("09", "green");
        bonusBoard.put("010", "green");
        bonusBoard.put("012", "green");
        bonusBoard.put("013", "green");

        bonusBoard.put("10", "green");
        bonusBoard.put("12", "green");
        bonusBoard.put("13", "green");
        bonusBoard.put("14", "green");
        bonusBoard.put("16", "green");
        bonusBoard.put("17", "green");
        bonusBoard.put("18", "green");
        bonusBoard.put("110", "green");
        bonusBoard.put("111", "green");
        bonusBoard.put("112", "green");
        bonusBoard.put("114", "green");
        bonusBoard.put("20", "green");
        bonusBoard.put("21", "green");
        bonusBoard.put("24", "green");
        bonusBoard.put("25", "green");
        bonusBoard.put("27", "green");
        bonusBoard.put("29", "green");
        bonusBoard.put("210", "green");
        bonusBoard.put("211", "green");
        bonusBoard.put("213", "green");
        bonusBoard.put("214", "green");
        bonusBoard.put("31", "green");
        bonusBoard.put("32", "green");
        bonusBoard.put("34", "green");
        bonusBoard.put("35", "green");
        bonusBoard.put("36", "green");
        bonusBoard.put("38", "green");
        bonusBoard.put("39", "green");
        bonusBoard.put("310", "green");
        bonusBoard.put("312", "green");
        bonusBoard.put("313", "green");
        bonusBoard.put("40", "green");
        bonusBoard.put("41", "green");
        bonusBoard.put("42", "green");
        bonusBoard.put("43", "green");
        bonusBoard.put("45", "green");
        bonusBoard.put("46", "green");
        bonusBoard.put("47", "green");
        bonusBoard.put("48", "green");
        bonusBoard.put("49", "green");
        bonusBoard.put("411", "green");
        bonusBoard.put("412", "green");
        bonusBoard.put("413", "green");
        bonusBoard.put("414", "green");
        bonusBoard.put("50", "green");
        bonusBoard.put("52", "green");
        bonusBoard.put("53", "green");
        bonusBoard.put("54", "green");
        bonusBoard.put("56", "green");
        bonusBoard.put("57", "green");
        bonusBoard.put("58", "green");
        bonusBoard.put("510", "green");
        bonusBoard.put("511", "green");
        bonusBoard.put("512", "green");
        bonusBoard.put("514", "green");
        bonusBoard.put("60", "green");
        bonusBoard.put("61", "green");
        bonusBoard.put("63", "green");
        bonusBoard.put("64", "green");
        bonusBoard.put("65", "green");
        bonusBoard.put("67", "green");
        bonusBoard.put("69", "green");
        bonusBoard.put("610", "green");
        bonusBoard.put("611", "green");
        bonusBoard.put("613", "green");
        bonusBoard.put("614", "green");
        bonusBoard.put("71", "green");
        bonusBoard.put("72", "green");
        bonusBoard.put("74", "green");
        bonusBoard.put("75", "green");
        bonusBoard.put("76", "green");
        bonusBoard.put("78", "green");
        bonusBoard.put("79", "green");
        bonusBoard.put("710", "green");
        bonusBoard.put("712", "green");
        bonusBoard.put("713", "green");
        bonusBoard.put("80", "green");
        bonusBoard.put("81", "green");
        bonusBoard.put("83", "green");
        bonusBoard.put("84", "green");
        bonusBoard.put("85", "green");
        bonusBoard.put("87", "green");
        bonusBoard.put("89", "green");
        bonusBoard.put("810", "green");
        bonusBoard.put("811", "green");
        bonusBoard.put("813", "green");
        bonusBoard.put("814", "green");
        bonusBoard.put("90", "green");
        bonusBoard.put("92", "green");
        bonusBoard.put("93", "green");
        bonusBoard.put("94", "green");
        bonusBoard.put("96", "green");
        bonusBoard.put("97", "green");
        bonusBoard.put("98", "green");
        bonusBoard.put("910", "green");
        bonusBoard.put("911", "green");
        bonusBoard.put("912", "green");
        bonusBoard.put("914", "green");
        bonusBoard.put("100", "green");
        bonusBoard.put("101", "green");
        bonusBoard.put("102", "green");
        bonusBoard.put("103", "green");
        bonusBoard.put("105", "green");
        bonusBoard.put("106", "green");
        bonusBoard.put("107", "green");
        bonusBoard.put("108", "green");
        bonusBoard.put("109", "green");
        bonusBoard.put("1011", "green");
        bonusBoard.put("1012", "green");
        bonusBoard.put("1013", "green");
        bonusBoard.put("1014", "green");

        bonusBoard.put("115", "green");
        bonusBoard.put("116", "green");
        bonusBoard.put("118", "green");
        bonusBoard.put("119", "green");
        bonusBoard.put("1110", "green");
        bonusBoard.put("1112", "green");
        bonusBoard.put("1113", "green");
        bonusBoard.put("120", "green");
        bonusBoard.put("121", "green");
        bonusBoard.put("123", "green");
        bonusBoard.put("124", "green");
        bonusBoard.put("125", "green");
        bonusBoard.put("127", "green");
        bonusBoard.put("129", "green");
        bonusBoard.put("1210", "green");
        bonusBoard.put("1211", "green");
        bonusBoard.put("1213", "green");
        bonusBoard.put("1214", "green");
        bonusBoard.put("130", "green");
        bonusBoard.put("132", "green");
        bonusBoard.put("133", "green");
        bonusBoard.put("134", "green");
        bonusBoard.put("136", "green");
        bonusBoard.put("137", "green");
        bonusBoard.put("138", "green");
        bonusBoard.put("1310", "green");
        bonusBoard.put("1311", "green");
        bonusBoard.put("1312", "green");
        bonusBoard.put("1314", "green");
        bonusBoard.put("141", "green");
        bonusBoard.put("142", "green");
        bonusBoard.put("144", "green");
        bonusBoard.put("145", "green");
        bonusBoard.put("146", "green");
        bonusBoard.put("148", "green");
        bonusBoard.put("149", "green");
        bonusBoard.put("1410", "green");
        bonusBoard.put("1412", "green");
        bonusBoard.put("1413", "green");


        bonusBoard.put("77", "star");
        bonusBoard.put("00", "red");
        bonusBoard.put("07", "red");
        bonusBoard.put("014", "red");
        bonusBoard.put("70", "red");
        bonusBoard.put("714", "red");
        bonusBoard.put("140", "red");
        bonusBoard.put("147", "red");
        bonusBoard.put("1414", "red");

        bonusBoard.put("11", "yellow");
        bonusBoard.put("113", "yellow");
        bonusBoard.put("22", "yellow");
        bonusBoard.put("212", "yellow");
        bonusBoard.put("33", "yellow");
        bonusBoard.put("311", "yellow");
        bonusBoard.put("44", "yellow");
        bonusBoard.put("410", "yellow");
        bonusBoard.put("104", "yellow");
        bonusBoard.put("1010", "yellow");
        bonusBoard.put("113", "yellow");
        bonusBoard.put("1111", "yellow");
        bonusBoard.put("122", "yellow");
        bonusBoard.put("1212", "yellow");
        bonusBoard.put("1313", "yellow");
        bonusBoard.put("131", "yellow");

        bonusBoard.put("03", "azure");
        bonusBoard.put("011", "azure");
        bonusBoard.put("26", "azure");
        bonusBoard.put("28", "azure");
        bonusBoard.put("30", "azure");
        bonusBoard.put("37", "azure");
        bonusBoard.put("314", "azure");
        bonusBoard.put("62", "azure");
        bonusBoard.put("66", "azure");
        bonusBoard.put("68", "azure");
        bonusBoard.put("612", "azure");
        bonusBoard.put("73", "azure");
        bonusBoard.put("711", "azure");
        bonusBoard.put("82", "azure");
        bonusBoard.put("86", "azure");
        bonusBoard.put("88", "azure");
        bonusBoard.put("812", "azure");
        bonusBoard.put("110", "azure");
        bonusBoard.put("117", "azure");
        bonusBoard.put("1114", "azure");
        bonusBoard.put("126", "azure");
        bonusBoard.put("128", "azure");
        bonusBoard.put("143", "azure");
        bonusBoard.put("1411", "azure");

        bonusBoard.put("15", "blue");
        bonusBoard.put("19", "blue");
        bonusBoard.put("51", "blue");
        bonusBoard.put("55", "blue");
        bonusBoard.put("59", "blue");
        bonusBoard.put("513", "blue");
        bonusBoard.put("91", "blue");
        bonusBoard.put("95", "blue");
        bonusBoard.put("99", "blue");
        bonusBoard.put("913", "blue");
        bonusBoard.put("135", "blue");
        bonusBoard.put("139", "blue");


    }

    public Tile[][] getTiles() {
        Tile[][] dupTiles = (Tile[][]) board.clone();
        return dupTiles;
    }

    //// Help Method 01 for boardLegal, check if the word is legal.
    public boolean wordInBoard(Word word)
    {   // row or col is outside board bounds
        // Checks if the index of the first letter of the word is in the bound of the table
        if (word.getCol() < 0 || word.getCol() > 14 || word.getRow() < 0 || word.getRow() > 14) {
            return false;
        }

        if (word.isVertical())   // Checks if the length of the word is not out of the bound of the table.
        {
            if (word.getRow() + word.getTiles().length > 14) {
                return false;
            }
        }
        // vertical = false
        else if (word.getCol() + word.getTiles().length > 14) {
            return false;
        }

        // reach here -> legal word
        return true;
    }

    //// Help Method 02 for boardLegal, check if the word lean on one of the existing tiles on the board.
    public boolean isLapping(Word word, Tile[][] board)
    {
        int countOverLapping = 0;

        for (int i = 0; i < word.getTiles().length; i++)
        {
            if (word.isVertical()) {
                //
                if (board[word.getRow() + i][word.getCol()] != null && board[word.getRow() + i][word.getCol()] != word.getTiles()[i])
                    return false;
                else if (board[word.getRow() + i][word.getCol()] == word.getTiles()[i])
                    countOverLapping++;
            } else {
                if (board[word.getRow()][word.getCol() + i] != null && board[word.getRow()][word.getCol() + i] != word.getTiles()[i])
                    return false;
                else if (board[word.getRow()][word.getCol() + i] == word.getTiles()[i])
                    countOverLapping++;

            }
        }

        if (countOverLapping == 0)
            return false;
        return true;
    }

    private boolean firstWord(Word word) {

        int i; // index for rows
        int j; // index for cols
        int wLength = word.getTiles().length;

        if (board[7][7] != null)
            return false;

        if (word.isVertical() && word.getCol() == 7) {

            int rowIndex = word.getRow(); // index of the first letter in word

            for (i = 0; i < wLength; i++) {

                if (rowIndex + i == 7) // first word valid and one of is tiles at "*";
                    return true;

            }

        } else if (!word.isVertical() && word.getRow() == 7) {

            int colIndex = word.getCol(); // index of the first letter in word

            for (j = 0; j < wLength; j++) {

                if (colIndex + j == 7) // first word valid and one of is tiles at "*";
                    return true;
            }
        }
        return false;
    }

    boolean boardLegal(Word w)
    {
        // wordInBoard is Help Method that checks if the word is legal.
        if (!wordInBoard(w))
            return false;

        if (board[7][7] == null) {// If the game is not start yet, Help Method gameNotStartYet checks if the word is goings to be on the (7,7) Tile.
            if (!firstWord(w))
                return false;
        }

        if (isLapping(w, board) || isTouchingWord(w)) // isLapping is Help Method that checks if the word lean on one of the existing tiles on the board.
            return true;

        return false;
    }

    ////// Help Methods for boardLegal

    boolean isTouchingWord(Word word){ // checks if the touching word is in dictionary
        ArrayList<Word> tmp = getWords(word);
        for(Word w: tmp)
            if(dictionaryLegal(w))
                return true;
        return false;
    }
    boolean dictionaryLegal(Word word) {
        return true;
    }

    ArrayList<Word> getWords(Word word) {

        ArrayList<Word> optWords = new ArrayList<>();
        optWords.add(word);
        int first ,last; // The first/last index of the new word.
        int wordIndex = 0; // original words index

        Tile[] tileArray;
        if (!word.isVertical())
        {


            int loopItr = word.getTiles().length + word.getCol();
            first = word.getRow(); // index of first Tile in word we found on board
            last = word.getRow(); // index of last Tile in  word we found on board

            for (int i = word.getCol(); i < loopItr; i++) // runs through the word - horizontally
            {

                int row = word.getRow();
//                if (isLapping(word, scrabbleBoard))
//                    continue;
                if(board[word.getRow()][i] == word.getTiles()[wordIndex]) {
                    wordIndex++;
                    continue;
                }


                if (board[row - 1][i] != null) { // goes up on board
                    first = findUpWordIndex(row - 1, i);
                }
                if (board[row + 1][i] != null) { // goes down on board
                    last = findDownWordIndex(row + 1, i);
                }
                // If there is only one letter, it means that there is new word.
                if(last == first)
                {
                    wordIndex++;
                    continue;
                }

                // Create word ---->

                int lengthWord = last - first + 1;
                tileArray = new Tile[lengthWord]; // create new tile array for new optional word

                int indexTa = 0; // index new tile array

                for (int j = first; j < lengthWord+first; j++)
                { // create the Word
                    if (board[j][i] == null) {
                        tileArray[indexTa] = word.getTiles()[wordIndex];

                    } else {
                        Tile newTile = board[j][i];
                        tileArray[indexTa] = newTile;
                    }
                    indexTa++;

                }
                // <----

                if(indexTa>0)  // Push word.
                {
                    Word newWord = new Word(tileArray, first, i,true );
                    optWords.add(newWord);
                    first = last = word.getRow();
                }
                wordIndex++;
            }

        }
        else{

            int loopItr = word.getTiles().length + word.getRow();
            first = word.getCol(); // index of first Tile in word we found on board
            last = word.getCol(); // index of last Tile in  word we found on board

            for (int i = word.getRow(); i < loopItr; i++) // runs through the word - vertically
            {

                int col = word.getCol();


                if(board[i][word.getCol()] == word.getTiles()[wordIndex]) {
                    wordIndex++;
                    continue;
                }

                // Get the length of the word ---->

                if (board[i][col-1] != null) { // goes right on board
                    first = getFirstColIndex(i, col-1);
                }
                if (board[i][col+1] != null) { // goes up on board
                    last = getLastColIndex(i, col+1);
                }
                if(last == first) {
                    wordIndex++;
                    continue;
                }
                int lengthWord = last - first + 1;
                tileArray = new Tile[lengthWord]; // create new tile array for new optional word

                // <----

                int indexTa = 0; // index new tile array

                for (int j = first; j < lengthWord+first; j++) { // create the Word
                    if (board[i][j] == null) {
                        tileArray[indexTa] = word.getTiles()[wordIndex];

                    } else {
                        Tile newTile = board[i][j];
                        tileArray[indexTa] = newTile;
                    }
                    indexTa++;


                }
                if(indexTa>0) {
                    Word newWord = new Word(tileArray,i,first,false );
                    optWords.add(newWord);
                    first = last = word.getCol();
                }
                wordIndex++;
            }

        }

        return optWords;
    }

    // Help Method for getWords, return the first row of the word.
    int findUpWordIndex(int row,int col){ // find start index of word

        while ( board[row-1][col] != null)
        {
            row--;
        }
        return row;
    }

    // Help Method for getWords, return the last row of the word.
    int findDownWordIndex(int row,int col){ // find end index of word
        while ( board[row+1][col] != null)
        {
            row++;
        }
        return row;
    }
    private int getLastColIndex(int row, int col) {
        while ( board[row][col+1] != null)
        {
            col++;
        }
        return col;
    }
    private int getFirstColIndex(int row, int col) {
        while ( board[row][col-1] != null)
        {
            col--;
        }
        return col;
    }

    public int specialBonus(Word word, String color) {

        int ltrScore = 0;
        int i;
        for (i = 0; i < word.getTiles().length; i++) {
            ltrScore += word.getTiles()[i].score;
        }

        if (color.equals("red"))
            ltrScore *= 3;
        else
            ltrScore *= 2;

        return ltrScore;

    }

    public int getScore(Word word) {

        Integer row = word.getRow();
        Integer col = word.getCol();
        int sumScore = 0;
        int mul = 1;
        String indexTileKey;
        for (int i = 0; i < word.getTiles().length; i++) {

            indexTileKey = row.toString() + col.toString();
            String val = bonusBoard.get(indexTileKey);

            if( word.isVertical() )
                row++;
            else
            {
                col++;
            }

            if (bonusBoard.containsKey(indexTileKey) && word.getTiles()[i] != null) // val is bonus tile
            {
                switch (val) {

                    case ("green"):
                        sumScore += word.getTiles()[i].score;
                        break;

                    case ("red"):
                        mul *= 3;
                        sumScore += word.getTiles()[i].score;
//
                        break;
                    case ("yellow"):
                        sumScore += word.getTiles()[i].score;
                        mul *= 2;
                        break;
                    case ("star"):
                        sumScore += word.getTiles()[i].score;
                        mul *= 2;
                        bonusBoard.replace(indexTileKey,"green");
                        break;

                    case ("azure"):
                        sumScore += word.getTiles()[i].score * 2;
                        break;
                    case ("blue"):
                        sumScore += word.getTiles()[i].score * 3;
                        break;
                }
            }

            else{sumScore += board[row.intValue()][col.intValue()].score;}
        }
        sumScore = sumScore * mul;
        return sumScore;
    }

    public int tryPlaceWord(Word word) {

        Word myWord = createFullWord(word);

        if (boardLegal(myWord) && dictionaryLegal(myWord)) {


            int addedScore = 0;
            ArrayList<Word> addedWords = getWords(myWord);

            for (Word newWord : addedWords) {
                if (dictionaryLegal(newWord)) {
                    addedScore += getScore(newWord);
                } else //At least one word isn't legal
                {
                    break;
                }
            }

            placeOnBoard(word);

            return addedScore;
        }
        return 0;
    }

    Word createFullWord(Word word) {
        Word newWord;

        Tile[] newTile = new Tile[word.getTiles().length];
        if (word.isVertical()) {
            for (int i = 0; i < word.getTiles().length; i++) {
                if (word.getTiles()[i] == null) {
                    newTile[i] = board[word.getRow() + i][word.getCol()];
                } else {
                    newTile[i] = word.getTiles()[i];
                }
            }
            newWord = new Word(newTile, word.getRow(), word.getCol(), word.isVertical());
            return newWord;

        }
        else{
            for (int i = 0; i < word.getTiles().length; i++) {
                if (word.getTiles()[i] == null) {
                    newTile[i] = board[word.getRow()][word.getCol() + i];
                } else {
                    newTile[i] = word.getTiles()[i];
                }
            }
            newWord = new Word(newTile, word.getRow(), word.getCol(), word.isVertical());
            return newWord;

        }
    }

    void placeOnBoard(Word word) {

        int row = word.getRow();
        int col = word.getCol();

        if (word.isVertical())
        {
            for (int i = 0; i < word.getTiles().length; i++)
            {
                if (board[row][col] == null) {
                    board[row][col] = word.getTiles()[i];
                }
                row += 1;
            }
        }

        else
        {
            for (int i = 0; i < word.getTiles().length; i++) {
                if (board[row][col] == null) {
                    board[row][col] = word.getTiles()[i];
                }
                col += 1;
            }
        }
    }
}


