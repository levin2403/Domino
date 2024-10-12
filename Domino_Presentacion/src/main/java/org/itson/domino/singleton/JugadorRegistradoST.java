/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.singleton;

import DTOs.JugadorDTO;

/**
 *
 * @author skevi
 */
public class JugadorRegistradoST {
    
    //
    private static JugadorDTO instance;
    
    /**
     * 
     * @return 
     */
    public JugadorDTO getInstance() {
        if (instance == null) {
            synchronized (JugadorRegistradoST.class) {
                if (instance == null) {
                    instance = new JugadorDTO();
                }
            }
        }
        return instance;
    }

    /**
     * 
     * @param instance 
     */
    public void setInstance(JugadorDTO instance) {
        JugadorRegistradoST.instance = instance;
    }
    
    
}
