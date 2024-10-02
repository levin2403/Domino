package org.itson.domino.singleton;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontSingleton {

    private static FontSingleton instance;
    
    private Font baseFont;
    private Font fontSize80;
    private Font fontSize26;

    private FontSingleton() {
        loadBaseFont("resources/fonts/Evil Empire.otf");
        deriveFonts();
    }

    public static FontSingleton getInstance() {
        if (instance == null) {
            instance = new FontSingleton();
        }
        return instance;    
    }
    
    private void loadBaseFont(String path) {
        try {
            File fontFile = new File(path);
            if (!fontFile.exists()) {
                throw new IOException("No se pudo encontrar la fuente en la ruta: " + path);
            }
            baseFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deriveFonts() {
        if (baseFont != null) {
            fontSize80 = baseFont.deriveFont(80f);
            fontSize26 = baseFont.deriveFont(26f);
        } else {
            fontSize80 = new Font("Serif", Font.PLAIN, 24);
            fontSize26 = new Font("Serif", Font.PLAIN, 18);
        }
    }

    public Font getFontSize80() {
        return fontSize80;
    }

    public Font getFontSize26() {
        return fontSize26;
    }
}
