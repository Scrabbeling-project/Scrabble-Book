package Model;


import java.util.HashMap;

public class DictionaryManager
{

    private static DictionaryManager dm = null;
    HashMap<String,Dictionary> map = new HashMap<>();


    public static DictionaryManager get()
    {
        if (dm == null)
        {
            dm = new DictionaryManager();
            return dm;
        }

        return dm;
    }



    public boolean query(String...args)
    {
        String word = args[args.length -1];
        boolean wordisExist = false;



        for (int i = 0;i<args.length-1;i++)
        {
            if (!map.containsKey(args[i]))
            {
                map.put(args[i], new Dictionary(args[i]));
            }


            if (!wordisExist)
            {
                wordisExist = map.get(args[i]).query(word);
            }
            else
                {
                    map.get(args[i]).query(word);
                }
        }
        return wordisExist;
    }



    public boolean challenge(String...args)
    {
        String word = args[args.length -1];
        boolean wordisExist = false;



        for (int i = 0;i<args.length-1;i++)
        {
            if (!map.containsKey(args[i]))
            {
                map.put(args[i], new Dictionary(args[i]));
            }


            if (!wordisExist)
            {
                wordisExist = map.get(args[i]).challenge(word);
            }
            else
            {
                map.get(args[i]).challenge(word);
            }
        }
        return wordisExist;
    }



    public int getSize()
    {
        return map.size();
    }



}
