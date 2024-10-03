/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.domino.main;

import org.itson.domino.mediator.FormMediator;

/**
 *
 * @author gamaliel
 */
public class Domino_Presentacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FormMediator mediator = new FormMediator();
        mediator.showFrmWelcome();
    }
}
