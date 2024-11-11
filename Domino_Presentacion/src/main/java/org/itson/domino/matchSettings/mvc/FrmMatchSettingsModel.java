/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.matchSettings.mvc;

import static DTOs.Acciones.MENU;
import DTOs.ConfiguracionDTO;
import Observer.ObserverEstablecerConfiguracion;
import Observer.Vista.ObserverFrmSettingsView;

/**
 *
 * @author gamaliel
 */
public class FrmMatchSettingsModel {
    private ObserverEstablecerConfiguracion observer;

    ObserverEstablecerConfiguracion observable = new ObserverEstablecerConfiguracion() {

        @Override
        public void actualizarConfiguracion(Object objecto) {
            observerView.actualizarVista(objecto);
        }

    };
    private int numberOfPlayers;
    private int numberOfTiles;

    private ObserverFrmSettingsView observerView;

    public ObserverFrmSettingsView getObserverView() {
        return observerView;
    }

    public void setObserverView(ObserverFrmSettingsView observerView) {
        this.observerView = observerView;
    }

    // Constantes para los límites de jugadores y fichas
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 4;
    private static final int MIN_TILES = 3;
    private static final int MAX_TILES = 7;

    public FrmMatchSettingsModel() {
        this.numberOfPlayers = MIN_PLAYERS;
        this.numberOfTiles = MIN_TILES;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        if (numberOfPlayers >= MIN_PLAYERS && numberOfPlayers <= MAX_PLAYERS) {
            this.numberOfPlayers = numberOfPlayers;
        } else {
            throw new IllegalArgumentException("El número de jugadores debe estar entre " + MIN_PLAYERS + " y " + MAX_PLAYERS);
        }
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void menu() {
        observer.actualizarConfiguracion(MENU);
    }

    public void crearPartida() {
        ConfiguracionDTO c = new ConfiguracionDTO(numberOfPlayers, numberOfTiles);
        observer.actualizarConfiguracion(c);
    }

    public void setNumberOfTiles(int numberOfTiles) {
        if (numberOfTiles >= MIN_TILES && numberOfTiles <= MAX_TILES) {
            this.numberOfTiles = numberOfTiles;
        } else {
            throw new IllegalArgumentException("El número de fichas debe estar entre " + MIN_TILES + " y " + MAX_TILES);
        }
    }

    public int getNumberOfTiles() {
        return numberOfTiles;
    }

    public void registrarObservador(ObserverEstablecerConfiguracion o) {
        this.observer = o;
    }

    public void notificar(Object objecto) {
        observer.actualizarConfiguracion(objecto);
    }

    public ObserverEstablecerConfiguracion getObservable() {
        return observable;
    }

    public void setObservable(ObserverEstablecerConfiguracion observable) {
        this.observable = observable;
    }

    public boolean validateSettings() {
        return (numberOfPlayers >= MIN_PLAYERS && numberOfPlayers <= MAX_PLAYERS)
                && (numberOfTiles >= MIN_TILES && numberOfTiles <= MAX_TILES);
    }

    public void saveSettings() {
        System.out.println("Configuración guardada: " + numberOfPlayers + " jugadores, " + numberOfTiles + " fichas por jugador");
    }
}
