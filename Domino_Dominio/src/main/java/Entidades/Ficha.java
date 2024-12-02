
package Entidades;

/**
 * 
 * @author skevi
 * @author RUZZKY
 */
public class Ficha {
    
    private int valorSuperior; // Valor superior de la ficha
    private int valorInferior; // Valor inferior de la ficha
    private Locacion centerLocacion;
    private Direccion direccionLado;
    private Direccion direccionPosicion;
    private String icon;

    public Ficha() {
    }
            
    public Ficha(int valorSuperior, int valorInferior) {
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
    }

    public Ficha(int valorSuperior, int valorInferior, Locacion 
            centerLocacion) {
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
        this.centerLocacion = centerLocacion;
    }

    public Ficha(int valorSuperior, int valorInferior, Locacion centerLocacion, Direccion direccionLado, Direccion direccionPosicion) {
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

    public Locacion getCenterLocacion() {
        return centerLocacion;
    }

    public Direccion getDireccionLado() {
        return direccionLado;
    }

    public Direccion getDireccionPosicion() {
        return direccionPosicion;
    }
    
    public boolean isMula(Ficha ficha){
        return ficha.valorSuperior == ficha.valorInferior;    
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
   /**
     * Compara esta ficha con otro objeto para determinar su igualdad.
     * 
     * Este método sobrescribe el método para definir
     * la igualdad basada en los valores valorSuperior y valorInferior.

     * @return code true si code obj es una instancia de code Ficha y
     *         ambos valores superiores e inferiores son iguales; 
     * code false  en caso contrario.
     */ 
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.valorSuperior;
        hash = 89 * hash + this.valorInferior;
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
        final Ficha other = (Ficha) obj;
        if (this.valorSuperior != other.valorSuperior) {
            return false;
        }
        return this.valorInferior == other.valorInferior;
    }


    @Override
    public String toString() {
        return "Ficha{" + "valorSuperior=" + valorSuperior + ", valorInferior=" + valorInferior + ", centerLocacion=" + centerLocacion + ", direccionLado=" + direccionLado + ", direccionPosicion=" + direccionPosicion + '}';
    }

    
    
    

}
  
