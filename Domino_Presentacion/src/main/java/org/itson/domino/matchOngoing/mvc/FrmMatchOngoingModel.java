/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.matchOngoing.mvc;

import DTOs.JugadorDTO;
import Observable.ObservableObtenerFichaPozo;
import Observer.ObserverObtenerFichaPozo;
import Observer.ObserverRealizarJugada;
import Observer.Vista.ObserverFrmMatchOngoingView;
import java.util.List;

/**
 *
 * @author gamaliel
 */
public class FrmMatchOngoingModel{
    private ObserverRealizarJugada observer;
    private JugadorDTO jugadorDto;
    private List<JugadorDTO> jugadores;
    private ObserverFrmMatchOngoingView observerView;
    ObserverRealizarJugada observable = new ObserverRealizarJugada() {
        @Override
        public void actualizar(Object objecto) {

            observerView.actualizarVista(objecto);
        }

    };

    public ObserverRealizarJugada getObservable() {
        return observable;
    }

    public void setObservable(ObserverRealizarJugada observable) {
        this.observable = observable;
    }

    public ObserverFrmMatchOngoingView getObserverView() {
        return observerView;
    }

    public void setObserverView(ObserverFrmMatchOngoingView observerView) {
        this.observerView = observerView;
    }

    public ObserverRealizarJugada getObserver() {
        return observer;
    }

    public void setObserver(ObserverRealizarJugada observer) {
        this.observer = observer;
    }

    public JugadorDTO getJugadorDto() {
        return jugadorDto;
    }

    public void setJugadorDto(JugadorDTO jugadorDto) {
        this.jugadorDto = jugadorDto;
    }

    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }

    public void actulizarLogica(Object objecto) {
        observer.actualizar(objecto);
    }
}
