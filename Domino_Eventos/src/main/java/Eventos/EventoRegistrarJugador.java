/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import DTOs.JugadorDTO;
import DTOs.PlayerSettingsModelDTO;

/**
 *
 * @author skevi
 */
public class EventoRegistrarJugador {
    
    public  String TIPO_EVENTO = "eventoRegistrarJugador"; 
    private PlayerSettingsModelDTO player;
    private JugadorDTO jugador;
    private boolean host;

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
