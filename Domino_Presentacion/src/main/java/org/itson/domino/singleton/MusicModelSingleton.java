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
        if (currentSong != null && currentSong.equals(filePath) && isPlaying) {
            return;
        }

        stopCurrentMusic();
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
                isPlaying = false;
                currentSong = null;
            }
        });

        playerThread.start();
    }

    public void stopCurrentMusic() {
        if (player != null) {
            player.close(); 
            player = null;
        }
        isPlaying = false;
        currentSong = null;
    }


    public String getCurrentSong() {
        return currentSong;
    }
}