/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observer;

/**
 * Interface que representa el rol de un observador en el patrón Observer.
 * Un observador es notificado de cambios en el estado de un objeto sujeto
 * al que está registrado.
 *
 * @author skevi
 */
public interface IObserver {
    
    /**
     * Método que es llamado para notificar al observador de cambios.
     * Este método será ejecutado cuando el sujeto al que está suscrito
     * detecte un cambio en su estado.
     */
    void update();
    
}