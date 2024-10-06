
package Entidades;

/**
 *
 * @author skevi
 * @author RUZZKY
 */
public class Ficha {
    
    private int valorSuperior; // Valor superior de la ficha
    private int valorInferior; // Valor inferior de la ficha
    private Locacion locacionSuperior;
    private Locacion locacionInferior;
    private Direccion direccion;

    public Ficha(int valorSuperior, int valorInferior) {
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
    }

    public Ficha(int valorSuperior, int valorInferior, Locacion 
            locacionSuperior, Locacion locacionInferior) {
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
        this.locacionSuperior = locacionSuperior;
        this.locacionInferior = locacionInferior;
    }

    public Ficha(int valorSuperior, int valorInferior, Locacion 
            locacionSuperior, Locacion locacionInferior, Direccion direccion) {
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
        this.locacionSuperior = locacionSuperior;
        this.locacionInferior = locacionInferior;
        this.direccion = direccion;
    }
    
    public int getValorSuperior() {
        return valorSuperior;
    }

    public int getValorInferior() {
        return valorInferior;
    }

    public Locacion getLocacionSuperior() {
        return locacionSuperior;
    }

    public Locacion getLocacionInferior() {
        return locacionInferior;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    
    public boolean isMula(Ficha ficha){
        return ficha.valorSuperior == ficha.valorInferior;    
    }

    @Override
    public String toString() {
        return "Ficha{" + "valorSuperior=" + valorSuperior + 
                ", valorInferior=" + valorInferior + ", locacionSuperior=" + 
                locacionSuperior + ", locacionInferior=" + locacionInferior + 
                ", direccion=" + direccion + '}';
    }
    
    

}
  
