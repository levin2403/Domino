/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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

    public Pozo getPozo() {
        return pozo;
    }

    public void setPozo(Pozo pozo) {
        this.pozo = pozo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
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
    /**
     * Metodo que añade a un jugador a la lista actual de jugadores.
     */
    public void añadirJugador(Jugador jugador) {
        if (jugador != null && !jugadores.contains(jugador)) {
            jugadores.add(jugador);
        }
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Metodo que elimina a un jugador de la lista actual de jugadores en caso
     * de abandono de la partida.
     *
     */
    public void eliminarJugador(Jugador jugador) {
        // Verifica si el jugador a eliminar es el jugador en turno
        if (jugador.equals(jugadorEnTurno)) {
            // Si hay más de un jugador, pasar el turno al siguiente
            if (!jugadores.isEmpty()) {
                pasarTurno();
            }
        }
        // Elimina al jugador de la lista
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
        if (!jugadores.isEmpty()) {
            // Si no es el último jugador, avanzamos al siguiente
            if (contador == jugadores.size() - 1) {
                contador = 0;  // Reseteamos al primer jugador
            } else {
                contador++;  // Aumentamos el contador para pasar al siguiente jugador
            }
            // Establecemos al siguiente jugador como el jugador en turno
          
            jugadorEnTurno = jugadores.get(contador);
        }
    }

    public void asignarTurnos() {
        Jugador jugadorConMula = verificarMula();  // Verifica si algún jugador tiene mula

        while (jugadorConMula == null) {
            // Si no hay mula, se agregan fichas extra a cada jugador
            agregarFichaExtraAJugadores();
            jugadorConMula = verificarMula();  // Volver a verificar
        }

        // Poner al jugador con la mula más grande en primer lugar
        jugadorEnTurno = jugadorConMula;

        // Ordenar el resto de los jugadores aleatoriamente
        Collections.shuffle(jugadores);
        // Asegurarse de que el jugador con la mula más grande esté en primer lugar
        jugadores.remove(jugadorEnTurno);
        jugadores.add(0, jugadorEnTurno);
    }

    /**
     * Método que asigna una cantidad inicial de fichas a cada jugador.
     *
     * @param cantidad Cantidad de fichas iniciales a asignar a cada jugador.
     */
    public void asignarFichas(int cantidad) {
        for (Jugador jugador : jugadores) {
            List<Ficha> fichasIniciales = pozo.obtenerFichas((byte) cantidad);
            jugador.setFichas(fichasIniciales);
        }
    }

    public void agregarFichaExtraAJugadores() {
        for (Jugador jugador : jugadores) {
            jugador.añadirFicha(pozo.obtenerFicha());  // Se usa añadirFicha para agregar una ficha
        }
    }

    public Jugador verificarMula() {
        Jugador jugadorConMulaMasGrande = null;
        // Recorremos a todos los jugadores para buscar el que tenga la mula más grande
        for (Jugador jugador : jugadores) {
            Ficha mula = jugador.mulaMasGrande();
            if (mula != null) {
                if (jugadorConMulaMasGrande == null || mula.getValorSuperior() > jugadorConMulaMasGrande.mulaMasGrande().getValorSuperior()) {
                    jugadorConMulaMasGrande = jugador;  // Actualizamos el jugador con la mula más grande
                }
            }
        }
        return jugadorConMulaMasGrande;  // Retorna el jugador con la mula más grande o null si nadie tiene mula
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
