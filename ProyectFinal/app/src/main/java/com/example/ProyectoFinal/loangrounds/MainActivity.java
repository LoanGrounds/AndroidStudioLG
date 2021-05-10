package com.example.ProyectoFinal.loangrounds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnIniciarSesion;
    Button btnRegistrarse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ObtenerReferencias();
        setearListeners();

    }
    private void setearListeners(){
        btnIniciarSesion.setOnClickListener(btnIniciarSesion_Click);
        btnRegistrarse.setOnClickListener(btnRegistrarse_Click);

    }

    View.OnClickListener btnIniciarSesion_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent;

                intent = new Intent ( MainActivity.this, MainActivityIniciarSesion.class);
                startActivity(intent);


            }
    };

   View.OnClickListener btnRegistrarse_Click = new View.OnClickListener() {
       @Override
        public void onClick(View view) {

            Intent intent1;

                intent1 = new Intent ( MainActivity.this, MainActivityRegistrase1.class);
                startActivity(intent1);


            }
    };



    private void ObtenerReferencias() {
        btnIniciarSesion= (Button) findViewById(R.id.btnIniciarSesion);
        btnRegistrarse= (Button) findViewById(R.id.btnRegistrarse);

    }

}