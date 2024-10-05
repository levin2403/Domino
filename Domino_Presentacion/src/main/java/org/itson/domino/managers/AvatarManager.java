package org.itson.domino.managers;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.List;

public class AvatarManager {
    private int currentAvatarIndex = 0;

    // Lista inmutable de rutas de avatares
    private final List<String> avatarPaths = List.of(
            "resources/avatars/cactus.jpg",
            "resources/avatars/clown.jpg",
            "resources/avatars/dog.jpg",
            "resources/avatars/george.jpg",
            "resources/avatars/mexican_femboy.jpg",
            "resources/avatars/mexican_girl.jpg",
            "resources/avatars/robot.jpg",
            "resources/avatars/soldier.jpg",
            "resources/avatars/tiger.jpg"
    );

    // Método para obtener la ruta del avatar actual
    public String getCurrentAvatarPath() {
        return avatarPaths.get(currentAvatarIndex);
    }

    // Método para avanzar al siguiente avatar
    public String nextAvatar() {
        currentAvatarIndex = (currentAvatarIndex + 1) % avatarPaths.size(); // Avanza al siguiente avatar
        return getCurrentAvatarPath(); // Retorna la nueva ruta
    }

    // Método para retroceder al avatar anterior
    public String previousAvatar() {
        currentAvatarIndex = (currentAvatarIndex - 1 + avatarPaths.size()) % avatarPaths.size(); // Retrocede al anterior avatar
        return getCurrentAvatarPath(); // Retorna la nueva ruta
    }

    // Método para obtener la imagen del avatar actual escalada a un tamaño específico
    public ImageIcon getCurrentAvatar(int width, int height) {
        return scaleImage(getCurrentAvatarPath(), width, height);
    }

    // Método privado para escalar la imagen del avatar
    private ImageIcon scaleImage(String path, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(path); // Cargar la imagen desde la ruta
        Image image = imageIcon.getImage(); // Obtener el objeto de imagen
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Escalar la imagen
        return new ImageIcon(scaledImage); // Retornar la imagen escalada
    }
}
