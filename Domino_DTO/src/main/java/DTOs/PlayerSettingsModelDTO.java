/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Dell
 */
public class PlayerSettingsModelDTO {  
    // Modelo que representa la configuración de un jugador

    private String playerName; // Nombre del jugador
    private String imagen; // Ruta o referencia a la imagen del jugador

    public PlayerSettingsModelDTO(String playerName, String imagen) {  
        // Constructor para inicializar el nombre y la imagen del jugador
        this.playerName = playerName;
        this.imagen = imagen;
    }

    public String getPlayerName() {  
        return playerName; // Obtiene el nombre del jugador
    }

    public void setPlayerName(String playerName) {  
        this.playerName = playerName; // Establece el nombre del jugador
    }

    public String getImagen() {  
        return imagen; // Devuelve la imagen asociada al jugador
    }

    public void setImagen(String imagen) {  
        this.imagen = imagen; // Actualiza la imagen del jugador
    }
}

