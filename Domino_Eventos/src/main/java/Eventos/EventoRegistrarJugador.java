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
    // Constante que define el tipo de evento
    public  String TIPO_EVENTO = "eventoRegistrarJugador"; 
    // Configuración general del juego
    private ConfiguracionDTO c;
     // Lista de jugadores registrados
    private List<JugadorDTO > jugadores;
    // Configuración específica del jugador que se registra
    private PlayerSettingsModelDTO player;
    // Información del jugador que se registra
    private JugadorDTO jugador;
    // Indica si el jugador es el anfitrión (host) del juego
    private boolean host;
    
    /**
     * Constructor de la clase. Inicializa la lista de jugadores como
     * una lista vacía.
     */
    public EventoRegistrarJugador() {
     jugadores = new ArrayList<>();
    }
    
    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }
    
    
    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }
    
    
    public ConfiguracionDTO getC() {
        return c;
    }

    public void setC(ConfiguracionDTO c) {
        this.c = c;
    }

    //la mayoria se queda a como lo pusieron
    public PlayerSettingsModelDTO getPlayer() {
        return player;
    }

    public JugadorDTO getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDTO jugador) {
        this.jugador = jugador;
    }

    public void setPlayer(PlayerSettingsModelDTO player) {
        this.player = player;
    }

    public boolean isHost() {
        return host;
    }

    public void setHost(boolean host) {
        this.host = host;
    }
     public String getTIPO_EVENTO() {
        return TIPO_EVENTO;
    }
}
