/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.domino.observable;

import org.itson.domino.observer.ObserverObtenerFichaPozo;

/**
 *
 * @author Dell
 */
public interface ObservableObtenerFichaPozo {
    
    public void registrarObservador(ObserverObtenerFichaPozo orj);
    public void notificar();
    
}
