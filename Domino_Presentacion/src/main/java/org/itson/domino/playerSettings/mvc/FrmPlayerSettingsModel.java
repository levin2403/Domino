package org.itson.domino.playerSettings.mvc;


import DTOs.PlayerSettingsModelDTO;
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
    
     ObserverRegistrarJugador observable = new ObserverRegistrarJugador() {
        @Override
        public void actualizarRegistrarJugador(Object objeto) {
         observerVista.actualizarVista(objeto);
        }
    };
     
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
    
    @Override
    public void registrarObservadorLogica(ObserverRegistrarJugador orj) {
       this.orj = orj;
    }

    public ObserverRegistrarJugador getObservable() {
        return observable;
    }

    public void setObservable(ObserverRegistrarJugador observable) {
        this.observable = observable;
    }
    
    /**
     * 
     */
    public void registrarJugador(){
        System.out.println("Ahi te va");
        PlayerSettingsModelDTO p = new PlayerSettingsModelDTO(playerName, getSelectedAvatarPath());
        orj.actualizarRegistrarJugador(p);
    }
    @Override
    public void notificarRegistro() {
        
       
    }

    @Override
    public void registrarObservadorVista(ObserverFrmPlayerSettingsView o) {
        this.observerVista = o;
    }
}
