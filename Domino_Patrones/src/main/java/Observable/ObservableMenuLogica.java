/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observable;

import Observer.ObserverMenuLogica;
import Observer.Vista.ObserverFrmWelcomeView;

/**
 *
 * @author skevi
 */
public interface ObservableMenuLogica {
    public void registrarObservador(ObserverMenuLogica o);
    public void registrarObservadorView(ObserverFrmWelcomeView o);
    public void notificar(Object objecto);
}
