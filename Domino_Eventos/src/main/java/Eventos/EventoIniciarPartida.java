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
    // Clase que representa un evento para iniciar una partida

    public String TIPO_EVENTO = "eventoIniciarPartida";  // Tipo de evento que se está manejando
    private List<JugadorDTO> jugadores;  // Lista de jugadores que participan en la partida
    private JugadorDTO jugadorTurno;  // Jugador que inicia el turno
    private ManejadorTurnosDTO manejador;  // Manejador de turnos para controlar el flujo de la partida
    private PozoDTO pozo;  // Pozo de fichas disponible al inicio de la partida

    public EventoIniciarPartida() {  
        // Constructor que inicializa la lista de jugadores
        jugadores = new ArrayList<>();
    }

    public List<JugadorDTO> getJugadores() {  
        return jugadores; // Devuelve la lista de jugadores de la partida
    }

    public PozoDTO getPozo() {  
        return pozo; // Devuelve el pozo de fichas
    }

    public void setPozo(PozoDTO pozo) {  
        this.pozo = pozo; // Establece el pozo de fichas
    }

    public void setJugadores(List<JugadorDTO> jugadores) {  
        this.jugadores = jugadores; // Establece la lista de jugadores
    }

    public JugadorDTO getJugadorTurno() {  
        return jugadorTurno; // Devuelve el jugador que tiene el turno
    }

    public void setJugadorTurno(JugadorDTO jugadorTurno) {  
        this.jugadorTurno = jugadorTurno; // Establece el jugador que tiene el turno
    }

    public ManejadorTurnosDTO getManejador() {  
        return manejador; // Devuelve el manejador de turnos
    }

    public void setManejador(ManejadorTurnosDTO manejador) {  
        this.manejador = manejador; // Establece el manejador de turnos
    }
}

