/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.singleton;

public class PlayerAvatarSingleton {
    private static PlayerAvatarSingleton instance;
    private String selectedAvatar;

    private PlayerAvatarSingleton() {
        // Constructor privado para evitar instancias externas
    }

    public static PlayerAvatarSingleton getInstance() {
        if (instance == null) {
            instance = new PlayerAvatarSingleton();
        }
        return instance;
    }

    public String getSelectedAvatar() {
        return selectedAvatar;
    }

    public void setSelectedAvatar(String selectedAvatar) {
        this.selectedAvatar = selectedAvatar;
    }
}
