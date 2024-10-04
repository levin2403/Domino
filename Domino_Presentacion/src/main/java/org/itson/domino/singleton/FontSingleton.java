package org.itson.domino.singleton;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FontSingleton {

    private static FontSingleton instance;
    private Map<String, Font> fonts = new HashMap<>();

    private FontSingleton() {
        loadFont("Evil Empire", "resources/fonts/Evil Empire.otf");
        loadFont("Montserrat", "resources/fonts/Montserrat.ttf");
    }

    public static FontSingleton getInstance() {
        if (instance == null) {
            instance = new FontSingleton();
        }
        return instance;    
    }
    
    private void loadFont(String name, String path) {
        try {
            File fontFile = new File(path);
            if (!fontFile.exists()) {
                throw new IOException("No se pudo encontrar la fuente en la ruta: " + path);
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
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
        return new Font("Serif", Font.PLAIN, 12); // Fuente por defecto
    }
}