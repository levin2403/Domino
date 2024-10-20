/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Conversores.FichaCVR;
import DTOs.FichaDTO;
import Entidades.ManejadorTurnos;
import Entidades.Pozo;
import org.itson.domino.observer.ObserverObtenerFichaPozo;
import org.itson.domino.singleton.MiJugadorST;
import singleton.PozoST;

/**
 *
 * @author skevi
 */
public class ObtenerFichaPozo implements ObserverObtenerFichaPozo{
    
    //intancia singletone del jugador propio
    
    //intancia de jugador 
    
    
    /**
     * Constructor para inicializar las instancias de la clase
     */
    public ObtenerFichaPozo() {
        
    }

    private void jalarFicha() {
        
      // Verificar si el jugador es el jugador en turno
        if (true) {
            
            //obtenemos una nueva ficha del pozo
            
            
            //se la asignamos al usario que la pidio
            
            
            //
            
        }
        else{
            
        }
        

    }

    @Override
    public void jalarDelPozo() {
        this.jalarFicha();
    }

}
