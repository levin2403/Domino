/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filtrobuscarpartida;

import DTOs.Acciones;
import Eventos.EventoBuscarPartida;
import com.mycompany.filterdomino.FilterDomino;
import interfaz.IPipeDomino;
/**
 *
 * @author Dell
 * @param <T>
 */
public class FiltroBuscarPartida<T> extends FilterDomino<T>{

    private IPipeDomino pipaSiguiente;   
    
    @Override
    public void procesar(T mensaje) {
        if (mensaje instanceof EventoBuscarPartida) {
            
            ((EventoBuscarPartida)mensaje).setAccion(Acciones.BUSCARPARTIDA);          
        }
        this.mensajeProcesado= mensaje;
        if (pipaSiguiente != null) {
            pipaSiguiente.enviar(mensajeProcesado);
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