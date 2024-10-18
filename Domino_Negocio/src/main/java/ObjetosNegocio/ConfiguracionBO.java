/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import Entidades.Partida;
import singleton.PartidaST;

/**
 * Objeto de negocio de Configuracion que funciona como controlador entre la 
 * de domino y la clase de negocio, contiene los metodos del objeto de dominio 
 * con la diferencia que ahora se usaran DTOs. 
 * 
 * @author skevi
 */
public class ConfiguracionBO {
    
    //instancia del singletone de partida
    private PartidaST partidaST;
    
    //instancia de partida
    private Partida partida;

    public ConfiguracionBO() {
        this.partida = partidaST.getInstance();
    }
    
    /**
     * Obtiene el numero de jugadores de la partida.
     * @return 
     */
    public byte getNumJugadores(){
        return partida.getConfiguracion().getNumJugadores();
    }
    
    /**
     * Obtiene el numero de de fichas por jugador.
     * @return Numero de de fichas por jugador.
     */
    public byte getFichasPorJugador(){
        return partida.getConfiguracion().getFichasPorJugador();
    }
    
        /**
     * Metodo para establecer el numero de jugadores.
     * 
     * @param numJugadores Numero de jugadores.
     */
    public void setNumJugadores(byte numJugadores) {
        partida.getConfiguracion().setNumJugadores(numJugadores);
    }

    /**
     * Metodo para establecer el numero de fichas por jugador.
     * 
     * @param FichasPorJugador Fichas por jugador.
     */
    public void setFichasPorJugador(byte FichasPorJugador) {
        partida.getConfiguracion().setFichasPorJugador(FichasPorJugador);
    }
}
