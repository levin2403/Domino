package org.itson.domino.playerSettings.mvc;

import DTOs.PlayerSettingsModelDTO;
import org.itson.domino.managers.AvatarManager;
import Observer.ObserverRegistrarJugador;
import Observable.ObservableRegistrarJugador;
import Observer.Vista.ObserverFrmPlayerSettingsView;

public class FrmPlayerSettingsModel implements ObservableRegistrarJugador {

    private ObserverRegistrarJugador orj; // Observador para registrar al jugador.
    private ObserverFrmPlayerSettingsView observerVista; // Observador de la vista del formulario de configuración del jugador.
    private ObserverRegistrarJugador observable = new ObserverRegistrarJugador() {
        @Override
        public void actualizarRegistrarJugador(Object objecto) {
            observerVista.actualizarVista(objecto); // Actualiza la vista cuando se registra un jugador.
        }
    };
    
    private String playerName; // Nombre del jugador.
    private AvatarManager avatarManager; // Gestor de avatares.

    // Constructor que inicializa el gestor de avatares.
    public FrmPlayerSettingsModel() {
        this.avatarManager = new AvatarManager(); // Inicializa el avatarManager.
    }

    // Establece el nombre del jugador.
    public void setPlayerName(String name) {
        this.playerName = name;
    }

    // Obtiene el nombre del jugador.
    public String getPlayerName() {
        return playerName;
    }

    // Obtiene la ruta del avatar seleccionado.
    public String getSelectedAvatarPath() {
        return avatarManager.getCurrentAvatarPath();
    }

    // Obtiene la ruta del siguiente avatar en el gestor.
    public String nextAvatar() {
        return avatarManager.nextAvatar();
    }

    // Obtiene la ruta del avatar anterior en el gestor.
    public String previousAvatar() {
        return avatarManager.previousAvatar();
    }

    // Registra un observador para la lógica del registro del jugador.
    @Override
    public void registrarObservadorLogica(ObserverRegistrarJugador orj) {
        this.orj = orj;
    }

    // Devuelve el observable de registro de jugador.
    public ObserverRegistrarJugador getObservable() {
        return observable;
    }

    // Establece el observable para el registro de jugador.
    public void setObservable(ObserverRegistrarJugador observable) {
        this.observable = observable;
    }

    // Registra al jugador utilizando el nombre y avatar seleccionado.
    public void registrarJugador() {
        PlayerSettingsModelDTO p = new PlayerSettingsModelDTO(playerName, getSelectedAvatarPath());
        orj.actualizarRegistrarJugador(p); // Notifica al observador que el jugador ha sido registrado.
    }

    // Método vacío para la notificación de registro (se puede implementar según la lógica de la aplicación).
    @Override
    public void notificarRegistro() {
        // Implementación pendiente (si es necesario).
    }

    // Registra un observador de la vista para actualizarla.
    @Override
    public void registrarObservadorVista(ObserverFrmPlayerSettingsView o) {
        this.observerVista = o;
    }
}
