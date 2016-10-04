package com.example.arondaniel.lolpickshelp;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by AronDaniel on 04/10/2016.
 */

public class ChampionAndGroupList implements Serializable {
    private static ArrayList<Champion> championCollection;
    public ChampionAndGroupList() {
        this.championCollection = new ArrayList<Champion>();

    }

    public ChampionAndGroupList(ArrayList<Champion> championCollection) {
        this.championCollection = championCollection;

    }

    public ArrayList<Champion> getChampionCollection() {
        return championCollection;
    }

    public void setChampionCollection(ArrayList<Champion> championCollection) {
        this.championCollection = championCollection;
    }

    public void addChampion(Champion champion){
        this.championCollection.add(champion);
    }

    public void removeChampion(Champion champion){
        this.championCollection.remove(this.championCollection.indexOf(champion));
    }

    public Champion getChampion(int index){
        return this.championCollection.get(index);
    }

    public int size(){
        return this.championCollection.size();
    }


    // Não sei pra que serve esse código mas não funciona sem ele.
    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException {

    }
    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
    }
    private void readObjectNoData()
            throws ObjectStreamException {
    }


}