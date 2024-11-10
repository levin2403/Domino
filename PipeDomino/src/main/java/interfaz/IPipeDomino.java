/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import filter.FilterDomino;

/**
 *
 * @author Dell
 * @param <T>
 */
public interface IPipeDomino<T> {
    public void enviar(T mensaje);
    public FilterDomino getFiltro();
    public void setFiltro(FilterDomino filtro);
}
