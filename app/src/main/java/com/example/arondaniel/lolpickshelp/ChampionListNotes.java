package com.example.arondaniel.lolpickshelp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.arondaniel.lolpickshelp.Activitys.ChampionSelectionActivity;
import com.example.arondaniel.lolpickshelp.Activitys.HomeScreenActivity;

import static android.R.id.message;


// Esta classe instancia as notas (anotações) de campeões
// Basicamente o que ela faz é listar todos os campeões que possuem alguma anotação com o campeão selecionado e passado por
// parâmetro.
public class ChampionListNotes extends Fragment {


    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static ChampionListNotes newInstance(int page, String title) {
        ChampionListNotes championListNotes = new ChampionListNotes();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        championListNotes.setArguments(args);
        return championListNotes;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("ChampionListNotes", "pré chamada");
        View view = inflater.inflate(R.layout.activity_champion_list_notes, container, false);
//        TextView tvLabel = (TextView) view.findViewById(R.id.pager_header);
//        tvLabel.setText(page + " -- " + title);

        // Instanciando o GridView que vai exibir a lista de campeões
        GridView gridView = (GridView) view.findViewById(R.id.championList_GridView);

        // Setando o adaptador

        gridView.setAdapter(new ChampionListNotesItemAdapter(view.getContext()));
        return view;
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_champion_list_notes);
//
//        Log.d("ChampionListNotes", "Disparou a activity");
//
//
//        // Instanciando o GridView que vai exibir a lista de campeões
//        GridView gridView = (GridView) findViewById(R.id.championList_GridView);
//
//        // Setando o adaptador
//        gridView.setAdapter(new ChampionListNotesItemAdapter(this));
//
//    }

}
