/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import Entidades.Partida;

/**
 *
 * @author skevi
 */
public class PartidaST {
    
    private static Partida instance; 
    
    /**
     * 
     * @return 
     */
    public Partida getInstance() {
        if (instance == null) {
            synchronized (PartidaST.class) {
                if (instance == null) {
                    instance = new Partida();
                }
            }
        }
        return instance;
    }
    
    /**
     * Este metodo estblece una nueva configuracion al singletone en caso 
     * de ser requerido ser modificado fuera de la clase.
     * 
     * @param newInstance nueva instancia a incluir dentro del singletone
     */
    public void setInstance(Partida newInstance){
        PartidaST.instance = newInstance;
    }
}
