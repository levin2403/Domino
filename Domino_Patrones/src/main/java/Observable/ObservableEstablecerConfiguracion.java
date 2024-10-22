/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observable;

import Observer.ObserverEstablecerConfiguracion;

/**
 *
 * @author skevi
 */
public interface ObservableEstablecerConfiguracion {
    
    public void registrarObservador(ObserverEstablecerConfiguracion o);
    public void notificarConfiguracion();
    
}
