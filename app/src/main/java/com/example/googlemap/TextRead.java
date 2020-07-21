package com.example.googlemap;

import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextRead
{
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args)  throws Exception
    {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get("file.txt"), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        BufferedReader bufReader = new BufferedReader(new FileReader("file.txt"));
     ArrayList<String> listOfLines = new ArrayList<>();
     String line = bufReader.readLine();

     while (line != null)
     {
         listOfLines.add(line);
         line = bufReader.readLine();
     }
     bufReader.close();

}

}
