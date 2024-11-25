/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package filtro;

import DTOs.AvatarDTO;
import DTOs.JugadorDTO;
import Eventos.EventoRegistrarJugador;
import filter.FilterDomino;
import interfaz.IPipe;

/**
 *
 * @author Dell
 */
public class FiltroRegistrarJugador<T> extends FilterDomino<T>{

    private IPipe pipaSiguiente;
    
    @Override
    public void procesar(T mensaje) {
        if (mensaje instanceof EventoRegistrarJugador) {
            EventoRegistrarJugador r= (EventoRegistrarJugador)mensaje;
            AvatarDTO a = new AvatarDTO(r.getPlayer().getImagen());
            JugadorDTO o = new JugadorDTO(r.getPlayer().getPlayerName(),a);
              ((EventoRegistrarJugador)mensaje).setJugador(o); 
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
