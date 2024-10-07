/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import Controlers.ControlGeneraFichas;
import Controlers.ControlReparteFichas;
import Conversores.ConversorFicha;
import DTOs.FichaDTO;
import Entidades.Avatar;
import Entidades.Direccion;
import Entidades.Ficha;
import Entidades.Jugador;
import Entidades.Locacion;
import Entidades.Pozo;
import java.util.List;

/**
 *
 * @author Dell
 */
public class prueba {
    public static void main(String[] args) {
//        Controlers.ControlGeneraFichas controlFichas = new ControlGeneraFichas();
//        List<FichaDTO> fichasDTO = controlFichas.generaFichas();
//        
//        Locacion loc = new Locacion(5, 3);
//        
//        Ficha ficha = new Ficha(0, 0, loc, null, Direccion.ABAJO);
//        Conversores.ConversorFicha converFicha = new ConversorFicha();
//        
//        FichaDTO fichaDTO = converFicha.fichaConvertirEntidadADTO(ficha);
//        
//        System.out.println(fichaDTO);
        
        ControlReparteFichas controlRF = new ControlReparteFichas();
        Jugador jugador1 = new Jugador("Vato", new Avatar("Vato"));
        Jugador jugador2 = new Jugador("Vata", new Avatar("Vata"));
        Pozo pozo = new Pozo();
        controlRF.repartirFichas2Jugadores((byte)7, jugador1, jugador2);
        
        System.out.println(jugador1.getFichas());
        System.out.println(jugador2.getFichas());
        System.out.println(pozo.getPozo());
    }
}
