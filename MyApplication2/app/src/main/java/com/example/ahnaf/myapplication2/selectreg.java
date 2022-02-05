package com.example.ahnaf.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectreg extends AppCompatActivity {

    private Button oreg,rentreg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectreg);
         oreg = (Button)findViewById(R.id.ownerbt);
        rentreg = (Button)findViewById(R.id.renterbt);

        oreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectreg.this,owner_reg.class);
                startActivity(intent);
            }
        });
        rentreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectreg.this,renterreg.class);
                startActivity(intent);
            }
        });
    }
}
