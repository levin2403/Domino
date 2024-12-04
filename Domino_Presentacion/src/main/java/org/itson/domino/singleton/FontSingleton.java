package org.itson.domino.singleton;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.itson.domino.constants.FontPaths;

public class FontSingleton {

    private static FontSingleton instance; // Instancia única del Singleton
    private Map<String, Font> fonts = new HashMap<>(); // Mapa que almacena las fuentes cargadas

    // Constructor privado para cargar las fuentes al inicio
    private FontSingleton() {
        loadFont("Evil Empire", FontPaths.EVIL_EMPIRE); // Cargar fuente "Evil Empire"
        loadFont("Montserrat", FontPaths.MONTSERRAT); // Cargar fuente "Montserrat"
    }

    // Método para obtener la instancia única del Singleton
    public static FontSingleton getInstance() {
        if (instance == null) {
            instance = new FontSingleton(); // Crear la instancia solo cuando sea necesario
        }
        return instance;
    }

    // Método privado para cargar una fuente desde una ruta
    private void loadFont(String name, String path) {
        try (InputStream fontStream = getClass().getResourceAsStream(path)) {
            if (fontStream == null) {
                throw new IOException("No se pudo encontrar la fuente en la ruta: " + path); // Manejo de errores si no se encuentra la fuente
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(12f); // Crear la fuente y establecer tamaño 12
            fonts.put(name, font); // Guardar la fuente en el mapa
        } catch (FontFormatException | IOException e) {
            e.printStackTrace(); // Imprimir el error si ocurre alguno
        }
    }

    // Método para obtener una fuente por nombre y tamaño
    public Font getFont(String name, float size) {
        Font font = fonts.get(name); // Buscar la fuente por nombre
        if (font != null) {
            return font.deriveFont(size); // Devolver la fuente con el tamaño solicitado
        }
        return new Font("Serif", Font.PLAIN, 12); // Fuente predeterminada si no se encuentra la fuente solicitada
    }
}
