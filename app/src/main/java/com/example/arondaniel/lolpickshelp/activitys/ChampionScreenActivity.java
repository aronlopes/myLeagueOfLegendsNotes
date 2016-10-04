package com.example.arondaniel.lolpickshelp.Activitys;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arondaniel.lolpickshelp.ChampionListNotes;
import com.example.arondaniel.lolpickshelp.R;
import com.example.arondaniel.lolpickshelp.SecondFragment;

import static android.R.id.message;

public class ChampionScreenActivity extends AppCompatActivity {

    // TAG utilizada para debug (Log.d)
    private static String TAG = "ChampionScreen";

    FragmentPagerAdapter adapterViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_screen);


        //Pegando do Intent o nome de campeão passado como parametro
        String championNameString = getIntent().getStringExtra(HomeScreenActivity.CHAMPION_NAME);


        //Pegando a textView do nome do campeão
        TextView championName = (TextView) findViewById(R.id.championScreen_championName);
        //Pegando a imageView do retrato do campeão
        ImageView championPortrait = (ImageView) findViewById(R.id.championScreen_championPortrait);

        // O trecho abaixo pega o identificador  do icone do campeão selecionado
        int idChampionIcon = this.getResources().getIdentifier(championNameString.concat("_icon"), "drawable", this.getPackageName());

        //Setando o nome do campeão
        championName.setText(championNameString.substring(0,1).toUpperCase() + championNameString.substring(1));
        //Setando o ícone do campeão
        championPortrait.setImageResource(idChampionIcon);

        //Inicializando a viewPager (Tab)
        ViewPager vpPager = (ViewPager) findViewById(R.id.championScreen_ViewPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

    }


    //Declarando a classe que manipula as tabs dessa view
    //Ela é declarada aqui e não em uma outra classe porque ela só serve para esta view
    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    // A primeira tab retorna a lista de anotações de campeões.
                    return ChampionListNotes.newInstance(0, "Page # 1");
                case 1:
                    return ChampionListNotes.newInstance(1, "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return SecondFragment.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {

            //Retornando o nome da tab de acordo com a posição em que ela se encontra.
            switch (position) {
                case 0:
                    // A primeira tab retorna a lista de anotações de campeões.
                    return "Champion Notes";
                default:
                    return "Page x";
            }

        }
    }


    // Método invocado quando o usuário clica no botão "Add Champion Note"
    public void addChampionNote(View view){

        // Criando o intent que irá iniciar a atividade de ChampionSelection
        Intent intent = new Intent(view.getContext(), AddChampionNote.class);
        intent.putExtra(HomeScreenActivity.EXTRA_MESSAGE, message);
        startActivity(intent);

    }



}
