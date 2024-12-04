/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */

package org.itson.domino.matchSettings.mvc;

import Mediator.Mediador;

public class FrmMatchSettingsController {
    private FrmMatchSettingsView view;
    private FrmMatchSettingsModel model;
    private Mediador mediator;
    
    // Constructor que inicializa el modelo, la vista y el mediador.
    public FrmMatchSettingsController(FrmMatchSettingsModel model ,FrmMatchSettingsView view) {
        this.view = view;
        this.model = model;
        this.mediator = new Mediador();

        // Configura los escuchadores de eventos para los botones y combo boxes.
        setupListeners();
    }

    // Configura los escuchadores de eventos de la vista.
    private void setupListeners() {
        view.addNextFormButtonListener(e -> openNextForm()); // Escucha el evento para ir al siguiente formulario.
        view.addPrevFormButtonListener(e -> openPrevForm()); // Escucha el evento para regresar al formulario anterior.
        view.addPlayersComboBoxListener(e -> updatePlayers()); // Escucha cambios en el número de jugadores.
        view.addTilesComboBoxListener(e -> updateTiles()); // Escucha cambios en el número de fichas.
    }
    
    // Actualiza el número de jugadores en el modelo basado en la selección de la vista.
    private void updatePlayers() {
        try {
            int players = view.getSelectedPlayers();
            model.setNumberOfPlayers(players);
        } catch (IllegalArgumentException ex) {
            view.showErrorMessage("Error al establecer el número de jugadores: " + ex.getMessage());
        }
    }

    // Actualiza el número de fichas en el modelo basado en la selección de la vista.
    private void updateTiles() {
        try {
            int tiles = view.getSelectedTiles();
            model.setNumberOfTiles(tiles);
        } catch (IllegalArgumentException ex) {
            view.showErrorMessage("Error al establecer el número de fichas: " + ex.getMessage());
        }
    }

    // Muestra la vista en pantalla.
    public void mostrarPantalla(){
        view.setVisible(true);
    }
    
    // Abre el siguiente formulario después de crear la partida.
    private void openNextForm() {
        model.crearPartida();
    }

    // Regresa al menú principal si el usuario lo solicita.
    private void openPrevForm() {
        model.menu();
    }
}
