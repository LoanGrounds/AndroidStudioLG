package com.example.ProyectoFinal.loangrounds.Registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

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
    LinearLayout item3;
    LinearLayout item4;
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
        contador = 0;
       layoutRhoot= inflater.inflate(R.layout.fragment_registro, container, false);

        ObtenerReferencias();
        SetearListners();
        return layoutRhoot;
    }



    private void ObtenerReferencias(){
        btnSiguiente = (Button) layoutRhoot.findViewById(R.id.btnSiguiente);




    }





    public void SetearListners() {
        btnSiguiente.setOnClickListener(btnSiguiente_Click);

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
            if(contador == 2){
                item2 =   layoutRhoot.findViewById(R.id.LinearLayout2);
                item2.setVisibility(View.INVISIBLE);
                item3 =   layoutRhoot.findViewById(R.id.LinearLayout3);
                item3.setVisibility(View.VISIBLE);

            }
            if(contador == 3){
                item3 =   layoutRhoot.findViewById(R.id.LinearLayout3);
                item3.setVisibility(View.INVISIBLE);
                item4 =   layoutRhoot.findViewById(R.id.LinearLayout4);
                item4.setVisibility(View.VISIBLE);
                btnSiguiente.setText("Crear cuenta");

            }
            if(contador == 4){

                MainActivity actividadContenedora;
                actividadContenedora = (MainActivity) getActivity();
                actividadContenedora.cambioActivity();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                int count = fm.getBackStackEntryCount();
                for(int i = 0; i < count; ++i) {
                    fm.popBackStack();
                }

            }




        }
    };



}