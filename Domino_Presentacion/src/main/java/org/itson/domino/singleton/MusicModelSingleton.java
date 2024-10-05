package org.itson.domino.singleton;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.FileInputStream;

import java.io.IOException;

public class MusicModelSingleton {

    private static MusicModelSingleton instance;
    private AdvancedPlayer player;
    private Thread playerThread;
    private String currentSong;
    private boolean isPlaying;

    private MusicModelSingleton() {
        this.isPlaying = false;
    }

    public static MusicModelSingleton getInstance() {
        if (instance == null) {
            instance = new MusicModelSingleton();
        }
        return instance;
    }

    public void playMusic(String filePath) {
        if (currentSong != null && currentSong.equals(filePath) && isPlaying) {
            return; // La canción ya está sonando, no hacemos nada
        }

        stopCurrentMusic(); // Detiene la música anterior si está sonando
        currentSong = filePath;
        isPlaying = true;

        playerThread = new Thread(() -> {
            while (isPlaying) {
                try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
                    player = new AdvancedPlayer(fileInputStream);
                    player.play();
                } catch (JavaLayerException | IOException e) {
                    System.err.println("Error al reproducir la música: " + e.getMessage());
                    isPlaying = false;
                }
                // La canción terminó, pero isPlaying sigue siendo true, así que vuelve a empezar
            }
        });
        playerThread.start();
    }

    public void stopCurrentMusic() {
        isPlaying = false;
        if (player != null) {
            player.close();
            player = null;
        }
        if (playerThread != null) {
            playerThread.interrupt();
            try {
                playerThread.join(1000); // Espera hasta 1 segundo para que el hilo termine
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            playerThread = null;
        }
        currentSong = null;
    }

    public String getCurrentSong() {
        return currentSong;
    }
}
