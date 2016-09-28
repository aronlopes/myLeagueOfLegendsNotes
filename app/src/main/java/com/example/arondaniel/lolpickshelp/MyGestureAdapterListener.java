package com.example.arondaniel.lolpickshelp;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by AronDaniel on 28/09/2016.
 */

// Criando a classe para tratar a captura de toques e movimentos
public class MyGestureAdapterListener extends GestureDetector.SimpleOnGestureListener {

    public static String TAG = "MyGestureAdapter";

    private static String lastState = null;

    public void onLongPress(MotionEvent e) {
        Log.d(TAG, "onLongPress " + e.toString());
        lastState = "LONGPRESS";
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.d(TAG, "onSingleTapConfirmed " + e.toString());

        lastState = "SINGLETAP";

        return true;
    }

    // You really need all these boilerplate methods for GestureDetector to work

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }
    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    public static String getLastState(){
        String temp = lastState;
        lastState = null;
        return temp;
    }

    public static void setLastState(String string){
        lastState = string;
    }
}