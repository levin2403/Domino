package org.itson.domino.playerSettings.mvc;

import org.itson.domino.mediator.FormMediator;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsModel;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsView;
import org.itson.domino.singleton.MusicModelSingleton;


public class FrmPlayerSettingsController {

    private FrmPlayerSettingsView view;
    private FrmPlayerSettingsModel model;
    private FormMediator mediator;
    private MusicModelSingleton musicModel;

    public FrmPlayerSettingsController(FrmPlayerSettingsView view, FrmPlayerSettingsModel model, FormMediator mediator) {
        this.view = view;
        this.model = model;
        this.mediator = mediator;
        this.musicModel = MusicModelSingleton.getInstance();

        setupButtonListeners();
        setupAvatarCarousel();
        updateAvatarDisplay();
    }

    private void setupButtonListeners() {
        view.addNextFormButtonListener(e -> openNextForm());
        view.addPrevFormButtonListener(e -> openPrevForm());
    }

        private void setupAvatarCarousel() {
            view.addNextAvatarListener(e -> {
                String avatarPath = model.nextAvatar();
                view.updateAvatarDisplay(avatarPath);
            });
            view.addPrevAvatarListener(e -> {
                String avatarPath = model.previousAvatar();
                view.updateAvatarDisplay(avatarPath);
            });
        }

        private void updateAvatarDisplay() {
            String avatarPath = model.getSelectedAvatarPath();
            view.updateAvatarDisplay(avatarPath);
        }


    private void savePlayerSettings() {
        model.setPlayerName(view.getPlayerName());
    }

    private void openNextForm() {
        savePlayerSettings();
        model.saveSettings();
        musicModel.stopCurrentMusic();
        navigateToForm(mediator::showFrmLobby);
    }

    private void openPrevForm() {
        savePlayerSettings();
        model.saveSettings();
        navigateToForm(mediator::showFrmMatchSettings);
    }

    private void navigateToForm(Runnable action) {
        view.dispose();
        action.run();
    }
}
