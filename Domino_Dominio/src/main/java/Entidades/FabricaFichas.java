/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class FabricaFichas {
    

    /**
     * Contructor por defecto
     */
    public FabricaFichas() {

    }
    
     /**
     * Metodo encargado de la fabricacion de las 28 fichas para la 
     * inicializacion del pozo.
     * 
     * @return Lista con las 28 fichas fabricadas;
     */
    public List<Ficha> crearFichas() {
        List<Ficha> fichas = new ArrayList<>();

        // Generar todas las combinaciones de fichas (28 fichas en total)
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                Ficha ficha = new Ficha(i, j);
                ficha.setIcon(i+"-"+j);
                fichas.add(ficha);
            }
        }

        return fichas;
    }
    
//    public List<Ficha> crearFichas2() {
//        List<Ficha> fichas = new ArrayList<>();
//
//        // Generar todas las combinaciones de fichas (28 fichas en total)
//        for (int i = 0; i <= 6; i++) {
//            for (int j = i; j <= 6; j++) {
//                Ficha ficha = new Ficha(i, j);
//                if(!fichas.contains(ficha)){
//                 fichas.add(ficha);   
//                }
//            }
//        }
//
//        return fichas;
//    }
}
