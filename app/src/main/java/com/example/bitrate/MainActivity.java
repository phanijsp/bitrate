package com.example.bitrate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView mTextViewResult;
    private RequestQueue mQueue;
SwipeRefreshLayout pullToRefresh;
ImageView infobutton;
    private MOvieAdapater mAdapter;
    ListView listView;
    ArrayList<MOvie> moviesList;


    TextView tvc3;
    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     // getWindow().setStatusBarColor(ContextCompat.getColor(this ,R.color.colorPrimary));
     getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/sdsds.ttf");
        typefacehelper.setTypeface(typeface);

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        TextView tv=(TextView)findViewById(R.id.textView);
        tv.setTypeface(typeface);

        ImageView button1=(ImageView)findViewById(R.id.button);
        infobutton=(ImageView) findViewById(R.id.button2);
        infobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,infoactivity.class);
                startActivity(i);
            }
        });
        button1.setVisibility(View.INVISIBLE);





        mQueue = Volley.newRequestQueue(this);
        jsonParse();



        listView=(ListView)findViewById(R.id.lv);
        moviesList = new ArrayList<>();

        mAdapter = new MOvieAdapater(this,moviesList);
        listView.setAdapter(mAdapter);

        pullToRefresh=(SwipeRefreshLayout)findViewById(R.id.pullToRefresh);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            int Refreshcounter = 1; //Counting how many times user have refreshed the layout

            @Override
            public void onRefresh() {
                //Here you can update your data from internet or from local SQLite data
                jsonParse();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        pullToRefresh.setRefreshing(false);

                    }
                }, 1500);


            }
        });





    }
    private void jsonParse() {

        String url = "https://blockchain.info/ticker";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            ArrayList<MOvie> moviesList = new ArrayList<>();;

                            JSONObject usd=response.getJSONObject("USD");
                            String price=usd.getString("last")+usd.getString("symbol");
                            moviesList.add(new MOvie("USD",price));

                            JSONObject inr=response.getJSONObject("INR");
                            price=inr.getString("last")+inr.getString("symbol");
                            moviesList.add(new MOvie("INR",price));

                            JSONObject cad=response.getJSONObject("CAD");
                            price=cad.getString("last")+cad.getString("symbol");
                            moviesList.add(new MOvie("CAD",price));

                            JSONObject aud=response.getJSONObject("AUD");
                            price=aud.getString("last")+aud.getString("symbol");
                            moviesList.add(new MOvie("AUD",price));

                            JSONObject brl=response.getJSONObject("BRL");
                            price=brl.getString("last")+brl.getString("symbol");
                            moviesList.add(new MOvie("BRL",price));

                            JSONObject chf=response.getJSONObject("CHF");
                            price=chf.getString("last")+chf.getString("symbol");
                            moviesList.add(new MOvie("CHF",price));

                            JSONObject cny=response.getJSONObject("CNY");
                            price=cny.getString("last")+cny.getString("symbol");
                            moviesList.add(new MOvie("CNY",price));

                            JSONObject dkk=response.getJSONObject("DKK");
                            price=dkk.getString("last")+dkk.getString("symbol");
                            moviesList.add(new MOvie("DKK",price));

                           JSONObject eur=response.getJSONObject("EUR");
                           price=eur.getString("last")+eur.getString("symbol");
                           moviesList.add(new MOvie("EUR",price));

                           JSONObject gbp=response.getJSONObject("GBP");
                           price=gbp.getString("last")+gbp.getString("symbol");
                           moviesList.add(new MOvie("GBP",price));

                           JSONObject hkd=response.getJSONObject("HKD");
                           price=hkd.getString("last")+hkd.getString("symbol");
                           moviesList.add(new MOvie("HKD",price));

                           JSONObject isk=response.getJSONObject("ISK");
                           price=isk.getString("last")+isk.getString("symbol");
                           moviesList.add(new MOvie("ISK",price));

                           JSONObject jpy=response.getJSONObject("JPY");
                           price=jpy.getString("last")+jpy.getString("symbol");
                           moviesList.add(new MOvie("JPY",price));

                           JSONObject krw=response.getJSONObject("KRW");
                           price=krw.getString("last")+krw.getString("symbol");
                           moviesList.add(new MOvie("KRW",price));

                           JSONObject nzd=response.getJSONObject("NZD");
                           price=nzd.getString("last")+nzd.getString("symbol");
                           moviesList.add(new MOvie("NZD",price));

                           JSONObject pln=response.getJSONObject("PLN");
                           price=pln.getString("last")+pln.getString("symbol");
                           moviesList.add(new MOvie("PLN",price));

                            JSONObject sek=response.getJSONObject("SEK");
                            price=sek.getString("last")+sek.getString("symbol");
                            moviesList.add(new MOvie("SEK",price));


                            mAdapter=new MOvieAdapater(MainActivity.this,moviesList);
                            listView.setAdapter(mAdapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

}
