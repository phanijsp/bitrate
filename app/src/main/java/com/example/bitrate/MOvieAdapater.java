package com.example.bitrate;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MOvieAdapater extends ArrayAdapter<MOvie> {

    private Context mContext;
    private List<MOvie> moviesList = new ArrayList<>();

    public MOvieAdapater(@NonNull Context context, @LayoutRes ArrayList<MOvie> list) {
        super(context, 0 , list);
        mContext = context;
        moviesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.listitem,parent,false);
        MOvie currentMOvie = moviesList.get(position);


        TextView name = (TextView) listItem.findViewById(R.id.name);
        name.setText(currentMOvie.getname());

        TextView release = (TextView) listItem.findViewById(R.id.value);
        if(position==0){
            release.setBackgroundResource(R.drawable.bg);
        }
        if(position==1){
            release.setBackgroundResource(R.drawable.bg2);
        }
        if(position==2){
            release.setBackgroundResource(R.drawable.bg3);
        }
        if(position==3){
            release.setBackgroundResource(R.drawable.bg4);
        }
        if(position==4){
            release.setBackgroundResource(R.drawable.bg5);
        }
        if(position==5){
            release.setBackgroundResource(R.drawable.bg6);
        }
        if(position==6){
            release.setBackgroundResource(R.drawable.bg7);
        }
        if(position==7){
            release.setBackgroundResource(R.drawable.bg2);
        }
        if(position==8){
            release.setBackgroundResource(R.drawable.bg3);
        }
        if(position==9){
            release.setBackgroundResource(R.drawable.bg4);
        }
        if(position==10){
            release.setBackgroundResource(R.drawable.bg5);
        }
        if(position==11){
            release.setBackgroundResource(R.drawable.bg6);
        }
        if(position==12){
            release.setBackgroundResource(R.drawable.bg7);
        }
        if(position==13){
            release.setBackgroundResource(R.drawable.bg);
        }
        if(position==14){
            release.setBackgroundResource(R.drawable.bg2);
        }
        if(position==15){
            release.setBackgroundResource(R.drawable.bg3);
        }
        if(position==16){
            release.setBackgroundResource(R.drawable.bg4);
        }
        if(position==17){
            release.setBackgroundResource(R.drawable.bg5);
        }
        if(position==18){
            release.setBackgroundResource(R.drawable.bg6);
        }
        if(position==19){
            release.setBackgroundResource(R.drawable.bg7);
        }
        if(position==20){
            release.setBackgroundResource(R.drawable.bg);
        }
        if(position==21){
            release.setBackgroundResource(R.drawable.bg2);
        }


















        Typeface typeface=typefacehelper.getTypeface();

        name.setTypeface(typeface);
        release.setTypeface(typeface);
        release.setText(currentMOvie.getvalue());

        return listItem;
    }
}
