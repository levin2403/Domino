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
    // Clase que representa una partida de juego, incluyendo su configuración, tablero, pozo y turnos

    private Tablero tablero; // Tablero donde se colocan las fichas
    private Pozo pozo; // Pozo con las fichas disponibles
    private Configuracion configuracion; // Configuración de la partida
    private ManejadorTurnos manejadorTurnos; // Gestión de turnos entre jugadores

    public Partida() {  
        // Constructor que inicializa los componentes de la partida
        this.tablero = new Tablero();
        this.pozo = new Pozo();
        this.configuracion = new Configuracion();
        this.manejadorTurnos = new ManejadorTurnos();
    }

    public Tablero getTablero() {  
        return tablero; // Devuelve el tablero de la partida
    }

    public void setTablero(Tablero tablero) {  
        this.tablero = tablero; // Establece el tablero de la partida
    }

    public Pozo getPozo() {  
        return pozo; // Devuelve el pozo con las fichas de la partida
    }

    public void setPozo(Pozo pozo) {  
        this.pozo = pozo; // Asigna un nuevo pozo a la partida
    }

    public Configuracion getConfiguracion() {  
        return configuracion; // Obtiene la configuración de la partida
    }

    public void setConfiguracion(Configuracion configuracion) {  
        this.configuracion = configuracion; // Establece la configuración de la partida
    }

    public ManejadorTurnos getManejadorTurnos() {  
        return manejadorTurnos; // Obtiene el manejador de turnos de la partida
    }

    public void setManejadorTurnos(ManejadorTurnos manejadorTurnos) {  
        this.manejadorTurnos = manejadorTurnos; // Asigna un nuevo manejador de turnos
    }
}

