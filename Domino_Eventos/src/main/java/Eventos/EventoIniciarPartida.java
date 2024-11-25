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
    public String TIPO_EVENTO = "eventoIniciarPartida";
    private List<JugadorDTO> jugadores;
    private JugadorDTO jugadorTurno;
    private ManejadorTurnosDTO manejador;
    private PozoDTO pozo;

    public EventoIniciarPartida() {
        jugadores = new ArrayList<>();
    }

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

    public JugadorDTO getJugadorTurno() {
        return jugadorTurno;
    }

    public void setJugadorTurno(JugadorDTO jugadorTurno) {
        this.jugadorTurno = jugadorTurno;
    }

    public ManejadorTurnosDTO getManejador() {
        return manejador;
    }

    public void setManejador(ManejadorTurnosDTO manejador) {
        this.manejador = manejador;
    }
}
