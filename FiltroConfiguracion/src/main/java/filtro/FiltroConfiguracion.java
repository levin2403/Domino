/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package filtro;

import Eventos.EventoEstablecerConfiguracion;
import filter.FilterDomino;
import interfaz.IPipeDomino;

/**
 *
 * @author Dell
 */
public class FiltroConfiguracion<T> extends FilterDomino<T>{

    private IPipeDomino pipaSiguiente;  
    
    @Override
    public void procesar(T mensaje) {
        if (mensaje instanceof EventoEstablecerConfiguracion) {
            ((EventoEstablecerConfiguracion)mensaje).getConfiguracion();
        }
        this.mensajeProcesado= mensaje;
        if (pipaSiguiente != null) {
            pipaSiguiente.enviar(mensajeProcesado); 
        }
       
    }

    public IPipeDomino getPipe() {
        return pipaSiguiente;
    }

    public void setPipe(IPipeDomino pipaSiguiente) {
        this.pipaSiguiente = pipaSiguiente;
    }

    @Override
    public T getMensaje() {
        return mensajeProcesado;
    }
}
