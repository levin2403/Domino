/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mediator;

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
    
    public void showFrmWelcome(){
        FrmWelcomeModel model = new FrmWelcomeModel();
        FrmWelcomeView view = new FrmWelcomeView(model);
        FrmWelcomeController controller = new FrmWelcomeController(model, view);
        view.setVisible(true);
    }
    
    public void showFrmMatchSettings() {
        FrmMatchSettingsModel model = new FrmMatchSettingsModel();
        FrmMatchSettingsView view = new FrmMatchSettingsView(model);
        FrmMatchSettingsController controller = new FrmMatchSettingsController(model ,view);
        view.setVisible(true);
    }
    
    public void showFrmPlayerSettings() {
        FrmPlayerSettingsView view = new FrmPlayerSettingsView();
        AvatarManager avatarManager = new AvatarManager();
        FrmPlayerSettingsModel model = new FrmPlayerSettingsModel();
        model.registrarObservadorVista(view);
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
