package com.example.tatoorandomizer;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import android.content.res.AssetManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class InputRead {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static ArrayList<String> read(AssetManager assetManager)
    {
        //String filePath = "/Users/josiahfriesen/AndroidStudioProjects/TatooRandomizer/app/ideas.txt";

        InputStream input = null;
        try {
            input = assetManager.open("ideas.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return usingBufferedReader(input);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static ArrayList<String> usingBufferedReader(InputStream input)
    {
        ArrayList<String> list = new ArrayList<String>();

        //try (BufferedReader br = new BufferedReader(new FileReader(input)))
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
//            if (!mFolder.exists()) {
//                mFolder.mkdir();
//            }
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                //list.add((sCurrentLine).concat("\n"));
                list.add(sCurrentLine);
            }
        }
        catch (IOException e)
        {
            System.out.println("IT DOESNT EXIST");
            e.printStackTrace();
        }
        return list;
    }

}
