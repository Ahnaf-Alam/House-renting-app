package com.example.ahnaf.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class knapsackoutput extends AppCompatActivity {

    String Url5 = "http://pranta.ourcuet.com/query.php";
    String rarea, rbed, rent1, rent2;
    String qe;
    Map<String, String> x = new HashMap<>();
    ListView mylist;
   ArrayList<Houseiteam> housearray = new ArrayList<>();
    //ArrayList<Houseiteam> tmp;
    //house
   // String[] housenam = {"Alimansion","hazi mansion","kabir mansion","shikdar monjil","kobir villa","shajahn","taher mansion"};
    //int[] rent56 ={12000,20000,30000,5600,5000,9000,7000};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knapsackoutput);

        rarea = getIntent().getStringExtra("prevrare1");
        rbed = getIntent().getStringExtra("prevrb1");
        rent1 = getIntent().getStringExtra("prevrt11");
        rent2 = getIntent().getStringExtra("prevrt22");
        int rent11 = Integer.parseInt(rent1);
       int rent22 = Integer.parseInt(rent2);

        qe = "select * from Posthouse where area like '"+rarea+"' and bedroom like '"+rbed+"' and rent between '"+rent11+"' and '"+rent22+"' " ;
        //qe = "select * from Posthouse where area like '" + rarea + "' and bedroom like '" + rbed + "' and rent like between '" + rent1 + "' AND '" + rent2 + "' ";
        x.put("query", qe);
        PushOrParse.getDataFromServer(Url5, x, getApplicationContext());
        senddata();

        mylist = (ListView) findViewById(R.id.listviewid);


       customAdapter customAdapter = new customAdapter(this,housearray);
       mylist.setAdapter(customAdapter);

    }

    public void senddata() {

        android.os.Handler handler = new android.os.Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                JSONArray ar = PushOrParse.deliverData();
                try {
                    for(int i=0;i<ar.length();i++){
                        JSONObject jo = ar.getJSONObject(i);

                        Houseiteam temp = new Houseiteam(jo.getString("id"),jo.getString("phone"),jo.getString("area"),jo.getString("roadno"),jo.getString("housename"),jo.getString("houseno"),jo.getString("floor"),jo.getString("flatno"),jo.getString("bedroom"),jo.getString("washroom"),jo.getString("rent"));
                      //  Houseiteam temp = new Houseiteam(jo.getString("id"),jo.getString("flat_no"),jo.getString("owner_name"),jo.getString("email"),jo.getString("phone"),
                        //       jo.getString("area"),jo.getString("housename"),jo.getString("houseno"),jo.getString("floor"),jo.getString("bedroom"),jo.getString("washroom"),
                          //      jo.getString("facilities"),jo.getString("rent"));
                        housearray.add(temp);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        }, 7000);
    }

}
