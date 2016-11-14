package com.example.carolina.tumascota;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {
  ListView listView;
    ArrayList<String> listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

    }

private void CargarListado(){
    listView=(ListView)findViewById(R.id.listadomascotas);
    listado =ListaMoscota();
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listado);

    listView.setAdapter(adapter);
}


    private ArrayList<String> ListaMoscota(){

        ArrayList<String> datos=new ArrayList<String>();
        BaseHelper helper=new BaseHelper(Listado.this,"Demo2",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();

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

