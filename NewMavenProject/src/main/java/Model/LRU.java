package Model;


import java.util.LinkedHashSet;

public class LRU implements CacheReplacementPolicy
{

    LinkedHashSet<String> words = new LinkedHashSet<>();

    public LRU()
    {
        words = new LinkedHashSet<>();
    }


    @Override
    public void add(String word)
    {
        words.remove(word);
        words.add(word);
    }

    // Remove and return the first word in words because is the oldest.
    @Override
    public String remove()
    {
        String theOldest = words.iterator().next();
        return theOldest;
    }
}
