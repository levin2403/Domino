/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Conversores.FichaCVR;
import Conversores.JugadorCVR;
import DTOs.FichaDTO;
import DTOs.JugadorDTO;
import Entidades.Direccion;
import Entidades.Ficha;
import Entidades.Jugador;
import Entidades.ManejadorTurnos;
import Entidades.Tablero;
import Singleton.ManejadorTurnosST;
import org.itson.domino.matchOngoing.mvc.FrmMatchOngoingView;
import singleton.PartidaST;
import singleton.TableroST;

/**
 *
 * @author skevi
 */
public class RealizarJugada {
    
    //instancia global de partida
    PartidaST partida;
    
    //instancia del manejador de turnos
    ManejadorTurnos manejadorTurnos;
    
    //instancia de tablero
    Tablero tablero;
    
    //convertidor de ficha
    FichaCVR convertFicha;
    
    //convertidor de ficha
    JugadorCVR convertJugador;

    public RealizarJugada() {
        manejadorTurnos = partida.getInstance().getManejadorTurnos();
        tablero = partida.getInstance().getTablero();
        convertFicha = new FichaCVR();
        convertJugador = new JugadorCVR();
    }
    
    
    public void realizarJugada(FichaDTO ficha, FrmMatchOngoingView juego){
        Ficha fichaAColocar = convertFicha.fichaConvertirDTOAEntidad(ficha);
//        JugadorDTO jugadorEnTurno = manejadorTurnos.getJugadorEnTurno();
//        Jugador jugadorEnt = convertJugador.jugadorConvertirDTOAEntidad(jugadorEnTurno);
        
        if(tablero.getFichas().isEmpty()){
            juego.pintaPrimerFicha(ficha);
        }
        
        switch (ficha.getDireccionLado()) {
            case DERECHA:
                tablero.addLast(fichaAColocar);
                break;
            case IZQUIERDA:
                tablero.addFirst(fichaAColocar);
                break;
        }
    }
}
