package com.example.arondaniel.lolpickshelp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.Random;

import static android.R.id.message;

public class ChampionSelectionActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.arondaniel.lolpickshelp";
    public static final String CHAMPION_SELECTED_MESSAGE = "com.example.arondaniel.lolpickshelp";


    private int championViewIdSelected;

    // Create a string for the ImageView label
    private static final String IMAGEVIEW_TAG = "icon bitmap";

    // TAG utilizada nos logs desta activity
    private static String TAG = "ChampionSelection";

    //Criando um objeto GestureDetector para capturar toque na tela e movimentos
    private MyGestureDetector detector = new MyGestureDetector(new MyGestureAdapterListener());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_picks);


        // O código abaixo pega o identificador  do icone blue_champion e seta a imagemView com ele
        int idBlueIcon = this.getResources().getIdentifier("blue_champion_icon", "drawable", ChampionSelectionActivity.this.getPackageName());

        //==============================================================================
        //Setando os icones default nas views dos bans de campeões
        //==============================================================================
        ImageView imageViewBanBlue1 = (ImageView) findViewById(R.id.championBanBlue1);
        imageViewBanBlue1.setImageResource(idBlueIcon);
        imageViewBanBlue1.setTag("blue_champion_icon");

        ImageView imageViewBanBlue2 = (ImageView) findViewById(R.id.championBanBlue2);
        imageViewBanBlue2.setImageResource(idBlueIcon);
        imageViewBanBlue2.setTag("blue_champion_icon");

        ImageView imageViewBanBlue3 = (ImageView) findViewById(R.id.championBanBlue3);
        imageViewBanBlue3.setImageResource(idBlueIcon);
        imageViewBanBlue3.setTag("blue_champion_icon");


        //==============================================================================
        // Setando os icones default nas views dos picks de campeõesdo lado azul
        //==============================================================================
        MyCircularImageView imageViewBlue1 = (MyCircularImageView) findViewById(R.id.championSelectedBlue1);
        imageViewBlue1.setImageResource(idBlueIcon);
        imageViewBlue1.setTag("blue_champion_icon");

        MyCircularImageView imageViewBlue2 = (MyCircularImageView) findViewById(R.id.championSelectedBlue2);
        imageViewBlue2.setImageResource(idBlueIcon);
        imageViewBlue2.setTag("blue_champion_icon");

        MyCircularImageView imageViewBlue3 = (MyCircularImageView)findViewById(R.id.championSelectedBlue3);
        imageViewBlue3.setImageResource(idBlueIcon);
        imageViewBlue3.setTag("blue_champion_icon");

        MyCircularImageView imageViewBlue4 = (MyCircularImageView) findViewById(R.id.championSelectedBlue4);
        imageViewBlue4.setImageResource(idBlueIcon);
        imageViewBlue4.setTag("blue_champion_icon");

        MyCircularImageView imageViewBlue5 = (MyCircularImageView) findViewById(R.id.championSelectedBlue5);
        imageViewBlue5.setImageResource(idBlueIcon);
        imageViewBlue5.setTag("blue_champion_icon");




        // O código abaixo pega o identificador  do icone red_champion e seta a imagemView com ele
        int idRedIcon = this.getResources().getIdentifier("red_champion_icon", "drawable", ChampionSelectionActivity.this.getPackageName());

        //==============================================================================
        //Setando os icones default nas views dos bans de campeões
        //==============================================================================
        ImageView imageViewBanRed1 = (ImageView) findViewById(R.id.championBanRed1);
        imageViewBanRed1.setImageResource(idRedIcon);
        imageViewBanRed1.setTag("red_champion_icon");

        ImageView imageViewBanRed2 = (ImageView) findViewById(R.id.championBanRed2);
        imageViewBanRed2.setImageResource(idRedIcon);
        imageViewBanRed2.setTag("red_champion_icon");

        ImageView imageViewBanRed3 = (ImageView) findViewById(R.id.championBanRed3);
        imageViewBanRed3.setImageResource(idRedIcon);
        imageViewBanRed3.setTag("red_champion_icon");

        //==============================================================================
        // Setando os icones default nas views dos picks de campeões
        //==============================================================================
        MyCircularImageView imageViewRed1 = (MyCircularImageView) findViewById(R.id.championSelectedRed1);
        imageViewRed1.setImageResource(idRedIcon);
        imageViewRed1.setTag("red_champion_icon");

        MyCircularImageView imageViewRed2 = (MyCircularImageView) findViewById(R.id.championSelectedRed2);
        imageViewRed2.setImageResource(idRedIcon);
        imageViewRed2.setTag("red_champion_icon");

        MyCircularImageView imageViewRed3 = (MyCircularImageView) findViewById(R.id.championSelectedRed3);
        imageViewRed3.setImageResource(idRedIcon);
        imageViewRed3.setTag("red_champion_icon");

        MyCircularImageView imageViewRed4 = (MyCircularImageView) findViewById(R.id.championSelectedRed4);
        imageViewRed4.setImageResource(idRedIcon);
        imageViewRed4.setTag("red_champion_icon");

        MyCircularImageView imageViewRed5 = (MyCircularImageView) findViewById(R.id.championSelectedRed5);
        imageViewRed5.setImageResource(idRedIcon);
        imageViewRed5.setTag("red_champion_icon");



        //===============================================================
        // Inicializando os spinners de seleção de lanes
        //===============================================================
        Spinner spinnerLane1 = (Spinner) findViewById(R.id.championLaneBlue1);
        Spinner spinnerLane2 = (Spinner) findViewById(R.id.championLaneBlue2);
        Spinner spinnerLane3 = (Spinner) findViewById(R.id.championLaneBlue3);
        Spinner spinnerLane4 = (Spinner) findViewById(R.id.championLaneBlue4);
        Spinner spinnerLane5 = (Spinner) findViewById(R.id.championLaneBlue5);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.lanes_array, R.layout.lol_spiner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinnerLane1.setAdapter(adapter);
        spinnerLane2.setAdapter(adapter);
        spinnerLane3.setAdapter(adapter);
        spinnerLane4.setAdapter(adapter);
        spinnerLane5.setAdapter(adapter);


        // Mudando as cores dos textos apresentados no XML
        TextView textYouShouldPick = (TextView) findViewById(R.id.textShouldPick);
        TextView textYouShouldAvoid = (TextView) findViewById(R.id.textShouldAvoid);

        textYouShouldPick.setTextSize(16);
        textYouShouldAvoid.setTextSize(16);

        textYouShouldPick.setTextColor(Color.WHITE);
        textYouShouldAvoid.setTextColor(Color.WHITE);


        //==================================================================================
        //        Definindo o objeto dragable
        //==================================================================================
        // Creates a new ImageView
//        final ImageView imageViewDragItem = new ImageView(this);
//
//        // Sets the bitmap for the ImageView from an icon bit map (defined elsewhere)
//        int w = 10, h = 10;
//
//        Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
//        Bitmap bmp = Bitmap.createBitmap(w, h, conf); // this creates a MUTABLE bitmap
//        Canvas canvas = new Canvas(bmp);
//
//        bmp.setPixel(0,0, Color.RED);
//        imageViewDragItem.setImageBitmap(bmp);
//
//        // Sets the tag
//        imageViewDragItem.setTag(IMAGEVIEW_TAG);

        // Sets a long click listener for the ImageView using an anonymous listener object that
        // implements the OnLongClickListener interface
//        MyDragEventListener mDragListen = new MyDragEventListener();
//        findViewById(R.id.gridview).setOnDragListener(mDragListen);


//        imageViewBlue1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
////                Log.d("ChampionSelection", "motion:");
//                switch (ChampionSelectionActivity.this.detector.onTouchEvent(imageViewBanBlue1, motionEvent))
//                {
//                    case "SINGLETAP":
//                        Log.d("ChampionSelection", "SINGLETAP");
//                        searchChampion(view);
//                        return true;
//                    case "LONGPRESS":
//                        Log.d("ChampionSelection", "LONGPRESS");
//                        return true;
//                }
//                return false;
//            }
//            });
    }


    // Este método é invocado quando o usuário clica na imagem para selecionar um champion.
    public void searchChampion(View view) {

        // Vamos descobrir qual é a view que foi clicada
        int viewId = view.getId();

        // Vamos substituir o campeão caso ele ainda seja o ícone defaul inicial azul ou vermelho
        if (view.getTag() == "blue_champion_icon" || view.getTag() == "red_champion_icon") {

            // Criando o intent que irá iniciar a atividade de ChampionSearch
            Intent intent = new Intent(this, ChampionsSearchActivity.class);
            setChampionViewSelected(viewId);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivityForResult(intent, 0);
        }
        else
        // Caso contrário ele vai ser marcado como um campeão para comparações
        {

            // Caso o ícone seja selecionado seja algum dos ícones de bans entra nesta condicional.
            // Isso acontece pois as ImageViews são diferentes para cada caso então temos
            // de tratar isso separadamente
            if (    view.getId() == R.id.championBanBlue1 ||
                    view.getId() == R.id.championBanBlue2 ||
                    view.getId() == R.id.championBanBlue3 ||
                    view.getId() == R.id.championBanRed1 ||
                    view.getId() == R.id.championBanRed2 ||
                    view.getId() == R.id.championBanRed3) {

                ImageView imageView = (ImageView) findViewById(viewId);

                // Verificando se a borda está visível
                if (imageView.getBackground().isVisible()) {

                    // Se está, deixa invisível.
                    imageView.getBackground().setVisible(false,true);
                    imageView.setBackgroundColor(Color.TRANSPARENT);
                } else {

                    // Se não está, deixa visível.
                    imageView.getBackground().setVisible(true,true);
                    imageView.setBackgroundColor(Color.YELLOW);
                }

            }
            else {

                MyCircularImageView imageView = (MyCircularImageView) findViewById(viewId);
                // Verificando se a borda está visível
                if (imageView.haveBorder()) {

                    // Se está, deixa invisível.
                    imageView.setBorderWidth(0);
                } else {

                    // Se não está, deixa visível.
                    imageView.setBorderWidth(2);
                }
            }
        }
    }

    private void setChampionViewSelected(int viewId) {
        championViewIdSelected = viewId;
    }

    private int getChampionViewSelected() {
        return championViewIdSelected;
    }


    // Método invocado caso o usuário tenha selecionado algum campeão na tela de seleção.
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        // Verificando se deu tudo ok com a Activity
        if (resultCode ==  RESULT_OK) {

            // Um campeão foi selecionado então iremos atualizar o ícone do campeão
            String stringDoChamp = data.getStringExtra(CHAMPION_SELECTED_MESSAGE).toLowerCase();;
            int idChampionIcon = this.getResources().getIdentifier(stringDoChamp, "drawable", R.drawable.class.getPackage().getName());

            // Caso o ícone seja selecionado seja algum dos ícones de bans entra nesta condicional.
            // Isso acontece pois as ImageViews são diferentes para cada caso então temos
            // de tratar isso separadamente
            if (    getChampionViewSelected() == R.id.championBanBlue1 ||
                    getChampionViewSelected() == R.id.championBanBlue2 ||
                    getChampionViewSelected() == R.id.championBanBlue3 ||
                    getChampionViewSelected() == R.id.championBanRed1 ||
                    getChampionViewSelected() == R.id.championBanRed2 ||
                    getChampionViewSelected() == R.id.championBanRed3){

                ImageView imageView = (ImageView) findViewById(getChampionViewSelected());
                imageView.setImageResource(idChampionIcon);

                // Setando a borda
                imageView.setBackgroundColor(Color.YELLOW);
                imageView.getBackground().setVisible(true,true);
                imageView.setPadding(2,2,2,2);

                // Adicionando o nome do campeão atual na tag da view
                imageView.setTag(stringDoChamp);
            }

            // Caso contrário
            else {
                MyCircularImageView imageView = (MyCircularImageView) findViewById(getChampionViewSelected());
                imageView.setImageResource(idChampionIcon);

                // Setando a borda
                imageView.setBorderWidth(2);
                imageView.setBorderColor(Color.YELLOW);

                // Adicionando o nome do campeão atual na tag da view
                imageView.setTag(stringDoChamp);
            }

            // Quando o usuário escolhe um novo campeão na lista, dispara o evento de sugerir um pick
            suggestChampions();
        }
    }


    // Este é o método invocado para gerar os campeões sugeridos ao usuário com base nos campeões
    // que ele inseriu nos picks e bans.
    protected void suggestChampions(){

        // Pegando a view da grid e zerando ela
        GridLayout picksGrid = (GridLayout) findViewById(R.id.picksGrid);
        picksGrid.removeAllViews();


        // Gerando a imagem das 9 sugestões de picks
        for (int i = 0; i < 9; i++) {

            //Alocando uma nova imageView
            ImageView imageView;
            imageView = new ImageView(picksGrid.getContext());
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);

            // Pegando a string de um dos campeões selecionados
            Random r = new Random();
            int randomNumber = r.nextInt(ChampionList.getLenght() - 0);
            String stringDoChamp = ChampionList.getItem(randomNumber).getName().toLowerCase() + "_icon";

            // O código abaixo pega o identificador  do icone da String do campeão selecionado e seta a imagemView com ele
            int championIcon = this.getResources().getIdentifier(stringDoChamp, "drawable", ChampionSelectionActivity.this.getPackageName());


            // Setando o imageView com a imagem do campeão utilizando o identificador
            imageView.setImageResource(championIcon);

            //Adicionando a imagem do campeão na grid.
            picksGrid.addView(imageView);

        }



        //Fazendo a mesma coisa agora para a grid de avoidPicks
        // Pegando a view da grid e zerando ela
        GridLayout avoidGrid = (GridLayout) findViewById(R.id.avoidGrid);
        avoidGrid.removeAllViews();


        // Gerando a imagem das 9 sugestões de picks
        for (int i = 0; i < 9; i++) {

            //Alocando uma nova imageView
            ImageView imageView;
            imageView = new ImageView(picksGrid.getContext());
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);

            // Pegando a string de um dos campeões selecionados
            Random r = new Random();
            int randomNumber = r.nextInt(ChampionList.getLenght() - 0);
            String stringDoChamp = ChampionList.getItem(randomNumber).getName().toLowerCase() + "_icon";

            // O código abaixo pega o identificador  do icone da String do campeão selecionado e seta a imagemView com ele
            int championIcon = this.getResources().getIdentifier(stringDoChamp, "drawable", ChampionSelectionActivity.this.getPackageName());


            // Setando o imageView com a imagem do campeão utilizando o identificador
            imageView.setImageResource(championIcon);

            //Adicionando a imagem do campeão na grid.
            avoidGrid.addView(imageView);

        }


    }

}
