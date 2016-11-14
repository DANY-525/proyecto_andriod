package com.example.carolina.tumascota;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {
  ListView listView;
    ArrayList<String> listado;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
CargarListado();
    }

private void CargarListado(){
    listView=(ListView)findViewById(R.id.listadomascotas);
    gridView=(GridView)findViewById(R.id.gridView);
    listado =ListaMoscota();
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listado);
    gridView.setAdapter(adapter);
    listView.setAdapter(adapter);
}


    private ArrayList<String> ListaMoscota(){

        ArrayList<String> datos=new ArrayList<String>();
        BaseHelper helper1=new BaseHelper(Listado.this,"Demo2",null,1);
        SQLiteDatabase db = helper1.getWritableDatabase();

        String sql2="select Id,Nombre,Apellido from mascotas";
        Cursor  c= db.rawQuery(sql2,null);
        if (c.moveToFirst()) {

            do {
            String linea = c.getInt(0)+""+c.getString(1)+""+c.getString(2);
                datos.add(linea);
        } while (c.moveToNext());
        }




        return datos;
    }




}

