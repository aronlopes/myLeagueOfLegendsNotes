package com.example.arondaniel.lolpickshelp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AronDaniel on 03/10/2016.
 */

public class ChampionListNotesItemAdapter extends BaseAdapter {

    Context context;


    private static LayoutInflater inflater=null;

    public ChampionListNotesItemAdapter(Context mContext) {
        // TODO Auto-generated constructor stub
        context = mContext;
        Log.d("ChampionListNotes", "Método criador. Contexto" + context.toString());

        inflater = ( LayoutInflater ) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d("ChampionListNotes", "Método criador. Service:" + inflater.toString());

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        Log.d("ChampionListNotes", "GetCount");
        return ChampionPool.getLenght();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        Log.d("ChampionListNotes", "GetItem");
        return ChampionPool.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        Log.d("ChampionListNotes", "GetItemId");
        String stringDoChampion = ChampionPool.getItem(position).getName().toString() + "_icon";

        // Pegando o recurso (imagem) do campeão presente na string

        int idDoChampion = context.getResources().getIdentifier(stringDoChampion, "drawable", R.drawable.class.getPackage().getName());

        return idDoChampion;
    }



    // Criando uma classe Holder que irá ajudar a "montar" a linha a ser exibida na Grid.
    public class Holder
    {
        TextView textView;
        ImageView imageView;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        Log.d("ChampionListNotes", "GetView");

        // Instanciando um novo Holder e uma nova view (que é a view do Holder).
        Holder holder=new Holder();
        View rowView;

        // Inflando a view com o layout que será utilizado para exibir as informações.
        rowView = inflater.inflate(R.xml.champion_list_note_item, null);

        // Atribuindo ao holder as ids das views correspondentes
        holder.textView=(TextView) rowView.findViewById(R.id.championListNoteItem_textView);
        holder.imageView=(ImageView) rowView.findViewById(R.id.championListNoteItem_imageView);

        // Setando o conteúdeo do holder.
        holder.textView.setText(ChampionPool.getItem(position).getName().substring(0,1).toUpperCase() + ChampionPool.getItem(position).getName().substring(1));
        holder.imageView.setImageResource((int) getItemId(position));

//        rowView.setOnClickListener(new View.OnClickListener() {
//
////            @Override
////            public void onClick(View v) {
////                // TODO Auto-generated method stub
////                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
////            }
//        });

        return rowView;
    }

}