/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.filtrojson;

import com.google.gson.Gson;
import com.mycompany.filterdomino.FilterDomino;
import interfaz.IPipeDomino;

/**
 *
 * @author Dell
 */
public class FiltroJson<T> extends FilterDomino<T>{

    private IPipeDomino pipaSiguiente; 
    
    @Override
    public void procesar(T mensaje) {
        Gson gson = new Gson();
       this.mensajeProcesado = (T) gson.toJson(mensaje);
        if (pipaSiguiente != null) {
            pipaSiguiente.enviar(mensajeProcesado); // Envía el JSON al siguiente pipe si existe
        }
       
    }

    public IPipeDomino getPipe() {
        return pipaSiguiente;
    }

    public void setPipe(IPipeDomino pipaSiguiente) {
        this.pipaSiguiente = pipaSiguiente;
    }

    @Override
    public T getMensaje() {
        return mensajeProcesado;
    }
}
