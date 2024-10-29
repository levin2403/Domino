/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import Mediator.Mediador;
import Observer.ObserverRegistrarJugador;
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
        public void showFrmWelcome() {
            mediador.showFrmWelcome();
        }

        @Override
        public void showFrmMatchSettings() {
            mediador.showFrmMatchSettings();
        }

        @Override
        public void showFrmPlayerSettings(ObserverRegistrarJugador observer) {
            mediador.showFrmPlayerSettings(observer);
        }

        @Override
        public void showFrmLobby() {
            mediador.showFrmLobby();
        }

        @Override
        public void showFrmMatchOngoing() {
            mediador.showFrmMatchOngoing();
        }

        @Override
        public void showFrmMatchEndingRequest() {
            mediador.showFrmMatchEndingRequest();
        }

    public static IFachada getFachada() {
        if(fachada == null){
            fachada = new Fachada();
        }
        return fachada;
    }
    
    
    
    
    
}
