package com.example.arondaniel.lolpickshelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static android.R.id.message;

public class HomeScreenActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.arondaniel.lolpickshelp";

    // TAG utilizada nos logs desta activity
    private static String TAG = "HomeScreen";
    public static String CHAMPION_NAME = "ChampionName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

    }


    // Caso o usuário clique no botão "Pick Selection" vamos iniciar esta atividade.
    public void pickSelection(View view){
        Log.d(TAG, "Entrou no método Pick Selection");

        // Criando o intent que irá iniciar a atividade de ChampionSelection
        Intent intent = new Intent(this, ChampionSelectionActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    public void makeANote(View view){
        Log.d(TAG, "Entrou no método Make a Note");

        // Criando o intent que irá iniciar a atividade de makeANote
        Intent intent = new Intent(this, MakeANoteActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
