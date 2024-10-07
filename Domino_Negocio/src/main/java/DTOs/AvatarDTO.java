/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Dell
 */
public class AvatarDTO {
    //atributo de clase para la ruta.
    private String imageURL;

    //constructor para establecer la ruta de la imagen
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
}
