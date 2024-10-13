/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author skevi
 */
public class ConfiguracionDTO {
    
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
