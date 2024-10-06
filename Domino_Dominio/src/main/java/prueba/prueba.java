/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import Entidades.Direccion;
import Entidades.FabricaFichas;

/**
 *
 * @author Dell
 */
public class prueba {
    public static void main(String[] args) {
        FabricaFichas ff = new FabricaFichas();
        Direccion direccion = Direccion.ABAJO;
        
        
        System.out.println(ff.crearFichas());
        
        System.out.println(direccion.toString());
        
    }
    
    
}
