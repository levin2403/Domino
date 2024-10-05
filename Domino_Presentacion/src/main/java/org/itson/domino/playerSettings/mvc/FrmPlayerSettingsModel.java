package org.itson.domino.playerSettings.mvc;

import org.itson.domino.managers.AvatarManager;

public class FrmPlayerSettingsModel {

    private String playerName;
    private AvatarManager avatarManager;

    public FrmPlayerSettingsModel(AvatarManager avatarManager) {
        this.avatarManager = avatarManager;
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getSelectedAvatarPath() {
        return avatarManager.getCurrentAvatarPath();
    }

    public String nextAvatar() {
        return avatarManager.nextAvatar();
    }

    public String previousAvatar() {
        return avatarManager.previousAvatar();
    }
    
    public void saveSettings() {
        System.out.println("Configuración guardada: " + playerName + " es Jugador.");
    }
}
