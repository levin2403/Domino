/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import Mediator.Mediador;
import Observer.ObserverEstablecerConfiguracion;
import Observer.ObserverLobby;
import Observer.ObserverMenuLogica;
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

    public static IFachada getFachada() {
        if(fachada == null){
            fachada = new Fachada();
        }
        return fachada;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ObserverLobby showFrmLobby(ObserverLobby o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void showFrmMatchOngoing() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void showFrmMatchEndingRequest() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
