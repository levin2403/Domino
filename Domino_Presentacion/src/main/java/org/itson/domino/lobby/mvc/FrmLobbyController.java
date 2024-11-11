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
import Observer.ObserverRegistrarJugador;
import org.itson.domino.constants.MusicPaths;
import org.itson.domino.singleton.MusicModelSingleton;

public class FrmLobbyController {
    private FrmLobbyView view;
    private MusicModelSingleton musicModel;
    private Mediador mediator;
    private FrmLobbyModel model;

    public FrmLobbyController(FrmLobbyModel model, FrmLobbyView view) {
        this.model = model;
        this.view = view;
        this.mediator = new Mediador();
        this.musicModel = MusicModelSingleton.getInstance();

        playLobbyTheme();
//        setupButtonListeners();
    }

    private void playLobbyTheme() {
        musicModel.playMusic(MusicPaths.LOBBY_THEME);
    }

    private void playMainTheme() {
        musicModel.playMusic(MusicPaths.MAIN_THEME);
    }

    public void mostrarPantalla() {
        view.setVisible(true);
    }

//    private void setupButtonListeners(ObserverRegistrarJugador observer) {
//        view.addNextFormButtonListener(e -> openNextForm());
//        view.addPrevFormButtonListener(e -> openPrevForm(observer));
//    }
//    
//    private void openNextForm() {
//        navigateToForm(() -> mediator.showFrmMatchOngoing());
//    }
//
//    private void openPrevForm(ObserverRegistrarJugador observer) {
//        navigateToForm(() -> {
//            playMainTheme();
//            mediator.showFrmPlayerSettings(observer);
//        });
//    }
//
//    private void navigateToForm(Runnable action) {
//        view.dispose();
//        action.run();
//    }
}
