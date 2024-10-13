/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import DTOs.AvatarDTO;
import DTOs.JugadorDTO;
import Mediator.Mediator;
import Singleton.ManejadorTurnosST;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsModel;
import org.itson.domino.observer.ObserverRegistrarJugador;

/**
 *
 * @author skevi
 */
public class RegistrarJugador implements ObserverRegistrarJugador{
    
    // para registrar al jugador
    ManejadorTurnosST manejadorTurnosST;
    ManejadorTurnos manejadorTurnos;

    //para el frame que usaremos
    FrmPlayerSettingsModel psm;
    
    //mediador para abrir nuevos frames 
    Mediator mediador;

    /**
     * Constructor que inicializa la clase 
     */
    public RegistrarJugador() {
        this.manejadorTurnos = manejadorTurnosST.getInstance();
        this.psm = new FrmPlayerSettingsModel();
        
        //registramos a la clase como observadora
        psm.registrarObservador(this);
    }
    
    /**
     * Metodo que registra a un jugador dentro del manejador de turnos para
     * mantener un registro de los jugadores que estan registrados
     */
    public void RegistrarJugador(){
        //datos del jugador a registrar
        String user = psm.getPlayerName();
        String imagen = psm.getSelectedAvatarPath();
        
        //instanciamos al jugadorDTO
        AvatarDTO avatar = new AvatarDTO(imagen);
        JugadorDTO jugador = new JugadorDTO(user, avatar);
        
        //registramos al jugador dentro del manejador de turnos
        manejadorTurnos.addJugador(jugador);
        
        // abrimos el frame del lobby 
        mediador.showFrmLobby();
    }

    /**
     * Metodo de actualizar desencadenado por el Observable que 
     * realiza la accion de registrar a un nuevo jugador.
     */
    @Override
    public void actualizar() {
        RegistrarJugador();
    }
    
    
}
