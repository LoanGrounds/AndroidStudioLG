package com.example.ProyectoFinal.loangrounds.Registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ProyectoFinal.loangrounds.MainActivity;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.toastes;

public class RegistroFragment extends Fragment {

    Button btnSiguiente;
    View layoutRhoot;
    LinearLayout item1;
    LinearLayout item2;
    int contador = 0;



    public RegistroFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }



    private void ObtenerReferencias(){
        btnSiguiente = (Button) layoutRhoot.findViewById(R.id.btnSiguiente);




    }





    public void SetearListners() {
        btnSiguiente.setOnClickListener(btnSiguiente_Click);
        Log.i("Hola",""+ contador);
    }
    View.OnClickListener btnSiguiente_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
         contador++;

            Log.i("Hola",""+ contador);
         if(contador == 1){
             item1 =   layoutRhoot.findViewById(R.id.LinearLayout1);
             item1.setVisibility(View.INVISIBLE);
             item2 =   layoutRhoot.findViewById(R.id.LinearLayout2);
             item2.setVisibility(View.VISIBLE);

         }



        }
    };



}