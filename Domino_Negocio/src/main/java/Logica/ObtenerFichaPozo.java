/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Conversores.FichaCVR;
import DTOs.FichaDTO;
import DTOs.JugadorDTO;
import Entidades.ManejadorTurnos;
import Entidades.Pozo;
import javax.swing.JOptionPane;
import Observer.ObserverObtenerFichaPozo;
import org.itson.domino.singleton.MiJugadorST;
import singleton.PozoST;

/**
 *
 * @author skevi
 */
public class ObtenerFichaPozo implements ObserverObtenerFichaPozo{
    
    //intancia singletone del jugador propio
    MiJugadorST miJugador;
    
    //intancia de jugador 
    JugadorDTO jugador;
    
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
            
            
            //actualizamos al usuario del singletone
            
            //modificamos el frame de para representar la nueva ficha
            
        }
        else{
            JOptionPane.showMessageDialog(null, 
                    "Espere a su turno para tomar una ficha del pozo", 
                    "Obtener ficha", JOptionPane.INFORMATION_MESSAGE);
        }
        

    }

    @Override
    public void actualizarObtenerFicha() {
        this.jalarFicha();
    }

}
