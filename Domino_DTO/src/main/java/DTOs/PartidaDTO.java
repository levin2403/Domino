

package DTOs;

import java.io.Serializable;

/**
 *
 * @author Ruzzky
 */

public class PartidaDTO implements Serializable{

    private TableroDTO tablero;
    private PozoDTO pozo;
    private ConfiguracionDTO configuracion;
    private ManejadorTurnosDTO manejadorTurnos;

    public TableroDTO getTablero() {
        return tablero;
    }

    public void setTablero(TableroDTO tablero) {
        this.tablero = tablero;
    }

    public PozoDTO getPozo() {
        return pozo;
    }

    public void setPozo(PozoDTO pozo) {
        this.pozo = pozo;
    }

    public ConfiguracionDTO getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(ConfiguracionDTO configuracion) {
        this.configuracion = configuracion;
    }

    public ManejadorTurnosDTO getManejadorTurnos() {
        return manejadorTurnos;
    }

    public void setManejadorTurnos(ManejadorTurnosDTO manejadorTurnos) {
        this.manejadorTurnos = manejadorTurnos;
    }

}
