package com.example.arondaniel.lolpickshelp.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.arondaniel.lolpickshelp.ChampionPool;
import com.example.arondaniel.lolpickshelp.MyClasses.MyImageAdapter;
import com.example.arondaniel.lolpickshelp.R;

public class MakeANoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_anote);

        // Criando a gridview que irá exibir os campeões
        GridView gridview = (GridView) findViewById(R.id.makeANoteGrid);
        gridview.setAdapter(new MyImageAdapter(this));

        // Declarando o listener
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Criando a string do campeão selecionado pelo usuário
                String championName = ChampionPool.getItem(position).getName().toString();

                // Criando o intent que irá iniciar a atividade de ChampionScreen
                Intent intent = new Intent(MakeANoteActivity.super.getApplicationContext(), ChampionScreenActivity.class);
                intent.putExtra(HomeScreenActivity.CHAMPION_NAME, championName);
                startActivity(intent);

            }
        });
    }
}
