/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observable;

import Observer.ObserverRealizarJugada;

/**
 *
 * @author skevi
 */
public interface ObservableRealizarJugada {
    
    public void registrarObservador(ObserverRealizarJugada o);
    public void notificarJugada();
    
}
