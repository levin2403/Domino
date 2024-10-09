/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import Entidades.Pozo;

/**
 *
 * @author Dell
 */
public class GeneracionPozoSingleton {

    private static Pozo instance;


    // Método para obtener la instancia única de Pozo
    public Pozo getPozo() {
        if (instance == null) {
            // Sincronización para asegurar seguridad en multihilo
            synchronized (GeneracionPozoSingleton.class) {
                if (instance == null) {
                    instance = new Pozo();
                }
            }
        }
        return instance;
    }

    public  void setPozo(Pozo pozo) {
        synchronized (GeneracionPozoSingleton.class) {
            instance = pozo;
        }
    }
    
    
}

