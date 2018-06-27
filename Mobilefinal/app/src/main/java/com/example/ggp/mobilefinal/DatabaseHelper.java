package com.example.ggp.mobilefinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int VERSAO_DB = 1;
    private static final String NAME_DB = "bdenem";

    private static final String TABELA_NOTA = "tb_nota";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_NOTA = "nota";
    private static final String COLUNA_PRECURSO = "precurso";
    private static final String COLUNA_ID_FACULDADE = "id_faculdade";

    private static final String TABELA_FACULDADE = "tb_faculdade";
    private static final String COLUNA_COD = "cod";
    private static final String COLUNA_NOTA_CURSO = "nota_curso";
    private static final String COLUNA_CIDADE = "cidade";
    private static final String COLUNA_CURSO = "curso";

    public DatabaseHelper(Context context) {
        super(context, NAME_DB,null, VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String criaNota ="CREATE TABLE " + TABELA_NOTA + " ("
                + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUNA_NOTA + " REAL,"
                + COLUNA_PRECURSO + " TEXT)";/*
                +COLUNA_ID_FACULDADE + " INTEGER ");
                "FOREIGN KEY("+COLUNA_ID_FACULDADE +") REFERENCES "+TABELA_FACULDADE+"("+COLUNA_COD+") )";*/
        String criaFaculdade ="CREATE TABLE " + TABELA_FACULDADE + " ("
                + COLUNA_COD + " INTEGER PRIMARY KEY, "
                + COLUNA_NOTA_CURSO + " REAL,"
                + COLUNA_CURSO + " TEXT ,"
                +COLUNA_CIDADE+ " TEXT);";
        db.execSQL(criaFaculdade);
        db.execSQL(criaNota);
//        db.execSQL("INSERT INTO "+ TABELA_NOTA+ " (" + COLUNA_ID+","+ COLUNA_NOTA + ","+ COLUNA_PRECURSO+") VALUES (1,507.23,Eng. Eletrica,Apucarana)");
/*        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (1,507.23,Eng. Eletrica,Apucarana)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (2,497.92,Eng. Quimica,Apucarana)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (3,424.8,Eng. Ambiental,CM)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (4,578.79,Eng. Civil,CM)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (5,443.91,ADS,CP)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (6,453.06,Eng. Software,CP)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (7,595.79,Eng. Eletronica,Curitiba)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (8,648.33,Eng.Computacao,Curitiba)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (9,515.7,Agronomia,DV)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (10,438.58,Eng. Florestal,DV)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (11,448.76,Eng. Ambiental,FB)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (12,432.03,Eng.Alimentos ,FB)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (13,502.29,Eng. Civil,Guarapuava)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (14,466.88,Eng. Mecanica,Guarapuava)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (15,486.7,Eng. Quimica,Londrina)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (16,564.69,Eng. Producao,Londrina)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (17,466.89,Cien. Computacao,Medianeira)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (18,433.31,Eng. Ambiental,Medianeira)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (19,502.31,Eng. Eletrica,PB)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (20,515.46,Eng. Computacao,PB)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (21,445.13,Eng. Eletronica,PG)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (22,526.47,Eng. Producao,PG)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (23,422.21,Cien. Computacao,SH)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (24,450.32,Cien. Biologica,SH)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (25,597.44,Eng. Eletronica,Toledo)");
        db.execSQL("INSERT INTO "+ TABELA_FACULDADE+ " (" + COLUNA_COD+","+ COLUNA_NOTA_CURSO + ","+ COLUNA_CURSO+","+COLUNA_CIDADE+") VALUES (26,454.98,Matematica,Toledo)");
*/



    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addNota(Nota nota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_NOTA, nota.getNota());
        values.put(COLUNA_PRECURSO,nota.getCurso());


        db.insert(TABELA_NOTA, null, values);
        db.close();
    }
    public void deleteNota(Nota nota){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABELA_NOTA,COLUNA_ID +"= ?",new String [] {String.valueOf(nota.getNota())});
        db.close();

    }
    public Nota mostraNota(int codigo){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABELA_NOTA, new String[] {COLUNA_ID,COLUNA_NOTA,COLUNA_PRECURSO},COLUNA_ID+" = ?",
                new String[] {String.valueOf(codigo)},null, null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        Nota values;
        values = new Nota(Integer.parseInt(cursor.getString(0)),
                Float.parseFloat(cursor.getString(1)),
                cursor.getString(2));
        return values;

    }
    public void alteraNota(Nota nota){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_ID,nota.getId());
        values.put(COLUNA_NOTA, nota.getNota());
        values.put(COLUNA_PRECURSO,nota.getCurso());
        db.update(TABELA_NOTA, values,COLUNA_ID +"= ?", new String [] {String.valueOf(nota.getNota())});
        db.close();



    }
    public List<Nota> listaNotaFaculdade(){
        List<Nota> listaNota = new ArrayList<Nota>();
//        String querry = "SELECT * FROM"+TABELA_NOTA+","+ TABELA_FACULDADE+"WHERE " +COLUNA_NOTA +" >= "+COLUNA_NOTA_CURSO
//                + " AND " + COLUNA_PRECURSO+" = "+ COLUNA_CURSO;
        String listaTudo = "SELECT * FROM "+TABELA_NOTA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(listaTudo,null);
        if (cursor.moveToFirst()){
            do {
                Nota nota = new Nota();
                nota.setId(Integer.parseInt(cursor.getString(0)));
                nota.setNota(Float.parseFloat(cursor.getString(1)));
                nota.setCurso(cursor.getString(2));


                listaNota.add(nota);
            }while (cursor.moveToNext());
        }
        return listaNota;
    }
}
