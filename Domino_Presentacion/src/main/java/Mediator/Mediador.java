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
    
    public Mediador() {
        
    }
    
    public ObserverMenuLogica showFrmWelcome(ObserverMenuLogica observerMenuLogica){
        FrmWelcomeModel model = new FrmWelcomeModel(); 
        model.registrarObservador(observerMenuLogica);
        FrmWelcomeController controller = new FrmWelcomeController(model);
        controller.mostrarPantalla();
        return model.getObservable();
    }
    
    public ObserverEstablecerConfiguracion showFrmMatchSettings(ObserverEstablecerConfiguracion o) {
        FrmMatchSettingsModel model = new FrmMatchSettingsModel();
        FrmMatchSettingsView view = new FrmMatchSettingsView(model);
        model.registrarObservador(o);
        model.setObserverView(view); 
        FrmMatchSettingsController controller = new FrmMatchSettingsController(model ,view);
        controller.mostrarPantalla();
        return model.getObservable();
    }
    
    //Le asignas un observer a este metodo y le pides que te regrese el modelo que se creara dentro (esto para que logica le pueda asignar el observer)
    public ObserverRegistrarJugador showFrmPlayerSettings(ObserverRegistrarJugador observer) {
        FrmPlayerSettingsView view = new FrmPlayerSettingsView();
        FrmPlayerSettingsModel model = new FrmPlayerSettingsModel();
        model.registrarObservadorVista(view);//Asignas el observador vista en caso de necesitarlo
        model.registrarObservadorLogica(observer);//le asignas el observador de logica
        FrmPlayerSettingsController controller = new FrmPlayerSettingsController(model ,view);
        controller.mostrarPantalla();
        return model.getObservable();
    }
    
    public ObserverLobby showFrmLobby(ObserverLobby o) {
        FrmLobbyModel model = new FrmLobbyModel(); 
        FrmLobbyView view = new FrmLobbyView(model);
        model.setObserverView(view);
        model.setObserver(o);
        FrmLobbyController controller = new FrmLobbyController(model ,view);
        controller.mostrarPantalla();
        return model.getObservable();
    }
    
    public ObserverRealizarJugada showFrmMatchOngoing(ObserverRealizarJugada o) {
        FrmMatchOngoingModel model = new FrmMatchOngoingModel();
        FrmMatchOngoingView view = new FrmMatchOngoingView(model);
        model.setObserverView(view);
        model.setObserver(o);
        FrmMatchOngoingController controller = new FrmMatchOngoingController(model,view);
        controller.abrirPantalla();
        return model.getObservable();
    }
    
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
