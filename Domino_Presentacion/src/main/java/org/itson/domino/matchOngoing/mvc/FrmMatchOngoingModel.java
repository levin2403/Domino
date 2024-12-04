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

    // Observable que notifica a la vista cuando se actualiza el modelo.
    ObserverRealizarJugada observable = new ObserverRealizarJugada() {
        @Override
        public void actualizar(Object objecto) {
            observerView.actualizarVista(objecto);
        }
    };

    // Obtiene el jugador que tiene el turno.
    public JugadorDTO getJugadorTurno() {
        return jugadorTurno;
    }

    // Establece el jugador que tiene el turno.
    public void setJugadorTurno(JugadorDTO jugadorTurno) {
        this.jugadorTurno = jugadorTurno;
    }

    // Obtiene el observable que notificará a los observadores de cambios.
    public ObserverRealizarJugada getObservable() {
        return observable;
    }

    // Obtiene la vista asociada al modelo.
    public ObserverFrmJuegoView getObserverView() {
        return observerView;
    }

    // Establece la vista asociada al modelo.
    public void setObserverView(ObserverFrmJuegoView observerView) {
        this.observerView = observerView;
    }

    // Obtiene el observador que actualiza la vista.
    public ObserverRealizarJugada getObserver() {
        return observer;
    }

    // Establece el observador para este modelo.
    public void setObserver(ObserverRealizarJugada observer) {
        this.observer = observer;
    }

    // Verifica si es el turno del jugador actual.
    public boolean tuTurno() {
        return jugadorDto.equals(jugadorTurno);
    }

    // Coloca una ficha a la izquierda del tablero si es el turno del jugador.
    public void colocarIzquierda(FichaDTO j) {
        System.out.println(jugadorDto.getFichas().size() + " ficha");
        jugadorDto.eliminarFicha(j);
        System.out.println(jugadorDto.getFichas().size() + " ficha");
        JugadaDTO jugada = new JugadaDTO(jugadorDto, j, true); // True indica que es a la izquierda.
        observer.actualizar(jugada);
    }

    // Coloca una ficha a la derecha del tablero si es el turno del jugador.
    public void colocarDerecha(FichaDTO j) {
        System.out.println(jugadorDto.getFichas().size() + " ficha");
        jugadorDto.eliminarFicha(j);
        System.out.println(jugadorDto.getFichas().size() + " ficha");
        JugadaDTO jugada = new JugadaDTO(jugadorDto, j, false); // False indica que es a la derecha.
        observer.actualizar(jugada);
    }

    // Obtiene el jugador actual.
    public JugadorDTO getJugadorDto() {
        return jugadorDto;
    }

    // Permite robar una ficha si es el turno del jugador.
    public void robarFicha() {
        observer.actualizar(jugadorDto);
    }

    // Establece el jugador actual.
    public void setJugadorDto(JugadorDTO jugadorDto) {
        this.jugadorDto = jugadorDto;
    }

    // Obtiene la lista de jugadores.
    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    // Establece la lista de jugadores.
    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }

    // Actualiza la lógica del juego y notifica a los observadores.
    public void actulizarLogica(Object objecto) {
        observer.actualizar(objecto);
    }
}
