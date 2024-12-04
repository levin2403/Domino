/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mediator;

import Observable.ObservableMenuLogica;
import Observer.ObserverEstablecerConfiguracion;
import Observer.ObserverLobby;
import Observer.ObserverMenuLogica;
import Observer.ObserverRealizarJugada;
import Observer.ObserverRegistrarJugador;
import Observer.ObserverTerminarPartida;
import javax.swing.JFrame;
import org.itson.domino.lobby.mvc.FrmLobbyController;
import org.itson.domino.lobby.mvc.FrmLobbyModel;
import org.itson.domino.lobby.mvc.FrmLobbyView;
import org.itson.domino.managers.AvatarManager;
import org.itson.domino.matchEndingRequest.mvc.FrmMatchEndingRequestController;
import org.itson.domino.matchEndingRequest.mvc.FrmMatchEndingRequestModel;
import org.itson.domino.matchEndingRequest.mvc.FrmMatchEndingRequestView;
import org.itson.domino.matchOngoing.mvc.FrmMatchOngoingController;
import org.itson.domino.matchOngoing.mvc.FrmMatchOngoingModel;
import org.itson.domino.matchOngoing.mvc.FrmMatchOngoingView;
import org.itson.domino.matchSettings.mvc.FrmMatchSettingsController;
import org.itson.domino.matchSettings.mvc.FrmMatchSettingsModel;
import org.itson.domino.matchSettings.mvc.FrmMatchSettingsView;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsController;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsModel;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsView;
import org.itson.domino.welcome.mvc.FrmWelcomeController;
import org.itson.domino.welcome.mvc.FrmWelcomeModel;
import org.itson.domino.welcome.mvc.FrmWelcomeView;

/**
 *
 * @author skevi
 */

public class Mediador {

    // Constructor de la clase Mediador
    public Mediador() {
    }

    /**
     * Muestra la pantalla de bienvenida y registra el observador.
     * @param observerMenuLogica El observador para la pantalla de bienvenida.
     * @return El modelo observable de la pantalla de bienvenida.
     */
    public ObserverMenuLogica showFrmWelcome(ObserverMenuLogica observerMenuLogica) {
        FrmWelcomeModel model = new FrmWelcomeModel(); 
        model.registrarObservador(observerMenuLogica);
        FrmWelcomeController controller = new FrmWelcomeController(model);
        controller.mostrarPantalla();
        return model.getObservable();
    }

    /**
     * Muestra la pantalla de configuración de la partida y registra el observador.
     * @param o El observador para la configuración de la partida.
     * @return El modelo observable de la pantalla de configuración de la partida.
     */
    public ObserverEstablecerConfiguracion showFrmMatchSettings(ObserverEstablecerConfiguracion o) {
        FrmMatchSettingsModel model = new FrmMatchSettingsModel();
        FrmMatchSettingsView view = new FrmMatchSettingsView(model);
        model.registrarObservador(o);
        model.setObserverView(view); 
        FrmMatchSettingsController controller = new FrmMatchSettingsController(model ,view);
        controller.mostrarPantalla();
        return model.getObservable();
    }

    /**
     * Muestra la pantalla de configuración del jugador y registra el observador.
     * @param observer El observador para la configuración del jugador.
     * @return El modelo observable de la pantalla de configuración del jugador.
     */
    public ObserverRegistrarJugador showFrmPlayerSettings(ObserverRegistrarJugador observer) {
        FrmPlayerSettingsView view = new FrmPlayerSettingsView();
        FrmPlayerSettingsModel model = new FrmPlayerSettingsModel();
        model.registrarObservadorVista(view);  // Asigna el observador de vista
        model.registrarObservadorLogica(observer);  // Asigna el observador de lógica
        FrmPlayerSettingsController controller = new FrmPlayerSettingsController(model ,view);
        controller.mostrarPantalla();
        return model.getObservable();
    }

    /**
     * Muestra la pantalla del lobby y registra el observador.
     * @param o El observador para el lobby.
     * @return El modelo observable del lobby.
     */
    public ObserverLobby showFrmLobby(ObserverLobby o) {
        FrmLobbyModel model = new FrmLobbyModel(); 
        FrmLobbyView view = new FrmLobbyView(model);
        model.setObserverView(view);
        model.setObserver(o);
        FrmLobbyController controller = new FrmLobbyController(model ,view);
        System.out.println("Aqui estoooooyyyyyyy");
        controller.mostrarPantalla();
        return model.getObservable();
    }

    /**
     * Muestra la pantalla de la partida en curso y registra el observador.
     * @param o El observador para la partida en curso.
     * @return El modelo observable de la partida en curso.
     */
    public ObserverRealizarJugada showFrmMatchOngoing(ObserverRealizarJugada o) {
        FrmMatchOngoingModel model = new FrmMatchOngoingModel();
        FrmMatchOngoingView view = new FrmMatchOngoingView(model);
        model.setObserverView(view);
        model.setObserver(o);
        FrmMatchOngoingController controller = new FrmMatchOngoingController(model,view);
        controller.abrirPantalla();
        return model.getObservable();
    }

    /**
     * Muestra la pantalla de terminación de la partida y registra el observador.
     * @param o El observador para la terminación de la partida.
     * @return El modelo observable de la terminación de la partida.
     */
    public ObserverTerminarPartida showFrmMatchEndingRequest(ObserverTerminarPartida o) {
        FrmMatchEndingRequestModel model = new FrmMatchEndingRequestModel();
        FrmMatchEndingRequestView view = new FrmMatchEndingRequestView(model);
        model.setObserverView(view);
        model.setObserverTerminarPartidaModel(o);
        FrmMatchEndingRequestController controller = new FrmMatchEndingRequestController(model ,view);
        controller.abrirPantalla();
        return model.getObserverTerminarPartida();
    }
}
