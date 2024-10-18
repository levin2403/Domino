/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import DTOs.FichaDTO;
import Entidades.Partida;
import singleton.PartidaST;

/**
 * Objeto de negocio de Tablero que funciona como controlador entre la clase 
 * de domino y la clase de negocio, contiene los metodos del objeto de dominio 
 * con la diferencia que ahora se usaran DTOs. 
 * 
 * @author skevi
 */
public class TableroBO {
    
    //instancia del singletone de partida
    private PartidaST partidaST;
    
    //instancia de partida
    private Partida partida;

    public TableroBO() {
        this.partida = partidaST.getInstance();
    }
    
    /**
     * Añade una ficha al principio de la lista.
     * 
     * @param ficha Ficha a añadir al tablero.
     */
    public void addFirst(FichaDTO ficha) {
        
    }

    /**
     * Añade una ficha al final de la lista.
     * 
     * @param ficha Ficha a añadir al tablero.
     */
    public void addLast(FichaDTO ficha) {

    }
    
    /**
     * Obtiene el primer elemento de la lista.
     * 
     * @return Retorna la primera ficha en la lista.
     */
    public FichaDTO getFirst(){
        return null;
    }
    
    /**
     * Obtiene el ultimo elemento de la lista
     * 
     * @return Retorna la ultima ficha en la lista.
     */
    public FichaDTO getLast(){
        return null;
    }
    
    /**
     * Metodo que valida si tanto la locacionSuperior tanto como la 
     * locacionSuperior estan ocupada por alguna otra ficha dentro de la 
     * lista de fichas que ya se encuentran en el tablero.
     * 
     * @return True en caso de que la posicion no este ocupada por ninguna 
     * otra ficha en el tablero, false si ya esta ocupada.
     */
    public boolean validarPosicion(FichaDTO ficha) {
        return false;
    }
}
