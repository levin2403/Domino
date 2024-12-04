/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.matchOngoing.mvc;

import DTOs.FichaDTO;
import DTOs.JugadaDTO;
import DTOs.JugadorDTO;
import Eventos.EventoRealizarJugada;
import Observable.ObservableObtenerFichaPozo;
import Observer.ObserverLobby;
import Observer.ObserverObtenerFichaPozo;
import Observer.ObserverRealizarJugada;
import Observer.Vista.ObserverFrmJuegoView;
import java.util.List;

/**
 *
 * @author gamaliel
 */
public class FrmMatchOngoingModel {

    private ObserverRealizarJugada observer;
    private JugadorDTO jugadorDto;
    private JugadorDTO jugadorTurno;
    private List<JugadorDTO> jugadores;
    private ObserverFrmJuegoView observerView;
    ObserverRealizarJugada observable = new ObserverRealizarJugada() {
        @Override
        public void actualizar(Object objecto) {

            observerView.actualizarVista(objecto);
        }

    };

    public JugadorDTO getJugadorTurno() {
        return jugadorTurno;
    }

    public void setJugadorTurno(JugadorDTO jugadorTurno) {
        this.jugadorTurno = jugadorTurno;
    }

    public ObserverRealizarJugada getObservable() {
        return observable;
    }

    public ObserverFrmJuegoView getObserverView() {
        return observerView;
    }

    public void setObserverView(ObserverFrmJuegoView observerView) {
        this.observerView = observerView;
    }

    public ObserverRealizarJugada getObserver() {
        return observer;
    }

    public void setObserver(ObserverRealizarJugada observer) {
        this.observer = observer;
    }

    public boolean tuTurno() {
        return jugadorDto.equals(jugadorTurno);
    }

    public void colocarIzquierda(FichaDTO j) {
         System.out.println(jugadorDto.getFichas().size()+" ficha");
        jugadorDto.eliminarFicha(j);
        System.out.println(jugadorDto.getFichas().size()+" ficha");
        JugadaDTO jugada = new JugadaDTO(jugadorDto, j, true);
        observer.actualizar(jugada);
    }

    public void colocarDerecha(FichaDTO j) {
         System.out.println(jugadorDto.getFichas().size()+" ficha");
        jugadorDto.eliminarFicha(j);
        System.out.println(jugadorDto.getFichas().size()+" ficha");
        JugadaDTO jugada = new JugadaDTO(jugadorDto, j, false);  
        observer.actualizar(jugada);
    }

    public JugadorDTO getJugadorDto() {
        return jugadorDto;
    }

    public void robarFicha() {
        observer.actualizar(jugadorDto);
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
