/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Conversores.ConversorFicha;
import Conversores.ConversorJugador;
import DTOs.FichaDTO;
import DTOs.JugadorDTO;
import Entidades.Direccion;
import Entidades.Ficha;
import Entidades.Jugador;
import Entidades.Tablero;
import Singleton.ManejadorTurnosST;
import singleton.TableroST;

/**
 *
 * @author skevi
 */
public class RealizarJugada {
    ManejadorTurnosST mts;
    TableroST ts;
    ManejadorTurnos manejadorTurnos;
    Tablero tablero;
    ConversorFicha convertFicha;
    ConversorJugador convertJugador;
//    FrmMatchOngoingModel mugm;

    public RealizarJugada() {
        mts = new ManejadorTurnosST();
        manejadorTurnos = mts.getInstance();
        ts = new TableroST();
        tablero = ts.getInstance();
        convertFicha = new ConversorFicha();
        convertJugador = new ConversorJugador();
    }
    
    
    public void realizarJugada(FichaDTO ficha){
        Ficha fichaAColocar = convertFicha.fichaConvertirDTOAEntidad(ficha);
        JugadorDTO jugadorEnTurno = manejadorTurnos.getJugadorEnTurno();
        Jugador jugadorEnt = convertJugador.jugadorConvertirDTOAEntidad(jugadorEnTurno);
        
        switch (ficha.getDireccion()) {
            case DERECHA:
                tablero.addLast(fichaAColocar);
                break;
            case IZQUIERDA:
                tablero.addFirst(fichaAColocar);
                break;
        }
        
        
        
        
        
    }
}
