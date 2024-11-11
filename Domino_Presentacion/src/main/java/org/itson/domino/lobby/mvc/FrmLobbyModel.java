/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.lobby.mvc;

import DTOs.JugadorDTO;
import Observer.ObserverLobby;
import Observer.Vista.ObserverFrmLobbyView;


/**
 *
 * @author gamaliel
 */
public class FrmLobbyModel {
    private ObserverLobby observer;
    private JugadorDTO jugadorDto;
    ObserverLobby observable = new ObserverLobby() {
        @Override
        public void actualizar(Object objecto) {
            observerView.actualizarVista(objecto);
        }

    };

    public JugadorDTO getJugadorDto() {
        return jugadorDto;
    }

    public void setJugadorDto(JugadorDTO jugadorDto) {
        this.jugadorDto = jugadorDto;
    }

    private ObserverFrmLobbyView observerView;

    public ObserverLobby getObservable() {
        return observable;
    }

    public void setObservable(ObserverLobby observable) {
        this.observable = observable;
    }

    public ObserverFrmLobbyView getObserverView() {
        return observerView;
    }

    public void setObserverView(ObserverFrmLobbyView observerView) {
        this.observerView = observerView;
    }

    public void actulizarLogica(Object objecto) {
        observer.actualizar(objecto);
    }
}
