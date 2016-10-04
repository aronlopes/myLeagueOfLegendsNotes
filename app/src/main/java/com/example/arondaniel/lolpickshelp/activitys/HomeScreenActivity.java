package com.example.arondaniel.lolpickshelp.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.arondaniel.lolpickshelp.R;

import static android.R.id.message;

public class HomeScreenActivity extends AppCompatActivity {

    // Definindo strings para utilizar de parâmetros na passagem de Intents
    public static final String EXTRA_MESSAGE = "com.example.arondaniel.lolpickshelp";
    public static final String CHAMPION_NAME = "ChampionName";
    public static final String CHAMPION_SELECTED_MESSAGE = "ChampionSelected";

    // TAG utilizada para debug (Log.d)
    private static String TAG = "HomeScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

    }


    // Caso o usuário clique no botão "Pick Selection" vamos iniciar esta atividade.
    public void pickSelection(View view){

        // Criando o intent que irá iniciar a atividade de ChampionSelection
        Intent intent = new Intent(this, ChampionSelectionActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    public void makeANote(View view){

        // Criando o intent que irá iniciar a atividade de makeANote
        Intent intent = new Intent(this, MakeANoteActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
