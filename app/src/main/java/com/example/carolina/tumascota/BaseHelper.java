package com.example.carolina.tumascota;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by carolina on 13/11/2016.
 */

public class BaseHelper extends SQLiteOpenHelper {
    String tabla="CREATE TABLE MASCOTAS(ID INTEGER PRIMARY KEY, NOMBRE TEXT, APELLIDO TEXT,TIPOSANGRE TEXT,FECHANACIMIENTO TEXT,RAZA TEXT)";

    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop tabla mascotas");

        db.execSQL(tabla);


    }
}
