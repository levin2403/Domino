/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observable;

import Observer.ObserverTerminarPartida;

/**
 *
 * @author skevi
 */
public interface ObservableTerminarPartida {
    
    public void registrarObservador(ObserverTerminarPartida o);
    public void notificarTerminarPartida();
    
}
