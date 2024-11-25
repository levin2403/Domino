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
    /**
     * Atributo que define la acción específica que se realiza en el 
     * evento de búsqueda.
     */
    public  String TIPO_EVENTO = "eventoBuscarPartida";  
    private Acciones accion;
    private boolean respuesta;
    private String respuestaString;
    private ConfiguracionDTO configuracion;
  
    public EventoBuscarPartida() {
    }

    public ConfiguracionDTO getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(ConfiguracionDTO configuracion) {
        this.configuracion = configuracion;
    }

    public Acciones getAccion() {
        return accion;
    }
    
    public void setAccion(Acciones accion) {
        this.accion = accion;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuestaString() {
        return respuestaString;
    }

    public void setRespuestaString(String respuestaString) {
        this.respuestaString = respuestaString;
    }
    
    //es mas sencilla ya cosa oiga, tampoco se complique la vida 
}
