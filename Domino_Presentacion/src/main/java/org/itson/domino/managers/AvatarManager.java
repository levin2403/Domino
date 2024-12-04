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
                
            } catch (Exception e) {
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
