package org.itson.domino.singleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonStyleSingleton {

    private static ButtonStyleSingleton instance;

    private ButtonStyleSingleton() {
    }

    public static ButtonStyleSingleton getInstance() {
        if (instance == null) {
            instance = new ButtonStyleSingleton();
        }
        return instance;
    }

    public void applyButtonStyle(JButton button) {
        button.putClientProperty("JComponent.sizeVariant", "large");
        button.setOpaque(false);
        button.setBackground(new Color(114, 9, 183));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(63, 55, 201));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(114, 9, 183));
            }
        });
    }
}
