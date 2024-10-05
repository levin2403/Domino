/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */

package org.itson.domino.matchSettings.mvc;

import org.itson.domino.mediator.FormMediator;

public class FrmMatchSettingsController {
    private FrmMatchSettingsView view;
    private FormMediator mediator;
    private FrmMatchSettingsModel model;
    
    public FrmMatchSettingsController(FrmMatchSettingsView view, FrmMatchSettingsModel model, FormMediator mediator) {
        this.view = view;
        this.model = model;
        this.mediator = mediator;

        setupListeners();
    }

    private void setupListeners() {
        view.addNextFormButtonListener(e -> openNextForm());
        view.addPrevFormButtonListener(e -> openPrevForm());
        view.addPlayersComboBoxListener(e -> updatePlayers());
        view.addTilesComboBoxListener(e -> updateTiles());
    }
    
    private void updatePlayers() {
        try {
            int players = view.getSelectedPlayers();
            model.setNumberOfPlayers(players);
        } catch (IllegalArgumentException ex) {
            view.showErrorMessage("Error al establecer el número de jugadores: " + ex.getMessage());
        }
    }

    private void updateTiles() {
        try {
            int tiles = view.getSelectedTiles();
            model.setNumberOfTiles(tiles);
        } catch (IllegalArgumentException ex) {
            view.showErrorMessage("Error al establecer el número de fichas: " + ex.getMessage());
        }
    }
    
    private void openNextForm() {
        if (model.validateSettings()) {
            model.saveSettings();
            navigateToForm(() -> mediator.showFrmPlayerSettings());
        } else {
            // Mostrar un mensaje de error al usuario
        }
    }

    private void openPrevForm() {
        navigateToForm(() -> {
            mediator.showFrmWelcome();
        });
    }

    private void navigateToForm(Runnable action) {
        view.dispose();
        action.run();
    }
}
