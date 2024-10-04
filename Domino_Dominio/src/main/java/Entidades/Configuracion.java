/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Clase de configuracion para la partida, declara el numero de jugadores 
 * y las fichas que se van a repartir
 * 
 * @author skevi
 */
public class Configuracion {
    
    private static byte numJugadores;
    private static byte FichasPorJugador;

    /**
     * Constructor que inicializa ambos atributos de la clase. 
     * 
     * @param numJugadores numero de jugadores.
     * @param FichasPorJugador fichas iniciales por cada jugador.
     */
    public Configuracion(byte numJugadores, byte FichasPorJugador) {
        this.numJugadores = numJugadores;
        this.FichasPorJugador = FichasPorJugador;
    }

    /**
     * Metodo para obetener el numero de jugadores para la partida.
     * 
     * @return numero de jugadores.
     */
    public byte getNumJugadores() {
        return numJugadores;
    }

    /**
     * Metodo para obetener el numero lwe fichas iniciales por jugador 
     * para la partida.
     * 
     * @return Numero de fichas iniciales a repartir.
     */
    public byte getFichasPorJugador() {
        return FichasPorJugador;
    }
    
}
