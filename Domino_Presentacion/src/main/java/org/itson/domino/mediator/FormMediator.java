/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.mediator;

import org.itson.domino.lobby.mvc.FrmLobbyController;
import org.itson.domino.lobby.mvc.FrmLobbyView;
import org.itson.domino.managers.AvatarManager;
import org.itson.domino.matchOngoing.mvc.FrmMatchOngoingController;
import org.itson.domino.matchOngoing.mvc.FrmMatchOngoingView;
import org.itson.domino.matchSettings.mvc.FrmMatchSettingsController;
import org.itson.domino.matchSettings.mvc.FrmMatchSettingsModel;
import org.itson.domino.matchSettings.mvc.FrmMatchSettingsView;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsController;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsModel;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsView;
import org.itson.domino.welcome.mvc.FrmWelcomeController;
import org.itson.domino.welcome.mvc.FrmWelcomeView;

/**
 *
 * @author gamaliel
 */
public class FormMediator {
    public void showFrmWelcome(){
        FrmWelcomeView view = new FrmWelcomeView();
        FrmWelcomeController controller = new FrmWelcomeController(view, this);
        view.setVisible(true);
    }
    
    public void showFrmMatchSettings() {
        FrmMatchSettingsView view = new FrmMatchSettingsView();
        FrmMatchSettingsModel model = new FrmMatchSettingsModel();
        FrmMatchSettingsController controller = new FrmMatchSettingsController(view, model, this);
        view.setVisible(true);
    }
    
    public void showFrmPlayerSettings() {
        FrmPlayerSettingsView view = new FrmPlayerSettingsView();
        AvatarManager avatarManager = new AvatarManager();
        FrmPlayerSettingsModel model = new FrmPlayerSettingsModel(avatarManager);
        FrmPlayerSettingsController controller = new FrmPlayerSettingsController(view, model, this);
        view.setVisible(true);
    }
    
    public void showFrmLobby() {
        FrmLobbyView viewLobby = new FrmLobbyView();
        FrmLobbyController controllerLobby = new FrmLobbyController(viewLobby, this);
        viewLobby.setVisible(true);
    }
    public void showFrmMatchOngoing() {
        FrmMatchOngoingView viewMatchOngoing = new FrmMatchOngoingView();
        FrmMatchOngoingController controllerMatchOngoing = new FrmMatchOngoingController(viewMatchOngoing, this);
        viewMatchOngoing.setVisible(true);
    }
}
