/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.managers;
/**
 *
 * @author gamaliel
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.itson.domino.singleton.MusicModelSingleton;

public class ButtonManager {
    private static ButtonManager instance;

    private ButtonManager() {}

    public static ButtonManager getInstance() {
        if (instance == null) {
            instance = new ButtonManager();
        }
        return instance;
    }

    public void addMinimizeButton(JButton minimizeButton, JFrame frame) {
        minimizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setState(JFrame.ICONIFIED);
            }
        });
    }

    public void addCloseButton(JButton closeButton, JFrame frame) {
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MusicModelSingleton.getInstance().stopMusic();
                System.exit(0);
            }
        });
    }
}
