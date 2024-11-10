/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

/**
 *
 * @author Dell
 * @param <T>
 */
public class FilterDomino<T> {
    protected T mensajeProcesado;

    // Método que puede ser sobreescrito en subclases para procesar el mensaje
    public void procesar(T mensaje) {
        mensajeProcesado = mensaje; // Comportamiento por defecto (si es necesario)
    }

    // Método para obtener el mensaje procesado
    public T getMensaje() {
        return mensajeProcesado;
    }
}
