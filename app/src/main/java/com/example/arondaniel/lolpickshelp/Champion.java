package com.example.arondaniel.lolpickshelp;

import android.content.res.Resources;
import android.media.Image;
import android.util.Log;
import android.widget.ImageView;

import java.util.Collection;

/**
 * Created by AronDaniel on 22/09/2016.
 */

public class Champion {

    private String name;

    public void onCreate(String name) {
        this.setName(name);
    }
    public void setName(String name){

        this.name = name;

    }

    public String getName(){
        return this.name;
    }

}
