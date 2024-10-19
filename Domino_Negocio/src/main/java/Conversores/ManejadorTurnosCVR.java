/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conversores;

import DTOs.JugadorDTO;
import DTOs.ManejadorTurnosDTO;
import Entidades.Jugador;
import Entidades.ManejadorTurnos;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ManejadorTurnosCVR {
    
    JugadorCVR jugadorCVR; //Convertidor de jugador

    public ManejadorTurnosCVR() {
        this.jugadorCVR = new JugadorCVR();
    }
    
    /**
     * 
     * @param mtDTO
     * @return 
     */
    public ManejadorTurnos toEntity(ManejadorTurnosDTO mtDTO){
        ManejadorTurnos mt = new ManejadorTurnos();
        List<Jugador> jugadores = new LinkedList();
        
//        for (int i = 0; i < mtDTO.getJugadores().size(); i++) {
//            Jugador jugador = mt.
//        }
//        
//        mt.setJugadores(jugadores);
//        mt.setJugadorEnTurno(jugadorEnTurno);
        
        return mt; //retornamos el nuevo objeto
    }
    
    /**
     * 
     * @param mt
     * @return 
     */
    public ManejadorTurnosDTO toDTO(ManejadorTurnos mt){
        ManejadorTurnosDTO mtDTO = new ManejadorTurnosDTO();
        
        return mtDTO; //retornamos el nuevo objeto
    }
    
}
