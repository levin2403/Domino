/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;


import DTOs.FichaDTO;
import DTOs.JugadorDTO;
import Entidades.Jugador;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ManejadorTurnos {
    
    private List <JugadorDTO> jugadores;
    private JugadorDTO jugadorEnTurno;
    private int contador = 0; 

    public ManejadorTurnos() {
        jugadores = new LinkedList<>();
    }
    
    public boolean addJugador(JugadorDTO jugador){
        jugadores.add(jugador);
        return true;
    }
    
    public boolean deleteJugador(Jugador jugador){
        jugadores.remove(jugador);
        return true;
    }
    
    public boolean asignarPrimerTurno(){
        jugadorEnTurno = jugadores.getFirst();
        return true;
    }
    
    public boolean pasarTurno(){
        
        if(contador == jugadores.size()){
            contador = 0;
        }
        
        jugadorEnTurno = jugadores.get(contador + 1);
        contador ++;
        return true;
    }
    
    public void darFichaAJugador(FichaDTO ficha){
        jugadores.get(contador).añadirFicha(ficha);
    }

    public JugadorDTO getJugadorEnTurno() {
        return jugadorEnTurno;
    }
    
}
