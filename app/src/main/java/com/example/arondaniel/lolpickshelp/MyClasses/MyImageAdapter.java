package com.example.arondaniel.lolpickshelp.MyClasses;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.arondaniel.lolpickshelp.Champion;
import com.example.arondaniel.lolpickshelp.ChampionPool;
import com.example.arondaniel.lolpickshelp.R;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by AronDaniel on 21/09/2016.
 */
public class MyImageAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Champion> championPool;

    public MyImageAdapter(Context c) {
        context = c;
        championPool = ChampionPool.getChampionArrayList();
    }

    public MyImageAdapter(Context c, ArrayList<Champion> championList) {
        context = c;
        championPool = championList;
    }

    public int getCount() {
        return championPool.size();
    }

    public Object getItem(int position) {
        return championPool.get(position);
    }

    public long getItemId(int position) {

        String stringDoIcone = championPool.get(position).getName().toString() + "_icon";

        int identificador = context.getResources().getIdentifier(stringDoIcone.toLowerCase(), "drawable", R.drawable.class.getPackage().getName());

        return identificador;

    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(120, 120));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        // O código abaixo pega o identificador  do icone de cada campeão
        String stringDoIcone = championPool.get(position).getName().toString() + "_icon";

        int identificador = context.getResources().getIdentifier(stringDoIcone.toLowerCase(), "drawable", R.drawable.class.getPackage().getName());

        // Setando o imageView com a imagem do campeão utilizando o identificador
        imageView.setImageResource(identificador);

        return imageView;
    }
}