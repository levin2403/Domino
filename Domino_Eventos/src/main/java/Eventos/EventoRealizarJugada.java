/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import DTOs.FichaDTO;
import DTOs.JugadaDTO;
import DTOs.JugadorDTO;

/**
 *
 * @author skevi
 * @author Ruzzky
 * 
 * el duo desvelado
 */


/**
 * Clase que representa un evento de realizar una jugada en el juego de dominó.
 * 
 * Este evento se genera cuando un jugador realiza una acción (jugada) durante su turno.
 */
public class EventoRealizarJugada {

    /**
     * Tipo del evento, utilizado para identificar esta acción específica.
     */
    public String TIPO_EVENTO = "eventoRealizarJugada";

    /**
     * Representa la jugada que se está realizando.
     */
    public JugadaDTO jugada;

    /**
     * Representa al jugador que realiza la jugada.
     */
    public JugadorDTO jugador;

    /**
     * Representa la ficha que el jugador está utilizando en esta jugada.
     */
    public FichaDTO ficha;

    /**
     * Indica si la jugada se realiza en el lado izquierdo del tablero.
     * Si es `false`, la jugada se realiza en el lado derecho.
     */
    public boolean Izquierda;

    /**
     * Constructor que inicializa el evento con la jugada proporcionada.
     * 
     * @param jugada La jugada que se está realizando.
     */
    public EventoRealizarJugada(JugadaDTO jugada) {
        this.jugada = jugada;
    }

    /**
     * Obtiene la jugada asociada al evento.
     * 
     * @return La jugada que se está realizando.
     */
    public JugadaDTO getJugada() {
        return jugada;
    }

    /**
     * Establece la jugada asociada al evento.
     * 
     * @param jugada La jugada a asociar con este evento.
     */
    public void setJugada(JugadaDTO jugada) {
        this.jugada = jugada;
    }

    /**
     * Obtiene el jugador que realiza la jugada.
     * 
     * @return El jugador que realiza la acción.
     */
    public JugadorDTO getJugador() {
        return jugador;
    }

    /**
     * Establece el jugador que realiza la jugada.
     * 
     * @param jugador El jugador que realiza la acción.
     */
    public void setJugador(JugadorDTO jugador) {
        this.jugador = jugador;
    }

    /**
     * Obtiene el tipo de evento.
     * 
     * @return El tipo de evento como cadena de texto.
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
     * Obtiene la ficha asociada a la jugada.
     * 
     * @return La ficha utilizada en esta jugada.
     */
    public FichaDTO getFicha() {
        return ficha;
    }

    /**
     * Establece la ficha asociada a la jugada.
     * 
     * @param ficha La ficha a asociar con esta jugada.
     */
    public void setFicha(FichaDTO ficha) {
        this.ficha = ficha;
    }

    /**
     * Indica si la jugada se realiza en el lado izquierdo del tablero.
     * 
     * @return `true` si la jugada es en el lado izquierdo, `false` en caso contrario.
     */
    public boolean isIzquierda() {
        return Izquierda;
    }

    /**
     * Establece si la jugada se realiza en el lado izquierdo del tablero.
     * 
     * @param Izquierda `true` si es en el lado izquierdo, `false` en el lado derecho.
     */
    public void setIzquierda(boolean Izquierda) {
        this.Izquierda = Izquierda;
    }

    /**
     * Representa el objeto como una cadena de texto, útil para depuración.
     * 
     * @return Una representación textual del evento, incluyendo sus atributos principales.
     */
    @Override
    public String toString() {
        return "EventoRealizarJugada{" +
                "TIPO_EVENTO=" + TIPO_EVENTO +
                ", jugada=" + jugada +
                ", jugador=" + jugador +
                ", ficha=" + ficha +
                ", Izquierda=" + Izquierda +
                '}';
    }
}


