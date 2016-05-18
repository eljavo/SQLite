package com.example.teres.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class frmConsulta2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener{


    ListView lstDatos;
    ArrayList<entAlumno> AL;
    ArrayAdapter<entAlumno> AADatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_consulta2);

        lstDatos=(ListView) findViewById(R.id.lstDatos);
        conAlumno objcon= new conAlumno(this);
        AL=objcon.consultarAlumno();
        AADatos=new ArrayAdapter<entAlumno>(this,android.R.layout.simple_list_item_1,AL);
        lstDatos.setAdapter(AADatos);
        lstDatos.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> Arg0, View Arg1, int arg2, long Arg3) {
        Intent objEditar=new Intent(this,FrmEditarActivity.class);
        objEditar.putExtra("registro", ((TextView)Arg1).getText());
        startActivity(objEditar);
        finish();
    }
}
