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

    // Observador que permite actualizar la vista
    private ObserverLobby observer;

    // Datos del jugador actual
    private JugadorDTO jugadorDto;

    // Lista de jugadores en el lobby
    private List<JugadorDTO> jugadores;

    // Observable para notificar actualizaciones al observador
    ObserverLobby observable = new ObserverLobby() {
        @Override
        public void actualizar(Object objecto) {
            observerView.actualizarVista(objecto);
        }
    };

    /**
     * Obtiene los datos del jugador actual.
     * @return El objeto JugadorDTO que contiene los datos del jugador.
     */
    public JugadorDTO getJugadorDto() {
        return jugadorDto;
    }

    /**
     * Establece los datos del jugador actual.
     * @param jugadorDto El objeto JugadorDTO con los datos del jugador.
     */
    public void setJugadorDto(JugadorDTO jugadorDto) {
        this.jugadorDto = jugadorDto;
    }

    /**
     * Obtiene la lista de jugadores en el lobby.
     * @return La lista de objetos JugadorDTO de los jugadores.
     */
    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    /**
     * Establece la lista de jugadores en el lobby.
     * @param jugadores La lista de jugadores que se establecerá.
     */
    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }

    // Observador que actualiza la vista del lobby
    private ObserverFrmLobbyView observerView;

    /**
     * Obtiene el observable asociado a las actualizaciones.
     * @return El objeto ObserverLobby que notifica las actualizaciones.
     */
    public ObserverLobby getObservable() {
        return observable;
    }

    /**
     * Obtiene el observador actual.
     * @return El objeto ObserverLobby que se usa para las notificaciones.
     */
    public ObserverLobby getObserver() {
        return observer;
    }

    /**
     * Establece el observador que recibirá las notificaciones.
     * @param observer El observador que se asignará.
     */
    public void setObserver(ObserverLobby observer) {
        this.observer = observer;
    }

    /**
     * Obtiene el observador de la vista del lobby.
     * @return El objeto ObserverFrmLobbyView asociado a la vista.
     */
    public ObserverFrmLobbyView getObserverView() {
        return observerView;
    }

    /**
     * Inicia la partida enviando los jugadores al manejador de turnos.
     */
    public void iniciarPartida() {
        ManejadorTurnosDTO m = new ManejadorTurnosDTO();
        m.setJugadores(jugadores);
        actulizarLogica(m);
    }

    /**
     * Establece el observador para la vista del lobby.
     * @param observerView El observador de la vista.
     */
    public void setObserverView(ObserverFrmLobbyView observerView) {
        this.observerView = observerView;
    }

    /**
     * Actualiza la lógica del juego con el objeto proporcionado.
     * @param objecto El objeto con los datos para actualizar la lógica del juego.
     */
    public void actulizarLogica(Object objecto) {
        observer.actualizar(objecto);
    }
}
