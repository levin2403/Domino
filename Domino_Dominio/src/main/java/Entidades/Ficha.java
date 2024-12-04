
package Entidades;

/**
 * 
 * @author skevi
 * @author RUZZKY
 */
public class Ficha {  
    // Clase que representa una ficha de juego con valores y propiedades adicionales

    private int valorSuperior; // Valor superior de la ficha
    private int valorInferior; // Valor inferior de la ficha
    private Locacion centerLocacion; // Ubicación central de la ficha en el tablero
    private Direccion direccionLado; // Dirección del lado de la ficha
    private Direccion direccionPosicion; // Dirección de posición de la ficha
    private String icon; // Icono gráfico asociado a la ficha

    public Ficha() {  
        // Constructor vacío por defecto
    }

    public Ficha(int valorSuperior, int valorInferior) {  
        // Constructor con valores de la ficha
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
    }

    public Ficha(int valorSuperior, int valorInferior, Locacion centerLocacion) {  
        // Constructor con valores y ubicación central
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
        this.centerLocacion = centerLocacion;
    }

    public Ficha(int valorSuperior, int valorInferior, Locacion centerLocacion, Direccion direccionLado, Direccion direccionPosicion) {  
        // Constructor completo con todos los atributos
        this.valorSuperior = valorSuperior;
        this.valorInferior = valorInferior;
        this.centerLocacion = centerLocacion;
        this.direccionLado = direccionLado;
        this.direccionPosicion = direccionPosicion;
    }

    public int getValorSuperior() {  
        return valorSuperior; // Devuelve el valor superior de la ficha
    }

    public int getValorInferior() {  
        return valorInferior; // Devuelve el valor inferior de la ficha
    }

    public Locacion getCenterLocacion() {  
        return centerLocacion; // Devuelve la ubicación central de la ficha
    }

    public Direccion getDireccionLado() {  
        return direccionLado; // Obtiene la dirección del lado
    }

    public Direccion getDireccionPosicion() {  
        return direccionPosicion; // Obtiene la dirección de posición
    }

    public boolean isMula(Ficha ficha) {  
        // Verifica si la ficha es "mula" (ambos valores son iguales)
        return ficha.valorSuperior == ficha.valorInferior;
    }

    public String getIcon() {  
        return icon; // Devuelve el icono asociado a la ficha
    }

    public void setIcon(String icon) {  
        this.icon = icon; // Establece el icono de la ficha
    }

    @Override
    public int hashCode() {  
        // Genera un código hash único basado en los valores de la ficha
        int hash = 5;
        hash = 89 * hash + this.valorSuperior;
        hash = 89 * hash + this.valorInferior;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {  
        // Compara esta ficha con otro objeto para verificar igualdad
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Ficha other = (Ficha) obj;
        return this.valorSuperior == other.valorSuperior && this.valorInferior == other.valorInferior;
    }

    @Override
    public String toString() {  
        // Representación textual de la ficha
        return "Ficha{" + 
               "valorSuperior=" + valorSuperior + 
               ", valorInferior=" + valorInferior + 
               ", centerLocacion=" + centerLocacion + 
               ", direccionLado=" + direccionLado + 
               ", direccionPosicion=" + direccionPosicion + 
               '}';
    }
}

