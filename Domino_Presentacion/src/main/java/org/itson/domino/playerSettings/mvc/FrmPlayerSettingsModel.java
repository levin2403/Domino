package org.itson.domino.playerSettings.mvc;


import org.itson.domino.managers.AvatarManager;
import org.itson.domino.observable.ObserverbableRegistrarJugador;
import org.itson.domino.observer.ObserverRegistrarJugador;

/**
 * 
 * @author skevi
 */
public class FrmPlayerSettingsModel implements ObserverbableRegistrarJugador {

    ObserverRegistrarJugador orj;
    
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
    public void registrarJugador(){
        notificar();
    }

    @Override
    public void registrarObservador(ObserverRegistrarJugador orj) {
       this.orj = orj;
    }

    @Override
    public void aliminarObservador(ObserverRegistrarJugador orj) {
        this.orj = null;
    }

    @Override
    public void notificar() {
        orj.actualizar();
    }

}
