package com.example.ProyectoFinal.loangrounds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivityInicio extends AppCompatActivity {
    ImageButton imageButton2;
    TextView textView3;
    EditText name;
    Button PROBAR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio);
       /* ObtenerReferencias();
        setearListeners();*/

    }
    /*private void setearListeners(){
        PROBAR.setOnClickListener(PROBAR_Click);

    }

    View.OnClickListener PROBAR_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String texto;
            texto=name.getText().toString();
        textView3.setText(texto);

        }
    };

    private void ObtenerReferencias() {
      imageButton2= (ImageButton) findViewById(R.id.imageButton2);
        textView3= (TextView) findViewById(R.id.textView3);
        name= (EditText) findViewById(R.id.name);
        PROBAR= (Button) findViewById(R.id.PROBAR);

    }*/

}