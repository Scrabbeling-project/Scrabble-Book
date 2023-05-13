package Model;


import java.util.HashMap;
import java.util.Map;


public class LFU implements CacheReplacementPolicy
{

    HashMap<String,Integer> cacheMap;


    public LFU()
    {
        cacheMap = new HashMap<>();
    }


    @Override
    public void add(String word)
    {

        if (cacheMap.containsKey(word)) // If frequency != 0, cacheMap contains word, increment the frequency.
        {
            int newFrequency = cacheMap.get(word);
            newFrequency+=1;
            cacheMap.put(word,newFrequency);
            return;
        }

        cacheMap.put(word,0);

    }

    @Override
    public String remove()
    {

        Map.Entry<String,Integer> minEntry = null;




        for (Map.Entry<String, Integer> entry : cacheMap.entrySet())
        {
            if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0)
            {
                minEntry = entry;
            }
        }



        return minEntry.getKey();
    }
}
