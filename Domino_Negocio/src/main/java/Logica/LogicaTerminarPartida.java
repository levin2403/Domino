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
public class LogicaTerminarPartida implements ObserverSocket {
    
    // Fachada para acceder a la interfaz del sistema
    IFachada fachada;
    
    // Instancia única de LogicaTerminarPartida (Singleton)
    private volatile static LogicaTerminarPartida instance;

    // Observer para manejar la terminación de la partida
    ObserverTerminarPartida observerTerminarPartida = new ObserverTerminarPartida() {
        @Override
        public void actualizarTerminarPartida(Object objecto) {
            // Método para manejar la actualización de la terminación de la partida
            // En este caso, no tiene lógica implementada
        }
    };
    
    // Modelo del observer de la terminación de la partida
    ObserverTerminarPartida observerTerminarPartidaModel;

    // Getter para obtener el modelo del observer de la terminación de la partida
    public ObserverTerminarPartida getObserverTerminarPartidaModel() {
        return observerTerminarPartidaModel;
    }

    // Método para mostrar la pantalla de finalización de la partida
    public void mostrarPantalla() {
        // Muestra la pantalla de terminación de la partida utilizando la fachada
        this.observerTerminarPartidaModel = fachada.showFrmMatchEndingRequest(observerTerminarPartida);
    }

    // Setter para establecer el modelo del observer de la terminación de la partida
    public void setObserverTerminarPartidaModel(ObserverTerminarPartida observerTerminarPartidaModel) {
        this.observerTerminarPartidaModel = observerTerminarPartidaModel;
    }

    // Getter para obtener el observer de la terminación de la partida
    public ObserverTerminarPartida getObserverTerminarPartida() {
        return observerTerminarPartida;
    }

    // Setter para establecer el observer de la terminación de la partida
    public void setObserverTerminarPartida(ObserverTerminarPartida observerTerminarPartida) {
        this.observerTerminarPartida = observerTerminarPartida;
    }

    // Método para notificar al observer de la terminación de la partida
    public void avisar(Object objecto) {
        // Llama al método de actualización del observer de la terminación de la partida
        observerTerminarPartidaModel.actualizarTerminarPartida(objecto);
    }

    // Método para obtener la instancia única de LogicaTerminarPartida (Singleton)
    public static synchronized LogicaTerminarPartida getInstance() {
        if (instance == null) {
            instance = new LogicaTerminarPartida();
        }
        return instance;
    }

    /**
     * Constructor que inicializa la clase y registra al cliente en el sistema.
     */
    public LogicaTerminarPartida() {
        this.fachada = Fachada.getFachada();  // Obtiene la instancia de Fachada
        Cliente cliente = Cliente.getInstance();  // Obtiene la instancia de Cliente
    }

    // Método para manejar actualizaciones de eventos (no implementado en esta clase)
    @Override
    public void update(Object evento) {
        // Aquí no se implementa la lógica de manejo de eventos
    }
}
