/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import DTOs.JugadorDTO;
import java.util.List;

/**
 *
 * @author skevi
 */
public class EventoPartidaTerminada {  
    // Clase que representa un evento cuando la partida ha terminado

    public String TIPO_EVENTO = "eventoPartidaTerminada";  // Tipo de evento que se está manejando
    private List<JugadorDTO> jugadores;  // Lista de jugadores que participaron en la partida
    private JugadorDTO primerLugar;  // Jugador que ocupa el primer lugar al terminar la partida

    public String getTIPO_EVENTO() {  
        return TIPO_EVENTO; // Devuelve el tipo de evento
    }

    public void setTIPO_EVENTO(String TIPO_EVENTO) {  
        this.TIPO_EVENTO = TIPO_EVENTO; // Establece el tipo de evento
    }

    public List<JugadorDTO> getJugadores() {  
        return jugadores; // Devuelve la lista de jugadores de la partida
    }

    public void setJugadores(List<JugadorDTO> jugadores) {  
        this.jugadores = jugadores; // Establece la lista de jugadores
    }

    public JugadorDTO getPrimerLugar() {  
        return primerLugar; // Devuelve el jugador en primer lugar
    }

    public void setPrimerLugar(JugadorDTO primerLugar) {  
        this.primerLugar = primerLugar; // Establece al jugador en primer lugar
    }
}

