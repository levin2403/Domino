/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */

package org.itson.domino.matchSettings.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.itson.domino.mediator.FormMediator;

public class FrmMatchSettingsController {
    private FrmMatchSettingsView view;
    private FormMediator mediator;

    public FrmMatchSettingsController(FrmMatchSettingsView view, FormMediator mediator) {
        this.view = view;
        this.mediator = mediator;
        
       openNextForm();
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
}
