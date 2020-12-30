package com.example.tatoorandomizer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;



public class GenerateActivity extends AppCompatActivity {
    TextView textView;
    TextView output;
    Button generate;
    Button inspo;
    CurrIdea current_idea = new CurrIdea();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        textView = findViewById(R.id.textView);
        output = findViewById(R.id.output);
        generate = findViewById(R.id.generate);
        inspo = findViewById(R.id.inspo);

        output.setVisibility(View.INVISIBLE);
        inspo.setVisibility(View.INVISIBLE);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void sendOutput(View view) {
        output.setVisibility(View.VISIBLE);
        inspo.setVisibility(View.VISIBLE);
        AssetManager assetManager = getAssets();
        ArrayList<String> list_of_ideas = com.example.tatoorandomizer.InputRead.read(assetManager);
        ArrayList<String> list_of_parts = new ArrayList<String>();
        ArrayList<String> list_of_colors = new ArrayList<String>();
        Random rand = new Random();
        list_of_parts.add("neck");
        list_of_parts.add("ear");
        list_of_parts.add("ankle");
        list_of_parts.add("forearm");
        list_of_parts.add("foot");
        list_of_parts.add("toe");
        list_of_parts.add("calf");
        list_of_parts.add("forehead");
        list_of_parts.add("eye");
        list_of_parts.add("ribcage");
        list_of_parts.add("butt");
        list_of_parts.add("lip");
        list_of_parts.add("eyelid");
        list_of_parts.add("wrist");
        list_of_parts.add("scalp");
        list_of_parts.add("hip");
        list_of_parts.add("spine");
        list_of_parts.add("shoulder blade");
        list_of_parts.add("butt (above)");


        list_of_colors.add("red");
        list_of_colors.add("blue");
        list_of_colors.add("green");
        list_of_colors.add("yellow");
        list_of_colors.add("purple");
        list_of_colors.add("black");
        list_of_colors.add("orange");
        list_of_colors.add("pink");
        list_of_colors.add("cyan");
        list_of_colors.add("magenta");
        list_of_colors.add("indigo");
        list_of_colors.add("chartreuse");
        list_of_colors.add("baby pink");
        list_of_colors.add("hot pink");
        list_of_colors.add("fucsia");


        //TextView textView = (TextView) findViewById(R.id.output);
        System.out.println(list_of_ideas);
        int i = rand.nextInt(list_of_ideas.size());
        int p = rand.nextInt(list_of_parts.size());
        int c = rand.nextInt(list_of_colors.size());
        String idea = list_of_ideas.get(i).toLowerCase();
        String part = list_of_parts.get(p);
        String color = list_of_colors.get(c);
        char vow = color.charAt(0);
        char plural = idea.charAt(idea.length() - 1);
        String prefix = "";
        String verb = " tattoo ";
        if (plural == 's') {
            prefix = "Get ";
            verb = " tattooed ";
        }
        else if (vow == 'a' || vow == 'e' || vow == 'i' || vow == 'o' || vow == 'u') {
            prefix = "Get an ";
        }
        else {
            prefix = "Get a ";
        }
        current_idea.setColor(color);
        current_idea.setIdea(idea);
        String message = prefix + color+" "+idea + verb + "on your "+part+". ";
        output.setText(message);
    }

    public void displayLink (View view){
        try {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            String term = (current_idea.getInfo())[0] + " " + (current_idea.getInfo()[1]) + " tattoo";
            intent.putExtra(SearchManager.QUERY, term);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse()));
    }
}