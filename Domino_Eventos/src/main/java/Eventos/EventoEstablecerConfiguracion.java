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
    // Clase que representa un evento para establecer la configuración de una partida

    public String TIPO_EVENTO = "eventoEstablecerConfiguracion";  // Tipo de evento que se está manejando
    public ConfiguracionDTO confi;  // Configuración que se va a establecer

    public ConfiguracionDTO getConfiguracion() {  
        return confi; // Devuelve la configuración asociada al evento
    }

    public void setConfiguracion(ConfiguracionDTO confi) {  
        this.confi = confi; // Establece la configuración del evento
    }
}
