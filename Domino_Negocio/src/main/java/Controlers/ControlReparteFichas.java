/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import DTOs.FichaDTO;
import DTOs.JugadorDTO;
import Entidades.Ficha;
import Entidades.Jugador;
import Entidades.Pozo;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ControlReparteFichas {
    ControlGeneraFichas controlGF;
    Pozo pozo;
    
    public ControlReparteFichas() {
        controlGF = new ControlGeneraFichas();
        pozo = new Pozo();
    }
    
    

    public boolean repartirFichas2Jugadores(byte numeroFichas,Jugador jugador1, Jugador jugador2){
        pozo.getFichasGeneradas();
        this.reparteFichasAJugador(numeroFichas, jugador1);
        this.reparteFichasAJugador(numeroFichas, jugador2);
        
        return true;

    }
    
    public boolean repartirFichas3Jugadores(byte numeroFichas,Jugador jugador1, Jugador jugador2, Jugador jugador3){
        pozo.getFichasGeneradas();
        this.reparteFichasAJugador(numeroFichas, jugador1);
        this.reparteFichasAJugador(numeroFichas, jugador2);
        this.reparteFichasAJugador(numeroFichas, jugador3);
        
        return true;

    }
    
    public boolean repartirFichas4Jugadores(byte numeroFichas,Jugador jugador1, Jugador jugador2, Jugador jugador3, Jugador jugador4){
        pozo.getFichasGeneradas();
        this.reparteFichasAJugador(numeroFichas, jugador1);
        this.reparteFichasAJugador(numeroFichas, jugador2);
        this.reparteFichasAJugador(numeroFichas, jugador3);
        this.reparteFichasAJugador(numeroFichas, jugador4);
        
        return true;

    }
    
    private boolean reparteFichasAJugador(byte numeroFichas, Jugador jugador){
        List<Ficha> fichasJugador = pozo.obtenerFichas(numeroFichas);
        jugador.setFichas(fichasJugador);
        return true;
    }
}
