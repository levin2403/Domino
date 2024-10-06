/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Dell
 */
public class FichaDTO {
    
    private int valorSuperior; // Valor superior de la ficha
    private int valorInferior; // Valor inferior de la ficha
    private LocacionDTO locacionSuperior;
    private LocacionDTO locacionInferior;
    private DireccionDTO direccion;

    public FichaDTO(int valorSuperior, int valorInferior) {
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
    }

    public FichaDTO(int valorSuperior, int valorInferior, LocacionDTO 
            locacionSuperior, LocacionDTO locacionInferior) {
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
        this.locacionSuperior = locacionSuperior;
        this.locacionInferior = locacionInferior;
    }

    public FichaDTO(int valorSuperior, int valorInferior, LocacionDTO 
            locacionSuperior, LocacionDTO locacionInferior, DireccionDTO direccion) {
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

    public LocacionDTO getLocacionSuperior() {
        return locacionSuperior;
    }

    public LocacionDTO getLocacionInferior() {
        return locacionInferior;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }
    
    public boolean isMula(FichaDTO ficha){
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
