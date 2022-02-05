package com.example.ahnaf.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RunnableFuture;

public class renterfirstpage extends AppCompatActivity {

    String Url5="http://pranta.ourcuet.com/query.php";
    EditText rare,rb,rt1,rt2;
    private Button all,not;
    String rare1,rb1,rt11,rt22;
    int bed,rent1,rent2;
    String qe;
    Map<String,String> x = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renterfirstpage);
        rare = (EditText) findViewById(R.id.farea);
        rb = (EditText) findViewById(R.id.fbed);
        rt1 = (EditText) findViewById(R.id.frent1);
        rt2 = (EditText) findViewById(R.id.frent2);
        all = (Button) findViewById(R.id.find2);
        not = (Button) findViewById(R.id.find1);



        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rare1 = rare.getText().toString();
                rb1 = rb.getText().toString();
                rt11 = rt1.getText().toString();
                rt22 = rt2.getText().toString();
                //bed= Integer.parseInt(rb1);
                //rent1= Integer.parseInt(rt11);
                //rent2= Integer.parseInt(rt22);
                Intent intent = new Intent(renterfirstpage.this,knapsackoutput.class);
                intent.putExtra("prevrare1",rare1);
                intent.putExtra("prevrb1",rb1);
                intent.putExtra("prevrt11",rt11);
                intent.putExtra("prevrt22", rt22);

                startActivity(intent);
               // qe= "select * from houseinfo where area like '"+rare1+"' and bedroom like '"+bed+"' and rent like between '"+rent1+"' AND '"+rent2+"' ";
                //x.put("query",qe);
                //PushOrParse.getDataFromServer(Url5, x, getApplicationContext());

                //senddata();
            }
        });
    }

    /*public  void senddata(){

        android.os.Handler handler = new android.os.Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                JSONArray ar=PushOrParse.deliverData();
                try {
                    JSONObject jo=ar.getJSONObject(0);
                    if(jo.getString("phone").equals("")){

                        Toast.makeText(renterfirstpage.this, "NO HOUSE FOUND!!", Toast.LENGTH_SHORT).show();



                    }
                    else {
                        String namm = jo.getString("name");
                        Toast.makeText(renterfirstpage.this, "HOUSE FOUND", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(renterfirstpage.this,knapsack.class);
                        startActivity(intent);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },3000);

    }*/
}


