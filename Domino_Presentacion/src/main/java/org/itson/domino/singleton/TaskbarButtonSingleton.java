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
    private static TaskbarButtonSingleton instance;

    private TaskbarButtonSingleton() {}

    public static TaskbarButtonSingleton getInstance() {
        if (instance == null) {
            instance = new TaskbarButtonSingleton();
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
                MusicModelSingleton.getInstance().stopCurrentMusic();
                System.exit(0);
            }
        });
    }
}
