/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.welcome.mvc;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author gamaliel
 */
public class FrmWelcomeModel {
    
    private ImageIcon createImageIcon(String path, int x, int y,
            String extension) throws Exception {
        URL imgURL = FrmWelcomeView.class.getResource("/icons/" + path + "."
                + extension);
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image image = originalIcon.getImage().getScaledInstance(x, y,
                    Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            throw new Exception("No se pudo encontrar el archivo de imagen");
        }
    }
}
