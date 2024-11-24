/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package filtro;

import DTOs.ManejadorTurnosDTO;
import Eventos.EventoIniciarPartida;
import filter.FilterDomino;
import interfaz.IPipeDomino;

/**
 *
 * @author Dell
 */
public class FiltroIniciarPartida<T> extends FilterDomino<T>{

    private IPipeDomino pipaSiguiente;   
    
    @Override
    public void procesar(T mensaje) {
        if (mensaje instanceof EventoIniciarPartida e) {
            ManejadorTurnosDTO m = new ManejadorTurnosDTO();
            m.setJugadorEnTurno(e.getJugadorTurno());
            m.setJugadores(e.getJugadores());
            m.setPozo(e.getPozo());
            ((EventoIniciarPartida) mensaje).setManejador(m);
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
