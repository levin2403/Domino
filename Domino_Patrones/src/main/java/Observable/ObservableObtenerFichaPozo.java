/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observable;

import Observer.ObserverObtenerFichaPozo;

/**
 *
 * @author Dell
 */
public interface ObservableObtenerFichaPozo {
    
    public void registrarObservador(ObserverObtenerFichaPozo o);
    public void notificarObtencionFicha();
    
}
