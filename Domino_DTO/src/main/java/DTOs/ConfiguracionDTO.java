/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.io.Serializable;

/**
 *
 * @author skevi
 */
public class ConfiguracionDTO implements Serializable {
    
    private int fichasARepartir; // numero de fichas a repartir
    private int numJugadores; // numero de jugadores de la partida

    /**
     * Constructor por defecto para la clase 
     */
    public ConfiguracionDTO() {
    }
    
    /**
     * Constructor unico que inicializa ambos atributos de la clase
     * 
     * @param fichasARepartir numero de fichas a repartir
     * @param numJugadores numero de jugadores de la partida
     */
    public ConfiguracionDTO(int fichasARepartir, int numJugadores) {
        this.fichasARepartir = fichasARepartir;
        this.numJugadores = numJugadores;
    }

    //Getter y Setters
    
    public int getFichasARepartir() {
        return fichasARepartir;
    }

    public void setFichasARepartir(int fichasARepartir) {
        this.fichasARepartir = fichasARepartir;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    @Override
    public String toString() {
        return "ConfiguracionDTO{" + "fichasARepartir=" + fichasARepartir + 
                ", numJugadores=" + numJugadores + '}';
    }
    
}
