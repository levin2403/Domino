package org.itson.domino.managers;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class ResourceLoader {

    public static ImageIcon loadIcon(String iconName, int x, int y) throws Exception {
        return loadResource(iconName, x, y);
    }

    public static ImageIcon loadBackground(String backgroundName, int x, int y) throws Exception {
        return loadResource(backgroundName, x, y);
    }

    private static ImageIcon loadResource(String resourcePath, int x, int y) throws Exception {
        URL imgURL = ResourceLoader.class.getResource(resourcePath);
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image image = originalIcon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            throw new Exception("No se pudo encontrar el archivo de imagen en la ruta: " + resourcePath);
        }
    }
}
