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
    
    private int fichasARepartir;
    private int numJugadores;

    public ConfiguracionDTO() {
    }
    
    public ConfiguracionDTO(int fichasARepartir, int numJugadores) {
        this.fichasARepartir = fichasARepartir;
        this.numJugadores = numJugadores;
    }

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
    
    
}
