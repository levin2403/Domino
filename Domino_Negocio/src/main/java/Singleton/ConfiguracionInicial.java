/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

import DTOs.ConfiguracionDTO;

/**
 *
 * @author skevi
 */
public class ConfiguracionInicial {
    
    private static ConfiguracionDTO instance;
    
    public ConfiguracionDTO getInstance() {
        if (instance == null) {
            synchronized (JugadorRegistrado.class) {
                if (instance == null) {
                    instance = new ConfiguracionDTO();
                }
            }
        }
        return instance;
    }
    
    
}
