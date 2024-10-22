/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observable;

import Observer.ObserverSalirLobby;

/**
 *
 * @author skevi
 */
public interface ObservableVotar {
    
    public void registrarObservador(ObserverSalirLobby o);
    public void notificarSalida();
    
}
