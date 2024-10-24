/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachadas;

import Observer.ObserverRegistrarJugador;

/**
 *
 * @author Dell
 */
public interface IFachada {
    public void showFrmWelcome();
    
    public void showFrmMatchSettings();
    
    //Le asignas un observer a este metodo y le pides que te regrese el modelo que se creara dentro (esto para que logica le pueda asignar el observer)
    public void showFrmPlayerSettings(ObserverRegistrarJugador observer);
    
    public void showFrmLobby();
    
    public void showFrmMatchOngoing();
    
    public void showFrmMatchEndingRequest();
}
