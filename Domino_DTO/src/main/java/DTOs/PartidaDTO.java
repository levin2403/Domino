

package DTOs;

import java.io.Serializable;

/**
 *
 * @author Ruzzky
 */

public class PartidaDTO implements Serializable{

    private TableroDTO tablero; // Tablero de la partida
    private PozoDTO pozo; // Pozo de la partida
    private ConfiguracionDTO configuracion; // Configuracion de la partida
    private ManejadorTurnosDTO manejadorTurnos; // Manejador de turnos de la partida

    /**
     * Constructor por defecto de la clase.
     */
    public PartidaDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase.
     * 
     * @param tablero Tablero de la partida
     * @param pozo Pozo de la partida
     * @param configuracion Configuracion de la partida
     * @param manejadorTurnos Manejador de turnos de la partida
     */
    public PartidaDTO(TableroDTO tablero, PozoDTO pozo, 
            ConfiguracionDTO configuracion, 
            ManejadorTurnosDTO manejadorTurnos) {
        this.tablero = tablero;
        this.pozo = pozo;
        this.configuracion = configuracion;
        this.manejadorTurnos = manejadorTurnos;
    }
    
    //Getters y Setters
    
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

    @Override
    public String toString() {
        return "PartidaDTO{" + "tablero=" + tablero + ", pozo=" + pozo + 
                ", configuracion=" + configuracion + ", manejadorTurnos=" + 
                manejadorTurnos + '}';
    }

}
