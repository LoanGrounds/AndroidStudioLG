package com.example.ProyectoFinal.loangrounds.AsyncTask;

import com.example.ProyectoFinal.loangrounds.Model.DetallePrestamo;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.google.gson.Gson;

public class AsyncTaskGetDetalle extends  AsyncTaskBase{
    private static DetallePrestamo detalle;

    public AsyncTaskGetDetalle(int id) {
        super(ApiHelper.devolverUrlParaGet("Detalles","obtenerPorId",String.valueOf(id)));
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(!s.equals("")){
            detalle = DetallePrestamo.fromjson(s);
            return;
        }
        CustomLog.log("me llego vacio el json");

    }

    public static DetallePrestamo devolverDetalle(int id){
        AsyncTaskGetDetalle dameElDetalle = new AsyncTaskGetDetalle(id);
        dameElDetalle.execute();
        return detalle;
    }
}
