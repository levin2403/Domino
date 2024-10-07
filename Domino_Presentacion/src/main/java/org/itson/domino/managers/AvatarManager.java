package org.itson.domino.managers;

import java.net.URL;
import java.util.List;

public class AvatarManager {

    private int currentIndex = 0;
    private final List<String> avatarPaths = List.of(
            "avatars/cactus.jpg",
            "avatars/clown.jpg",
            "avatars/dog.jpg",
            "avatars/george.jpg",
            "avatars/mexican_femboy.jpg",
            "avatars/mexican_girl.jpg",
            "avatars/robot.jpg",
            "avatars/soldier.jpg",
            "avatars/tiger.jpg"
    );

    public AvatarManager() {
        loadAvatars();
    }

    public void loadAvatars() {
        for (String path : avatarPaths) {
            try {
                URL imageUrl = getClass().getClassLoader().getResource(path);
                if (imageUrl != null) {

                    System.out.println("Cargado: " + path);
                } else {
                    System.err.println("Error: No se pudo encontrar la imagen en la ruta: " + path);
                }
            } catch (Exception e) {
                System.err.println("Error al cargar la imagen: " + e.getMessage());
            }
        }
    }

    public String getCurrentAvatarPath() {
        return avatarPaths.get(currentIndex);
    }

    public String nextAvatar() {
        currentIndex = (currentIndex + 1) % avatarPaths.size();
        return getCurrentAvatarPath();
    }

    public String previousAvatar() {
        currentIndex = (currentIndex - 1 + avatarPaths.size()) % avatarPaths.size();
        return getCurrentAvatarPath();
    }
}
