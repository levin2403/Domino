/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.mediator;

import org.itson.domino.matchSettings.mvc.FrmMatchSettingsController;
import org.itson.domino.matchSettings.mvc.FrmMatchSettingsView;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsController;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsView;
import org.itson.domino.welcome.mvc.FrmWelcomeController;
import org.itson.domino.welcome.mvc.FrmWelcomeView;

/**
 *
 * @author gamaliel
 */
public class FormMediator {
    public void showFrmWelcome(){
        FrmWelcomeView viewWelcome = new FrmWelcomeView();
        FrmWelcomeController controllerWelcome = new FrmWelcomeController(viewWelcome, this);
        viewWelcome.setVisible(true);
    }
    
    public void showFrmMatchSettings() {
        FrmMatchSettingsView viewMatchSettings = new FrmMatchSettingsView();
        FrmMatchSettingsController controllerMatchSettings = new FrmMatchSettingsController(viewMatchSettings, this);
        viewMatchSettings.setVisible(true);
    }
    
        public void showFrmPlayerSettings() {
        FrmPlayerSettingsView viewPlayerSettings = new FrmPlayerSettingsView();
        FrmPlayerSettingsController controllerMatchSettings = new FrmPlayerSettingsController(viewPlayerSettings, this);
        viewPlayerSettings.setVisible(true);
    }
}
