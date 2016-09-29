package com.example.arondaniel.lolpickshelp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class ChampionsSearchActivity extends AppCompatActivity {

    public static final String CHAMPION_SELECTED_MESSAGE = "com.example.arondaniel.lolpickshelp";

    @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champions_search);

        // Criando a gridview que irá exibir os campeões
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        // Declarando o listener
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Criando a string do campeão selecionado pelo usuário
                String stringDoIcone = ChampionList.getItem(position).getName().toString() + "_icon";

                Intent intent = new Intent();

                // Enviando a string do campeão selecionado para a activity pai
                intent.putExtra(CHAMPION_SELECTED_MESSAGE, stringDoIcone.toLowerCase());
                setResult(RESULT_OK, intent);

                Log.d("ChampionSearch", "Campião selecionado:" + stringDoIcone.toLowerCase());

                finish();
            }
        });
    }

}
