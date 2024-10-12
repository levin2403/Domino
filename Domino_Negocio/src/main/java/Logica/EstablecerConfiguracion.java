/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import DTOs.ConfiguracionDTO;
import Singleton.ConfiguracionInicial;

/**
 *
 * @author skevi
 */
public class EstablecerConfiguracion {
    
    
    ConfiguracionDTO configuracionDTO;
    ConfiguracionInicial ci;

    public EstablecerConfiguracion() {
        this.configuracionDTO = ci.getInstance();
    }
    
    
    
    
}
