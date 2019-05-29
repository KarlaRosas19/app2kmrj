package com.test.marianarosas.app2kmrj;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    //DEFINICION DE VARIABLES
    private ListView list2;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<Integer> adapterimg;
    private ArrayList arrayList2;
    private ArrayList<Integer> arrayList2img;
    private TextView tvdescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //ASIGNACION DE OBJETOS
        list2 = (ListView)findViewById(R.id.listview2);
        arrayList2=new ArrayList<String>();
        arrayList2img=new ArrayList<Integer>();

       //ELEMENTOS RECIBIDOS DE LA ACTIVIDAD
       ArrayList arrayList2 =(ArrayList)getIntent().getSerializableExtra("la");

       //ADAPATAR A CASIILA DE LISTVIEW PERSONALIZADA
       CustomListview customListview=new CustomListview(this,arrayList2);
       list2.setAdapter(customListview);

        //INDICAR EL ID, SEGÚN EL ELEMENTO DE LA LISTA
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String listaAlumnos = (String)list2.getItemAtPosition(position);
                Toast.makeText(getApplication(),"ID"+(position+1),Toast.LENGTH_SHORT).show();

            }
        });

        //PONER ICONO A UN LADO DEL NOMBRE EN PANTALLA EN USO
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        //RESTRINGIR EL USO DE LA PANTALLA A SOLO VERTICAL
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    //METODOS

    //METODO PARA EL BOTON, REGRESAR Y VOLVER A INSERTAR ALUMNOS EN LA LISTA
    public void Regresar(View view){
        Intent regresar = new Intent(this, MainActivity.class);
        startActivity(regresar);
    }
}
