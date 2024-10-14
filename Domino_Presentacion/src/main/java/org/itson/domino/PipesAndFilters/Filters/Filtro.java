/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.domino.PipesAndFilters.Filters;

import org.itson.domino.PipesAndFilters.Pipes.Pipe;

/**
 *
 * @author skevi
 * @param <T>
 */
public interface Filtro<T> {
    
    public void ejecutar(T objeto);
    public Pipe getPipe();
    public void setPipe(Pipe pipe);
    
}
