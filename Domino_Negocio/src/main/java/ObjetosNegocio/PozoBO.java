/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import Entidades.Partida;
import singleton.PartidaST;

/**
 * Objeto de negocio de Pozo que funciona como controlador entre la clase 
 * de domino y la clase de negocio, contiene los metodos del objeto de dominio 
 * con la diferencia que ahora se usaran DTOs. 
 *
 * @author skevi
 */
public class PozoBO {
    
    //instancia del singletone de partida
    PartidaST partidaST;
    
    //instancia de partida
    private Partida partida;

    public PozoBO() {
        this.partida = partidaST.getInstance();
    }
    
    
    
}
