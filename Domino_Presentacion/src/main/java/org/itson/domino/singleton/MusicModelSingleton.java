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
    private volatile boolean playing;

    private MusicModelSingleton() {}

    public static MusicModelSingleton getInstance() {
        if (instance == null) {
            instance = new MusicModelSingleton();
        }
        return instance;
    }

public void playMusic(String filePath) throws MusicFileNotFoundException {
    if (player == null || musicThread == null || !musicThread.isAlive()) {
        playing = true;
        musicThread = new Thread(() -> {
            while (playing) {
                try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
                    player = new AdvancedPlayer(fileInputStream);
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                    break;
                } catch (IOException e) {
                    System.err.println("El archivo de música no se encontró: " + filePath);
                    break;
                }
            }
        });
        musicThread.start();
    }
}


    // Método para detener la música
    public void stopMusic() {
        playing = false;
        if (player != null) {
            player.close();
        }
    }
}

