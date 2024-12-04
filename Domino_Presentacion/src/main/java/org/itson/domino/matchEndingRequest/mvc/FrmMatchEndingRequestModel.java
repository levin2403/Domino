/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.matchEndingRequest.mvc;

import Observer.ObserverTerminarPartida;
import Observer.Vista.ObserverFrmTerminarPartida;

/**
 *
 * @author gamaliel
 */
public class FrmMatchEndingRequestModel {
    
    ObserverTerminarPartida observerTerminarPartidaModel;
    private ObserverFrmTerminarPartida observerView;
    ObserverTerminarPartida observerTerminarPartida = new ObserverTerminarPartida() {
        @Override
        public void actualizarTerminarPartida(Object objecto) {
            observerView.actualizarVista(objecto);
            
        }
    };

    public ObserverTerminarPartida getObserverTerminarPartidaModel() {
        return observerTerminarPartidaModel;
    }

    public void setObserverTerminarPartidaModel(ObserverTerminarPartida observerTerminarPartidaModel) {
        this.observerTerminarPartidaModel = observerTerminarPartidaModel;
    }

    public ObserverTerminarPartida getObserverTerminarPartida() {
        return observerTerminarPartida;
    }
    

    public ObserverFrmTerminarPartida getObserverView() {
        return observerView;
    }

    public void setObserverView(ObserverFrmTerminarPartida observerView) {
        this.observerView = observerView;
    }
    
    
    
    
    
}
