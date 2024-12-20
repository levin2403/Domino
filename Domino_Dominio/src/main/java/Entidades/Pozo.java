/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Define el pozo del juego en el cual durante la ejecucion sera el encargado de
 * la reparticion de las fichas, al igual que de donde los jugadores obtendran
 * sus fichas extras durante el juego.
 * 
 * @author skevi
 */
public class Pozo {

    // Atributo que tendra todas las fichas dadas por el jugador 
    private List<Ficha> pozo;
    private FabricaFichas fabricaFichas;

    public Pozo() {
        // instanciamos a la fabrica de fichas
        this.fabricaFichas = new FabricaFichas();
        // le agregamos al pozo las fichas fabricadas 
        pozo = fabricaFichas.crearFichas();
    }

    public List<Ficha> getPozo() {
        return pozo;
    }

    /**
     * Obtiene un número determinado de fichas aleatorias del pozo,
     * posteriormente elimina las fichas obtenidas del pozo para mantener
     * consistencia con las fichas disponibles en el pozo.
     *
     * @param numero Número de fichas a obtener del pozo.
     * @return Lista de fichas extraídas del pozo.
     */
    public void setPozo(List<Ficha> pozo) {
        this.pozo = pozo;
    }

    public boolean quitarFicha(Ficha ficha) {
        // Verificamos si la ficha está en el pozo
        if (pozo.contains(ficha)) {
            pozo.remove(ficha); // Eliminar la ficha del pozo
            return true; // Indicar que la eliminación fue exitosa
        }
        return false; // Si la ficha no está en el pozo, retornamos false
    }

    public List<Ficha> obtenerFichas(byte numero) {
        // Lista temporal para almacenar las fichas
        List<Ficha> fichasObtenidas = new ArrayList<>();

        // Mezclamos el pozo 
        Collections.shuffle(pozo);

        for (int i = 0; i < numero; i++) {
            Ficha ficha = pozo.remove(0);
            fichasObtenidas.add(ficha);
        }

        return fichasObtenidas;
    }

    /**
     * Método que devuelve una ficha aleatoria del pozo y la elimina para
     * mantener la consistencia con la existencia de las fichas.
     *
     * @return La ficha extraída del pozo o null si no hay fichas disponibles.
     */
    public Ficha obtenerFicha() {
        //retornamos null en caso de que el poso este vacio.
        if (pozo.isEmpty()) {
            return null;
        }

        // Mezclamos el pozo para obtener una ficha aleatoria
        Collections.shuffle(pozo);

        // Eliminamos y retornamos la primera ficha
        return pozo.remove(0);
    }

    /**
     * Metodo para obtener el numero de fichas restantes en el pozo.
     *
     * @return Numero de fichas restantes en el pozo.
     */
    public int fichasDisponibles() {
        if (pozo == null) {
            return 0;
        }
        return pozo.size();
    }

    /**
     * Metodo que devuelve las fichas restantes de un jugador en caso de que
     * haya abandonado la partida.
     *
     * @param fichas
     */
    public void devolverFichas(List<Ficha> fichas) {
        // Agregamos las fichas devueltas al pozo
        pozo.addAll(fichas);
    }

}