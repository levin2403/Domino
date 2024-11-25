/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package filtro;

import DTOs.ManejadorTurnosDTO;
import Eventos.EventoIniciarPartida;
import filter.FilterDomino;
import interfaz.IPipe;

/**
 *
 * @author Dell
 */
public class FiltroIniciarPartida<T> extends FilterDomino<T>{

    private IPipe pipaSiguiente;   
    
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

    public IPipe getPipe() {
        return pipaSiguiente;
    }

    public void setPipe(IPipe pipaSiguiente) {
        this.pipaSiguiente = pipaSiguiente;
    }

    @Override
    public T getMensaje() {
        return mensajeProcesado;
    }
}
