package org.itson.domino.singleton;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.InputStream;
import java.io.IOException;

public class MusicModelSingleton {

    private static MusicModelSingleton instance;  // Instancia única de la clase
    private AdvancedPlayer player;  // Reproductor de música
    private Thread playerThread;  // Hilo que reproduce la música
    private String currentSong;  // Ruta de la canción actual
    private boolean isPlaying;  // Estado de reproducción

    // Constructor privado para evitar la creación directa de instancias
    private MusicModelSingleton() {
        this.isPlaying = false;  // Inicialmente no se está reproduciendo música
    }

    // Método que devuelve la única instancia de la clase
    public static MusicModelSingleton getInstance() {
        if (instance == null) {  // Si la instancia aún no existe
            instance = new MusicModelSingleton();  // Se crea la instancia
        }
        return instance;  // Se devuelve la instancia única
    }

    // Método que reproduce música desde la ruta especificada
    public void playMusic(String filePath) {
        // Si la canción actual ya está en reproducción, no hacer nada
        if (currentSong != null && currentSong.equals(filePath) && isPlaying) {
            return;
        }

        // Detener la música actual si hay una reproduciéndose
        stopCurrentMusic();
        currentSong = filePath;  // Actualizar la canción actual
        isPlaying = true;  // Marcar que la música está en reproducción

        // Crear un hilo para reproducir la música sin bloquear el hilo principal
        playerThread = new Thread(() -> {
            try (InputStream inputStream = getClass().getResourceAsStream(filePath)) {
                if (inputStream == null) {
                    throw new IOException("File not found: " + filePath);
                }
                player = new AdvancedPlayer(inputStream);  // Crear el reproductor de música
                player.play();  // Reproducir la música
            } catch (JavaLayerException e) {
                System.err.println("JavaLayer error: " + e.getMessage());  // Error de reproducción
            } catch (IOException e) {
                System.err.println("Error loading music: " + e.getMessage());  // Error al cargar el archivo
            } finally {
                isPlaying = false;  // Marcar que la música ya no está en reproducción
                currentSong = null;  // Limpiar la canción actual
            }
        });

        playerThread.start();  // Iniciar el hilo de reproducción
    }

    // Método que detiene la música actual
    public void stopCurrentMusic() {
        if (player != null) {
            player.close();  // Detener el reproductor
            player = null;  // Limpiar el reproductor
        }
        isPlaying = false;  // Marcar que no se está reproduciendo música
        currentSong = null;  // Limpiar la canción actual
    }

    // Método que devuelve la canción actual
    public String getCurrentSong() {
        return currentSong;
    }
}
