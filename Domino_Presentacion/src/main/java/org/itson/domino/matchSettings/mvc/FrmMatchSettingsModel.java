/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.matchSettings.mvc;

/**
 *
 * @author gamaliel
 */
public class FrmMatchSettingsModel {
    private int numberOfPlayers;
    private int numberOfTiles;

    // Constantes para los límites de jugadores y fichas
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 4;
    private static final int MIN_TILES = 3;
    private static final int MAX_TILES = 7;

    public FrmMatchSettingsModel() {
        // Inicializar con valores por defecto
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

    public boolean validateSettings() {
        return (numberOfPlayers >= MIN_PLAYERS && numberOfPlayers <= MAX_PLAYERS)
                && (numberOfTiles >= MIN_TILES && numberOfTiles <= MAX_TILES);
    }

    public void saveSettings() {
        // Aquí puedes implementar la lógica para guardar la configuración
        // Por ejemplo, guardar en un archivo o en una base de datos
        System.out.println("Configuración guardada: " + numberOfPlayers + " jugadores, " + numberOfTiles + " fichas por jugador");
    }
}
