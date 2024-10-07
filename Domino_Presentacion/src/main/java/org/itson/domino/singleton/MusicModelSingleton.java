package org.itson.domino.singleton;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.InputStream;
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
        // Evitar reproducir la misma canción si ya está sonando
        if (currentSong != null && currentSong.equals(filePath) && isPlaying) {
            return; // La canción ya está sonando
        }

        stopCurrentMusic(); // Detener la música actual si está sonando
        currentSong = filePath;
        isPlaying = true;

        playerThread = new Thread(() -> {
            try (InputStream inputStream = getClass().getResourceAsStream(filePath)) {
                if (inputStream == null) {
                    throw new IOException("File not found: " + filePath);
                }
                player = new AdvancedPlayer(inputStream);
                player.play();
            } catch (JavaLayerException e) {
                System.err.println("JavaLayer error: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Error loading music: " + e.getMessage());
            } finally {
                isPlaying = false; // Asegúrate de que isPlaying se restablezca al final
                currentSong = null; // Restablecer currentSong si es necesario
            }
        });

        playerThread.start();
    }

    public void stopCurrentMusic() {
        if (player != null) {
            player.close(); // Detener la reproducción
            player = null; // Limpiar el objeto del reproductor
        }
        isPlaying = false; // Marcar que no hay música sonando
        currentSong = null; // Limpiar la canción actual
    }


    public String getCurrentSong() {
        return currentSong;
    }
}
