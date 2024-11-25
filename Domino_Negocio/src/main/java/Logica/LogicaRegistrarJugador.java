/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import static DTOs.Acciones.CERRARVENTANA;
import DTOs.AvatarDTO;
import DTOs.JugadorDTO;
import DTOs.PlayerSettingsModelDTO;
import Eventos.EventoRegistrarJugador;
import Mediator.Mediador;
import ObjetosNegocio.ManejadorTurnosBO;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsModel;
import Observer.ObserverRegistrarJugador;
import Observer.ObserverSocket;
import Socket.Cliente;
import fachada.Fachada;
import fachadas.IFachada;
import filtro.FiltroJson;
import filtro.FiltroRegistrarJugador;
import interfaz.IPipe;
import javax.swing.JFrame;
import pipe.PipeBasico;

/**
 * 
 * @author skevi
 */
public class LogicaRegistrarJugador implements ObserverSocket {

    //intancia del manejador de turnos 
    ManejadorTurnosBO manejadorTurnos;
    JugadorDTO jugador = null;
    IFachada fachada;
    private volatile static LogicaRegistrarJugador instance;

    public static synchronized LogicaRegistrarJugador getInstance() {
        if (instance == null) {
            instance = new LogicaRegistrarJugador();
        }
        return instance;
    }

    /**
     * Constructor que inicializa la clase
     */
    public LogicaRegistrarJugador() {
        this.fachada = Fachada.getFachada();
        manejadorTurnos = new ManejadorTurnosBO();
        Cliente cliente = Cliente.getInstance();
        cliente.registrarObserver(EventoRegistrarJugador.class, this);
    }

    ObserverRegistrarJugador observerRegistrarJugador = new ObserverRegistrarJugador() {
        @Override
        public void actualizarRegistrarJugador(Object objecto) {
            if (objecto instanceof PlayerSettingsModelDTO) {

                avisar(CERRARVENTANA);
                registrarJugador((PlayerSettingsModelDTO) objecto);
            }
        }
    };

    public void avisar(Object objecto) {
        observerRegistrarModel.actualizarRegistrarJugador(objecto);

    }

    public ObserverRegistrarJugador getObserverRegistrarJugador() {
        return observerRegistrarJugador;
    }
    ObserverRegistrarJugador observerRegistrarModel;

    public ObserverRegistrarJugador getObserverRegistrarModel() {
        return observerRegistrarModel;
    }

    public void mostrarPantalla() {
        System.out.println("mOSTRAR PANTALLA");
        this.observerRegistrarModel = fachada.showFrmPlayerSettings(observerRegistrarJugador);
    }

    public void setObserverRegistrarModel(ObserverRegistrarJugador observerRegistrarModel) {
        this.observerRegistrarModel = observerRegistrarModel;
    }

    public void registrarJugador(PlayerSettingsModelDTO p) {
        EventoRegistrarJugador e = new EventoRegistrarJugador();
        jugador = new JugadorDTO(p.getPlayerName(), new AvatarDTO(p.getImagen()));
        e.setPlayer(p);
        e.setHost(false);
        IPipe<EventoRegistrarJugador> pipa = new PipeBasico();
        IPipe<EventoRegistrarJugador> pipa2 = new PipeBasico();

        FiltroRegistrarJugador filtroRegistrarJugador = new FiltroRegistrarJugador();
        FiltroJson filtroJson = new FiltroJson();
        pipa.setFiltro(filtroRegistrarJugador);
        filtroRegistrarJugador.setPipe(pipa2);
        pipa2.setFiltro(filtroJson);

        pipa.enviar(e);
        Cliente c = Cliente.getInstance();
        c.enviarJSON((String) filtroJson.getMensaje());
    }

    @Override
    public void update(Object evento) {
        if (evento instanceof EventoRegistrarJugador) {

            EventoRegistrarJugador r = (EventoRegistrarJugador) evento;
            if (!r.isHost()) {
                if (r.getJugador().equals(jugador)) {
                    System.out.println("sono el mismo");
                    avisar(CERRARVENTANA);
                    LogicaLobby l = LogicaLobby.getInstance();
                    l.setJugador(jugador);
                    l.mostrarPantalla();
                    l.avisar(evento);
                }

            }
        }
    }

}
