/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observable;

import Observer.ObserverSocket;

/**
 *
 * @author skevi
 */
public interface ObservableSocket {
   // public void update(Object evento);
    
    //misokets 
    public void registrarObserver(Class<?> tipoEvento, ObserverSocket observer);
     public void notificarObserver(String  Json);

}
