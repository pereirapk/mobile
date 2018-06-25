package com.example.ggp.mobilefinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button ;
import android.content.Intent;



public class inicial extends AppCompatActivity {
    Button btninicial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btninicial = (Button) findViewById(R.id.button);
        final Intent intent = new Intent(this, MainActivity.class);
        btninicial.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(android.view.View v){
                startActivity(intent);

            }
        }
        );

    }

}
