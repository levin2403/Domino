/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.matchOngoing.mvc;

import org.itson.domino.observable.ObservableObtenerFichaPozo;
import org.itson.domino.observer.ObserverObtenerFichaPozo;

/**
 *
 * @author gamaliel
 */
public class FrmMatchOngoingModel implements ObservableObtenerFichaPozo{
    ObserverObtenerFichaPozo observer;
    ObserverObtenerFichaPozo orj;
    
    @Override
    public void registrarObservador(ObserverObtenerFichaPozo orj) {
        this.observer = orj;
    }
    
    @Override
    public void notificar() {
        this.observer.jalarDelPozo();
    }

}
