package com.example.ahnaf.myapplication2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {

    String Url2="http://pranta.ourcuet.com/query.php";
    private Button nx;
    EditText nam,em,ph,ar,pst;
    String nam1,em1,ph1,ar1,pst1,q2;
    int id;
    Map<String,String> info = new HashMap<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nx= (Button) findViewById(R.id.next);
        nam = (EditText) findViewById(R.id.editText);
        em = (EditText) findViewById(R.id.editText3);
        ph = (EditText) findViewById(R.id.editText7);
        ar = (EditText) findViewById(R.id.editText8);
        pst = (EditText) findViewById(R.id.editText9);

        nx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nam1= nam.getText().toString();
                em1= em.getText().toString();
                ph1 = ph.getText().toString();
                ar1= ar.getText().toString();
                pst1= pst.getText().toString();
               // String flat = "A1";
                id=101;

               // q2 = "inert into houseinfo (id,flat_no,owner_name,email,phone,area,housename,houseno,floor,bedroom,washroom,facilities,rent,result) values ('"+id+"','"++"''"+nam1+"','"+em1+"','"+ph1+"','"+ar1+"')";

                info.put("query",q2);
                PushOrParse.getDataFromServer(Url2, info, getApplicationContext());
                //Intent intent = new Intent(register.this , houseinfo.class);
                //intent.putExtra("editText",nam1);
                //intent.putExtra("editText3",em1);
                //intent.putExtra("editText7",ph1);
                //intent.putExtra("editText8",ar1);
                //startActivity(intent);
            }
        });
    }
}
