/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

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
    private int contador = 0; 

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
    
    public boolean asignarPrimerTurno(){
        jugadorEnTurno = jugadores.getFirst();
        contador++;
        return true;
    }
    
    public boolean pasarTurno(){
        
        if(contador == jugadores.size()){
            contador = 0;
        }
        
        jugadorEnTurno = jugadores.get(contador);
        contador ++;
        return true;
    }
    
}
