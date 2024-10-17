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
    private int contador = 0; // contador de los turnos

    /**
     * Constructor por defecto.
     */
    public ManejadorTurnosDTO() {
    }

    /**
     * Constructor que inicializa los atributos de la clase.
     * 
     * @param jugadores
     * @param jugadorEnTurno 
     */
    public ManejadorTurnosDTO(List<JugadorDTO> jugadores, JugadorDTO jugadorEnTurno) {
        this.jugadores = jugadores;
        this.jugadorEnTurno = jugadorEnTurno;
    }

    // Getters y Setters
    
    public List<JugadorDTO> getJugadores() {
        return jugadores;
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

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    @Override
    public String toString() {
        return "ManejadorTurnosDTO{" + "jugadores=" + jugadores + 
                ", jugadorEnTurno=" + jugadorEnTurno + ", contador=" + 
                contador + '}';
    }
    
}
