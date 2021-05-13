package com.example.ProyectoFinal.loangrounds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ListView;

import com.example.ProyectoFinal.loangrounds.ListaRecomendados.Prestamo;
import com.example.ProyectoFinal.loangrounds.Menu.CadaPrestamoFragment;
import com.example.ProyectoFinal.loangrounds.Menu.ContactoFragment;
import com.example.ProyectoFinal.loangrounds.Menu.MenuFragment;
import com.example.ProyectoFinal.loangrounds.Menu.LupaFragment;
import com.example.ProyectoFinal.loangrounds.Menu.SolicitadosFragment;

import java.util.List;

public class MainActivityInicio extends AppCompatActivity {

    ContactoFragment fragmentContacto;
    MenuFragment fragmentMenu;
    LupaFragment fragmentLupa;
    SolicitadosFragment fragmentSolicitados;
    CadaPrestamoFragment fragmentCadaPrestamo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio);
        crearFragments();
        reemplazarFragmenbts(fragmentMenu,false);


    }
    public void reemplazarFragmenbts(Fragment fragmento){
        reemplazarFragmenbts(fragmento,true);
    }

    public void reemplazarFragmenbts(Fragment fragmento, Boolean blnAddToBackStack){
        FragmentManager manager= getSupportFragmentManager();
        FragmentTransaction transision = manager.beginTransaction();

        transision.replace(R.id.frameLayout2, fragmento, null );
        if(blnAddToBackStack){

            transision.addToBackStack(null);
        }
        transision.commit();

    }

    private void crearFragments() {
        fragmentMenu = new MenuFragment();
        fragmentLupa = new LupaFragment();
        fragmentSolicitados = new SolicitadosFragment();
        fragmentContacto = new ContactoFragment();
        fragmentCadaPrestamo= new CadaPrestamoFragment();

    }
    public  void setFragmentMenu(){

        reemplazarFragmenbts(fragmentMenu);

    }

    public  void setFragmentLupa(){
        reemplazarFragmenbts(fragmentLupa);
    }

    public  void setFragmentSolicitados(){
        reemplazarFragmenbts(fragmentSolicitados);

    }

    public  void setFragmentContacto(){
        reemplazarFragmenbts(fragmentContacto);

    }
    public  void setFragmentCadaPrestamo(){
        reemplazarFragmenbts(fragmentCadaPrestamo);

    }


    public void EnviarMensaje(int position,  List<Prestamo> prestamoList){
        fragmentCadaPrestamo.enviarPosition(position, prestamoList);
    }








}