/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.domino.observable;

import org.itson.domino.observer.ObserverRegistrarJugador;

/**
 *
 * @author skevi
 */
public interface ObserverbableRegistrarJugador {
    
    public void registrarObservador(ObserverRegistrarJugador orj);
    public void aliminarObservador(ObserverRegistrarJugador orj);
    public void notificar();
    
}
