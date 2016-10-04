package com.example.arondaniel.lolpickshelp;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by AronDaniel on 22/09/2016.
 */

public class ChampionPool {



    private final static ArrayList<Champion> championCollection = new ArrayList<Champion>();
    static {

        Champion champion = new Champion();


        //==============================================//
        //Adicionando na lista a champion Akali         //
        //==============================================//
        champion.setName("akali");
        championCollection.add(champion);

        //===============================================//
        //Adicionando na lista a champion Ahri           //
        //===============================================//
        champion = new Champion();
        champion.setName("ahri");
        championCollection.add(champion);

        //===============================================//
        //Adicionando na lista a champion Gnar           //
        //===============================================//
        champion = new Champion();
        champion.setName("gnar");
        championCollection.add(champion);

        //===============================================//
        //Adicionando na lista a champion Lux            //
        //===============================================//
        champion = new Champion();
        champion.setName("lux");
        championCollection.add(champion);


        //===============================================//
        //Adicionando na lista a champion Xerath         //
        //===============================================//
        champion = new Champion();
        champion.setName("xerath");
        championCollection.add(champion);

        //===============================================//
        //Adicionando na lista o champion Zilean         //
        //===============================================//
        champion = new Champion();
        champion.setName("zilean");
        championCollection.add(champion);

        //===============================================//
        //Adicionando na lista a champion Zyra           //
        //===============================================//
        champion = new Champion();
        champion.setName("zyra");
        championCollection.add(champion);

    }

    public static ArrayList<Champion> getChampionArrayList() {
        return championCollection;
    }

    public static Champion getItem(int index){
        return championCollection.get(index);
    }

    public static int getIndex(String name){
        return 0;
    }

    public static int getLenght(){
        return championCollection.size();
    }


}
