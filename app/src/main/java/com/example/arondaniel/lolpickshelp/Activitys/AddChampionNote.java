package com.example.arondaniel.lolpickshelp.Activitys;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.arondaniel.lolpickshelp.Champion;
import com.example.arondaniel.lolpickshelp.ChampionAndGroupList;
import com.example.arondaniel.lolpickshelp.MyClasses.MyCircularImageView;
import com.example.arondaniel.lolpickshelp.MyClasses.MyImageAdapter;
import com.example.arondaniel.lolpickshelp.R;

import java.io.Serializable;

import static android.R.id.message;

public class AddChampionNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_champion_note);
    }

    public void addChampionCounter(View view){
        // Criando o intent que irá iniciar a atividade de AddChampionCounter
        Intent intent = new Intent(this, AddChampionCounterActivity.class);
        intent.putExtra(HomeScreenActivity.EXTRA_MESSAGE, message);
        startActivityForResult(intent,0);


    }


    // Método invocado quando o usuário selecionar uma série de champion counters e clicar em selecionar
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {



        // Verificando se deu tudo ok com a Activity

        if (resultCode == RESULT_OK) {

            ChampionAndGroupList championList = (ChampionAndGroupList) intent.getSerializableExtra(HomeScreenActivity.CHAMPION_SELECTED_MESSAGE);
            GridView gridView = (GridView) findViewById(R.id.addChampionNote_ChampionCounterGrid);
            gridView.setAdapter(new MyImageAdapter(this, championList.getChampionCollection()));
            if (championList.getChampionCollection() != null)
            {
                for (int i = 0; i < championList.size(); i++) {
                    Log.d("AddChampion", "Champion name:" + championList.getChampion(i).getName());

                }
                // do something with the customer
            }
            else{
            Log.d("AddChampion", "É nulo");}
        }
    }
}
