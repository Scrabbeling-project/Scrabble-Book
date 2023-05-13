package Model;


import java.util.Arrays;
import java.util.Objects;

public class Word
{
    private Tile[] tiles;
    private int row;
    private int col;
    private boolean vertical;

    public Word(Tile[] tiles, int row, int col, boolean vertical)
    {

        /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

        //this.tiles = tiles; // Shallow copy, if tiles will change this.tiles will change also.
        this.tiles = new Tile[tiles.length];
        System.arraycopy(tiles,0,this.tiles,0,tiles.length); // deep copy

        
        this.row = row;
        this.col = col;
        this.vertical = vertical;
    }

    public Tile[] getTiles()
    {
        return tiles;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public boolean isVertical()
    {
        return vertical;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return row == word.row &&
                col == word.col &&
                vertical == word.vertical &&
                Arrays.equals(tiles, word.tiles);
    }


}
