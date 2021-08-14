package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class FiltrosFragment extends Fragment {

    View layoutRhoot;
    SeekBar skbMin;
    SeekBar skbMax;
    TextView tvPrecioMin;
    TextView tvPrecioMax;
    Button btnAplicarFilt;

    public FiltrosFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layoutRhoot= inflater.inflate(R.layout.fragment_filtros, container, false);

        ObtenerReferencia();
        SetearListners();

        return layoutRhoot;
    }
    public void SetearListners() {
        skbMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                tvPrecioMax.setText("$ "+String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                skbMin.setMin(1000);

                skbMax.setMax(100000);
                skbMax.setMin(skbMin.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        skbMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                tvPrecioMin.setText("$ "+String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                skbMin.setMin(1000);

                skbMax.setMax(100000);
                skbMin.setMax(skbMax.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnAplicarFilt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();
                actividadContenedora.setFragmentMenu();

            }
        });
    }
    private void ObtenerReferencia() {
        skbMax = (SeekBar) layoutRhoot.findViewById(R.id.skbMax);
        skbMin = (SeekBar) layoutRhoot.findViewById(R.id.skbMin);
        tvPrecioMin=(TextView) layoutRhoot.findViewById(R.id.tvPrecioMin);
        tvPrecioMax=(TextView) layoutRhoot.findViewById(R.id.tvPrecioMax);
        btnAplicarFilt=(Button) layoutRhoot.findViewById(R.id.btnAplicarFilt);

    }


}