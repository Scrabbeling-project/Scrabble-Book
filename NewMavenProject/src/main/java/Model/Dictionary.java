// Name: Tal Harel
// Id: 208991885



package Model;


import Model.IOSearcher;
import Model.LFU;
import Model.LRU;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Dictionary
{
    CacheManager cacheManager01;
    CacheManager cacheManager02;
    BloomFilter bloomFilter;
    ArrayList<String> filesList;


    public Dictionary(String... fileNames)
    {
        cacheManager01 = new CacheManager( 400,new LRU());
        cacheManager02 = new CacheManager( 100,new LFU());
        bloomFilter = new BloomFilter(256, "MD5", "SHA1");
        this.filesList = new ArrayList<String>();

        for (String fileName : fileNames)
        {
            this.filesList.add(fileName);
            addWordsBloomFilter(bloomFilter, fileName);
        }
    }


    public void addWordsBloomFilter(BloomFilter bloomFilter, String fileName)
    {


        ArrayList<String> words = new ArrayList<>();
        try
        {
            Scanner scanner = new Scanner(new File(fileName));

            while (scanner.hasNext())
            {
                String[] wordsInLine = scanner.nextLine().split("\\W+");
                words = new ArrayList<>(Arrays.asList(wordsInLine));


                for (String word : words)
                {
                    bloomFilter.add(word);
                }
            }


            scanner.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }


    }


    public boolean query(String word)
    {
        if (cacheManager01.query(word))
        {
            return true;
        }

        if (cacheManager02.query(word))
        {
            return false;
        }

        if (bloomFilter.contains(word))
        {
            cacheManager01.add(word);
            return true;
        }

        cacheManager02.add(word);
        return false;
    }


    public boolean challenge(String word)
    {

        for (String fileName : filesList)
        {
            if (IOSearcher.search(word, fileName))
            {
                cacheManager01.add(word);
                return true;
            }


        }

        cacheManager02.add(word);
        return false;

    }
}