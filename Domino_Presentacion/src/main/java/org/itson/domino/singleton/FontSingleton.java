package org.itson.domino.singleton;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.itson.domino.constants.FontPaths;

public class FontSingleton {

    private static FontSingleton instance;
    private Map<String, Font> fonts = new HashMap<>();

    private FontSingleton() {
        loadFont("Evil Empire", FontPaths.EVIL_EMPIRE);
        loadFont("Montserrat", FontPaths.MONTSERRAT);
    }


    public static FontSingleton getInstance() {
        if (instance == null) {
            instance = new FontSingleton();
        }
        return instance;    
    }

        private void loadFont(String name, String path) {
            try (InputStream fontStream = getClass().getResourceAsStream(path)) {
                if (fontStream == null) {
                    throw new IOException("No se pudo encontrar la fuente en la ruta: " + path);
                }
                Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(12f);
                fonts.put(name, font);
            } catch (FontFormatException | IOException e) {
                e.printStackTrace();
            }
        }



    public Font getFont(String name, float size) {
        Font font = fonts.get(name);
        if (font != null) {
            return font.deriveFont(size);
        }
        return new Font("Serif", Font.PLAIN, 12);
    }
}