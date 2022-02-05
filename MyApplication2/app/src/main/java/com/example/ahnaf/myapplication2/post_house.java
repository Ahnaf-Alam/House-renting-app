package com.example.ahnaf.myapplication2;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class post_house extends AppCompatActivity {
    String Url6 = "http://pranta.ourcuet.com/query.php";
    FloatingActionButton add;
    String id1;
    String qe;
    ListView mylistview;
    Map<String,String> ma= new HashMap<>();
    ArrayList<Houseiteam> housearry =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_house);
        add = (FloatingActionButton) findViewById(R.id.fab);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(post_house.this, scrolling.class);
                startActivity(intent);
            }
        });


        id1 = getIntent().getStringExtra("previd");
        qe = "select from Posthouse where id like '"+id1+"' ";
        ma.put("query",qe);
        PushOrParse.getDataFromServer(Url6, ma, getApplicationContext());
        senddata();

    }

    public void senddata(){

       android.os.Handler handler = new android.os.Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                JSONArray arr= PushOrParse.deliverData();
                try{
                    for(int i=0;i<arr.length();i++){
                        JSONObject jo1 = arr.getJSONObject(0);

                        Houseiteam temp = new Houseiteam(jo1.getString("id"),jo1.getString("phone"),jo1.getString("area"),jo1.getString("roadno"),jo1.getString("housename"),jo1.getString("houseno"),jo1.getString("floor"),jo1.getString("flatno"),jo1.getString("bedroom"),jo1.getString("washroom"),jo1.getString("rent"));
                        housearry.add(temp);
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        },7000);
    }
}
