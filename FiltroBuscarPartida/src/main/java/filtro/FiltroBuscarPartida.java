/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filtro;

import DTOs.Acciones;
import Eventos.EventoBuscarPartida;
import filter.FilterDomino;
import interfaz.IPipe;
/**
 *
 * @author Dell
 * @param <T>
 */
public class FiltroBuscarPartida<T> extends FilterDomino<T>{

    private IPipe pipaSiguiente;   
    
    @Override
    public void procesar(T mensaje) {
        if (mensaje instanceof EventoBuscarPartida) {
            
            ((EventoBuscarPartida)mensaje).setAccion(Acciones.BUSCARPARTIDA);          
        }
        this.mensajeProcesado= mensaje;
        if (pipaSiguiente != null) {
            pipaSiguiente.enviar(mensajeProcesado);
        }
       
    }

    public IPipe getPipe() {
        return pipaSiguiente;
    }

    public void setPipe(IPipe pipaSiguiente) {
        this.pipaSiguiente = pipaSiguiente;
    }

    @Override
    public T getMensaje() {
        return mensajeProcesado;
    }
}