package com.example.ProyectoFinal.loangrounds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityRegistrarse3 extends AppCompatActivity {

    Button btnSigue;
    Button btnOmitir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registrarse3);
        ObtenerReferencias();
        setearListeners();

    }
    private void setearListeners(){
        btnSigue.setOnClickListener(btnSigue_Click);
        btnOmitir.setOnClickListener(btnOmitir_Click);


    }
    View.OnClickListener btnSigue_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent2;

            intent2 = new Intent ( MainActivityRegistrarse3.this, MainActivityRegistrarse4.class);
            startActivity(intent2);


        }
    };
    View.OnClickListener btnOmitir_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent2;

            intent2 = new Intent ( MainActivityRegistrarse3.this, MainActivityRegistrarse4.class);
            startActivity(intent2);


        }
    };




    private void ObtenerReferencias() {
        btnOmitir= (Button) findViewById(R.id.btnOmitir);
        btnSigue= (Button) findViewById(R.id.btnSig3);

    }
}