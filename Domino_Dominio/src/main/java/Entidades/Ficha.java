
package Entidades;

/**
 *
 * @author skevi
 * @author RUZZKY
 */
public class Ficha {
  
    // Atributos protegidos para la visibilidad en el mismo paquete y en subclases.
    //LOS PROTECTED SIRVEN MAS QUE LOS PRIVADE YA QUE LOS PROTECTED ES PARA QUE SEA MÁS ACCESIBLE DENTRO DEL MISMO PAQUETE 
    //Y DESDE SUBCLASE INCLUSO EN DIFERENTES PAQUETES 
    protected String imagen;      // esta es como la imagen visual
    protected int puntoAbajo;     // parte que señala pa donde
    protected int puntoArriba;    // parte que señala pa donde
    protected boolean mula;       // Indica si la ficha es mula

    // por defecto
    public Ficha() { 
        // Constructor vacío.
    }

    public Ficha(int puntoAbajo, int puntoArriba) {
        this.puntoAbajo = puntoAbajo;
        this.puntoArriba = puntoArriba;
    }

    // Constructor que inicializa los valores de la ficha.
    //la imagen y los puntos en los extremos a donde va dirigida la ficha.
    // y con este se debe de determinar si la ficha es mula
    public Ficha(String imagen, int puntoAbajo, int puntoArriba) {
        this.imagen = imagen;                // Asigna la imagen
        this.puntoAbajo = puntoAbajo;        
        this.puntoArriba = puntoArriba;     
        this.mula = (puntoAbajo == puntoArriba); // si los extremos son iguales es mula 
    }

    // Método para obtener la imagen de la ficha.
    public String getImagen() {
        return imagen;
    }

    // Método para asignar una nueva imagen a la ficha.
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    // Método para obtener el valor en la parte inferior de la ficha.
    public int getPuntoAbajo() {
        return puntoAbajo;
    }

    // Método para asignar un nuevo valor a la parte abajo de la ficha.
    public void setPuntoAbajo(int puntoAbajo) {
        this.puntoAbajo = puntoAbajo;
    }

    // Método para obtener el valor en la parte arriba de la ficha.
    public int getPuntoArriba() {
        return puntoArriba;
    }

    // Método para asignar un nuevo valor a la parte superior de la ficha.
    public void setPuntoArriba(int puntoArriba) {
        this.puntoArriba = puntoArriba;
    }

    // Método para verificar si la ficha es "mula".
    public boolean isMula() {
        return mula;
    }

    // Método para establecer si la ficha es mula o no.
    public void setMula(boolean mula) {
        this.mula = mula;
    }
}
  
