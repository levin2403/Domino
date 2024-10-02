/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.managers;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

/**
 *        lblFondo.setIcon(fotosManager.getFoto(("src/main/java/implementaciones/multimedia/fondoMorado.jpeg")));

 * @author gamaliel
 */
public class FuentesManager {
    private Font fuenteCuerpo;
    private Font fuenteTitulo;

    public void cargarFuente() {
        try {
            File fontFile = new File("src/main/java/resources/fonts/Montserrat.ttf");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            fuenteCuerpo = customFont.deriveFont(16f);
            fuenteTitulo = customFont.deriveFont(30f); 
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public Font getFuenteCuerpo() {
        return fuenteCuerpo;
    }

    public Font getFuenteTitulo() {
        return fuenteTitulo;
    }
}
