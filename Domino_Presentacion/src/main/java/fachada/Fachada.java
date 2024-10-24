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
 *
 * @author Dell
 */
public class Fachada {

    Mediador mediador;

    public Fachada() {
        MediadorSingleton mS = new MediadorSingleton();
        mediador = mS.getInstance();
    }

    IFachada fachada = new IFachada() {
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
    };

    public IFachada getFachada() {
        return fachada;
    }
    
    
    
    
    
}
