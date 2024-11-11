package org.itson.domino.playerSettings.mvc;

//import Mediator.Mediador;
import Mediator.Mediador;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsModel;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsView;
import org.itson.domino.singleton.MusicModelSingleton;

public class FrmPlayerSettingsController {

    private FrmPlayerSettingsView view;
    private FrmPlayerSettingsModel model;
    private Mediador mediator;
    private MusicModelSingleton musicModel;

    public FrmPlayerSettingsController(FrmPlayerSettingsModel model, FrmPlayerSettingsView view) {
        this.view = view;
        this.model = model;
        this.mediator = new Mediador();
        this.musicModel = MusicModelSingleton.getInstance();

        setupButtonListeners();
        setupAvatarCarousel();
        updateAvatarDisplay();
    }

    private void setupButtonListeners() {
        view.addContinuarButtonListener(e -> openNextForm());
       // view.addPrevFormButtonListener(e -> openPrevForm());
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
        musicModel.stopCurrentMusic();
        model.registrarJugador();
    }

     public void mostrarPantalla(){
        view.setVisible(true);
    }

    private void navigateToForm(Runnable action) {
        view.dispose();
        action.run();
    }
}
