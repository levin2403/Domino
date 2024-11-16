/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;
import DTOs.JugadorDTO;
import DTOs.ManejadorTurnosDTO;
import DTOs.PozoDTO;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author skevi
 */
public class EventoIniciarPartida {
    //con razon, taba vacio.
    
    //wachen lo principal es lo siguiente pq sin eso no podremos avanzar más
    
   // Constante que define el tipo de evento
    public String TIPO_EVENTO = "eventoIniciarPartida"; 
    // Lista de jugadores participantes en la partida
    private List<JugadorDTO> jugadores;
    // Jugador que tiene el turno actual
    private JugadorDTO jugadorTurno;
    // Objeto encargado de manejar los turnos en la partida
    private ManejadorTurnosDTO manejador;
    // Pozo que contiene los elementos o recursos de la partida
    private PozoDTO pozo;

    /**
     * Constructor de la clase.
     * Inicializa la lista de jugadores como
     * una lista vacía.
     */
    public EventoIniciarPartida() {
        jugadores = new ArrayList<>();
    }

    /**
     * Obtiene la lista de jugadores de la partida.
     */
    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    /**
     * Establece la lista de jugadores de la partida.
     */
    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Obtiene el pozo asociado a la partida.
     */
    public PozoDTO getPozo() {
        return pozo;
    }

    /**
     * Establece el pozo asociado a la partida.
     */
    public void setPozo(PozoDTO pozo) {
        this.pozo = pozo;
    }

    /**
     * Obtiene el jugador que tiene el turno actual.
     */
    public JugadorDTO getJugadorTurno() {
        return jugadorTurno;
    }

    /**
     * Establece el jugador que tiene el turno actual.
     */
    public void setJugadorTurno(JugadorDTO jugadorTurno) {
        this.jugadorTurno = jugadorTurno;
    }

    /**
     * Obtiene el manejador de turnos de la partida.
     */
    public ManejadorTurnosDTO getManejador() {
        return manejador;
    }

    /**
     * Establece el manejador de turnos de la partida.
     */
    public void setManejador(ManejadorTurnosDTO manejador) {
        this.manejador = manejador;
    }
    
    // y eso es masomenos lo que se debe de tener 
    //a como dan mis conocimientos papus
    
}
