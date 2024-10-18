/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import DTOs.JugadorDTO;
import Entidades.Partida;
import singleton.PartidaST;

/**
 * Objeto de negocio de ManejadorTurnos que funciona como controlador entre 
 * la clase de domino y la clase de negocio, contiene los metodos del objeto 
 * de dominio con la diferencia que ahora se usaran DTOs. 
 * 
 * @author skevi
 */
public class ManejadorTurnosBO {
    
    //instancia del singletone de partida.
    PartidaST partidaST;
    
    //instancia de partida.
    private Partida partida;
    
    //convertidor para jugador.

   /**
    * Metodo que determina turnos aleatorios para los jugadores, este metodo 
    * se ejecutara unicamente una sola vez, el iniciar la partida.
    * Igualmente asignara a un jugador en turno al momento de ejecutarse.
    */
    public void determinarTurnos() {
        
    }
    
    /**
     * Metodo que añade a un jugador a la lista actual de jugadores.
     */
    public void añadirJugador(JugadorDTO jugador) {
        
    }
    
    /**
     * Metodo que elimina a un jugador de la lista actual de jugadores en 
     * caso de abandono de la partida.
     * 
     */
    public void eliminarJugador(JugadorDTO jugador) {
        
    }
    
    /**
     * Metodo para obtener el jugador que se encuentra en turno.
     * 
     * @return Jugador en turno.
     */
    public JugadorDTO getJugadorEnturno() {
        return null;
    }
    
    /**
     * Metodo para pasar de turno en caso de que el jugador que se 
     * encontraba en turno ya haya realizado su jugada.
     * 
     */
    public void pasarTurno() {
        
    }
    
}
