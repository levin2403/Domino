/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observable;

import Observer.ObserverRegistrarJugador;
import Observer.Vista.ObserverFrmPlayerSettingsView;

/**
 *
 * @author skevi
 */
public interface ObservableRegistrarJugador {
    
    public void registrarObservadorLogica(ObserverRegistrarJugador o);
    public void registrarObservadorVista(ObserverFrmPlayerSettingsView o);
    public void notificarRegistro();
    
    
}
