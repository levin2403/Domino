
package DTOs;

import java.io.Serializable;

import java.util.List;

/**
 *
 * @author Dell
 */
public class PozoDTO implements Serializable {  
    // Clase que representa un pozo en el juego, contiene fichas disponibles

    private List<FichaDTO> fichasPozo; // Lista de fichas en el pozo

    public PozoDTO() {  
        // Constructor vacío por defecto
    }

    public PozoDTO(List<FichaDTO> fichasPozo) {  
        // Constructor que inicializa el pozo con una lista de fichas
        this.fichasPozo = fichasPozo;
    }

    public List<FichaDTO> getFichasPozo() {  
        return fichasPozo; // Devuelve la lista de fichas en el pozo
    }

    public void setFichasPozo(List<FichaDTO> fichasPozo) {  
        this.fichasPozo = fichasPozo; // Establece la lista de fichas en el pozo
    }

    @Override
    public String toString() {  
        // Representación en texto de la clase
        return "PozoDTO{" + "fichasPozo=" + fichasPozo + '}';
    }
}
