/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Clase que define la imagen de avatar del jugador mdeiante la ruta 
 * absoluta dentro del folder de recursos del proyecto "Domino_Presentacion".
 * 
 * @author skevi
 */
public class Avatar {
    
    //atributo de clase para la ruta.
    private String imageURL;

    //constructor para establecer la ruta de la imagen
    public Avatar(String imageURL) {
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
