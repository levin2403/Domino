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
    private int conectado;
    private LocacionDTO centerLocacion; // Locacion de la primera parte
    private DireccionDTO direccionLado; // Locacion de la segunda parte
    private DireccionDTO direccionPosicion; // Direccion de la ficha(Orientacion)
    private String icon;

    /**
     * Construcor por defecto
     */
    public FichaDTO() {
    }

    public int getConectado() {
        return conectado;
    }

    public void setConectado(int conectado) {
        this.conectado = conectado;
    }

    /**
     * Constructor que inicializa los valores de la ficha.
     *
     * @param valorSuperior Valor superior de la ficha
     * @param valorInferior Valor inferior de la ficha
     */
    public FichaDTO(int valorSuperior, int valorInferior) {
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
    }

    /**
     * Constructor que inicializa todos los atributos de la clase.
     *
     * @param valorSuperior Valor superior de la ficha
     * @param valorInferior Valor inferior de la ficha
     * @param centerLocacion Locacion de la primera parte
     * @param direccionLado Locacion de la segunda parte
     * @param direccionPosicion Direccion de la ficha(Orientacion)
     */
    public FichaDTO(int valorSuperior, int valorInferior,
            LocacionDTO centerLocacion, DireccionDTO direccionLado,
            DireccionDTO direccionPosicion) {
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
        this.centerLocacion = centerLocacion;
        this.direccionLado = direccionLado;
        this.direccionPosicion = direccionPosicion;
    }

    //Getter y Setters
    public int getValorSuperior() {
        return valorSuperior;
    }

    public void setValorSuperior(int valorSuperior) {
        this.valorSuperior = valorSuperior;
    }

    public void setValorInferior(int valorInferior) {
        this.valorInferior = valorInferior;
    }

    public void setCenterLocacion(LocacionDTO centerLocacion) {
        this.centerLocacion = centerLocacion;
    }

    public void setDireccionLado(DireccionDTO direccionLado) {
        this.direccionLado = direccionLado;
    }

    public void setDireccionPosicion(DireccionDTO direccionPosicion) {
        this.direccionPosicion = direccionPosicion;
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

    public boolean isMula(FichaDTO ficha) {
        return ficha.valorSuperior == ficha.valorInferior;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.valorSuperior;
        hash = 37 * hash + this.valorInferior;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FichaDTO other = (FichaDTO) obj;
        if (this.valorSuperior != other.valorSuperior) {
            return false;
        }
        return this.valorInferior == other.valorInferior;
    }

    @Override
    public String toString() {
        return "FichaDTO{" + "valorSuperior=" + valorSuperior
                + ", valorInferior=" + valorInferior + ", centerLocacion="
                + centerLocacion + ", direccionLado=" + direccionLado
                + ", direccionPosicion=" + direccionPosicion + '}';
    }
}
