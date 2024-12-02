/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package filtro;

import DTOs.FichaDTO;
import DTOs.JugadaDTO;
import DTOs.JugadorDTO;
import Eventos.EventoRealizarJugada;
import filter.FilterDomino;
import interfaz.IPipe;

/**
 *
 * @author Dell
 */
public class FiltroRealizarJugada<T> extends FilterDomino<T> {

    private IPipe pipaSiguiente;

    @Override
    public void procesar(T mensaje) {
        if (mensaje instanceof EventoRealizarJugada) {
            EventoRealizarJugada r = (EventoRealizarJugada) mensaje;

            JugadaDTO j = r.getJugada();
            FichaDTO f = j.getFicha();
            JugadorDTO juga = j.getJugador();
            boolean b = j.isIzquierda();
            ((EventoRealizarJugada) mensaje).setIzquierda(b);
            ((EventoRealizarJugada) mensaje).setJugador(juga);
            ((EventoRealizarJugada) mensaje).setFicha(f);
        }
        this.mensajeProcesado = mensaje;
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