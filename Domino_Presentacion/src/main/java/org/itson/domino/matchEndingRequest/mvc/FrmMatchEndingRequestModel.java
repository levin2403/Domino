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

    // Observador que gestiona la lógica de finalizar partida.
    private ObserverTerminarPartida observerTerminarPartidaModel;

    // Observador de la vista asociada a la pantalla de finalización de partida.
    private ObserverFrmTerminarPartida observerView;

    // Implementación de ObserverTerminarPartida para actualizar la vista cuando el estado cambie.
    ObserverTerminarPartida observerTerminarPartida = new ObserverTerminarPartida() {
        @Override
        public void actualizarTerminarPartida(Object objecto) {
            // Actualiza la vista con los nuevos datos.
            observerView.actualizarVista(objecto);
        }
    };

    /**
     * Devuelve el observador de la lógica de terminar partida.
     * @return El observador de terminar partida.
     */
    public ObserverTerminarPartida getObserverTerminarPartidaModel() {
        return observerTerminarPartidaModel;
    }

    /**
     * Establece el observador de la lógica de terminar partida.
     * @param observerTerminarPartidaModel El observador que se va a asignar.
     */
    public void setObserverTerminarPartidaModel(ObserverTerminarPartida observerTerminarPartidaModel) {
        this.observerTerminarPartidaModel = observerTerminarPartidaModel;
    }

    /**
     * Devuelve el observador que gestiona la lógica de terminar partida.
     * @return El observador de terminar partida.
     */
    public ObserverTerminarPartida getObserverTerminarPartida() {
        return observerTerminarPartida;
    }

    /**
     * Devuelve el observador de la vista asociada.
     * @return El observador de la vista.
     */
    public ObserverFrmTerminarPartida getObserverView() {
        return observerView;
    }

    /**
     * Establece el observador de la vista asociada.
     * @param observerView El observador de la vista que se va a asignar.
     */
    public void setObserverView(ObserverFrmTerminarPartida observerView) {
        this.observerView = observerView;
    }
}
