/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

import DTOs.ConfiguracionDTO;

/**
 *
 * @author skevi
 */
public class ConfiguracionInicialST {
    
    //Configuracion estatica
    private static ConfiguracionDTO instance;
    
    /**
     * Metodo para obtener la instancia guardada dentro de la clase, en caso de
     * que la instancia sea nula osea que no se haya creado nunca,
     * devolvera una nueva instancia de ConfiguracionDTO.
     * El metodo esta adapatado para trabajar en entornos multihilo para en 
     * caso de ser necesario se comparta la misma instancia en diferentes hilos.
     * 
     * @return Instancia de la configuracion guardada
     */
    public ConfiguracionDTO getInstance() {
        if (instance == null) {
            synchronized (JugadorRegistrado.class) {
                if (instance == null) {
                    instance = new ConfiguracionDTO();
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
    public void setInstance(ConfiguracionDTO newInstance){
        ConfiguracionInicialST.instance = newInstance;
    }
    
}
