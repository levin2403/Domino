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

    public Pozo getPozo() {
        if (instance == null) {
            instance = new Pozo();
        }
        return instance;
    }

    public void setPozo(Pozo instance) {
        GeneracionPozoSingleton.instance = instance;
    }
}
