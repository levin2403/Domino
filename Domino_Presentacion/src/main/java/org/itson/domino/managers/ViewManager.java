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
    private JFrame currentView;

    public void showView(JFrame newView) {
        if (currentView != null) {
            currentView.setVisible(false);
        }
        currentView = newView;
        currentView.setVisible(true); 
    }
}

