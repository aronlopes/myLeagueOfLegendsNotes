package com.example.arondaniel.lolpickshelp.MyClasses;

import android.content.Context;
import android.util.AttributeSet;

import com.mikhaellopez.circularimageview.CircularImageView;

/**
 * Created by AronDaniel on 28/09/2016.
 */

public class MyCircularImageView extends CircularImageView {

    private boolean border;

    //=================================================================
    //Escrevendo os métodos construtores e mandando para o pai.
    //=================================================================
    public MyCircularImageView(final Context context) {
        super(context, null);
    }
    public MyCircularImageView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }
    public MyCircularImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    // Se o usuário setar uma borda, então o atributo border se torna true ou falso de acordo com o valor.
    // Joga o valor da borda para o pai.
    @Override
    public void setBorderWidth(float width) {
        super.setBorderWidth(width);

        if (width > 0) {
            border = true;
        }
        else{
            border = false;
        }
    }


    // Método que retorna verdadeiro caso o item tenha borda e negativo caso contrário.
    public boolean haveBorder (){
        if (border == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }



}
