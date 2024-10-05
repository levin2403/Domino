
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

    // Lista de fichas en juego
    private List<Ficha> fichasEnJuego;
    
    // Fichas que están en los extremos del tablero
    private Ficha fichaExtremo1;
    private Ficha fichaExtremo2;

    public Tablero() {
        fichasEnJuego = new LinkedList<>(); // Inicializamos la lista
    }

    // Método para insertar una ficha al principio
    public void setPrimer(Ficha ficha) {
        fichasEnJuego.add(0, ficha); // Insertamos al principio
        if (fichaExtremo1 == null) {
            fichaExtremo1 = ficha; // Si es la primera ficha, la establecemos como extremo
        }
    }

    // Método para obtener la ficha en el extremo inicial
    public Ficha getPrimer() {
        if (!fichasEnJuego.isEmpty()) {
            return fichasEnJuego.get(0); // Retornamos la primera ficha
        }
        return null; // Devuelve null si no hay fichas
    }

    // Método para insertar una ficha al final (extremo 2)
    public void setUltimo(Ficha ficha) {
        fichasEnJuego.add(ficha); // Insertamos al final
        if (fichaExtremo2 == null) {
            fichaExtremo2 = ficha; // Si es la primera ficha, la establecemos como extremo
        }
    }

    // Método para obtener la ficha en el extremo final
    public Ficha getUltimo() {
        if (!fichasEnJuego.isEmpty()) {
            return fichasEnJuego.get(fichasEnJuego.size() - 1); // Retornamos la última ficha
        }
        return null; // Devuelve null si no hay fichas
    }

    
}
