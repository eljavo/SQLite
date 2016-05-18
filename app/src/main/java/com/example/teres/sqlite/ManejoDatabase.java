package com.example.teres.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by teres on 15/04/2016.
 */
public class ManejoDatabase extends SQLiteOpenHelper {
    public static final String BASEDATOS="alumnosBD";
    public static final String NCONTROL="nControl";
    public static final String NOMBRE="nombre";
    public static final String DIRECCION="direccion";
    public static final String SEXO="sexo";
    public static final String CARRERA="carrera";

    public ManejoDatabase(Context context) {
        super(context,BASEDATOS, null, 1);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("CREATE TABLE alumno(codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nControl TEXT,nombre TEXT, direccion TEXT, sexo TEXT, carrera TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        android.util.Log.v("alumno", "Actualizando para borrar los datos");
        db.execSQL("DROP TABLE IF EXIST alumno");
        onCreate(db);
    }
}
