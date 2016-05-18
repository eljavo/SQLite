package com.example.teres.sqlite;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class FrmEditarActivity extends AppCompatActivity implements View.OnClickListener,AlertDialog.OnClickListener{
    EditText edNoControl,edNombre,edDireccion,edID;
    Spinner spCarrera;
    RadioButton rbM,rbF;
    Button btnEliminar,btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_editar);
        edNoControl=(EditText) findViewById(R.id.edNoControl);
        edNombre=(EditText) findViewById(R.id.edNombre);
        edDireccion=(EditText) findViewById(R.id.edDireccion);
        spCarrera=(Spinner) findViewById(R.id.spCarrera);
        rbF=(RadioButton) findViewById(R.id.rbFem);
        rbM=(RadioButton) findViewById(R.id.rbM);
        edID=(EditText) findViewById(R.id.edId);
        btnEliminar=(Button) findViewById(R.id.btnEliminar);
        btnActualizar=(Button)findViewById(R.id.btnActualizar);
        String[] datos=getIntent().getExtras().getString("registro").split("-");
        edID.setText(datos[0]);
        edNoControl.setText(datos[1]);
        edID.setEnabled(false);
        edNoControl.setEnabled(false);
        edNombre.setText(datos[2]);
        edDireccion.setText(datos[3]);
        if (datos[4].equals("Masculino")){
            rbM.setChecked(true);
        }else {
            rbF.setChecked(true);
        }
        switch (datos[5]){
            case "ISC":spCarrera.setSelection(0);
                break;
            case "IGEM":spCarrera.setSelection(1);
                break;
            default:spCarrera.setSelection(2);
                break;
        }

        btnActualizar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnActualizar){
            entAlumno objEnt=new entAlumno();

            objEnt.setId(Integer.parseInt(edID.getText().toString()));
            objEnt.setNoControl(edNoControl.getText().toString());
            objEnt.setNombre(edNombre.getText().toString());
            objEnt.setDireccion(edDireccion.getText().toString());
            if (rbF.isChecked()){
                objEnt.setSexo("Femenino");
            }else {
                objEnt.setSexo("Masculino");
            }

            objEnt.setCarrera(spCarrera.getSelectedItem().toString());
            conAlumno objControl=new conAlumno(this);
            objControl.actualizarAlumno(objEnt);

            Intent frmC=new Intent(this,frmConsulta2Activity.class);
            startActivity(frmC);
            finish();
        }else {
            AlertDialog.Builder dialogElimminar=new AlertDialog.Builder(this);
            dialogElimminar.setIcon(android.R.drawable.ic_delete);
            dialogElimminar.setTitle("Eliminando");
            dialogElimminar.setMessage("Esta seguro de eliminar el registro?");
            dialogElimminar.setCancelable(false);
            dialogElimminar.setPositiveButton(android.R.string.ok, this);
            dialogElimminar.setNegativeButton(android.R.string.no, null);
            dialogElimminar.create().show();
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        conAlumno objCon=new conAlumno(this);
        objCon.eliminarAlumno(edID.getText().toString());
        Intent objC=new Intent(this,frmConsulta2Activity.class);
        startActivity(objC);

    }
}
