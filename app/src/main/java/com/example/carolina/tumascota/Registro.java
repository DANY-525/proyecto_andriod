package com.example.carolina.tumascota;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    EditText nombre,descripcion,tiposangre,fechanacimiento,raza;
    Button registrar;
   // String nombreguardado,descripcionguardada,tiposangreguardada,tipodefechanacimientoguardada,tipoderazaguardada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre=(EditText)findViewById(R.id.nombreedit);

        descripcion =(EditText)findViewById(R.id.nombredescripcion);
        tiposangre=(EditText)findViewById(R.id.editsangre);
        fechanacimiento=(EditText)findViewById(R.id.editfechanacimiento);
        raza=(EditText)findViewById(R.id.editraza);
        registrar=(Button) findViewById(R.id.registrar);
        //nombreguardado =nombre.getText().toString();
        //descripcionguardada=descripcion.getText().toString();
        //tipodefechanacimientoguardada=fechanacimiento.getText().toString();
        //tipoderazaguardada=raza.getText().toString();
        //tiposangreguardada=tiposangre.getText().toString();


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                guardar(nombre.getText().toString(),descripcion.getText().toString(),tiposangre.getText().toString(),fechanacimiento.getText().toString(),raza.getText().toString());

            }
        });

    }




private void  guardar(String Nombre, String Apellido,String Tiposangre,String FechaNacimiento,String Raza){


    BaseHelper helper = new BaseHelper(Registro.this,"Demo",null,1);
    SQLiteDatabase db = helper.getWritableDatabase();
    try {

      ContentValues c= new ContentValues();
        c.put("Nombre", Nombre);
        c.put(" Apellido", Apellido);
        c.put("Tiposangre",Tiposangre);
        c.put("FechaNacimiento",FechaNacimiento);
        c.put("Raza",Raza);

        db.insert("MASCOTAS",null,c);

        Toast.makeText(this,"Registro insertado", Toast.LENGTH_SHORT).show();

    } catch (Exception e) {

        Toast.makeText(this, "error" + e.getMessage(), Toast.LENGTH_SHORT).show();

    }
}












}
