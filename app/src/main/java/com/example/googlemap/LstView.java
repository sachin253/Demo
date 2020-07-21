package com.example.googlemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LstView extends AppCompatActivity
{
ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_view);
        lv=findViewById(R.id.lvid);

        try {
            final Resources resources = this.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.mock);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            ArrayList<String> lines = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            br.close();
            int size=lines.size();
            String li[][]=new String[size][6];
            int i=0;
           for(String s:lines)
           {
               String a[]=s.split(",");
               for(int j=0;j<6;j++)
               {
                   li[i][j]=a[j];
               }
                i++;
           }
           for(int k=0;k<li.length;k++)
           {
               for(int j=0;j<li[k].length;j++)
               {
                   System.out.println(li[k][j]);

               }
           }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lines);
            lv.setAdapter(adapter);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}