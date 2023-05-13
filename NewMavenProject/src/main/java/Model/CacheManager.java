
package Model;


import Model.CacheReplacementPolicy;

import java.util.HashSet;
import java.util.Objects;

public class CacheManager
{

    private int size;
	CacheReplacementPolicy crp;
	HashSet<String> cache;


    public CacheManager(int size,CacheReplacementPolicy CRP)
    {
        this.size = size;
        this.crp = CRP;
        cache = new HashSet<>();
    }

    // If word contain in cache return true.
    public boolean query(String word)
    {
        if (cache.contains(word))
        {
            return true;
        }
        return false;
    }

    //Add word to cache, if the size is overflow, first remove by the rules of the crp that is the CacheReplacementPolicy and than add.
    public void add(String word)
    {
        if (cache.size() >= size)
        {
            String wordToRemove = crp.remove();
            cache.remove(wordToRemove);
        }

        crp.add(word);
        cache.add(word);
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CacheManager that = (CacheManager) o;
        return size == that.size &&
                Objects.equals(crp, that.crp) &&
                Objects.equals(cache, that.cache);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(size, crp, cache);
    }
}
