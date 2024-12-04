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
    public  String TIPO_EVENTO = "eventoPartidaTerminada";
    private List<JugadorDTO> jugadores;
    private JugadorDTO primerLugar;

    public String getTIPO_EVENTO() {
        return TIPO_EVENTO;
    }

    public void setTIPO_EVENTO(String TIPO_EVENTO) {
        this.TIPO_EVENTO = TIPO_EVENTO;
    }

    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }

    public JugadorDTO getPrimerLugar() {
        return primerLugar;
    }

    public void setPrimerLugar(JugadorDTO primerLugar) {
        this.primerLugar = primerLugar;
    }
}
