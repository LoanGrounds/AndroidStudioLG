package com.example.ProyectoFinal.loangrounds;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.biometrics.BiometricManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityRegistrarse4 extends AppCompatActivity {

    Button btnCrear;
    TextView tvMensaje;
    Button btnHuella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registrarse4);
        ObtenerReferencias();
        setearListeners();







    }
    private void setearListeners(){
        btnCrear.setOnClickListener(btnCrear_Click);


    }
    View.OnClickListener btnCrear_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent2;

            intent2 = new Intent ( MainActivityRegistrarse4.this, MainActivityInicio.class);
            startActivity(intent2);


        }
    };



    private void ObtenerReferencias() {

        btnCrear= (Button) findViewById(R.id.btnCrearCuenta);
        btnHuella=(Button) findViewById(R.id.btnHuela);
        tvMensaje=(TextView) findViewById(R.id.tvMsaje);

    }
}