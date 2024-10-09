/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

import DTOs.JugadorDTO;

/**
 *
 * @author skevi
 */
public class JugadorRegistrado {
    
    private static JugadorDTO instance;
    
    public JugadorDTO getInstance() {
        if (instance == null) {
            synchronized (JugadorRegistrado.class) {
                if (instance == null) {
                    instance = new JugadorDTO();
                }
            }
        }
        return instance;
    }

    public void setInstance(JugadorDTO instance) {
        JugadorRegistrado.instance = instance;
    }
    
    
}
