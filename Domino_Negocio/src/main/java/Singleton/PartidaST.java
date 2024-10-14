/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

import DTOs.PartidaDTO;

/**
 *
 * @author skevi
 */
public class PartidaST {
    
    private static PartidaDTO instance;
    
    public PartidaDTO getInstance() {
        if (instance == null) {
            synchronized (PartidaST.class) {
                if (instance == null) {
                    instance = new PartidaDTO();
                }
            }
        }
        return instance;
    }

    public void setInstance(PartidaDTO instance) {
        PartidaST.instance = instance;
    }   
    
}
