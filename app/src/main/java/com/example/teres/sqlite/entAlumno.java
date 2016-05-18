package com.example.teres.sqlite;

import java.io.Serializable;

/**
 * Created by teres on 15/04/2016.
 */
public class entAlumno implements Serializable{
    private  int Id;
    private String NoControl;
    private String Nombre;
    private String Direccion;
    private String Sexo;
    private String Carrera;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNoControl() {
        return NoControl;
    }

    public void setNoControl(String noControl) {
        NoControl = noControl;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        Carrera = carrera;
    }

    @Override
    public String toString() {
        return Id +"-"
                 +NoControl + "-"
                + Nombre + "-"
                + Direccion + "-"
                + Sexo + "-"
                + Carrera;
    }

}
