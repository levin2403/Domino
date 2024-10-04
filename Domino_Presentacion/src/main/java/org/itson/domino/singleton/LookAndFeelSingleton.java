/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.singleton;
/**
 * @author gamaliel
 */
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

public class LookAndFeelSingleton {
    private static LookAndFeelSingleton instance;

    private LookAndFeelSingleton() {
        setLookAndFeel();
    }

    public static LookAndFeelSingleton getInstance() {
        if (instance == null) {
            instance = new LookAndFeelSingleton();
        }
        return instance;
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Falló en inicializar LaF");
        }
    }
}
