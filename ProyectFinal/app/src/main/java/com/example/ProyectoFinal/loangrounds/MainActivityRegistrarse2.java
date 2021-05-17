package com.example.ProyectoFinal.loangrounds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityRegistrarse2 extends AppCompatActivity {
    Button btnSiguiente1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registrarse2);
        ObtenerReferencias();
        setearListeners();

    }
    private void setearListeners(){
        btnSiguiente1.setOnClickListener(btnSiguiente1_Click);


    }
    View.OnClickListener btnSiguiente1_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent2;

            intent2 = new Intent ( MainActivityRegistrarse2.this, MainActivityRegistrarse3.class);
            startActivity(intent2);


        }
    };



    private void ObtenerReferencias() {

        btnSiguiente1= (Button) findViewById(R.id.btnSig1);

    }
}