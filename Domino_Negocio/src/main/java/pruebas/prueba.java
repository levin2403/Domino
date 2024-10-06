/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import Controlers.ControlGeneraFichas;
import DTOs.FichaDTO;
import Entidades.Ficha;
import java.util.List;

/**
 *
 * @author Dell
 */
public class prueba {
    public static void main(String[] args) {
        Controlers.ControlGeneraFichas controlFichas = new ControlGeneraFichas();
        List<FichaDTO> fichasDTO = controlFichas.generaFichas();
        
        System.out.println(fichasDTO);
    }
}
