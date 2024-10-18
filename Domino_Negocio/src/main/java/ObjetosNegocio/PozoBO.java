/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import DTOs.FichaDTO;
import Entidades.Partida;
import java.util.List;
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
    private PartidaST partidaST;
    
    //instancia de partida
    private Partida partida;
    
    //convertidor de ficha
    

    public PozoBO() {
        this.partida = partidaST.getInstance();
    }
    
    /**
     * Obtiene un número determinado de fichas aleatorias del pozo,
     * posteriormente elimina las fichas obtenidas del pozo para mantener
     * consistencia con las fichas disponibles en el pozo.
     *
     * @param numero Número de fichas a obtener del pozo.
     * @return Lista de fichas extraídas del pozo.
     */
    public List<FichaDTO> obtenerFichas(byte numero) {
        return null;
    }
    
    /**
     * Método que devuelve una ficha aleatoria del pozo y la elimina para
     * mantener la consistencia con la existencia de las fichas.
     * 
     * @return La ficha extraída del pozo o null si no hay fichas disponibles.
     */
    public FichaDTO obtenerFicha() {
        return null;
    }
    
    /**
     * Metodo para obtener el numero de fichas restantes en el pozo.
     * 
     * @return Numero de fichas restantes en el pozo.
     */
    public int fichasDisponibles(){
        return 0;
    }
    
    /**
     * Metodo que retorna las fichas que estan dentro de la lista actual del
     * pozo.
     * 
     * @return Retorna la lista de fichas del pozo.
     */
    public List<FichaDTO> getPozo(){
        return null;
    }
    
}
