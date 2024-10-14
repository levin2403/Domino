/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class FichaDTO implements Serializable {
    
    private int valorSuperior; // Valor superior de la ficha
    private int valorInferior; // Valor inferior de la ficha
    private LocacionDTO centerLocacion;
    private DireccionDTO direccionLado;
    private DireccionDTO direccionPosicion;

    public FichaDTO(int valorSuperior, int valorInferior) {
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
    }

    public FichaDTO(int valorSuperior, int valorInferior, LocacionDTO centerLocacion) {
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
        this.centerLocacion = centerLocacion;
    }

    public FichaDTO(int valorSuperior, int valorInferior, LocacionDTO centerLocacion, DireccionDTO direccionLado, DireccionDTO direccionPosicion) {
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
        this.centerLocacion = centerLocacion;
        this.direccionLado = direccionLado;
        this.direccionPosicion = direccionPosicion;
    }
    
    public int getValorSuperior() {
        return valorSuperior;
    }

    public int getValorInferior() {
        return valorInferior;
    }

    public LocacionDTO getCenterLocacion() {
        return centerLocacion;
    }

    public DireccionDTO getDireccionLado() {
        return direccionLado;
    }

    public DireccionDTO getDireccionPosicion() {
        return direccionPosicion;
    }
    
    public boolean isMula(FichaDTO ficha){
        return ficha.valorSuperior == ficha.valorInferior;    
    }

    @Override
    public String toString() {
        return "FichaDTO{" + "valorSuperior=" + valorSuperior + ", valorInferior=" + valorInferior + ", centerLocacion=" + centerLocacion + ", direccionLado=" + direccionLado + ", direccionPosicion=" + direccionPosicion + '}';
    }

    
    
}
