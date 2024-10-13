/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author gamaliel
 */
package org.itson.domino.matchOngoing.mvc;

import org.itson.domino.constants.MusicPaths;
import org.itson.domino.mediator.FormMediator;
import org.itson.domino.singleton.MusicModelSingleton;

public class FrmMatchOngoingController {

    private FrmMatchOngoingView view;
    private FrmMatchOngoingModel model;
    private MusicModelSingleton musicModel;
    private FormMediator mediator;

    public FrmMatchOngoingController(FrmMatchOngoingView view, FormMediator mediator) {
        this.view = view;
        this.mediator = mediator;
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
        musicModel.playMusic(MusicPaths.MATCH_THEME);
    }

    private void setupButtonListeners() {
        view.addEndMatchButtonListener(e -> openNextForm());
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
