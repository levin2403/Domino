/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */

package org.itson.domino.welcome.mvc;

import javax.swing.JFrame;
import org.itson.domino.exceptions.MusicFileNotFoundException;
import org.itson.domino.matchSettings.mvc.FrmMatchSettingsView;
import org.itson.domino.managers.ViewManager;
import org.itson.domino.singleton.MusicModelSingleton;

public class FrmWelcomeController {
    private FrmWelcomeView view;
    private MusicModelSingleton musicModel;
    private ViewManager viewManager;

    public FrmWelcomeController(FrmWelcomeView view, ViewManager viewManager) {
        this.view = view;
        this.musicModel = MusicModelSingleton.getInstance();
        this.viewManager = ViewManager.getInstance();
        
        initialize();
        this.view.addNextFormButtonListener(e -> openNextForm());
    }

    private void initialize() {
        try {
            musicModel.playMusic("resources/main_theme.mp3");
        } catch (MusicFileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    
    private void openNextForm() {
        view.setVisible(false);
        FrmMatchSettingsView siguienteView = new FrmMatchSettingsView();
        viewManager.showView(siguienteView);
    }
}
