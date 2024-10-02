package org.itson.domino.singleton;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.FileInputStream;
import java.io.IOException;
import org.itson.domino.exceptions.MusicFileNotFoundException;

public class MusicModelSingleton {
    private static MusicModelSingleton instance;
    private AdvancedPlayer player;
    private Thread musicThread;
    private volatile boolean playing; // Variable para controlar la reproducción

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
        playing = true; // Indica que la música está sonando
        musicThread = new Thread(() -> {
            while (playing) { // Bucle para repetir la música mientras esté reproduciendo
                try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
                    player = new AdvancedPlayer(fileInputStream);
                    player.play(); // Reproduce la música
                } catch (JavaLayerException e) {
                    e.printStackTrace(); // Registrar el error de JavaLayer
                    break; // Salir del bucle si hay un error
                } catch (IOException e) {
                    System.err.println("El archivo de música no se encontró: " + filePath);
                    break; // Salir del bucle si hay un error
                }
            }
        });
        musicThread.start(); // Inicia el hilo
    }
}


    // Método para detener la música
    public void stopMusic() {
        playing = false; // Cambiar a false para salir del bucle
        if (player != null) {
            player.close(); // Cerrar el reproductor si está activo
        }
    }
}

