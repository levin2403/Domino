/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase esta diseñada para contener y manejar a los jugadores que se
 * Encuentran dentro de la partida.
 * 
 * @author skevi
 */
public class ManejadorTurnos {
    
    private List <Jugador> jugadores; // Jugadores en el manejador de turnos.
    private Jugador jugadorEnTurno; // Jugador en turno

    public ManejadorTurnos() {
        this.jugadores = new LinkedList();
    }
    
   /**
    * Metodo que determina turnos aleatorios para los jugadores, este metodo 
    * se ejecutara unicamente una sola vez, el iniciar la partida.
    * Igualmente asignara a un jugador en turno al momento de ejecutarse.
    */
    public void determinarTurnos() {
        // Mezclar aleatoriamente la lista de jugadores
        Collections.shuffle(jugadores);

        // Asignar al primer jugador como el jugador en turno
        if (!jugadores.isEmpty()) {
           jugadorEnTurno = jugadores.get(0);
        }
    }
    
    /**
     * Metodo que añade a un jugador a la lista actual de jugadores.
     */
    public void añadirJugador(Jugador jugador) {
        if (jugador != null && !jugadores.contains(jugador)) {
            jugadores.add(jugador);
        }
    }
    
    /**
     * Metodo que elimina a un jugador de la lista actual de jugadores en 
     * caso de abandono de la partida.
     * 
     */
    public void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);

        // Si el jugador eliminado es el que estaba en turno, pasar el turno al siguiente
        if (jugador.equals(jugadorEnTurno) && !jugadores.isEmpty()) {
            pasarTurno();
        }
    }
    
    /**
     * Metodo para obtener el jugador que se encuentra en turno.
     * 
     * @return Jugador en turno.
     */
    public Jugador getJugadorEnturno() {
        return jugadorEnTurno;
    }
    
    /**
     * Metodo para pasar de turno en caso de que el jugador que se 
     * encontraba en turno ya haya realizado su jugada.
     * 
     */
    public void pasarTurno() {
        if (!jugadores.isEmpty()) {
            int currentIndex = jugadores.indexOf(jugadorEnTurno);
            int nextIndex = (currentIndex + 1) % jugadores.size();
            jugadorEnTurno = jugadores.get(nextIndex);
        }
    }
    
}
