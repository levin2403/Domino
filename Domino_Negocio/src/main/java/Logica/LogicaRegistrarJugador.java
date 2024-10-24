/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import DTOs.AvatarDTO;
import DTOs.JugadorDTO;
import DTOs.PlayerSettingsModelDTO;
import Mediator.Mediador;
import ObjetosNegocio.ManejadorTurnosBO;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsModel;
import Observer.ObserverRegistrarJugador;
import fachada.Fachada;
import fachadas.IFachada;
import javax.swing.JFrame;

/**
 *
 * @author skevi
 */
public class LogicaRegistrarJugador {
    
    //intancia del manejador de turnos 
    ManejadorTurnosBO manejadorTurnos;
    
    IFachada fachada;

    /**
     * Constructor que inicializa la clase 
     */
    public LogicaRegistrarJugador() {
        Fachada facha = new Fachada();
        this.fachada = facha.getFachada();
        manejadorTurnos = new ManejadorTurnosBO();
        
    }

//    public void setPsm(FrmPlayerSettingsModel psm) {
//        this.psm = psm;
//    }
//    
    /**
     * Metodo que registra a un jugador dentro del manejador de turnos para
     * mantener un registro de los jugadores que estan registrados
     * @param dto
     */
    public void registrarJugador(PlayerSettingsModelDTO dto){
        //datos del jugador a registrar
        String user = dto.getPlayerName();
        String imagen = dto.getImagen();
        
        //instanciamos al jugadorDTO
        AvatarDTO avatar = new AvatarDTO(imagen);
        JugadorDTO jugador = new JugadorDTO(user, avatar);
        
        //registramos al jugador dentro del manejador de turnos
        manejadorTurnos.añadirJugador(jugador);
        
        // abrimos el frame del lobby 
//        fachada.showFrmLobby();
        
        //pasamos la informacion por su pipe correspondiente
        
        System.out.println("Configuración guardada: " + dto.getPlayerName() + " es Jugador.");
        
        this.siguienteFrame();
        
    }

    /**
     * Metodo de actualizar desencadenado por el Observable que 
     * realiza la accion de registrar a un nuevo jugador.
     * 
     */
     ObserverRegistrarJugador observerRegistrarJugador = new ObserverRegistrarJugador(){
        @Override
        public void actualizarRegistrarJugador(PlayerSettingsModelDTO dto) {
            registrarJugador(dto);
        }
    };

    public ObserverRegistrarJugador getObserverRegistrarJugador() {
        return observerRegistrarJugador;
    }
    
    private void siguienteFrame(){
        //Creas el mediador (Hacer fachada al mediador y hacer el mediador singleton)
        //Creas el siguiente evento (este aun  no se usa pero es para abrir el frame)
//        LogicaRegistrarJugador rJ= new LogicaRegistrarJugador();
//        Observer.ObserverRegistrarJugador observer= rJ.getObserverRegistrarJugador();
        //EL metodo del mediador regresa un modelo para poderlo asignar al evento que le corresponde
        fachada.showFrmLobby(); //pides al mediador que abra el frame y guardas el modelo de ese frame
    }
    
    
}
