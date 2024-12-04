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
    private static Mediador instance; // Instancia única de Mediador

    // Método para obtener la instancia única
    public Mediador getInstance() {
        // Verificación rápida (sin bloqueo)
        if (instance == null) {
            // Bloque sincronizado para crear la instancia de manera segura en entornos multihilo
            synchronized (Mediador.class) {
                // Verificación doble para asegurar que solo un hilo cree la instancia
                if (instance == null) {
                    instance = new Mediador(); // Crear la instancia de Mediador si aún no existe
                }
            }
        }
        return instance; // Devolver la instancia única de Mediador
    }
}
