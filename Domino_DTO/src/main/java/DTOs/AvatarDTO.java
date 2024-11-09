/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class AvatarDTO implements Serializable {
    
    //Atributo de clase para la ruta.
    private String imageURL;

    /**
     * Constructor vacio por defecto
     */
    public AvatarDTO() {
    }
    
    /**
     * Constructor para establecer la ruta de la imagen
     * @param imageURL 
     */
    public AvatarDTO(String imageURL) {
        this.imageURL = imageURL;
    }    

    /**
     * Metodo para obtener la ruta de la imagen en texto.
     * @return 
     */
    public String getImageURL() {
        return imageURL;
    }

    @Override
    public String toString() {
        return "AvatarDTO{" + "imageURL=" + imageURL + '}';
    }
    
}