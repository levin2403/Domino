/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Observer.ObserverSocket;
import Observer.ObserverTerminarPartida;
import Socket.Cliente;
import fachada.Fachada;
import fachadas.IFachada;

/**
 *
 * @author Dell
 */
public class LogicaTerminarPartida implements ObserverSocket{
    IFachada fachada;
    
    private volatile static LogicaTerminarPartida instance;
    
    ObserverTerminarPartida observerTerminarPartida = new ObserverTerminarPartida() {
        @Override
        public void actualizarTerminarPartida(Object objecto) {
            
            
        }
    };
    ObserverTerminarPartida observerTerminarPartidaModel;

    public ObserverTerminarPartida getObserverTerminarPartidaModel() {
        return observerTerminarPartidaModel;
    }
     public void mostrarPantalla() {
        this.observerTerminarPartidaModel = fachada.showFrmMatchEndingRequest(observerTerminarPartida);
    }
    public void setObserverTerminarPartidaModel(ObserverTerminarPartida observerTerminarPartidaModel) {
        this.observerTerminarPartidaModel = observerTerminarPartidaModel;
    }

    public ObserverTerminarPartida getObserverTerminarPartida() {
        return observerTerminarPartida;
    }

    public void setObserverTerminarPartida(ObserverTerminarPartida observerTerminarPartida) {
        this.observerTerminarPartida = observerTerminarPartida;
    }
    public void avisar(Object objecto) {
        observerTerminarPartidaModel.actualizarTerminarPartida(objecto);
        
    }    
    
    public static synchronized LogicaTerminarPartida getInstance() {
        if (instance == null) {
            instance = new LogicaTerminarPartida();
        }
        return instance;
    }
    
    public LogicaTerminarPartida() {
        this.fachada = Fachada.getFachada();
        Cliente cliente = Cliente.getInstance();
      
    }
    @Override
    public void update(Object evento) {
        
     }
    
}
