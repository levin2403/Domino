/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import Entidades.Direccion;
import Entidades.FabricaFichas;
import Entidades.Pozo;
import singleton.GeneracionPozoSingleton;

/**
 *
 * @author Dell
 */
public class prueba {
    public static void main(String[] args) {
//        FabricaFichas ff = new FabricaFichas();
//        Direccion direccion = Direccion.ABAJO;
//        
//        
//        System.out.println(ff.crearFichas());
//        
//        System.out.println(direccion.toString());

        
        GeneracionPozoSingleton genPozo = new GeneracionPozoSingleton();
        
        Pozo pozo = genPozo.getPozo();
        
        pozo.getFichasGeneradas();
        
        Pozo pozo2 = genPozo.getPozo();
        
        System.out.println("pozo1 " + pozo.getPozo());
        System.out.println("pozo2 " + pozo2.getPozo());
        
        
        
        
    }
    
    
}
