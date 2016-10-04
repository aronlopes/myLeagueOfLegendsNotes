package com.example.arondaniel.lolpickshelp.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.arondaniel.lolpickshelp.ChampionPool;
import com.example.arondaniel.lolpickshelp.MyClasses.MyImageAdapter;
import com.example.arondaniel.lolpickshelp.R;

public class ChampionsSearchActivity extends AppCompatActivity {

    @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champions_search);

        // Criando a gridview que irá exibir os campeões
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new MyImageAdapter(this));

        // Declarando o listener
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Criando a string do campeão selecionado pelo usuário
                String stringDoIcone = ChampionPool.getItem(position).getName().toString();

                Intent intent = new Intent();

                // Enviando a string do campeão selecionado para a activity pai
                intent.putExtra(HomeScreenActivity.CHAMPION_SELECTED_MESSAGE, stringDoIcone.toLowerCase());
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }

}
