/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */

package org.itson.domino.playerSettings.mvc;

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

    }
    
    private void openNextForm() {

    }
}
