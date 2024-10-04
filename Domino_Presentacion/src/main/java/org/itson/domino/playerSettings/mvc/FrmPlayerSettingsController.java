/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */

package org.itson.domino.playerSettings.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.itson.domino.mediator.FormMediator;
import org.itson.domino.singleton.MusicModelSingleton;

public class FrmPlayerSettingsController {
    private FrmPlayerSettingsView view;
    private MusicModelSingleton musicModel;
    private FormMediator mediator;

    public FrmPlayerSettingsController(FrmPlayerSettingsView view, FormMediator mediator) {
        this.view = view;
        this.musicModel = MusicModelSingleton.getInstance();
        this.mediator = mediator;

        openNextForm();
        openPrevForm();
    }
    
    private void openNextForm() {
        this.view.addNextFormButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                mediator.showFrmPlayerSettings();
            }
        });
    }
    private void openPrevForm() {
        this.view.addPrevFormButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                mediator.showFrmMatchSettings();
            }
        });
    }
}
