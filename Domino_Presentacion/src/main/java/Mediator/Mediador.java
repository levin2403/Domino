/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mediator;

import Observer.ObserverMenuLogica;
import Observer.ObserverRegistrarJugador;
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
    
    public ObserverMenuLogica showFrmWelcome(ObserverMenuLogica observerMenuLogica) {
        FrmWelcomeModel model = new FrmWelcomeModel();
        model.registrarObservador(observerMenuLogica);
        FrmWelcomeController controller = new FrmWelcomeController(model);
        controller.mostrarPantalla();
        return model.getObservable();
    }
    
    public void showFrmMatchSettings() {
        FrmMatchSettingsModel model = new FrmMatchSettingsModel();
        FrmMatchSettingsView view = new FrmMatchSettingsView(model);
        FrmMatchSettingsController controller = new FrmMatchSettingsController(model ,view);
        view.setVisible(true);
    }
    
    //Le asignas un observer a este metodo y le pides que te regrese el modelo que se creara dentro (esto para que logica le pueda asignar el observer)
    public void showFrmPlayerSettings(ObserverRegistrarJugador observer) {
        FrmPlayerSettingsView view = new FrmPlayerSettingsView();
        AvatarManager avatarManager = new AvatarManager();
        FrmPlayerSettingsModel model = new FrmPlayerSettingsModel();
        model.registrarObservadorVista(view);//Asignas el observador vista en caso de necesitarlo
        model.registrarObservadorLogica(observer);//le asignas el observador de logica
        FrmPlayerSettingsController controller = new FrmPlayerSettingsController(model ,view);
        view.setVisible(true);
    }
    
    public void showFrmLobby() {
        FrmLobbyModel model = new FrmLobbyModel(); 
        FrmLobbyView view = new FrmLobbyView(model);
        FrmLobbyController controller = new FrmLobbyController(model ,view);
        view.setVisible(true);
    }
    
    public void showFrmMatchOngoing() {
        FrmMatchOngoingModel model = new FrmMatchOngoingModel();
        FrmMatchOngoingView view = new FrmMatchOngoingView(model);
        FrmMatchOngoingController controller = new FrmMatchOngoingController(view, model);
        view.setVisible(true);
    }
    
    public void showFrmMatchEndingRequest() {
        FrmMatchEndingRequestModel model = new FrmMatchEndingRequestModel();
        FrmMatchEndingRequestView view = new FrmMatchEndingRequestView(model);
        FrmMatchEndingRequestController controller = new FrmMatchEndingRequestController(model ,view);
        view.setVisible(true);
    }
    
}
