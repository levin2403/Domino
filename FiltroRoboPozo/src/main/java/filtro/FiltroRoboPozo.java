/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package filtro;

import DTOs.FichaDTO;
import DTOs.JugadorDTO;
import Eventos.EventoObtenerFichaPozo;
import filter.FilterDomino;
import interfaz.IPipe;

/**
 *
 * @author Dell
 */
public class FiltroRoboPozo<T> extends FilterDomino<T> {

    private IPipe pipaSiguiente;

    @Override
    public void procesar(T mensaje) {
        if (mensaje instanceof EventoObtenerFichaPozo) {
            EventoObtenerFichaPozo r = (EventoObtenerFichaPozo) mensaje;

            JugadorDTO j = r.getJugador();
            FichaDTO f = r.getFicha();

            ((EventoObtenerFichaPozo) mensaje).setFicha(f);
            ((EventoObtenerFichaPozo) mensaje).setJugador(j);
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