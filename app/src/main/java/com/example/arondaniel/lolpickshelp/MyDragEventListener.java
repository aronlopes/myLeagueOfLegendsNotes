package com.example.arondaniel.lolpickshelp;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.Image;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by AronDaniel on 27/09/2016.
 */

public class MyDragEventListener implements View.OnDragListener {

    // This is the method that the system calls when it dispatches a drag event to the
    // listener.
    public boolean onDrag(View v, DragEvent event) {

        // Defines a variable to store the action type for the incoming event
        final int action = event.getAction();

        // Handles each of the expected events
        switch (action) {

            case DragEvent.ACTION_DRAG_STARTED:

                // Determines if this View can accept the dragged data
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {

                    // As an example of what your application might do,
                    // applies a blue color tint to the View to indicate that it can accept
                    // data.

                    // Invalidate the view to force a redraw in the new tint
                    v.invalidate();

                    // returns true to indicate that the View can accept the dragged data.
                    return true;

                }

                // Returns false. During the current drag and drop operation, this View will
                // not receive events again until ACTION_DRAG_ENDED is sent.
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:

                // Applies a green tint to the View. Return true; the return value is ignored.

//                v.setColorFilter(Color.GREEN);

                // Invalidate the view to force a redraw in the new tint
                v.invalidate();

                return true;

            case DragEvent.ACTION_DRAG_LOCATION:

                // Ignore the event
                return true;

            case DragEvent.ACTION_DRAG_EXITED:

                // Re-sets the color tint to blue. Returns true; the return value is ignored.
//                v.setColorFilter(Color.BLUE);

                // Invalidate the view to force a redraw in the new tint
                v.invalidate();

                return true;

            case DragEvent.ACTION_DROP:

                // Gets the item containing the dragged data
//                ClipData.Item item = event.getClipData().getItemAt(0);

                // Gets the text data from the item.
//                String dragData = item.getIntent().;
//                CharSequence dragData = item.getText();

                float x = event.getX();
                // Dropped, reassign View to ViewGroup
                View view = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();

//                owner.removeView(view);
//                GridLayout container = (GridLayout) v;


                ImageView imageView;
                imageView = new ImageView(v.getContext());
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);

                String championSelected = (String) event.getClipData().getItemAt(0).getText();
                int identificador = v.getContext().getResources().getIdentifier(championSelected , "drawable", R.drawable.class.getPackage().getName());

                // Setando o imageView com a imagem do campeão utilizando o identificador
                imageView.setImageResource(identificador);

                GridLayout container = (GridLayout) v;
                container.addView(imageView);
//                view.setVisibility(View.VISIBLE);

                // Displays a message containing the dragged data.
                Log.d("MyDragEvent", "X: " +            view.getId());
                Log.d("MyDragEvent", "Clip Data Text: " + championSelected);
//                Log.d("MyDragEvent", "Dragged data is " + event.getClipData().getItemAt(0).toString());

                // Turns off any color tints
//                v.clearColorFilter();

                // Invalidates the view to force a redraw
                v.invalidate();

                // Returns true. DragEvent.getResult() will return true.
                return true;

            case DragEvent.ACTION_DRAG_ENDED:

                // Turns off any color tinting
//                v.clearColorFilter();


                // Invalidates the view to force a redraw
                v.invalidate();

                // Does a getResult(), and displays what happened.
                if (event.getResult()) {
                    Log.d("MyDragEvent", "The drop was handled.");

                } else {
                    Log.d("MyDragEvent", "The drop didn't work.");

                }

                // returns true; the value is ignored.
                return true;

            // An unknown action type was received.
            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }

        return false;
    }
}
