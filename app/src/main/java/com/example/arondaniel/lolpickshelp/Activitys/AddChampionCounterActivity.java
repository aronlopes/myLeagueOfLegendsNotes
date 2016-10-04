package com.example.arondaniel.lolpickshelp.Activitys;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.arondaniel.lolpickshelp.Champion;
import com.example.arondaniel.lolpickshelp.ChampionAndGroupList;
import com.example.arondaniel.lolpickshelp.ChampionPool;
import com.example.arondaniel.lolpickshelp.MyClasses.MyImageAdapter;
import com.example.arondaniel.lolpickshelp.R;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

public class AddChampionCounterActivity extends AppCompatActivity {
    private static ChampionAndGroupList championList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_champion_counter);

        championList = new ChampionAndGroupList();


        // Criando a gridview que irá exibir os campeões
        final GridView gridview = (GridView) findViewById(R.id.addChampionCounter_GridView);
        gridview.setAdapter(new MyImageAdapter(this));

        // Declarando o listener
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Toda vez que o usuário clicar em um champion nós iremos:
                // 1. Adicionar uma borda no ícone da view e adicioner ele na lista de campeões selecionados
                // ou
                // 2. Remover a borda e remover ele da lista
                if(v.getBackground() != null && v.getBackground().isVisible()){
                    v.setBackgroundColor(Color.TRANSPARENT);
                    championList.removeChampion(ChampionPool.getItem(position));
                }
                else{
                    v.setBackgroundColor(Color.YELLOW);
                    championList.addChampion(ChampionPool.getItem(position));
                }

            }
        });
    }

    // Quando o usuário clicar no botão, encerra essa atividade e joga a lista
    // de campeões selecionados para a Activity pai
    public void selectChampionsCounter (View view){

        Intent intent = new Intent();
        intent.putExtra(HomeScreenActivity.CHAMPION_SELECTED_MESSAGE, championList);
        setResult(RESULT_OK, intent);

        finish();
    }

}
