/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import Entidades.Direccion;
import Entidades.FabricaFichas;
import Entidades.Pozo;
import singleton.PozoST;

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

        
        PozoST genPozo = new PozoST();
        
        Pozo pozo = genPozo.getInstance();
        
        Pozo pozo2 = genPozo.getInstance();
        
        System.out.println("pozo1 " + pozo.getPozo());
        System.out.println("pozo2 " + pozo2.getPozo());
        
        
        
        
    }
    
    
}
