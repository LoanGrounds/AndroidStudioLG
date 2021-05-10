package com.example.ProyectoFinal.loangrounds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityRegistrase1 extends AppCompatActivity {

    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registrase1);
        ObtenerReferencias();
        setearListeners();

    }
    private void setearListeners(){
        btnSiguiente.setOnClickListener(btnSiguiente_Click);


    }









    View.OnClickListener btnSiguiente_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent1;

            intent1 = new Intent ( MainActivityRegistrase1.this, MainActivityRegistrarse2.class);
            startActivity(intent1);


        }
    };



    private void ObtenerReferencias() {

        btnSiguiente= (Button) findViewById(R.id.btnSig);

    }
}