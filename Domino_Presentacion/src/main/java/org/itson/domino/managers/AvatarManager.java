package org.itson.domino.managers;

import java.net.URL;
import java.util.List;

public class AvatarManager {

    // Índice actual del avatar seleccionado
    private int currentIndex = 0;

    // Lista de rutas de los avatares disponibles
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

    /**
     * Constructor de la clase AvatarManager.
     * Carga los avatares al iniciar la clase.
     */
    public AvatarManager() {
        loadAvatars();
    }

    /**
     * Carga los avatares desde las rutas especificadas en avatarPaths.
     */
    public void loadAvatars() {
        for (String path : avatarPaths) {
            try {
                // Intenta cargar cada avatar desde las rutas proporcionadas
                URL imageUrl = getClass().getClassLoader().getResource(path);
                
            } catch (Exception e) {
                // Captura y maneja cualquier excepción durante la carga de los avatares
            }
        }
    }

    /**
     * Obtiene la ruta del avatar actualmente seleccionado.
     * @return La ruta del avatar en formato de cadena.
     */
    public String getCurrentAvatarPath() {
        return avatarPaths.get(currentIndex);
    }

    /**
     * Cambia al siguiente avatar en la lista cíclicamente.
     * @return La ruta del siguiente avatar.
     */
    public String nextAvatar() {
        currentIndex = (currentIndex + 1) % avatarPaths.size();
        return getCurrentAvatarPath();
    }

    /**
     * Cambia al avatar anterior en la lista cíclicamente.
     * @return La ruta del avatar anterior.
     */
    public String previousAvatar() {
        currentIndex = (currentIndex - 1 + avatarPaths.size()) % avatarPaths.size();
        return getCurrentAvatarPath();
    }
}

