/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.filtroregistrarjugador;

import DTOs.AvatarDTO;
import DTOs.JugadorDTO;
import Eventos.EventoRegistrarJugador;
import com.mycompany.filterdomino.FilterDomino;
import interfaz.IPipeDomino;

/**
 *
 * @author Dell
 */
public class FiltroRegistrarJugador<T> extends FilterDomino<T>{

    private IPipeDomino pipaSiguiente;
    
    @Override
    public void procesar(T mensaje) {
        if (mensaje instanceof EventoRegistrarJugador) {
            EventoRegistrarJugador r= (EventoRegistrarJugador)mensaje;
            AvatarDTO a = new AvatarDTO(r.getPlayer().getImagen());
            JugadorDTO o = new JugadorDTO(r.getPlayer().getPlayerName(),a);
              ((EventoRegistrarJugador)mensaje).setJugador(o); 
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
