package com.example.teres.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by teres on 15/04/2016.
 */
public class conAlumno {
    Context context;

    public conAlumno(Context context){
        this.context=context;
    }


    public void insertarAlumno(entAlumno alumno){
        ManejoDatabase manejoDB=new ManejoDatabase(this.context);
        SQLiteDatabase db=manejoDB.getWritableDatabase() ;
        ContentValues cv=new ContentValues();
        cv.put(manejoDB.NCONTROL, alumno.getNoControl());
        cv.put(manejoDB.NOMBRE, alumno.getNombre());
        cv.put(manejoDB.DIRECCION, alumno.getDireccion());
        cv.put(manejoDB.SEXO, alumno.getSexo());
        cv.put(manejoDB.CARRERA, alumno.getCarrera());

        db.insert("alumno", manejoDB.NOMBRE, cv);
        db.close();

    }

    public ArrayList<entAlumno> consultarAlumno(){
        ManejoDatabase con= new ManejoDatabase(context);
        SQLiteDatabase db= con.getReadableDatabase();
        Cursor cur=db.rawQuery("select * from alumno", null);

        ArrayList<entAlumno> alDatos=new ArrayList<entAlumno>();
        if (cur.moveToFirst()){
            do{
                entAlumno objEntAlumno=new entAlumno();
                objEntAlumno.setId(cur.getInt(0));
                objEntAlumno.setNoControl(cur.getString(1).toString());
                Toast.makeText(context, objEntAlumno.getNoControl().toString(), Toast.LENGTH_LONG).show();
                objEntAlumno.setNombre(cur.getString(2));
                objEntAlumno.setDireccion(cur.getString(3));
                objEntAlumno.setSexo(cur.getString(4));
                objEntAlumno.setCarrera(cur.getString(5));
                alDatos.add(objEntAlumno);
            }while (cur.moveToNext());
        }
        return alDatos;
    }
    public void actualizarAlumno(entAlumno alumno){
        ManejoDatabase manejoDB=new ManejoDatabase(context);
        SQLiteDatabase db=manejoDB.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(manejoDB.NOMBRE,alumno.getNombre());
        cv.put(manejoDB.DIRECCION,alumno.getDireccion());
        cv.put(manejoDB.SEXO,alumno.getSexo());
        cv.put(manejoDB.CARRERA,alumno.getCarrera());

        db.update("alumno", cv, "codigo=?", new String[]
                {String.valueOf(alumno.getId())});
        db.close();
        Toast.makeText(context,"Actualizado Correctamente!", Toast.LENGTH_LONG).show();
    }
    public void eliminarAlumno(String id){
        ManejoDatabase manejoDB=new ManejoDatabase(context);
        SQLiteDatabase db=manejoDB.getWritableDatabase();
        db.delete("alumno","codigo=?",new String[]{String.valueOf(id)});
        db.close();
        Toast.makeText(context,"Eliminado correctamente",Toast.LENGTH_LONG).show();
    }
}
