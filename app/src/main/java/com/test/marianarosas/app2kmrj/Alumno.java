package com.test.marianarosas.app2kmrj;

public class Alumno {

    String Nombre;
    String Apellidos;
    String Cuenta;
    String Genero;


    public Alumno(String Nombre, String Apellidos, String Cuenta,String Genero){


        this.Nombre=Nombre;
        this.Apellidos=Apellidos;
        this.Cuenta=Cuenta;
        this.Genero=Genero;


    }

    public String getAlumno(){

        return (" "+Nombre +" "+ Apellidos +" "+ Cuenta+ " "+Genero);
    }

    public void setAlumno(String Nombre, String Apellidos, String Cuenta,String Genero) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Cuenta=Cuenta;
        this.Genero=Genero;

    }


 }
