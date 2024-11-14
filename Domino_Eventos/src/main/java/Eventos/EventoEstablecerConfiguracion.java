/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import DTOs.ConfiguracionDTO;

/**
 *
 * @author skevi
 */
public class EventoEstablecerConfiguracion {
    
    public String TIPO_EVENTO = "eventoEstablecerConfiguracion"; 
     public ConfiguracionDTO confi;
    

    public ConfiguracionDTO getConfiguracion() {
        return confi;
    }

    public void setConfiguracion(ConfiguracionDTO confi) {
        this.confi = confi;
    }
}
