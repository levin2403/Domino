package org.itson.domino.music;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.FileInputStream;
import java.io.IOException;

public class MusicModel {
    private static MusicModel instance;
    private AdvancedPlayer player;
    private Thread musicThread;

    private MusicModel() {}

    public static MusicModel getInstance() {
        if (instance == null) {
            instance = new MusicModel();
        }
        return instance;
    }

public void playMusic(String filePath) {
    if (player == null || musicThread == null || !musicThread.isAlive()) {
        musicThread = new Thread(() -> {
            while (true) { 
                try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
                    player = new AdvancedPlayer(fileInputStream);
                    player.play(); 
                } catch (JavaLayerException | IOException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(2); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });
        musicThread.start();
    }
}
}