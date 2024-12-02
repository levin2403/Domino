/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.lobby.mvc;

import static DTOs.Acciones.INICIARPARTIDA;
import DTOs.JugadorDTO;
import DTOs.ManejadorTurnosDTO;
import Eventos.EventoIniciarPartida;
import Observable.ObservableMenuLogica;
import Observer.ObserverLobby;
import Observer.ObserverMenuLogica;
import Observer.Vista.ObserverFrmLobbyView;
import Observer.Vista.ObserverFrmWelcomeView;
import java.util.List;


/**
 *
 * @author gamaliel
 */
public class FrmLobbyModel {
 private ObserverLobby observer;
 private JugadorDTO jugadorDto;
 private List<JugadorDTO> jugadores;
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

    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }

    private ObserverFrmLobbyView observerView;

    public ObserverLobby getObservable() {
        return observable;
    }

    public ObserverLobby getObserver() {
        return observer;
    }

    public void setObserver(ObserverLobby observer) {
        this.observer = observer;
    }


    public ObserverFrmLobbyView getObserverView() {
        return observerView;
    }
    public void iniciarPartida(){
        ManejadorTurnosDTO m = new ManejadorTurnosDTO();
        m.setJugadores(jugadores);
        actulizarLogica(m);
    }

    public void setObserverView(ObserverFrmLobbyView observerView) {
        this.observerView = observerView;
    }
    public void actulizarLogica(Object objecto){
        observer.actualizar(objecto);
    }

}
