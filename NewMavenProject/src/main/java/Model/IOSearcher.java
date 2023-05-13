package Model;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IOSearcher
{
    public static boolean search(String word,String...fileNames)
    {

        for(String fileName : fileNames)
        {
            try
            {
                Scanner scanner = new Scanner(new File(fileName));

                while(scanner.hasNext())
                {

                    String line = scanner.nextLine();

                    for (String singleWord : line.split("\\s|\\W"))
                    {
                        if (word.equals(singleWord))
                        {
                            return true;
                        }
                    }
                }

            }

            catch (FileNotFoundException e)
            {
                throw new RuntimeException("File not found");
            }

        }


        return false;
    }
}
