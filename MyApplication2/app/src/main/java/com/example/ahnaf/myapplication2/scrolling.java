package com.example.ahnaf.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class scrolling extends AppCompatActivity {

    String Url3="http://pranta.ourcuet.com/query.php";
    EditText nam,id,phn,are,pst,housenam,hno,rno,floor,flat,bedroom,washroom,rent;
    CheckBox lif,gen,wat,ga,cc,pak,grd;
    String nam1,id1,phn1,are1,road1,housenam1,hno1,floor1,flat1,bedroom1,washroom1,rent1;
    String q3;
    private Button dn;
    Map<String,String> infomap = new HashMap<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        nam = (EditText) findViewById(R.id.name1);
        id = (EditText) findViewById(R.id.ownerid);
        phn = (EditText)findViewById(R.id.phone1);
        are = (EditText) findViewById(R.id.area1);
        pst = (EditText) findViewById(R.id.posto1);
        housenam = (EditText) findViewById(R.id.housename1);
        hno = (EditText) findViewById(R.id.houseno1);
        rno = (EditText) findViewById(R.id.roadno1);
        floor = (EditText) findViewById(R.id.floor1);
        flat = (EditText) findViewById(R.id.flatno1);
        bedroom = (EditText) findViewById(R.id.broom1);
        washroom = (EditText) findViewById(R.id.wroom1);
        gen = (CheckBox) findViewById(R.id.generator);
        lif = (CheckBox) findViewById(R.id.lift);
        wat = (CheckBox) findViewById(R.id.water);
        cc = (CheckBox) findViewById(R.id.camera);
        ga = (CheckBox) findViewById(R.id.gurd);
        pak = (CheckBox) findViewById(R.id.park);
        rent = (EditText) findViewById(R.id.rent1);

         dn= (Button)findViewById(R.id.donebutton);

        dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nam1 = nam.getText().toString();
                id1 = id.getText().toString();
                phn1 = phn.getText().toString();
                are1 = are.getText().toString();
                road1 = rno.getText().toString();
                housenam1=housenam.getText().toString();
                hno1=hno.getText().toString();
                floor1=floor.getText().toString();
                flat1=flat.getText().toString();
                bedroom1=bedroom.getText().toString();
                washroom1=washroom.getText().toString();
                rent1= rent.getText().toString();


               q3= "insert into Posthouse (id,phone,area,roadno,housename,houseno,floor,flatno,bedroom,washroom,rent) values ('"+id1+"','"+phn1+"','"+are1+"','"+road1+"','"+housenam1+"','"+hno1+"','"+floor1+"','"+flat1+"','"+bedroom1+"','"+washroom1+"','"+rent1+"')";

                infomap.put("query", q3);
                PushOrParse.getDataFromServer(Url3, infomap, getApplicationContext());

                Intent intent = new Intent(scrolling.this,post_house.class);
                startActivity(intent);
            }
        });
    }
}
