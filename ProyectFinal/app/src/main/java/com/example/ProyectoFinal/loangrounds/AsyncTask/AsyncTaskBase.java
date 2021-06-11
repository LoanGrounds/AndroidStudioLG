package com.example.ProyectoFinal.loangrounds.AsyncTask;

import android.os.AsyncTask;

import com.example.ProyectoFinal.loangrounds.Utilidades.StreamHelper;
//Este es para get!!!!!
public class AsyncTaskBase extends AsyncTask<Void, Void ,String> {

    private String Busqueda;

    public AsyncTaskBase(String b) {
        this.Busqueda = b;
    }
    @Override
    protected String doInBackground(Void... voids) {
        return StreamHelper.returnJsonAsString(Busqueda);
    }
}
