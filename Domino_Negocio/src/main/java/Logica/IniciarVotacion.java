/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import DTOs.JugadorDTO;
import Mediator.Mediador;
import org.itson.domino.singleton.MiJugadorST;

/**
 *
 * @author skevi
 */
public class IniciarVotacion {
    
    
    //hacemos una instancia del mediador
    Mediador mediador;
    
    //instancia del usuario que inicio la votacion
    //como este evento se lanza localmente pues es el
    //usuario propio quien la desencadeno.
    JugadorDTO jugador;

    //instancia del jugador propio
    MiJugadorST miJugador;
    
    public IniciarVotacion() {
        this.mediador = new Mediador();
        this.jugador = miJugador.getInstance();
    }
    
    public void iniciarVotacion(){
        //abrimos el frame de la votacion
        mediador.showFrmMatchEndingRequest();
        
        // mandamos la informacion a la primera pipe 
        // para que se vaya al servidor
        
    }
    
    //aqui estaria el observer que desencadena este evento
    
}
