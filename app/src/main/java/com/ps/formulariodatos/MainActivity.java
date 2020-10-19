package com.ps.formulariodatos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

        private String Nombre;
        private int dia;
        private  int mes;
        private int año ;
        private String Telefono;
        private String Email;
        private String Descripcion;

        public int editar;

      private EditText nombre;
      private EditText telefono;
      private EditText email;
      private EditText descripcion;
      private DatePicker dt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=findViewById(R.id.txtnombre);
        telefono=findViewById(R.id.txttelefono);
        email=findViewById(R.id.txtemail);
        descripcion=findViewById(R.id.txtdescripcion);
        dt1=findViewById(R.id.datepicker1);

        Bundle parametros=getIntent().getExtras();
        if(parametros!= null){

            String Nombre=parametros.getString("Nombre");
            String Telefono=parametros.getString("Telefono");
            String Email=parametros.getString("Email");
            String descripcion=parametros.getString("Descripcion");
            dia=parametros.getInt("dia");
            mes =parametros.getInt("mes");
            año =parametros.getInt("año");

            this.nombre.setText(Nombre);
            this.telefono.setText(Telefono);
            this.email.setText(Email);
            this.descripcion.setText(descripcion);
            dt1.updateDate(año,mes,dia);


        }



    }
    public void Siguiente(View view){

        Nombre=nombre.getText().toString();
        Telefono=telefono.getText().toString();
        Email=email.getText().toString();
        Descripcion=descripcion.getText().toString();
        dia=dt1.getDayOfMonth();
        mes=dt1.getMonth();
        año=dt1.getYear();

        Intent intent= new Intent(MainActivity.this,ConfirmarDatos.class);
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