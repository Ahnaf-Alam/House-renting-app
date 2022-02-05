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

public class renterreg extends AppCompatActivity {
    String Url4="http://pranta.ourcuet.com/query.php";
    EditText rname,rmail,rphone,rpass;
    String rname1,rmail1,rphone1,rpass1;
    String qu;
    private Button rentbt;
    Map<String,String> asd = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renterreg);

        rname= (EditText) findViewById(R.id.namerent);
        rmail= (EditText) findViewById(R.id.emailrent);
        rphone= (EditText) findViewById(R.id.phonerent);
        rpass= (EditText) findViewById(R.id.passrent);
        rentbt= (Button) findViewById(R.id.rt);

        rentbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rname1=rname.getText().toString();
                rmail1=rmail.getText().toString();
                rphone1=rphone.getText().toString();
                rpass1=rpass.getText().toString();

                qu="insert into renterlogin (name,email,phone,pass) values ('"+rname1+"','"+rmail1+"','"+rphone1+"','"+rpass1+"')";
                asd.put("query", qu);
                PushOrParse.getDataFromServer(Url4, asd, getApplicationContext());
                Toast.makeText(renterreg.this, "Registration completed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(renterreg.this,secondpage.class);
                startActivity(intent);
            }
        });
    }
}
