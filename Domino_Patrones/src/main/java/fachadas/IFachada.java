/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachadas;

import Observer.ObserverEstablecerConfiguracion;
import Observer.ObserverLobby;
import Observer.ObserverMenuLogica;
import Observer.ObserverRealizarJugada;
import Observer.ObserverRegistrarJugador;
import Observer.ObserverTerminarPartida;

/**
 *
 * @author Dell
 */
public interface IFachada {
    public ObserverMenuLogica showFrmWelcome(ObserverMenuLogica observerMenuLogica);
    
    public ObserverEstablecerConfiguracion showFrmMatchSettings(ObserverEstablecerConfiguracion o);
    
    //Le asignas un observer a este metodo y le pides que te regrese el modelo que se creara dentro (esto para que logica le pueda asignar el observer)
    public ObserverRegistrarJugador showFrmPlayerSettings(ObserverRegistrarJugador observer);
    
    public ObserverLobby showFrmLobby(ObserverLobby o);
    
    public ObserverRealizarJugada showFrmMatchOngoing(ObserverRealizarJugada O);
    
    public ObserverTerminarPartida showFrmMatchEndingRequest(ObserverTerminarPartida o);
}