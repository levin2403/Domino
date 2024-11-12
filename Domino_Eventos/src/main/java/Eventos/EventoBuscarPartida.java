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
 * Contiene información sobre la acción realizada, la respuesta de la búsqueda,
 * y un mensaje de respuesta en forma de texto.
 * 
 * @author skevi
 */
public class EventoBuscarPartida {

    /**
     * Atributo que define la acción específica que se realiza en el 
     * evento de búsqueda.
     */
    public Acciones accion;

    /**
     * Atributo booleano que indica si la búsqueda fue exitosa o no.
     */
    public boolean respuesta;

    /**
     * Atributo que contiene un mensaje descriptivo de la respuesta.
     */
    public String respuestaString;

    /**
     * Constructor vacío de la clase EventoBuscarPartida.
     */
    public EventoBuscarPartida() {
    }

    /**
     * Obtiene la acción asociada al evento de búsqueda.
     * @return acción realizada en el evento.
     */
    public Acciones getAccion() {
        return accion;
    }

    /**
     * Define la acción a realizar en el evento de búsqueda.
     * @param accion Acción a ser asignada.
     */
    public void setAccion(Acciones accion) {
        this.accion = accion;
    }

    /**
     * Verifica si la respuesta de la búsqueda fue exitosa.
     * @return true si la respuesta es positiva, false en caso contrario.
     */
    public boolean isRespuesta() {
        return respuesta;
    }

    /**
     * Asigna el valor de la respuesta de la búsqueda.
     * @param respuesta Valor booleano de la respuesta (true para éxito, false para fallo).
     */
    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * Obtiene el mensaje descriptivo de la respuesta.
     * @return Cadena de texto que representa la respuesta.
     */
    public String getRespuestaString() {
        return respuestaString;
    }

    /**
     * Asigna el mensaje descriptivo de la respuesta.
     * @param respuestaString Mensaje a ser asignado como respuesta.
     */
    public void setRespuestaString(String respuestaString) {
        this.respuestaString = respuestaString;
    }

    public void setConfiguracion(ConfiguracionDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
