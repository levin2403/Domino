/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author skevi
 */
public class Votar {
    
    private static int votos; //numero de votos en la partida

    public Votar() {
        
    }
    
    public void terminarVotacion(){
        
    }

    public static int getVotos() {
        return votos;
    }

    public static void setVotos(int votos) {
        Votar.votos = votos;
    }
    
    // aqui estaria el update de su observer 
    // para añadir mas votos
   
}
