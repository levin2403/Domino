/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pipe;

import com.mycompany.filterdomino.FilterDomino;
import interfaz.IPipeDomino;

/**
 *
 * @author Dell
 * @param <T>
 */
public class PipeDomino<T> implements IPipeDomino<T>{
    private FilterDomino filtro;

    public PipeDomino() {
        
    }
    
    @Override
    public void enviar(T mensaje) {     
        filtro.procesar(mensaje);
    }     
   
    @Override
    public FilterDomino getFiltro() {
        return filtro;
    }
  
    @Override
    public void setFiltro(FilterDomino filtro) {
        this.filtro = filtro;
    }
}
