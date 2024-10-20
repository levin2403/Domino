/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */

package org.itson.domino.lobby.mvc;

import Mediator.Mediador;
import org.itson.domino.constants.MusicPaths;
import org.itson.domino.singleton.MusicModelSingleton;

public class FrmLobbyController {
    private FrmLobbyView view;
    private MusicModelSingleton musicModel;
    private Mediador mediator;
    private FrmLobbyModel model;

    public FrmLobbyController(FrmLobbyModel model ,FrmLobbyView view) {
        this.model = model;
        this.view = view;
        this.musicModel = MusicModelSingleton.getInstance();
        
        playLobbyTheme();
        setupButtonListeners();
    }
    
    private void playLobbyTheme() {
        musicModel.playMusic(MusicPaths.LOBBY_THEME);
    }
    
    private void playMainTheme() {
        musicModel.playMusic(MusicPaths.MAIN_THEME);
    }

    private void setupButtonListeners() {
        view.addNextFormButtonListener(e -> openNextForm());
        view.addPrevFormButtonListener(e -> openPrevForm());
    }
    
    private void openNextForm() {
        navigateToForm(() -> mediator.showFrmMatchOngoing());
    }

    private void openPrevForm() {
        navigateToForm(() -> {
            playMainTheme();
            mediator.showFrmPlayerSettings();
        });
    }

    private void navigateToForm(Runnable action) {
        view.dispose();
        action.run();
    }
    
}
