/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.domino.main;

import org.itson.domino.welcome.mvc.FrmWelcomeController;
import org.itson.domino.welcome.mvc.FrmWelcomeView;
import org.itson.domino.managers.ViewManager;

/**
 *
 * @author gamaliel
 */
public class Domino_Presentacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ViewManager viewManager = new ViewManager();
        FrmWelcomeView view = new FrmWelcomeView();
        new FrmWelcomeController(view, viewManager);
        
        viewManager.showView(view);
    }
}
