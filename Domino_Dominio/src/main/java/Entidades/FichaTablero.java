package Entidades;

/**
 *
 * @author Ruzzky
 */

// Clase FichaTablero que extiende la clase Ficha, utilizada para representar una ficha que puede colocarse en el tablero.
// Además de los atributos heredados, esta clase incluye la capacidad de conectar la ficha por la parte inferior o superior.

public class FichaTablero extends Ficha {
    // Atributos que indican si la ficha puede conectarse por la parte inferior o superior.
    boolean conectarAbajo;    // Indica si la ficha se puede conectar por el lado de Abajo.
    boolean conectarArriba;   // Indica si la ficha se puede conectar por el lado de Arriba.

    public FichaTablero() {
        // Constructor vacío.
    }

    // Constructor que inicializa los valores de la ficha, heredando de la clase Ficha.
    public FichaTablero(String imagen, int puntoAbajo, int puntoArriba) {
        super(imagen, puntoAbajo, puntoArriba);  // Llama al constructor de Ficha.
    }

    // Método para obtener el valor de conectarAbajo.
    // Indica si la ficha puede conectarse por la parte inferior.
    public boolean isConectarAbajo() {
        return conectarAbajo;
    }

    // Método para asignar si la ficha puede conectarse por la parte inferior.
    public void setConectarAbajo(boolean conectarAbajo) {
        this.conectarAbajo = conectarAbajo;
    }

    // Método para obtener el valor de conectarArriba.
    // Indica si la ficha puede conectarse por la parte superior.
    public boolean isConectarArriba() {
        return conectarArriba;
    }

    // Método para asignar si la ficha puede conectarse por la parte superior.
    public void setConectarArriba(boolean conectarArriba) {
        this.conectarArriba = conectarArriba;
    }
}
