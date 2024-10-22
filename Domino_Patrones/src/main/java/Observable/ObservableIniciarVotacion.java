/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observable;

import Observer.ObserverIniciarVotacion;

/**
 *
 * @author skevi
 */
public interface ObservableIniciarVotacion {
    
    public void registrarObservador(ObserverIniciarVotacion observer);
    public void notificarInicio();
    
}
