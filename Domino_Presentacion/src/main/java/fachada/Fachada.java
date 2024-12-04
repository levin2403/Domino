/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import Mediator.Mediador;
import Observer.ObserverEstablecerConfiguracion;
import Observer.ObserverLobby;
import Observer.ObserverMenuLogica;
import Observer.ObserverRealizarJugada;
import Observer.ObserverRegistrarJugador;
import Observer.ObserverTerminarPartida;
import fachadas.IFachada;
import org.itson.domino.singleton.MediadorSingleton;

/**
 * Aqui tenemos que poner tambien los metodos necesarios para que logica se comunique con presentacion al momento de que le llegue info del server
 * Y esta fachada es entre logica y presentacion, ocupamos hacer otra fachada para las comunicaciones.
 * @author Dell
 */
public class Fachada implements IFachada{

    Mediador mediador;
    private static Fachada fachada;

    private Fachada() {
        MediadorSingleton mS = new MediadorSingleton();
        mediador = mS.getInstance();
    }

    @Override
        public ObserverMenuLogica showFrmWelcome(ObserverMenuLogica observerMenuLogica) {
            return mediador.showFrmWelcome(observerMenuLogica);
        }

        @Override
        public ObserverEstablecerConfiguracion showFrmMatchSettings(ObserverEstablecerConfiguracion o) {
           return mediador.showFrmMatchSettings(o);
        }

        @Override
        public ObserverRegistrarJugador showFrmPlayerSettings(ObserverRegistrarJugador observer) {
            return mediador.showFrmPlayerSettings(observer);
        }

        @Override
        public ObserverLobby showFrmLobby(ObserverLobby l) {
            return mediador.showFrmLobby(l);
        }

        @Override
        public ObserverRealizarJugada showFrmMatchOngoing(ObserverRealizarJugada O) {
            return mediador.showFrmMatchOngoing(O);
        }

        @Override
        public ObserverTerminarPartida showFrmMatchEndingRequest(ObserverTerminarPartida o) {
           return mediador.showFrmMatchEndingRequest(o);
        }

    public static IFachada getFachada() {
        if(fachada == null){
            fachada = new Fachada();
        }
        return fachada;
    }
    
    
    
    
    
}
