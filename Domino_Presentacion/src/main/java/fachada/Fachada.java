/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import Mediator.Mediador;
import Observer.ObserverEstablecerConfiguracion;
import Observer.ObserverLobby;
import Observer.ObserverMenuLogica;
import Observer.ObserverRealizarJugada;
import Observer.ObserverRegistrarJugador;
import Observer.ObserverTerminarPartida;
import fachadas.IFachada;
import org.itson.domino.singleton.MediadorSingleton;

/**
 * Aqui tenemos que poner tambien los metodos necesarios para que logica se comunique con presentacion al momento de que le llegue info del server
 * Y esta fachada es entre logica y presentacion, ocupamos hacer otra fachada para las comunicaciones.
 * @author Dell
 */

public class Fachada implements IFachada {

    // Instancia del Mediador para gestionar las pantallas
    Mediador mediador;

    // Instancia estática de Fachada (Singleton)
    private static Fachada fachada;

    /**
     * Constructor privado que inicializa el mediador utilizando el Singleton de Mediador.
     */
    private Fachada() {
        MediadorSingleton mS = new MediadorSingleton();
        mediador = mS.getInstance();
    }

    /**
     * Muestra la pantalla de bienvenida y pasa el observador.
     * @param observerMenuLogica El observador para la pantalla de bienvenida.
     * @return El modelo observable de la pantalla de bienvenida.
     */
    @Override
    public ObserverMenuLogica showFrmWelcome(ObserverMenuLogica observerMenuLogica) {
        return mediador.showFrmWelcome(observerMenuLogica);
    }

    /**
     * Muestra la pantalla de configuración de la partida y pasa el observador.
     * @param o El observador para la configuración de la partida.
     * @return El modelo observable de la pantalla de configuración de la partida.
     */
    @Override
    public ObserverEstablecerConfiguracion showFrmMatchSettings(ObserverEstablecerConfiguracion o) {
        return mediador.showFrmMatchSettings(o);
    }

    /**
     * Muestra la pantalla de configuración del jugador y pasa el observador.
     * @param observer El observador para la configuración del jugador.
     * @return El modelo observable de la pantalla de configuración del jugador.
     */
    @Override
    public ObserverRegistrarJugador showFrmPlayerSettings(ObserverRegistrarJugador observer) {
        return mediador.showFrmPlayerSettings(observer);
    }

    /**
     * Muestra la pantalla del lobby y pasa el observador.
     * @param l El observador para el lobby.
     * @return El modelo observable del lobby.
     */
    @Override
    public ObserverLobby showFrmLobby(ObserverLobby l) {
        return mediador.showFrmLobby(l);
    }

    /**
     * Muestra la pantalla de la partida en curso y pasa el observador.
     * @param O El observador para la partida en curso.
     * @return El modelo observable de la partida en curso.
     */
    @Override
    public ObserverRealizarJugada showFrmMatchOngoing(ObserverRealizarJugada O) {
        return mediador.showFrmMatchOngoing(O);
    }

    /**
     * Muestra la pantalla de terminación de la partida y pasa el observador.
     * @param o El observador para la terminación de la partida.
     * @return El modelo observable de la terminación de la partida.
     */
    @Override
    public ObserverTerminarPartida showFrmMatchEndingRequest(ObserverTerminarPartida o) {
        return mediador.showFrmMatchEndingRequest(o);
    }

    /**
     * Método estático para obtener la instancia única de Fachada (Singleton).
     * @return La instancia única de Fachada.
     */
    public static IFachada getFachada() {
        if (fachada == null) {
            fachada = new Fachada();
        }
        return fachada;
    }
}
