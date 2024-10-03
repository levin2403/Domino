/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */

package org.itson.domino.welcome.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.itson.domino.exceptions.MusicFileNotFoundException;
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
        
        initialize();
    }

    private void initialize() {
        try {
            musicModel.playMusic("resources/main_theme.mp3");
        } catch (MusicFileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        
        this.view.addNextFormButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                mediator.showFrmMatchSettings();
            }
        });
        
    }
}
