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
    
    private static byte votos; //numero de votos en la partida
    private static byte votosFavor; //votos a favor,
    private static byte votosContra; //votos en contra
    
    //instancia del finalizador de la partida
    
    //instancia de la configuracion de partida
    //la usariamos para saber si la cantidad de votos es 
    //igual al total de jugadores
    
    /**
     * Constructor por defecto;
     */
    public Votar() {
        
    }
    
    /**
     * Valida el estado de los votos y determina el camino a seguir dependiendo
     * si todos los usarios ya votaron.
     * Tanto como puede terminar la partida la puede retomar
     */
    private void validartVotacion(){
        //si el numero de votos es nulo 
        if (true) {
            
        }
        
    }

    /**
     * 
     */
    public void votarFavor(){
        Votar.votos ++;
        Votar.votosFavor++;
        validartVotacion();    
    }
    
    /**
     * 
     */
    public void votarContra(){
        Votar.votos ++;
        Votar.votosContra++;
        validartVotacion();  
    }

    //Sets para en caso de que el voto llegue externo
    
    public static void setVotosFavor(byte votosFavor) {
        Votar.votosFavor = votosFavor;
    }

    public static void setVotosContra(byte votosContra) {
        Votar.votosContra = votosContra;
    }
    
    
    
}
