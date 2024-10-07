/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */

package org.itson.domino.welcome.mvc;

import org.itson.domino.constants.MusicPaths;
import org.itson.domino.mediator.FormMediator;
import org.itson.domino.singleton.MusicModelSingleton;

public class FrmWelcomeController {
    private FrmWelcomeView view;
    private MusicModelSingleton musicModel;
    private FormMediator mediator;

    public FrmWelcomeController(FrmWelcomeView view, FormMediator mediator) {
        this.view = view;
        this.musicModel = MusicModelSingleton.getInstance();
        this.mediator = mediator;
        
        playMainTheme();
        setupButtonListeners();
    }

    private void playMainTheme() {
        musicModel.playMusic(MusicPaths.MAIN_THEME);
    }

    private void setupButtonListeners() {
        view.addNextFormButtonListener(e -> openNextForm());
    }
    
    private void openNextForm() {
        navigateToForm(() -> mediator.showFrmMatchSettings());
    }

    private void navigateToForm(Runnable action) {
        view.dispose();
        action.run();
    }
}
