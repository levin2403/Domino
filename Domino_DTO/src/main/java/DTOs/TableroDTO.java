

package DTOs;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ruzzky
 */
public class TableroDTO implements Serializable{
    
    private List<FichaDTO> fichasTablero;

    public TableroDTO() {
    }

    public TableroDTO(List<FichaDTO> fichasTablero) {
        this.fichasTablero = fichasTablero;
    }

    public List<FichaDTO> getFichasTablero() {
        return fichasTablero;
    }

    public void setFichasTablero(List<FichaDTO> fichasTablero) {
        this.fichasTablero = fichasTablero;
    }
    
}
