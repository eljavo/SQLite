package com.example.teres.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnInsertar,btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnInsertar=(Button) findViewById(R.id.btnInsertar);
        btnConsultar=(Button) findViewById(R.id.btnConsultar);
        btnConsultar.setOnClickListener(this);
        btnInsertar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==btnInsertar.getId()){
            Intent ins= new Intent(this,frmAlumnosActivity.class);
            startActivity(ins);
        }else {

            Intent cons=new Intent(this,frmConsulta2Activity.class);
            startActivity(cons);
        }
    }
}
