/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */

package org.itson.domino.matchEndingRequest.mvc;

import org.itson.domino.constants.MusicPaths;
import org.itson.domino.mediator.FormMediator;
import org.itson.domino.singleton.MusicModelSingleton;

public class FrmMatchEndingRequestController {
    private FrmMatchEndingRequestView view;
    private MusicModelSingleton musicModel;
    private FormMediator mediator;
    
    public FrmMatchEndingRequestController(FrmMatchEndingRequestView view, FormMediator mediator) {
        this.view = view;
        this.mediator = mediator;
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
        navigateToForm(() -> mediator.showFrmWelcome());
    }
    
    private void openPrevForm() {
        navigateToForm(() -> mediator.showFrmMatchOngoing());
    }
    
    private void navigateToForm(Runnable action) {
        view.dispose();
        action.run();
    }
}
