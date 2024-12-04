/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;


import java.util.List;

/**
 *
 * @author Dell
 */
public class ManejadorTurnosDTO {  
    // Clase que gestiona el turno de los jugadores en una partida
    
    private List<JugadorDTO> jugadores; // Lista que contiene a los jugadores
    private JugadorDTO jugadorEnTurno; // Jugador que está tomando su turno actual
    private PozoDTO pozo; // Pozo asociado a la partida
    private int contador; // Contador auxiliar para gestionar turnos
    
    public int getContador() {  
        return contador; // Devuelve el valor actual del contador
    }

    public void setContador(int contador) {  
        this.contador = contador; // Actualiza el valor del contador
    }
    
    public List<JugadorDTO> getJugadores() {  
        return jugadores; // Obtiene la lista de jugadores
    }

    public PozoDTO getPozo() {  
        return pozo; // Retorna el pozo de la partida
    }

    public void setPozo(PozoDTO pozo) {  
        this.pozo = pozo; // Establece el pozo de la partida
    }

    public void setJugadores(List<JugadorDTO> jugadores) {  
        this.jugadores = jugadores; // Asigna la lista de jugadores
    }

    public JugadorDTO getJugadorEnTurno() {  
        return jugadorEnTurno; // Devuelve el jugador actual en turno
    }

    public void setJugadorEnTurno(JugadorDTO jugadorEnTurno) {  
        this.jugadorEnTurno = jugadorEnTurno; // Establece el jugador en turno
    }
}
