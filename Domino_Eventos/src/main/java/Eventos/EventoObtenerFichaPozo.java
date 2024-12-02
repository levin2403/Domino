/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import DTOs.FichaDTO;
import DTOs.JugadorDTO;

/**
 *
 * @author skevi
 * @author RUZZKY
 * 
 * El kevin me trajo en madrugada chambeando madremia :´v
 */

/**
 * Clase que representa un evento para obtener una ficha del pozo en el juego de dominó.
 * 
 * Este evento se genera cuando un jugador toma una ficha del pozo.
 * Contiene información sobre el tipo de evento, el jugador involucrado 
 * y la ficha obtenida.
 */

public class EventoObtenerFichaPozo {

    /**
     * Tipo del evento, utilizado para identificar esta acción específica.
     */
    public String TIPO_EVENTO = "eventoObtenerFichaPozo";

    /**
     * Representa al jugador que obtiene la ficha del pozo.
     */
    public JugadorDTO jugador;

    /**
     * Representa la ficha que el jugador obtiene del pozo.
     */
    public FichaDTO ficha;

    /**
     * Constructor vacío de la clase.
     * 
     * Se utiliza principalmente para frameworks que requieren instanciación sin argumentos
     * o para inicializar los valores posteriormente.
     */
    public EventoObtenerFichaPozo() {
    }

    /**
     * Obtiene el tipo de evento.
     */
    public String getTIPO_EVENTO() {
        return TIPO_EVENTO;
    }

    /**
     * Establece el tipo de evento.
     * 
     * @param TIPO_EVENTO El tipo de evento a asignar.

     */
    public void setTIPO_EVENTO(String TIPO_EVENTO) {
        this.TIPO_EVENTO = TIPO_EVENTO;
    }

    /**
     * Obtiene el jugador asociado al evento.
     * 
     * @return El jugador que tomó la ficha del pozo.
     */
    public JugadorDTO getJugador() {
        return jugador;
    }

    /**
     * Establece el jugador asociado al evento.
     * 
     * @param jugador El jugador que participa en este evento.
     */
    public void setJugador(JugadorDTO jugador) {
        this.jugador = jugador;
    }

    /**
     * Obtiene la ficha asociada al evento.
     * 
     * @return La ficha que el jugador obtuvo del pozo.
     */
    public FichaDTO getFicha() {
        return ficha;
    }

    /**
     * Establece la ficha asociada al evento.
     * 
     * @param ficha La ficha que el jugador obtuvo del pozo.
     */
    public void setFicha(FichaDTO ficha) {
        this.ficha = ficha;
    }
}

