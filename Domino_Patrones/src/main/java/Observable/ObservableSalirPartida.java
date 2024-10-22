/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observable;

import Observer.ObserverSalirPartida;

/**
 *
 * @author skevi
 */
public interface ObservableSalirPartida {
    
    public void registrarObservador(ObserverSalirPartida o);
    public void notificarSalidaPartida();
    
}
