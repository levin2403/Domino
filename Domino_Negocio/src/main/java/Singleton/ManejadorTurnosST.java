/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

import Logica.ManejadorTurnos;

/**
 *
 * @author skevi
 */
public class ManejadorTurnosST {
    
    private static ManejadorTurnos instance;
    
    public ManejadorTurnos getInstance() {
        if (instance == null) {
            synchronized (JugadorRegistrado.class) {
                if (instance == null) {
                    instance = new ManejadorTurnos();
                }
            }
        }
        return instance;
    }

    public void setInstance(ManejadorTurnos instance) {
        ManejadorTurnosST.instance = instance;
    }    
    
    
}
