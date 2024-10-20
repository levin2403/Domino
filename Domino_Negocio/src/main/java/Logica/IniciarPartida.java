/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;


import ObjetosNegocio.ConfiguracionBO;
import ObjetosNegocio.ManejadorTurnosBO;
import ObjetosNegocio.PozoBO;

/**
 * Evento local que inicia la y tiene el rol de pump para mandar el aviso
 * de la partida iniciada a otro jugadores.
 * 
 * @author skevi
 */
public class IniciarPartida {
    
    //Instancia del pozo
    PozoBO pozo;
    
    //instancia del manejador de turnos;
    ManejadorTurnosBO manejadorTurnos;
    
    //intancia de la configuracion
    ConfiguracionBO configuracion;
    
    public IniciarPartida() {
        this.pozo = new PozoBO();
        this.manejadorTurnos = new ManejadorTurnosBO();
        this.configuracion = new ConfiguracionBO();
    }
    
    /**
     * Realiza la validacion inicial para saber si esta la cantidad 
     * suficiente de jugadores dentro de la partida.
     * En caso verdader, inicia el proceso para comenzar la partida y
     * en caso contrario manda un aviso de que no se puede iniciar.
     * 
     */
    private void validacionInicial(){
        
    }
    
    /**
     * Genera las fichas para el pozo que se usara en la partida.
     */
    private void generarFichas(){
        
    }
    
    /**
     * Reparte las fichas a todos los jugadores dentro de la partida.
     * 
     */
    private void repartirFichas(){
        
    }
    
    /**
     * Prepara el tablero, modelo y vista para iniciar la partida.
     * 
     * 
     */
    private void prepararTablero(){
        
    }
    
    /**
     * Envia el evento a su respectiva pipe para iniciar la partida de igual 
     * manera para los otros jugadores.
     * 
     */
    private void enviarAPipe(){
        
    }
    
    /**
     * Metodo conjunto que Realiza todos los pasos para iniciar la partida.
     * 
     */
    private void iniciar(){
        generarFichas();
        repartirFichas();
        prepararTablero();
        enviarAPipe();
    }
    
    //Observer para iniciar la partida.
    
}
