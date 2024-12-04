/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import DTOs.ConfiguracionDTO;
import DTOs.JugadorDTO;
import DTOs.PlayerSettingsModelDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */

public class EventoRegistrarJugador {  
    // Clase que representa el evento de registrar un jugador en el juego

    // Constante que define el tipo de evento
    public String TIPO_EVENTO = "eventoRegistrarJugador";  
    private ConfiguracionDTO c;  // Configuración general del juego
    private List<JugadorDTO> jugadores;  // Lista de jugadores registrados
    private PlayerSettingsModelDTO player;  // Configuración específica del jugador que se registra
    private JugadorDTO jugador;  // Información del jugador que se registra
    private boolean host;  // Indica si el jugador es el anfitrión (host) del juego
    
    /**
     * Constructor de la clase. Inicializa la lista de jugadores como
     * una lista vacía.
     */
    public EventoRegistrarJugador() {  
        jugadores = new ArrayList<>();
    }

    public List<JugadorDTO> getJugadores() {  
        return jugadores; // Devuelve la lista de jugadores registrados
    }

    public void setJugadores(List<JugadorDTO> jugadores) {  
        this.jugadores = jugadores; // Establece la lista de jugadores registrados
    }

    public ConfiguracionDTO getC() {  
        return c; // Devuelve la configuración general del juego
    }

    public void setC(ConfiguracionDTO c) {  
        this.c = c; // Establece la configuración general del juego
    }

    public PlayerSettingsModelDTO getPlayer() {  
        return player; // Devuelve la configuración específica del jugador
    }

    public JugadorDTO getJugador() {  
        return jugador; // Devuelve la información del jugador
    }

    public void setJugador(JugadorDTO jugador) {  
        this.jugador = jugador; // Establece la información del jugador
    }

    public void setPlayer(PlayerSettingsModelDTO player) {  
        this.player = player; // Establece la configuración específica del jugador
    }

    public boolean isHost() {  
        return host; // Devuelve si el jugador es el anfitrión
    }

    public void setHost(boolean host) {  
        this.host = host; // Establece si el jugador es el anfitrión
    }

    public String getTIPO_EVENTO() {  
        return TIPO_EVENTO; // Devuelve el tipo de evento
    }
}

