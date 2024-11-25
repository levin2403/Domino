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
        
        for (JugadorDTO jugadore : mtDTO.getJugadores()) {
            jugadores.add(jugadorCVR.jugadorConvertirDTOAEntidad(jugadore));
        }
        
        mt.setJugadores(jugadores);
        mt.setJugadorEnTurno(jugadorCVR.jugadorConvertirDTOAEntidad(mtDTO.getJugadorEnTurno()));
        
        return mt; //retornamos el nuevo objeto
    }
    
    /**
     * 
     * @param mt
     * @return 
     */
    public ManejadorTurnosDTO toDTO(ManejadorTurnos mt) {
        // Creamos un nuevo ManejadorTurnosDTO
        ManejadorTurnosDTO mtDTO = new ManejadorTurnosDTO();

        // Convertimos la lista de jugadores a una lista de JugadorDTO
        List<JugadorDTO> jugadoresDTO = new LinkedList<>();
        for (Jugador jugador : mt.getJugadores()) {
            jugadoresDTO.add(jugadorCVR.jugadorConvertirEntidadADTO(jugador));
        }

        // Establecemos la lista de JugadorDTO en el ManejadorTurnosDTO
        mtDTO.setJugadores(jugadoresDTO);

        // Convertimos y establecemos el jugador en turno
        mtDTO.setJugadorEnTurno(jugadorCVR.jugadorConvertirEntidadADTO(mt.getJugadorEnturno()));

        return mtDTO; // Retornamos el nuevo objeto ManejadorTurnosDTO
    }
    
}
