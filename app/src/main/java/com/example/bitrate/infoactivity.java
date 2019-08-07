package com.example.bitrate;

import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class infoactivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoactivity);
        getWindow().setStatusBarColor(ContextCompat.getColor(this ,R.color.colorPrimary));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/sdsds.ttf");
        typefacehelper.setTypeface(typeface);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        TextView tv=(TextView)findViewById(R.id.textView);
        tv.setTypeface(typeface);
        TextView textView=(TextView)findViewById(R.id.desctext);
        TextView textView1=(TextView)findViewById(R.id.source);
        TextView textView2=(TextView)findViewById(R.id.con);
        textView.setTypeface(typeface);
        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);
        Linkify.addLinks(textView1,Linkify.ALL);
        Linkify.addLinks(textView2,Linkify.EMAIL_ADDRESSES);
        ImageView button1=(ImageView)findViewById(R.id.button);
        ImageView button2=(ImageView)findViewById(R.id.button2);
        button2.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.INVISIBLE);



    }
}
