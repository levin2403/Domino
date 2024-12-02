

package DTOs;

import java.io.Serializable;

/**
 *
 * @author Ruzzky
 */
public class JugadaDTO implements Serializable  {
    public JugadorDTO jugador;
    public FichaDTO ficha;
    public boolean izquierda;

    public JugadaDTO(JugadorDTO jugador, FichaDTO ficha, boolean izquierda) {
        this.jugador = jugador;
        this.ficha = ficha;
        this.izquierda = izquierda;
    }

    public boolean isIzquierda() {
        return izquierda;
    }

    public void setIzquierda(boolean izquierda) {
        this.izquierda = izquierda;
    }

    public JugadorDTO getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDTO jugador) {
        this.jugador = jugador;
    }

    public FichaDTO getFicha() {
        return ficha;
    }

    public void setFicha(FichaDTO ficha) {
        this.ficha = ficha;
    }
    
}

