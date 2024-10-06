
package Entidades;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author skevi
 * @author Ruzzky
 */
  
/**
 * 
 *  Maneja una lista de fichas y proporciona métodos para agregar y validar 
 *  conexiones entre ellas.
 * 
 * @author skevi
 * @author Ruszzky
 * 
 */
public class Tablero {
    
    private LinkedList<Ficha> fichas; 

    public Tablero() {
        this.fichas = new LinkedList<>(); // Inicializa la lista de fichas
    }

    /**
     * Añade una ficha al principio de la lista.
     * 
     * @param ficha Ficha a añadir al tablero.
     */
    public void addFirst(Ficha ficha) {
        fichas.addFirst(ficha);
    }

    /**
     * Añade una ficha al final de la lista.
     * 
     * @param ficha Ficha a añadir al tablero.
     */
    public void addLast(Ficha ficha) {
        fichas.addLast(ficha);
    }
    
    /**
     * Obtiene el primer elemento de la lista.
     * 
     * @return Retorna la primera ficha en la lista.
     */
    public Ficha getFirst(){
        return fichas.getFirst();
    }
    
    /**
     * Obtiene el ultimo elemento de la lista
     * 
     * @return Retorna la ultima ficha en la lista.
     */
    public Ficha getLast(){
        return fichas.getLast();
    }
    
    /**
     * Metodo que valida si tanto la locacionSuperior tanto como la 
     * locacionSuperior estan ocupada por alguna otra ficha dentro de la 
     * lista de fichas que ya se encuentran en el tablero.
     * 
     * @return True en caso de que la posicion no este ocupada por ninguna 
     * otra ficha en el tablero, false si ya esta ocupada.
     */
    public boolean validarPosicion(Ficha ficha) {
        // Iterar a través de la lista de fichas en el tablero
        for (Ficha f : fichas) {
            // Comprobar si la locación superior o inferior de la ficha ya está 
            // ocupada
            if (f.getLocacionSuperior().equals(ficha.getLocacionSuperior()) ||
                f.getLocacionInferior().equals(ficha.getLocacionInferior())) {
                return false; // Posición ocupada
            }
        }
        return true; // Posición disponible
    }
    
}
