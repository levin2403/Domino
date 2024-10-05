
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

}
  
