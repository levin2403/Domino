/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadorTurnos;

import DTOs.JugadorDTO;
import Entidades.Jugador;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ManejadorTurnos {
    
    public List <Jugador> jugadores;
    public Jugador jugadorEnTurno;

    public ManejadorTurnos() {
        jugadores = new LinkedList<>();
    }
    
    public boolean addJugador(Jugador jugador){
        jugadores.add(jugador);
        return true;
    }
    
    public boolean deleteJugador(Jugador jugador){
        jugadores.remove(jugador);
        return true;
    }
    
    public boolean pasarTurno(){
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadorEnTurno.equals(jugadores.get(i))) {
                if (jugadores.getLast().equals(jugadorEnTurno)) {
                    jugadorEnTurno = jugadores.getFirst();
                    return true;
                }
                else{
                    jugadorEnTurno = jugadores.get(i+1);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean asignarPrimerTurno(){
        jugadorEnTurno = jugadores.getFirst();
        return true;
    }
    
}
