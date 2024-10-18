/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Conversores.FichaCVR;
import DTOs.FichaDTO;
import DTOs.JugadorDTO;
import DTOs.ManejadorTurnosDTO;
import Entidades.Ficha;
import Entidades.ManejadorTurnos;
import Entidades.Pozo;
import javax.swing.JOptionPane;
import org.itson.domino.observer.ObserverObtenerFichaPozo;
import org.itson.domino.singleton.MiJugadorST;
import singleton.PartidaST;
import singleton.PozoST;

/**
 *
 * @author skevi
 */
public class ObtenerFichaPozo implements ObserverObtenerFichaPozo{
    
    PartidaST partida;
    
    ManejadorTurnos manejadorTurnos;
    PozoST ps;
    Pozo pozo;
    FichaCVR convertFicha;
    MiJugadorST miJugador;

    public ObtenerFichaPozo() {
        manejadorTurnos = partida.getInstance().getManejadorTurnos();
        ps = new PozoST();
        pozo = ps.getInstance();
        miJugador = new MiJugadorST();
    }

    private FichaDTO jalarFicha() {
        
//        JugadorDTO miJugadorDTO = miJugador.getInstance();
//        JugadorDTO jugadorEnTurno = manejadorTurnos.getJugadorEnTurno();
//        
//        if (miJugadorDTO.getNickName().equals(jugadorEnTurno.getNickName())) {
//            if (pozo.fichasDisponibles() == 0) {
//                JOptionPane.showMessageDialog(null, "El pozo esta vaio");
//                return null;
//            }
//            Ficha fichaJalada = pozo.obtenerFicha();
//            FichaDTO fichaDTO = convertFicha.fichaConvertirEntidadADTO(fichaJalada);
//            manejadorTurnos.darFichaAJugador(fichaDTO);
//            return fichaDTO;
//        } else {
//            JOptionPane.showMessageDialog(null, "Espera tu turno");
//            return null;
//        }
          return null;
    }

    @Override
    public void jalarDelPozo() {
        this.jalarFicha();
    }

}
