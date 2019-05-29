package com.test.marianarosas.app2kmrj;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //DEFINICION DE VARIABLES
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private Button ba1;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<Integer> adapterimg;
    private ArrayList arrayList;
    private RadioButton rbf, rbm;
    private RadioGroup radioGroup;
    String gen="";

    private Activity context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ASIGNACION DE OBJETOS
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        rbf=(RadioButton)findViewById(R.id.rdf);
        rbm=(RadioButton)findViewById(R.id.rdm);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        ba1=(Button)findViewById(R.id.ba1);
        arrayList=new ArrayList<String>();


        //CRECION DE OBJETITO TIPO ALUMNO
     final Alumno al=new Alumno("","","","");

        //SIMPLEIFICACION
        String a=et1.getText().toString();
        String b=et2.getText().toString();
        String c=et3.getText().toString();


        //SELECTOR DE GENERO RADIOGROUP

        RadioGroup grupoun = (RadioGroup) findViewById(R.id.radioGroup);



            ba1.setOnClickListener(new View.OnClickListener() {
                @Override


                public void onClick(View view) {
                    //SI ES GENERO FEMENINO
                    if (rbf.isChecked() == true) {
                        gen = "F";   //SE MUESTRA F EN LA INFORMACION DE CONTACTO AL SER FEMENINO
                        if (et1.getText().toString().length() != 0 && et2.getText().toString().length() != 0 && et3.getText().toString().length() != 0) {
                            al.setAlumno(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), gen);

                            adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custum, arrayList);

                            arrayList.add(al.getAlumno());  //AGREGAR LOS DATOS DE CADA USUARIO A UN ARRAY PARA POSTERIORMENTE MOSTRARLO EN LISTA
                            adapter.notifyDataSetChanged(); //ACTUALIZAR ELEMENTOS EN EL ARRAY


                            //MENSAJE DE CONFIRMACION QUE EL USUARIO SE HA ANEXADO A LA LISTA
                            Toast.makeText(MainActivity.this, "Usuario agregado", Toast.LENGTH_LONG).show();
                        } else {
                            //VALIDACION DE CAMPOS VACIOS
                            Toast.makeText(MainActivity.this, "Ingrese todos los datos", Toast.LENGTH_LONG).show();
                        }
                        //SI ES GENERO MASCULINO M
                    } else if (rbm.isChecked() == true) {
                        gen = "M";
                        if (et1.getText().toString().length() != 0 && et2.getText().toString().length() != 0 && et3.getText().toString().length() != 0) {

                            al.setAlumno(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), gen);

                            adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custum, arrayList);

                            arrayList.add(al.getAlumno());  //AGREGAR LOS DATOS DE CADA USUARIO A UN ARRAY PARA POSTERIORMENTE MOSTRARLO EN LISTA
                            adapter.notifyDataSetChanged();

                            //CONFIRMACION DE USUARIO AGREGADO A LA LISTA
                            Toast.makeText(MainActivity.this, "Usuario agregado", Toast.LENGTH_LONG).show();
                        } else {

                            //VALIDACION
                            Toast.makeText(MainActivity.this, "Ingrese todos los datos", Toast.LENGTH_LONG).show();
                        }

                    }else{
                            //VALIDACION DE GENERO ELEGIDO
                            Toast.makeText(MainActivity.this,"Seleccione Genero",Toast.LENGTH_LONG).show();

                    }


                    //ADAPTAR A CONTENIDO DE TIPO STRING PARA MOSTRARLO EN LA LISTVIEW
                }

            });



        //RESTRINGIR EL USO DE LA PANTALLA A SOLO VERTICAL
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }



    //ENVIAR A LA ACTIVITY2---VISUALIZAR LA LISTA CREADA
    public void Ver(View view){

        Intent i = new Intent(this,Main2Activity.class);
       i.putExtra("la",arrayList);  //ENVIAR ARRAY CON EL CONTENIDO DE LA LISTA
        startActivity(i);                  //INICIAR ACTIVITY 2

    }

}
