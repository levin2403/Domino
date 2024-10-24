package org.itson.domino.playerSettings.mvc;


import org.itson.domino.managers.AvatarManager;
import Observer.ObserverRegistrarJugador;
import Observable.ObservableRegistrarJugador;
import Observer.Vista.ObserverFrmPlayerSettingsView;

/**
 * 
 * @author skevi
 */
public class FrmPlayerSettingsModel implements ObservableRegistrarJugador {

    ObserverRegistrarJugador orj;
    ObserverFrmPlayerSettingsView observerVista;
    
    // asdasdasd
    private String playerName;
    private AvatarManager avatarManager;

    
    public FrmPlayerSettingsModel() {
        this.avatarManager = new AvatarManager();
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getSelectedAvatarPath() {
        return avatarManager.getCurrentAvatarPath();
    }

    public String nextAvatar() {
        return avatarManager.nextAvatar();
    }

    public String previousAvatar() {
        return avatarManager.previousAvatar();
    }
    
    public void saveSettings() {
        System.out.println("Configuración guardada: " + playerName + " es Jugador.");
    }
    
    // observer que notifica al observador suscrito para que realice el
    // registro de un usuario.
    @Override
    public void registrarObservadorLogica(ObserverRegistrarJugador orj) {
       this.orj = orj;
    }

    /**
     * 
     */
    @Override
    public void notificarRegistro() {
        orj.actualizarRegistrarJugador();
    }

    @Override
    public void registrarObservadorVista(ObserverFrmPlayerSettingsView o) {
        this.observerVista = o;
    }
    

}
