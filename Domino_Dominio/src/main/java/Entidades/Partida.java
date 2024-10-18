/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author skevi
 */
public class Partida {
    
    private Tablero tablero;
    private Pozo pozo;
    private Configuracion configuracion;
    private ManejadorTurnos manejadorTurnos;

    public Partida() {
        this.tablero = new Tablero();
        this.pozo = new Pozo();
        this.configuracion = new Configuracion();
        this.manejadorTurnos = new ManejadorTurnos();
    }
    
    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Pozo getPozo() {
        return pozo;
    }

    public void setPozo(Pozo pozo) {
        this.pozo = pozo;
    }

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    public ManejadorTurnos getManejadorTurnos() {
        return manejadorTurnos;
    }

    public void setManejadorTurnos(ManejadorTurnos manejadorTurnos) {
        this.manejadorTurnos = manejadorTurnos;
    }
    
}
