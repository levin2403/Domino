
package DTOs;

import java.io.Serializable;

import java.util.List;

/**
 *
 * @author Dell
 */
public class PozoDTO implements Serializable {
    
    private List<FichaDTO> fichasPozo;

    public PozoDTO() {
    }

    public List<FichaDTO> getFichasPozo() {
        
        return fichasPozo;
    }

    public PozoDTO(List<FichaDTO> fichasPozo) {
        
        this.fichasPozo = fichasPozo;
    }

    public void setFichasPozo(List<FichaDTO> fichasPozo) {
        
        this.fichasPozo = fichasPozo;
    }

    @Override
    public String toString() {
        return "PozoDTO{" + "fichasPozo=" + fichasPozo + '}';
    }
    
}
