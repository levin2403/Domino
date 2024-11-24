/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;


import java.util.List;

/**
 *
 * @author Dell
 */
public class ManejadorTurnosDTO {
    
    private List<JugadorDTO> jugadores; // Lista de los jugadores de la partida
    private JugadorDTO jugadorEnTurno; // Jugador que se encuentra en turno
    private PozoDTO pozo;
    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    public PozoDTO getPozo() {
        return pozo;
    }

    public void setPozo(PozoDTO pozo) {
        this.pozo = pozo;
    }

    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }

    public JugadorDTO getJugadorEnTurno() {
        return jugadorEnTurno;
    }

    public void setJugadorEnTurno(JugadorDTO jugadorEnTurno) {
        this.jugadorEnTurno = jugadorEnTurno;
    }

}
