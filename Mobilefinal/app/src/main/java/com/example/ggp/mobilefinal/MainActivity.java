package com.example.ggp.mobilefinal;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EditText editid,editnota,editcurso;
    Button exclui,altera;
    ListView listviewnota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editid = (EditText)findViewById(R.id.editid);
        editnota = (EditText)findViewById(R.id.editnota);
        editcurso = (EditText)findViewById(R.id.editCurso);
        exclui = (Button)findViewById(R.id.bexclui);
        altera =(Button)findViewById(R.id.baltera);
        listviewnota = (ListView)findViewById(R.id.listViewNotas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}