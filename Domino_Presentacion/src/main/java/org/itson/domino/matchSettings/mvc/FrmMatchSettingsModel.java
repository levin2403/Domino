/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.matchSettings.mvc;

import static DTOs.Acciones.MENU;
import DTOs.ConfiguracionDTO;
import Observer.ObserverEstablecerConfiguracion;
import Observer.Vista.ObserverFrmSettingsView;
import Observer.Vista.ObserverFrmWelcomeView;

/**
 *
 * @author gamaliel
 */

public class FrmMatchSettingsModel {
    
    private ObserverEstablecerConfiguracion observer;

    // Observable que notifica los cambios en la configuración.
    ObserverEstablecerConfiguracion observable = new ObserverEstablecerConfiguracion() {
        @Override
        public void actualizarConfiguracion(Object objecto) {
            observerView.actualizarVista(objecto); // Actualiza la vista con los cambios en la configuración.
        }
    };
    
    // Variables que almacenan la cantidad de jugadores y fichas.
    private int numberOfPlayers;
    private int numberOfTiles;
    
    private ObserverFrmSettingsView observerView; // Vista asociada al modelo.

    // Métodos getter y setter para la vista.
    public ObserverFrmSettingsView getObserverView() {
        return observerView;
    }

    public void setObserverView(ObserverFrmSettingsView observerView) {
        this.observerView = observerView;
    }
    
    // Constantes para los límites de jugadores y fichas.
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 4;
    private static final int MIN_TILES = 3;
    private static final int MAX_TILES = 7;

    // Constructor que inicializa los valores por defecto de jugadores y fichas.
    public FrmMatchSettingsModel() {
        this.numberOfPlayers = MIN_PLAYERS;
        this.numberOfTiles = MIN_TILES;
    }

    // Establece el número de jugadores, validando el rango permitido.
    public void setNumberOfPlayers(int numberOfPlayers) {
        if (numberOfPlayers >= MIN_PLAYERS && numberOfPlayers <= MAX_PLAYERS) {
            this.numberOfPlayers = numberOfPlayers;
        } else {
            throw new IllegalArgumentException("El número de jugadores debe estar entre " + MIN_PLAYERS + " y " + MAX_PLAYERS);
        }
    }

    // Obtiene el número de jugadores configurados.
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    // Regresa al menú principal, notificando a los observadores.
    public void menu(){
        observer.actualizarConfiguracion(MENU);
    }

    // Crea la partida con la configuración actual y la notifica a los observadores.
    public void crearPartida(){
        ConfiguracionDTO c = new ConfiguracionDTO(numberOfTiles, numberOfPlayers);
        observer.actualizarConfiguracion(c);
    }

    // Establece el número de fichas, validando el rango permitido.
    public void setNumberOfTiles(int numberOfTiles) {
        if (numberOfTiles >= MIN_TILES && numberOfTiles <= MAX_TILES) {
            this.numberOfTiles = numberOfTiles;
        } else {
            throw new IllegalArgumentException("El número de fichas debe estar entre " + MIN_TILES + " y " + MAX_TILES);
        }
    }

    // Obtiene el número de fichas configuradas.
    public int getNumberOfTiles() {
        return numberOfTiles;
    }

    // Registra un observador para recibir actualizaciones de la configuración.
    public void registrarObservador(ObserverEstablecerConfiguracion o) {
        this.observer = o;
    }

    // Notifica a los observadores sobre cambios en la configuración.
    public void notificar(Object objecto) {
        observer.actualizarConfiguracion(objecto);
    }

    // Devuelve el objeto observable para ser registrado por los observadores.
    public ObserverEstablecerConfiguracion getObservable() {
        return observable;
    }

    // Establece el objeto observable.
    public void setObservable(ObserverEstablecerConfiguracion observable) {
        this.observable = observable;
    }

    // Valida que los valores de jugadores y fichas estén dentro de los límites permitidos.
    public boolean validateSettings() {
        return (numberOfPlayers >= MIN_PLAYERS && numberOfPlayers <= MAX_PLAYERS)
                && (numberOfTiles >= MIN_TILES && numberOfTiles <= MAX_TILES);
    }

    // Guarda la configuración y muestra un mensaje en consola.
    public void saveSettings() {
        System.out.println("Configuración guardada: " + numberOfPlayers + " jugadores, " + numberOfTiles + " fichas por jugador");
    }
}
