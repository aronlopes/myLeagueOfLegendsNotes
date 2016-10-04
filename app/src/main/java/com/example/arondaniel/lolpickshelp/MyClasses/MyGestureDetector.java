package com.example.arondaniel.lolpickshelp.MyClasses;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by AronDaniel on 28/09/2016.
 */

public class MyGestureDetector extends GestureDetector {

    public static String TAG = "MyGestureDetector";

    public MyGestureDetector (MyGestureAdapterListener myGestureAdapterListener){
        super(myGestureAdapterListener);

    }

    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        return true;

    }

    public String onTouchEvent(ImageView imageView, MotionEvent event) {
        super.onTouchEvent(event);

        String lastTouchEvent = MyGestureAdapterListener.getLastState();

        if (lastTouchEvent != null){
//        Log.d(TAG, "onLongPress " + imageView.getId());
            Log.d(TAG, "onLongPress " + lastTouchEvent);
            switch (lastTouchEvent) {
                case "LONGPRESS":
                    return "LONGPRESS";

                case "SINGLETAP":
                    return "SINGLETAP";
            }
        }

        return "NONE";

    }
}
