package Arquivo_de_codigo;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.arondaniel.lolpickshelp.ChampionSelectionActivity;

import static android.R.id.message;

/**
 * Created by AronDaniel on 27/09/2016.
 */

public final class MyTouchListenerOldVersion implements View.OnTouchListener {

    public static final String EXTRA_MESSAGE = "com.example.arondaniel.lolpickshelp";
    public int BUTTON_SELECTED;
    public ChampionSelectionActivity championSelectActivity;

    public MyTouchListenerOldVersion(ChampionSelectionActivity championSelectionActivityParameter) {
        this.championSelectActivity = championSelectionActivityParameter;

    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
            public void onLongPress(MotionEvent e) {
                Log.e("Downtime", "Longpress detected");
            }
        });

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN:
                Long tsLong = System.currentTimeMillis();
                Log.d("Downtime", "Current time:" + tsLong);
                Log.d("Downtime", "DownTime" + motionEvent.getDownTime());

//                if(motionEvent.getDownTime() == Date. motionEvent.getAction()) {
//
//                case MotionEvent.ACTION_POINTER_DOWN & MotionEvent.:
////                int id = view.getResources().getIdentifier("akali_icon", "drawable", R.class.getPackage().getName()).;
////                CharSequence charsequence = (CharSequence) id;
//                ClipData data = ClipData.newPlainText("", view.getTag().toString());
//                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
//                        view);
//                view.startDrag(data, shadowBuilder, view, 0);
////                view.setVisibility(View.INVISIBLE);
//                Log.d("MyTouchListenerOldVersion", "Action_Button_Press");
//                return true;
//
//            case MotionEvent.ACTION_POINTER_UP:
//                Log.d("MyTouchListenerOldVersion", "ACTION_DOWN");
//
//                //Se o usuário só clicou uma vez então ele quer selecionar um campeão.
//                championSelectActivity.searchChampion(view);
//
//                return true;

            default:
                return false;
            }
        }

}
