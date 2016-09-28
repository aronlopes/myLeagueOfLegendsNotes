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

public class ChampionList {



    private final static ArrayList<Champion> championCollection = new ArrayList<Champion>();
    static {

        Champion champion = new Champion();


        //==============================================//
        //Adicionando na lista a champion Akali         //
        //==============================================//
        champion.setName("Akali");
        championCollection.add(champion);

        //===============================================//
        //Adicionando na lista a champion Ahri           //
        //===============================================//
        champion = new Champion();
        champion.setName("Ahri");
        championCollection.add(champion);

        //===============================================//
        //Adicionando na lista a champion Gnar           //
        //===============================================//
        champion = new Champion();
        champion.setName("Gnar");
        championCollection.add(champion);

        //===============================================//
        //Adicionando na lista a champion Lux            //
        //===============================================//
        champion = new Champion();
        champion.setName("Lux");
        championCollection.add(champion);


        //===============================================//
        //Adicionando na lista a champion Xerath         //
        //===============================================//
        champion = new Champion();
        champion.setName("Xerath");
        championCollection.add(champion);

        //===============================================//
        //Adicionando na lista o champion Zilean         //
        //===============================================//
        champion = new Champion();
        champion.setName("Zilean");
        championCollection.add(champion);

        //===============================================//
        //Adicionando na lista a champion Zyra           //
        //===============================================//
        champion = new Champion();
        champion.setName("Zyra");
        championCollection.add(champion);

    }

    public static Collection<Champion> getChampionCollection() {
        return championCollection;
    }

    public static Champion getItem(int index){
        Log.d("ChampionList", "Retornou o champion:" + championCollection.get(index).getName());
        return championCollection.get(index);
    }

    public static int getIndex(String name){
        return 0;
    }

    public static int getLenght(){
        return championCollection.size();
    }


}
