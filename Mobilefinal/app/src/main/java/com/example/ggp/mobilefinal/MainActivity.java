package com.example.ggp.mobilefinal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editid,editnota,editcurso;
    Button btnexclui;
    ListView listviewnota;

    DatabaseHelper db = new DatabaseHelper(MainActivity.this);

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
        editid = findViewById(R.id.editid);
        editnota = findViewById(R.id.editnota);
        editcurso = findViewById(R.id.editCurso);
        btnexclui = (Button)findViewById(R.id.bexclui);
        listviewnota = (ListView)findViewById(R.id.listViewNotas);
        editid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        listaNota();
        listviewnota.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itensLista = (String) listviewnota.getItemAtPosition(position);
                String unicoitem = itensLista.substring(0,itensLista.indexOf("-"));
                unicoitem = unicoitem.trim();
                Nota not = db.mostraNota(Integer.parseInt(unicoitem));

                editid.setText(String.valueOf(not.getId()));
                editnota.setText(String.valueOf(not.getNota()));
                editcurso.setText(not.getCurso());
            }
        });
        btnexclui.setOnClickListener(new View.OnClickListener() {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            //final
            @Override
            public void onClick(View v) {
                final String idcod = editid.getText().toString();
               // final String idcod = editid.getText().toString();
                if(idcod.isEmpty()){
                    Toast.makeText(MainActivity.this,R.string.nenhumcli,Toast.LENGTH_LONG).show();
                }
                else {
                    alert.setTitle(R.string.deletar);
                    alert.setMessage(R.string.perguntadelete);
                    alert.setCancelable(false);
                    alert.setNegativeButton(R.string.Cancelar, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,R.string.desistir, Toast.LENGTH_LONG).show();
                        }

                    });
                    alert.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Nota not = new Nota();
                            not.setId(Integer.parseInt(idcod));
                            db.deleteNota(not);
                            Toast.makeText(MainActivity.this,R.string.excluido,Toast.LENGTH_LONG).show();
                            limpaCampos();
                            listaNota();
                        }
                    });
                    alert.show();
                }
            }

        });
        listaNota();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.home){
            startActivity(new Intent(this,inicial.class));
            this.finish();
            return true;
        }

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,Settings.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.action_new){
            Toast.makeText(getApplicationContext(),R.string.campolimp,Toast.LENGTH_LONG);
            limpaCampos();
        }
        if(id == R.id.action_salvar){
            String codi = editid.getText().toString();
            String nota = editnota.getText().toString();
            String cursopre = editcurso.getText().toString();

            if (nota.isEmpty() ){
                editnota.setError(getString(R.string.obrigatorio));
            }
            if(cursopre.isEmpty()){
                editcurso.setError(getString(R.string.obrigatorio));
            }
            else if(codi.isEmpty()){
                db.addNota(new Nota(Float.parseFloat(nota),cursopre));
                listaNota();
                limpaCampos();
            }
            else{
                db.alteraNota(new Nota(Integer.parseInt(codi),Float.parseFloat(nota),cursopre));
                listaNota();
                limpaCampos();
            }

        }


        return super.onOptionsItemSelected(item);
    }
    public void listaNota(){
        List<Nota> notas = db.listaNotaFaculdade();

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
        listviewnota.setAdapter(adapter);

        for(Nota not : notas){
            arrayList.add(not.getId()+" - "+not.getCurso()+"\n"+not.getNota());
            adapter.notifyDataSetChanged();
        }
    }
    public void limpaCampos(){
        editid.setText("");
        editnota.setText("");
        editcurso.setText("");

        editnota.requestFocus();
    }
}
