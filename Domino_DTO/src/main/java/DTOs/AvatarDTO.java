/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.io.Serializable;
import java.util.Objects;

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
    
    /**
     * Calcula un código hash para
     * el objeto AvatarDTO,
     * basado en la URL de la imagen.
     */
    
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.imageURL);
        return hash;
    }
    
    /**
     * Compara este objeto AvatarDTO
     * con otro para determinar si son iguales.
     * Dos objetos son iguales si tienen la misma clase
     * y la misma URL de imagen.
     *
     * @param obj el objeto a comparar.
     */
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AvatarDTO other = (AvatarDTO) obj;
        return Objects.equals(this.imageURL, other.imageURL);
    }
    
    //vamo tilin, eso tilin
}