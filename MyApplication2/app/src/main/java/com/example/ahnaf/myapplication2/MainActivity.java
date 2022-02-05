package com.example.ahnaf.myapplication2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {


     String Url="http://pranta.ourcuet.com/query.php";
      private Button olgin,reg2,rlgin;
    EditText name,pass;
    String username,pword;
    String query,que;
    Map<String,String> log= new HashMap<>();
    Map<String,String> log1= new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);
        name= (EditText) findViewById(R.id.editText6);
        pass= (EditText) findViewById(R.id.editText4);

        olgin = (Button) findViewById(R.id.ologin);
        rlgin = (Button) findViewById(R.id.rlogin);
        reg2 = (Button)findViewById(R.id.regbutton2);
        rlgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = name.getText().toString();
                pword = pass.getText().toString();


                que = "SELECT * FROM renterlogin WHERE name like '" + username + "' and pass like '" + pword + "'";


                log1.put("query", que);


                PushOrParse.getDataFromServer(Url, log1, getApplicationContext());


                sendData1();
            }
        });

        olgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = name.getText().toString();
                pword = pass.getText().toString();
                query = "SELECT * FROM `owenerlogin` WHERE name like'" + username + "' and pass like '" + pword + "'";

                log.put("query", query);

                PushOrParse.getDataFromServer(Url, log, getApplicationContext());


                sendData();


            }
        });



    }
    private void sendData(){


        android.os.Handler handler=new android.os.Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                JSONArray arr=PushOrParse.deliverData();
                try {
                    JSONObject jo=arr.getJSONObject(0);
                    if(jo.getString("name").equals(" ")){

                        Toast.makeText(MainActivity.this, "User doesnot Exits", Toast.LENGTH_SHORT).show();

                    }
                    else {  String namm=jo.getString("name");
                        Toast.makeText(getApplicationContext()," Welcome "+namm,Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, post_house.class);
                        intent.putExtra("previd",jo.getString("id"));
                        startActivity(intent);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        },3000);


    }

    private void sendData1(){
        android.os.Handler handler1 = new android.os.Handler();

        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                JSONArray arr1 = PushOrParse.deliverData();
                try {
                    JSONObject jo1 = arr1.getJSONObject(0);
                    if(jo1.getString("name").equals("")){
                        Toast.makeText(MainActivity.this, "Invalid account", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        String nam1 = jo1.getString("name");
                        Toast.makeText(MainActivity.this, "Welcome "+nam1, Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this,renterfirstpage.class);
                        startActivity(intent);

                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        },3000);
    }

}
