/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observer;

/**
 * Interface que define el comportamiento de un objeto observable en el patrón Observer.
 * Un objeto que implementa esta interfaz puede tener uno o más observadores que 
 * serán notificados cuando se produzcan cambios en su estado.
 * 
 * @author skevi
 */
public interface IObservable {

    /**
     * Registra un observador para que sea notificado de los cambios 
     * en el estado del objeto observable.
     * 
     * @param O Observador a añadir. Debe implementar la interfaz IObserver.
     */
    void addObserver(IObserver O);

    /**
     * Elimina un observador previamente registrado, impidiendo que 
     * siga recibiendo notificaciones de cambios.
     * 
     * @param o Observador a eliminar. Debe haber sido previamente añadido.
     */
    void deleteObserver(IObserver o);

    /**
     * Notifica a todos los observadores registrados sobre un cambio o evento
     * ocurrido en el objeto observable. Cada observador ejecutará su método 
     * update en respuesta a esta notificación.
     */
    void notifyObservers();

}
