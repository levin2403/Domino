package org.itson.domino.singleton;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.domino.exceptions.MusicFileNotFoundException;

public class MusicModelSingleton {
    private static MusicModelSingleton instance;
    private AdvancedPlayer player;
    private Thread musicThread;

    private MusicModelSingleton() {}

    public static MusicModelSingleton getInstance() {
        if (instance == null) {
            instance = new MusicModelSingleton();
        }
        return instance;
    }

    public void playMusic(String filePath) throws MusicFileNotFoundException {
        // Verificar que el hilo de música no esté activo
        if (player == null || musicThread == null || !musicThread.isAlive()) {
            musicThread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) { // Verifica si el hilo ha sido interrumpido
                    try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
                        player = new AdvancedPlayer(fileInputStream);
                        player.play(); // Reproduce la música
                    } catch (JavaLayerException e) {
                        // Manejo de errores de reproducción
                        e.printStackTrace();
                    } catch (IOException e) {
                        // Manejar IOException
                        Logger.getLogger(MusicModelSingleton.class.getName())
                              .log(Level.SEVERE, "El archivo de música no se encontró: " + filePath, e);
                        break; // Salir del bucle si no se encuentra el archivo
                    }
                }
            });
            musicThread.start(); // Inicia el hilo
        }
    }

    public void stopMusic() {
        if (player != null) {
            player.close(); // Cierra el reproductor
            player = null; // Limpia la referencia
        }
        if (musicThread != null) {
            musicThread.interrupt(); // Interrumpe el hilo
            try {
                musicThread.join(); // Espera a que el hilo termine
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restablecer el estado de interrupción
            }
            musicThread = null; // Limpia la referencia
        }
    }
}
