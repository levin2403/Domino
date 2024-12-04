package org.itson.domino.singleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonStyleSingleton {

    private static ButtonStyleSingleton instance; // Instancia única del Singleton

    // Constructor privado para evitar la creación de instancias fuera de la clase.
    private ButtonStyleSingleton() {
    }

    // Método para obtener la instancia única de ButtonStyleSingleton.
    public static ButtonStyleSingleton getInstance() {
        if (instance == null) {
            instance = new ButtonStyleSingleton();
        }
        return instance;
    }

    // Método para aplicar estilo al botón.
    public void applyButtonStyle(JButton button) {
        // Configuración de tamaño y apariencia del botón
        button.putClientProperty("JComponent.sizeVariant", "large"); // Tamaño grande
        button.setOpaque(false); // Hacer el botón opaco
        button.setBackground(new Color(114, 9, 183)); // Color de fondo morado
        button.setForeground(Color.WHITE); // Color de texto blanco
        button.setFocusPainted(true); // El botón tendrá una indicación visual cuando se enfoque
        button.setContentAreaFilled(true); // El área de contenido se llenará con el color de fondo

        // Agregar listeners para el evento del mouse
        button.addMouseListener(new MouseAdapter() {
            // Cambiar el color de fondo cuando el mouse entra
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(63, 55, 201)); // Fondo más oscuro cuando el mouse entra
            }

            // Restaurar el color original cuando el mouse sale
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(114, 9, 183)); // Fondo original al salir
            }
        });
    }
}
