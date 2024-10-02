/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.managers;

import javax.swing.JFrame;


/**
 *
 * @author gamaliel
 */
public class ViewManager {
    private static ViewManager instance;
    private JFrame currentView;

    public ViewManager() {
        // Constructor privado para evitar instanciación externa
    }

    public static ViewManager getInstance() {
        if (instance == null) {
            instance = new ViewManager();
        }
        return instance;
    }

    public void showView(JFrame view) {
        if (currentView != null) {
            currentView.setVisible(false);
            currentView.dispose(); // Cierra la vista anterior
        }
        currentView = view;
        currentView.setVisible(true);
    }
}