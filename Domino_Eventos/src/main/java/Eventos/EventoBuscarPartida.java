/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eventos;

import DTOs.Acciones;

/**
 *
 * @author skevi
 */
public class EventoBuscarPartida {
       
    public Acciones accion;
    public boolean respuesta;
    public String respuestaString;

    public EventoBuscarPartida() {
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
    
}
