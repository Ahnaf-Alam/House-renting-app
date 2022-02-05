package com.example.ahnaf.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class houseinfo extends AppCompatActivity {

    private Button nx1;
    EditText prevnam,prevem,prevph,prevar,hname,rno,hnum,floorno,bedno,washno;
    String hname1,hnum1,floorno1,bedno1,washno1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houseinfo);

        hname =(EditText) findViewById(R.id.hnam);
        hnum =(EditText) findViewById(R.id.hno);
        floorno =(EditText) findViewById(R.id.fno);
        bedno =(EditText) findViewById(R.id.bno);
        washno =(EditText) findViewById(R.id.wno);
        nx1= (Button) findViewById(R.id.next1);

        nx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hname1 = hname.getText().toString();
                hnum1 = hnum.getText().toString();
                floorno1 = floorno.getText().toString();
                bedno1 = bedno.getText().toString();
                washno1 = washno.getText().toString();
                Intent intent = new Intent(houseinfo.this, ownerpassword.class);

                startActivity(intent);
            }
        });
    }

}
