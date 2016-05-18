package com.example.teres.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class frmAlumnosActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Nocontrol,Nombre,Direccion;
    Spinner carreras;
    RadioButton rbFemenino,rbMasculino;
    Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_alumnos);
        Nocontrol=(EditText)findViewById(R.id.etNcontrol);
        Nombre=(EditText)findViewById(R.id.etNombre);
        Direccion=(EditText)findViewById(R.id.etDireccion);
        carreras=(Spinner)findViewById(R.id.spCarrera);
        rbFemenino=(RadioButton)findViewById(R.id.rbFemenino);
        rbMasculino=(RadioButton)findViewById(R.id.rbMasculino);
        btnEnviar=(Button)findViewById(R.id.btnGuardar);
        btnEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        entAlumno alumno=new entAlumno();
        alumno.setNoControl(Nocontrol.getText().toString());

        alumno.setNombre(Nombre.getText().toString());
        alumno.setDireccion(Direccion.getText().toString());
        if (rbFemenino.isSelected()){alumno.setSexo(rbFemenino.getText().toString());
        }else{alumno.setSexo(rbMasculino.getText().toString());}
        alumno.setCarrera(carreras.getSelectedItem().toString());
        conAlumno conObj=new conAlumno(this);
        conObj.insertarAlumno(alumno);
        Toast.makeText(this,"Alumno Registrado",Toast.LENGTH_LONG).show();
    }
}
