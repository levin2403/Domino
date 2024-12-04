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
    private static LookAndFeelSingleton instance; // Instancia única del Singleton

    // Constructor privado que establece el Look and Feel
    private LookAndFeelSingleton() {
        setLookAndFeel(); // Configura el Look and Feel cuando se crea la instancia
    }

    // Método para obtener la instancia única del Singleton
    public static LookAndFeelSingleton getInstance() {
        if (instance == null) {
            instance = new LookAndFeelSingleton(); // Crear la instancia si no existe
        }
        return instance; // Devuelve la instancia única
    }

    // Método para configurar el Look and Feel
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf()); // Establecer el tema FlatLightLaf
        } catch (Exception ex) {
            System.err.println("Falló en inicializar LaF"); // Manejo de errores si no se puede establecer el Look and Feel
        }
    }
}
