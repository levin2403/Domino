/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import Conversores.JugadorCVR;
import DTOs.JugadorDTO;
import Entidades.Jugador;
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
    private JugadorCVR jugadorCVR;
    
    /**
     * Contructor de la clase.
     */
    public ManejadorTurnosBO() {
        partidaST = new PartidaST();
        this.partida = partidaST.getInstance();
        this.jugadorCVR = new JugadorCVR();
    }
    

   /**
    * Metodo que determina turnos aleatorios para los jugadores, este metodo 
    * se ejecutara unicamente una sola vez, el iniciar la partida.
    * Igualmente asignara a un jugador en turno al momento de ejecutarse.
    */
    public void determinarTurnos() {
        partida.getManejadorTurnos().determinarTurnos();
    }
    
    /**
     * Metodo que añade a un jugador a la lista actual de jugadores.
     */
    public void añadirJugador(JugadorDTO jugador) {
        //Convertimos el jugador recibido en el parametro
        Jugador jugadorEntidad = jugadorCVR.
                jugadorConvertirDTOAEntidad(jugador);
        
        // pasamos el jugador a dominio
        partida.getManejadorTurnos().añadirJugador(jugadorEntidad);
    }
    
    /**
     * Metodo que elimina a un jugador de la lista actual de jugadores en 
     * caso de abandono de la partida.
     * 
     */
    public void eliminarJugador(JugadorDTO jugador) {
        //Convertimos el jugador recibido en el parametro
        Jugador jugadorEntidad = jugadorCVR.
                jugadorConvertirDTOAEntidad(jugador);
        
        partida.getManejadorTurnos().eliminarJugador(jugadorEntidad);
    }
    
    /**
     * Metodo para obtener el jugador que se encuentra en turno.
     * 
     * @return Jugador en turno.
     */
    public JugadorDTO getJugadorEnturno() {
        
        JugadorDTO jugador = jugadorCVR.
                jugadorConvertirEntidadADTO(partida.getManejadorTurnos().
                        getJugadorEnturno());
        
        return jugador;
    }
    
    /**
     * Metodo para pasar de turno en caso de que el jugador que se 
     * encontraba en turno ya haya realizado su jugada.
     * 
     */
    public void pasarTurno() {
        partida.getManejadorTurnos().pasarTurno();
    }
    
}
