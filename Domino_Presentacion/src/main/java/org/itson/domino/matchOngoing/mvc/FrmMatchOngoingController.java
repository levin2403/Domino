/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author gamaliel
 */
package org.itson.domino.matchOngoing.mvc;

import Mediator.Mediador;
import org.itson.domino.constants.MusicPaths;
import org.itson.domino.singleton.MusicModelSingleton;

public class FrmMatchOngoingController {

    private FrmMatchOngoingView view;
    private FrmMatchOngoingModel model;
    private MusicModelSingleton musicModel;
    private Mediador mediator;

    public FrmMatchOngoingController(FrmMatchOngoingModel model ,FrmMatchOngoingView view) {
        this.model = model;
        this.view = view;
        this.mediator = new Mediador();
        this.musicModel = MusicModelSingleton.getInstance();

        playMatchTheme();
        setupButtonListeners();
    }
    
    public FrmMatchOngoingController(FrmMatchOngoingView view, FrmMatchOngoingModel model) {
        this.view = view;
        this.model = model;
        this.musicModel = MusicModelSingleton.getInstance();

        playMatchTheme();
        setupButtonListeners();
    }

    private void playMatchTheme() {
        musicModel.playMusic(MusicPaths.MATCH_THEME_1);
    }

    private void setupButtonListeners() {
        view.addEndMatchButtonListener(e -> openNextForm());
    }
    public void abrirPantalla(){
        view.setVisible(true);
    }
    private void openNextForm() {
        musicModel.stopCurrentMusic();
        navigateToForm(() -> mediator.showFrmMatchEndingRequest());
    }

    private void navigateToForm(Runnable action) {
        view.dispose();
        action.run();
    }
}
