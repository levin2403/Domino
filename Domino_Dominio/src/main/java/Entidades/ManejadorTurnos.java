/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import singleton.PozoST;

/**
 * Esta clase esta diseñada para contener y manejar a los jugadores que se
 * Encuentran dentro de la partida.
 *
 * @author skevi
 */
public class ManejadorTurnos {

    private List<Jugador> jugadores; // Jugadores en el manejador de turnos.
    private Jugador jugadorEnTurno; // Jugador en turno
    private int contador = 0;
    private Pozo pozo;

    public ManejadorTurnos() {
        this.jugadores = new LinkedList();
        PozoST ps = new PozoST();
        pozo = ps.getInstance();
    }

    /**
     * Metodo que determina turnos aleatorios para los jugadores, este metodo se
     * ejecutara unicamente una sola vez, el iniciar la partida. Igualmente
     * asignara a un jugador en turno al momento de ejecutarse.
     */
    public void determinarTurnos() {
        // Mezclar aleatoriamente la lista de jugadores
        Collections.shuffle(jugadores);

        // Asignar al primer jugador como el jugador en turno
        if (!jugadores.isEmpty()) {
            jugadorEnTurno = jugadores.get(0);
            contador = 0;
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
     * Metodo que elimina a un jugador de la lista actual de jugadores en caso
     * de abandono de la partida.
     *
     */
    public void eliminarJugador(Jugador jugador) {

        if (jugador.equals(jugadorEnTurno) && !jugadores.isEmpty()) {
            pasarTurno();
        }

        jugadores.remove(jugador);
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
     * Metodo para pasar de turno en caso de que el jugador que se encontraba en
     * turno ya haya realizado su jugada.
     *
     */
    public void pasarTurno() {
//        if (!jugadores.isEmpty()) {
//            int currentIndex = jugadores.indexOf(jugadorEnTurno);
//            int nextIndex = (currentIndex + 1) % jugadores.size();
//            jugadorEnTurno = jugadores.get(nextIndex);
//        }

        if (contador == (jugadores.size() - 1)) {
            jugadorEnTurno = jugadores.get(0);
            contador = 0;
        } else {
            contador++;
            jugadorEnTurno = jugadores.get(contador);
        }
    }

    public void primeroEnJugar() {
        Map<Jugador, Ficha> mapaJugadores = new HashMap<>();
        for (Jugador jugadore : jugadores) {
            mapaJugadores.put(jugadore, jugadore.mulaMasGrande());
        }
        Jugador jugadorMulaMasGrande = this.jugadorConMulaMasGrande(mapaJugadores);

        if (jugadorMulaMasGrande != null) {
            jugadorEnTurno = jugadorMulaMasGrande;
            //modificar el contador a el numero en el que esta este jugador.
            for (int i = 0; i < jugadores.size(); i++) {
                if (jugadores.get(i).equals(jugadorEnTurno)) {
                    contador = i;
                    break;
                }
            }
        } else {
            for (Jugador jugadore : jugadores) {
                jugadore.añadirFicha(pozo.obtenerFicha());
            }
            this.primeroEnJugar();
        }
    }

    private Jugador jugadorConMulaMasGrande(Map<Jugador, Ficha> mapaJugadores) {
        Jugador jugadorConMulaMayor = null;
        Ficha mulaMayor = null;

        for (Map.Entry<Jugador, Ficha> entrada : mapaJugadores.entrySet()) {
            Jugador jugador = entrada.getKey();
            Ficha mulaActual = entrada.getValue();

            // Solo compara si la ficha actual no es null
            if (mulaActual != null && (mulaMayor == null || mulaActual.getValorSuperior() > mulaMayor.getValorSuperior())) {
                mulaMayor = mulaActual;
                jugadorConMulaMayor = jugador;
            }
        }

        return jugadorConMulaMayor;
    }

    /**
     * Metodo para establecer la lista de jugadores.
     *
     * @param jugadores Lista de jugadores a establecer
     */
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Metodo para establecer al jugador en turno.
     *
     * @param jugadorEnTurno Jugador a establecer en turno.
     */
    public void setJugadorEnTurno(Jugador jugadorEnTurno) {
        this.jugadorEnTurno = jugadorEnTurno;
    }

}
