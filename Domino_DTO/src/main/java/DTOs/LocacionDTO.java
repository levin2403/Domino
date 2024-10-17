/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class LocacionDTO implements Serializable {

    private int x; // Locacion en x
    private int y; // Locacion en y

    /**
     * Constructor por defecto
     */
    public LocacionDTO() {
    }
    
    /**
     * Constructor que inicializa todos los atributos de la clase.
     * 
     * @param x Locacion en x
     * @param y Locacion en y
     */
    public LocacionDTO(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters y Setters
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "LocacionDTO{" + "x=" + x + ", y=" + y + '}';
    }
    
}
