/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.singleton;

import Mediator.Mediador;

/**
 *
 * @author Dell
 */
public class MediadorSingleton {
    private static Mediador instance;

    public Mediador getInstance() {
        if (instance == null) {
            synchronized (Mediador.class) {
                if (instance == null) {
                    instance = new Mediador();
                }
            }
        }
        return instance;
    }
    
    
    
}
