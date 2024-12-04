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

    // Constructor que inicializa la vista, modelo, mediador y modelo de música.
    public FrmPlayerSettingsController(FrmPlayerSettingsModel model, FrmPlayerSettingsView view) {
        this.view = view;
        this.model = model;
        this.mediator = new Mediador();
        this.musicModel = MusicModelSingleton.getInstance();

        // Configura los escuchadores de los botones y el carrusel de avatares.
        setupButtonListeners();
        setupAvatarCarousel();
        updateAvatarDisplay();
    }

    // Configura los escuchadores de los botones.
    private void setupButtonListeners() {
        view.addContinuarButtonListener(e -> openNextForm());
        // Se puede agregar el botón de navegación anterior si se requiere.
        // view.addPrevFormButtonListener(e -> openPrevForm());
    }

    // Configura el carrusel de avatares, permitiendo avanzar y retroceder en los avatares.
    private void setupAvatarCarousel() {
        view.addNextAvatarListener(e -> {
            String avatarPath = model.nextAvatar(); // Obtiene el siguiente avatar.
            view.updateAvatarDisplay(avatarPath); // Actualiza la vista con el nuevo avatar.
        });
        view.addPrevAvatarListener(e -> {
            String avatarPath = model.previousAvatar(); // Obtiene el avatar anterior.
            view.updateAvatarDisplay(avatarPath); // Actualiza la vista con el nuevo avatar.
        });
    }

    // Actualiza la vista con la imagen del avatar seleccionado actualmente.
    private void updateAvatarDisplay() {
        String avatarPath = model.getSelectedAvatarPath(); // Obtiene la ruta del avatar seleccionado.
        view.updateAvatarDisplay(avatarPath); // Muestra el avatar en la vista.
    }

    // Guarda las configuraciones del jugador, como el nombre.
    private void savePlayerSettings() {
        model.setPlayerName(view.getPlayerName()); // Establece el nombre del jugador.
    }

    // Abre el siguiente formulario después de guardar los ajustes.
    private void openNextForm() {
        savePlayerSettings(); // Guarda los ajustes del jugador.
        musicModel.stopCurrentMusic(); // Detiene la música actual.
        model.registrarJugador(); // Registra al jugador en el modelo.
    }

    // Muestra la pantalla del formulario de configuración del jugador.
    public void mostrarPantalla(){
        view.setVisible(true);
    }

    // Navega a otro formulario y cierra la vista actual.
    private void navigateToForm(Runnable action) {
        view.dispose(); // Cierra la vista actual.
        action.run(); // Ejecuta la acción proporcionada.
    }
}
