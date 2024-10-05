
package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 * @author Ruzzky
 */
  
// Maneja una lista de fichas y proporciona métodos para agregar y validar conexiones entre ellas.

public class Tablero {

    private List<FichaTablero> fichasTablero; // Lista que almacena las fichas en el tablero.

    // Constructor por defecto que inicializa la lista de fichas.
    public Tablero() {
        this.fichasTablero = new ArrayList<>();
    }

    // Devuelve la lista de fichas en el tablero.
    public List<FichaTablero> getFichasTablero() {
        return fichasTablero;
    }

    // Establece una nueva lista de fichas en el tablero.
    public void setFichasTablero(List<FichaTablero> fichasTablero) {
        this.fichasTablero = fichasTablero;
    }

    // Agrega una ficha al final de la lista.
    public void addFichasTablero(FichaTablero fichaT) {
        fichasTablero.add(fichaT);
    }

    // Agrega una ficha al inicio de la lista.
    public void agregarInicio(FichaTablero fichaT) {
        fichasTablero.add(0, fichaT);
    }

    // Devuelve la ficha en el extremo derecho del tablero.
    public FichaTablero getExtremoDerecho() {
        if (fichasTablero.isEmpty()) {
            return null; // Si no hay fichas, devuelve null.
        }
        return fichasTablero.get(fichasTablero.size() - 1);
    }

    // Devuelve la ficha en el extremo izquierdo del tablero.
    public FichaTablero getExtremoIzquierdo() {
        if (fichasTablero.isEmpty()) {
            return null; // Si no hay fichas, devuelve null.
        }
        return fichasTablero.get(0);
    }

    // Valida si una ficha mula puede ser agregada al tablero.
    public boolean validaZonaInical(FichaTablero ficha) {
        if (ficha.isMula()) {
            addFichasTablero(ficha);
            return true; // Se puede agregar la ficha.
        }
        return false; // No se puede agregar.
    }

}
