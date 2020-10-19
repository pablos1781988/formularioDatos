package com.ps.formulariodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private  TextView tvnombre   ;
    private  TextView tvfecha    ;
    private  TextView tvtelefono ;
    private  TextView tvemail    ;
    private  TextView tvdescr    ;
    private String Nombre;
    private int dia;
    private  int mes;
    private int año ;
    private String Telefono;
    private String Email;
    private String Descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros=getIntent().getExtras();
        String nombre=parametros.getString("Nombre");
        String telefono=parametros.getString("Telefono");
        String Email=parametros.getString("Email");
        String descripcion=parametros.getString("Descripcion");
         dia=parametros.getInt("dia");
         mes =parametros.getInt("mes");
         año =parametros.getInt("año");
        String fecha= String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(año);

        tvnombre   =findViewById(R.id.tvnombre);
        tvfecha    =findViewById(R.id.tvFecha);
        tvtelefono =findViewById(R.id.tvTelefono);
        tvemail    =findViewById(R.id.tvEmail);
        tvdescr    =findViewById(R.id.tvDescripcion);

        tvnombre.setText(nombre);
        tvfecha.setText(fecha);
        tvemail.setText(Email);
        tvtelefono.setText(telefono);
        tvdescr.setText(descripcion);

    }
    public void  EditarDatos(View view){
        Nombre=tvnombre.getText().toString();
        Telefono=tvtelefono.getText().toString();
        Email=tvemail.getText().toString();
        Descripcion=tvdescr.getText().toString();


        Intent intent= new Intent(ConfirmarDatos.this,MainActivity.class);

        intent.putExtra("Nombre",Nombre );
        intent.putExtra("Telefono",Telefono );
        intent.putExtra("Email",Email );
        intent.putExtra("Descripcion",Descripcion);
        intent.putExtra("dia",dia);
        intent.putExtra("mes",mes);
        intent.putExtra("año",año);
        startActivity(intent);
    }
}