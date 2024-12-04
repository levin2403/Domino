

package DTOs;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ruzzky
 */
public class TableroDTO implements Serializable {  
    // Clase que representa el tablero de juego, contiene fichas colocadas

    private List<FichaDTO> fichasTablero; // Lista de fichas en el tablero

    public TableroDTO() {  
        // Constructor vacío por defecto
    }

    public TableroDTO(List<FichaDTO> fichasTablero) {  
        // Constructor que inicializa el tablero con una lista de fichas
        this.fichasTablero = fichasTablero;
    }

    public List<FichaDTO> getFichasTablero() {  
        return fichasTablero; // Devuelve la lista de fichas en el tablero
    }

    public void setFichasTablero(List<FichaDTO> fichasTablero) {  
        this.fichasTablero = fichasTablero; // Establece la lista de fichas en el tablero
    }

    @Override
    public String toString() {  
        // Representación en texto de la clase
        return "TableroDTO{" + "fichasTablero=" + fichasTablero + '}';
    }
}
