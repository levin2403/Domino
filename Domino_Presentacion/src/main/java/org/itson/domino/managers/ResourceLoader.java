package org.itson.domino.managers;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class ResourceLoader {

    /**
     * Carga un ícono desde una ruta especificada y lo ajusta al tamaño dado.
     */
    public static ImageIcon loadIcon(String iconName, int x, int y) throws Exception {
        return loadResource(iconName, x, y);
    }

    /**
     * Carga un fondo desde una ruta especificada y lo ajusta al tamaño dado.
     */
    public static ImageIcon loadBackground(String backgroundName, int x, int y) throws Exception {
        return loadResource(backgroundName, x, y);
    }

    /**
     * Carga una imagen desde una ruta especificada, 
     * redimensiona la imagen a las dimensiones dadas y la devuelve como un ImageIcon.
     */
    private static ImageIcon loadResource(String resourcePath, int x, int y) throws Exception {
        // Obtiene la URL del recurso de imagen.
        URL imgURL = ResourceLoader.class.getResource(resourcePath);
        
        if (imgURL != null) {
            // Si la imagen se encuentra, se carga y redimensiona.
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image image = originalIcon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            // Si la imagen no se encuentra, lanza una excepción.
            throw new Exception("No se pudo encontrar el archivo de imagen en la ruta: " + resourcePath);
        }
    }
}
