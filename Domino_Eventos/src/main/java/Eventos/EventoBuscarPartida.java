/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import DTOs.Acciones;
import DTOs.ConfiguracionDTO;

/**
 * Clase EventoBuscarPartida
 * Representa un evento relacionado con la búsqueda de una partida.
 * Contiene información sobre la acción realizada, la respuesta de la 
 * búsqueda, y un mensaje de respuesta en forma de texto.
 * 
 * @author skevi
 */
public class EventoBuscarPartida {  
    // Clase que representa un evento para buscar una partida en el juego

    public String TIPO_EVENTO = "eventoBuscarPartida";  // Tipo de evento que se está manejando
    private Acciones accion;  // Acción relacionada con el evento
    private boolean respuesta;  // Resultado de la búsqueda (éxito o fallo)
    private String respuestaString;  // Respuesta en formato de texto sobre el estado de la búsqueda
    private ConfiguracionDTO configuracion;  // Configuración asociada a la partida buscada

    public EventoBuscarPartida() {  
        // Constructor vacío
    }

    public ConfiguracionDTO getConfiguracion() {  
        return configuracion; // Devuelve la configuración asociada al evento
    }

    public void setConfiguracion(ConfiguracionDTO configuracion) {  
        this.configuracion = configuracion; // Establece la configuración del evento
    }

    public Acciones getAccion() {  
        return accion; // Devuelve la acción asociada al evento
    }

    public void setAccion(Acciones accion) {  
        this.accion = accion; // Establece la acción del evento
    }

    public boolean isRespuesta() {  
        return respuesta; // Devuelve si la búsqueda fue exitosa o no
    }

    public void setRespuesta(boolean respuesta) {  
        this.respuesta = respuesta; // Establece la respuesta del evento
    }

    public String getRespuestaString() {  
        return respuestaString; // Devuelve la respuesta en formato de texto
    }

    public void setRespuestaString(String respuestaString) {  
        this.respuestaString = respuestaString; // Establece la respuesta como texto
    }
}
