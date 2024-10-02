/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */

package org.itson.domino.matchSettings.mvc;

import org.itson.domino.managers.ViewManager;

public class FrmMatchSettingsController {
    private FrmMatchSettingsView view;
    private ViewManager viewManager;

    public FrmMatchSettingsController(FrmMatchSettingsView view, ViewManager viewManager) {
        this.view = view;
        this.viewManager = ViewManager.getInstance();
        
    }

    private void openNextForm() {
        FrmMatchSettingsView siguienteView = new FrmMatchSettingsView();
        viewManager.showView(siguienteView);
    }
}
