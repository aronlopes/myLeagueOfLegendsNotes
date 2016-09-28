package com.example.arondaniel.lolpickshelp;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

/**
 * Created by AronDaniel on 21/09/2016.
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;

    public ImageAdapter(Context c) {
        context = c;
    }

    public int getCount() {
        return ChampionList.getLenght();
    }

    public Object getItem(int position) {
        return ChampionList.getItem(position);
    }

    public long getItemId(int position) {

        String stringDoIcone = ChampionList.getItem(position).getName().toString() + "_icon";

        int identificador = context.getResources().getIdentifier(stringDoIcone.toLowerCase(), "drawable", R.drawable.class.getPackage().getName());

//        Log.d("ImageAdapter", "ChampionList valor:" + identificador);
//        Log.d("ImageAdapter", "mThumbIds valor:" + mThumbIds[position].longValue());
        return identificador;

    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        // O código abaixo pega o identificador  do icone de cada campeão
        String stringDoIcone = ChampionList.getItem(position).getName().toString() + "_icon";

        int identificador = context.getResources().getIdentifier(stringDoIcone.toLowerCase(), "drawable", R.drawable.class.getPackage().getName());

        // Setando o imageView com a imagem do campeão utilizando o identificador
        imageView.setImageResource(identificador);

        return imageView;
    }
}