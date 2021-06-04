package com.example.ProyectoFinal.loangrounds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ListView;

import com.example.ProyectoFinal.loangrounds.ListaRecomendados.Prestamo;
import com.example.ProyectoFinal.loangrounds.Menu.AtencionClienteFragment;
import com.example.ProyectoFinal.loangrounds.Menu.CadaPrestamoFragment;
import com.example.ProyectoFinal.loangrounds.Menu.CadaSolicitadoFragment;
import com.example.ProyectoFinal.loangrounds.Menu.ConfiguracionFragment;
import com.example.ProyectoFinal.loangrounds.Menu.ContactoFragment;
import com.example.ProyectoFinal.loangrounds.Menu.CrearPrestamoFragment;
import com.example.ProyectoFinal.loangrounds.Menu.EditarPerfilFragment;
import com.example.ProyectoFinal.loangrounds.Menu.FiltrosFragment;
import com.example.ProyectoFinal.loangrounds.Menu.MenuFragment;
import com.example.ProyectoFinal.loangrounds.Menu.LupaFragment;
import com.example.ProyectoFinal.loangrounds.Menu.MetodoPagoFragment;
import com.example.ProyectoFinal.loangrounds.Menu.PrestamosRecientesFragment;
import com.example.ProyectoFinal.loangrounds.Menu.RealizarFragment;
import com.example.ProyectoFinal.loangrounds.Menu.SolicitadosFragment;

import java.util.List;

public class MainActivityInicio extends AppCompatActivity {

    ContactoFragment fragmentContacto;
    MenuFragment fragmentMenu;
    LupaFragment fragmentLupa;
    SolicitadosFragment fragmentSolicitados;
    CadaPrestamoFragment fragmentCadaPrestamo;
    CadaSolicitadoFragment fragmentCadaSolicitado;
    CrearPrestamoFragment fragmentCrearPrestamo;
    EditarPerfilFragment fragmentEditarPerfil;
    FiltrosFragment fragmentFiltros;
    PrestamosRecientesFragment fragmentPrestamosRecientes;
    ConfiguracionFragment fragmentConfiguracion;
    AtencionClienteFragment fragmentAtencionCliente;
    MetodoPagoFragment fragmentMetodoPago;
    RealizarFragment fragmentRealizar;


    private Object SupportFragmentManager;


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
        fragmentCadaSolicitado=new CadaSolicitadoFragment();
        fragmentCrearPrestamo=new CrearPrestamoFragment();
        fragmentEditarPerfil=new EditarPerfilFragment();
        fragmentFiltros=new FiltrosFragment();
        fragmentPrestamosRecientes= new PrestamosRecientesFragment();
        fragmentConfiguracion= new ConfiguracionFragment();
        fragmentAtencionCliente= new AtencionClienteFragment();
        fragmentMetodoPago= new MetodoPagoFragment();
        fragmentRealizar= new RealizarFragment();
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

    public  void setFragmentCadaSolicitado(){
        reemplazarFragmenbts(fragmentCadaSolicitado);

    }

    public  void setFragmentEditarPerfil(){
        reemplazarFragmenbts(fragmentEditarPerfil);

    }
    public  void setFragmentCrearPrestamo(){
        reemplazarFragmenbts(fragmentCrearPrestamo);

    }
    public  void setFragmentFiltros(){
        reemplazarFragmenbts(fragmentFiltros);

    }
    public  void setFragmentPrestamosRecientes(){
        reemplazarFragmenbts(fragmentPrestamosRecientes);

    }
    public  void setFragmentConfiguracion(){
        reemplazarFragmenbts(fragmentConfiguracion);

    }
    public  void setFragmentAtencionCliente(){
        reemplazarFragmenbts(fragmentAtencionCliente);

    }

    public  void setFragmentMetodoPago(){
        reemplazarFragmenbts(fragmentMetodoPago);

    }

    public  void setFragmentRealizar(){
        reemplazarFragmenbts(fragmentRealizar);

    }



    public void EnviarMensaje(int position,  List<Prestamo> prestamoList){
        fragmentCadaPrestamo.enviarPosition(position, prestamoList);
    }
    public void EnviarMensajeSolicitado(int position,  List<Prestamo> prestamoList){
        fragmentCadaSolicitado.enviarPosition(position, prestamoList);
    }








}