/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import Entidades.Pozo;

/**
 *
 * @author skevi
 */
public class PozoST {
    
        //Configuracion estatica
    private static Pozo instance;
    
    /**
     * Metodo para obtener la instancia guardada dentro de la clase, en caso de
     * que la instancia sea nula osea que no se haya creado nunca,
     * devolvera una nueva instancia de ConfiguracionDTO.
     * El metodo esta adapatado para trabajar en entornos multihilo para en 
     * caso de ser necesario se comparta la misma instancia en diferentes hilos.
     * 
     * @return Instancia de la configuracion guardada
     */
    public Pozo getInstance() {
        if (instance == null) {
            synchronized (PozoST.class) {
                if (instance == null) {
                    instance = new Pozo();
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
    public void setInstance(Pozo newInstance){
        PozoST.instance = newInstance;
    }
    
}
