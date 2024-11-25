/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */

package org.itson.domino.matchEndingRequest.mvc;

import Mediator.Mediador;
import org.itson.domino.constants.MusicPaths;
import org.itson.domino.singleton.MusicModelSingleton;

public class FrmMatchEndingRequestController {
    private FrmMatchEndingRequestModel model;
    private FrmMatchEndingRequestView view;
    private MusicModelSingleton musicModel;
    private Mediador mediator;
    
    public FrmMatchEndingRequestController(FrmMatchEndingRequestModel model,FrmMatchEndingRequestView view) {
        this.model = model;
        this.view = view;
        this.mediator = new Mediador();
        this.musicModel = MusicModelSingleton.getInstance();
        
       playRequestTheme();
       setupButtonListeners();
    }

    private void playRequestTheme() {
        musicModel.playMusic(MusicPaths.REQUEST_THEME);
    }
    
    private void setupButtonListeners() {
        view.addNextFormButtonListener(e -> openNextForm());
        view.addPrevFormButtonListener(e -> openPrevForm());
    }
    
    private void openNextForm() {
//        navigateToForm(() -> mediator.showFrmWelcome());
    }
    
    private void openPrevForm() {
//        navigateToForm(() -> mediator.showFrmMatchOngoing());
    }
 
    private void navigateToForm(Runnable action) {
        view.dispose();
        action.run();
    }
    
}
