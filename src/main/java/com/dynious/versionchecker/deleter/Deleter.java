package com.dynious.versionchecker.deleter;

import java.io.*;

public class Deleter
{
    public static void main(String[] args)
    {
        if (args.length >= 1)
        {
            String path = args[0];
            try
            {
                File deleteFile = new File(path);
                BufferedReader reader = new BufferedReader(new FileReader(deleteFile));

                String line;
                while((line = reader.readLine()) != null)
                {
                    System.out.println(line);
                    File file = new File(line);
                    if (!file.delete())
                    {
                        file.deleteOnExit();
                    }
                }
                reader.close();
                if (!deleteFile.delete())
                {
                    deleteFile.deleteOnExit();
                }
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}
