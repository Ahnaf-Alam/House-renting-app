package com.example.ahnaf.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class owner_reg extends AppCompatActivity {

    String Url1="http://pranta.ourcuet.com/query.php";
    EditText use,em,ph,pa;
    String usena,ema,pho,pas,id;
    String q1;
    private  Button  regbutton3;
    Map<String,String> regmap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_reg);
        regbutton3 =(Button) findViewById(R.id.comreg);
        use = (EditText) findViewById(R.id.usernameput);
        em = (EditText) findViewById(R.id.useremailput);
        ph = (EditText) findViewById(R.id.userphoneput);
        pa = (EditText) findViewById(R.id.userpassput);
        regbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            usena = use.getText().toString();
                ema = em.getText().toString();
                pho = ph.getText().toString();
                pas = pa.getText().toString();
                id= "103";

               q1="insert into owenerlogin (id,name,email,phone,pass) values ('"+id+"','"+usena+"','"+ema+"','"+pho+"','"+pas+"')";

                regmap.put("query", q1);
                PushOrParse.getDataFromServer(Url1, regmap, getApplicationContext());
                Toast.makeText(owner_reg.this, "Registration complete", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(owner_reg.this,post_house.class);
                startActivity(intent);
            }
        });
    }

}
