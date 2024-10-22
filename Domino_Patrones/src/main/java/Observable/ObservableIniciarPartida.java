/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observable;

import Observer.ObserverIniciarPartida;

/**
 *
 * @author skevi
 */
public interface ObservableIniciarPartida {
    
    public void registrarObservador(ObserverIniciarPartida observer);
    public void notificarInicio();
    
}
