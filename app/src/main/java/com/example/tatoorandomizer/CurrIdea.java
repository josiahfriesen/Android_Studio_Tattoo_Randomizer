package com.example.tatoorandomizer;

import java.lang.reflect.Array;

public class CurrIdea {
    String idea = "";
    String color = "";

    public void setIdea(String new_idea){
        idea = new_idea;
    }
    public void setColor(String new_color){
        color = new_color;
    }

    public String[] getInfo(){
        String[] info;
        info = new String[] {color, idea};
        return info;
    }

}
