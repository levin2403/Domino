/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.singleton;
/**
 *
 * @author gamaliel
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.itson.domino.singleton.MusicModelSingleton;

public class TaskbarButtonSingleton {
    private static TaskbarButtonSingleton instance;  // Instancia única de la clase

    // Constructor privado para evitar la creación directa de instancias
    private TaskbarButtonSingleton() {}

    // Método que devuelve la única instancia de la clase
    public static TaskbarButtonSingleton getInstance() {
        if (instance == null) {  // Si la instancia aún no existe
            instance = new TaskbarButtonSingleton();  // Se crea la instancia
        }
        return instance;  // Se devuelve la instancia única
    }

    // Método que agrega un botón de minimizar al JFrame
    public void addMinimizeButton(JButton minimizeButton, JFrame frame) {
        minimizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setState(JFrame.ICONIFIED);  // Minimiza la ventana
            }
        });
    }

    // Método que agrega un botón de cerrar al JFrame
    public void addCloseButton(JButton closeButton, JFrame frame) {
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MusicModelSingleton.getInstance().stopCurrentMusic();  // Detener la música
                System.exit(0);  // Cerrar la aplicación
            }
        });
    }
}
