/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import DTOs.Acciones;
import static DTOs.Acciones.CERRARVENTANA;
import DTOs.JugadorDTO;
import DTOs.ManejadorTurnosDTO;
import Eventos.EventoIniciarPartida;
import Eventos.EventoRegistrarJugador;
import ObjetosNegocio.ManejadorTurnosBO;
import Observer.ObserverLobby;
import Observer.ObserverSocket;
import Socket.Cliente;
import fachada.Fachada;
import fachadas.IFachada;
import filtro.FiltroIniciarPartida;
import filtro.FiltroJson;
import interfaz.IPipe;
import java.util.List;
import pipe.PipeBasico;

/**
 *
 * @author skevi
 */
public class LogicaLobby implements ObserverSocket {

    IFachada fachada;

    private volatile static LogicaLobby instance;
    private JugadorDTO jugador;

    public static synchronized LogicaLobby getInstance() {
        if (instance == null) {
            instance = new LogicaLobby();
        }
        return instance;
    }
    ObserverLobby observerLobbyModel;
    ObserverLobby observerLobby = new ObserverLobby() {

        @Override
        public void actualizar(Object objecto) {

            if (objecto instanceof Acciones) {
                Acciones accion = (Acciones) objecto;

                if (accion == accion.INICIARPARTIDA) {

                }

            } else if (objecto instanceof ManejadorTurnosDTO m) {
                iniciarPartida(m.getJugadores());
            }
        }

    };

    public ObserverLobby getObserverLobbyModel() {
        return observerLobbyModel;
    }

    public void setObserverLobbyModel(ObserverLobby observerLobbyModel) {
        this.observerLobbyModel = observerLobbyModel;
    }

    public void mostrarPantalla() {
        this.observerLobbyModel = fachada.showFrmLobby(observerLobby);
    }

    public JugadorDTO getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDTO jugador) {
        this.jugador = jugador;
    }

    public LogicaLobby() {
        fachada = Fachada.getFachada();
        Cliente cliente = Cliente.getInstance();
        cliente.registrarObserver(EventoRegistrarJugador.class, this);
        cliente.registrarObserver(EventoIniciarPartida.class, this);
    }

    public void iniciarPartida(List<JugadorDTO> jugadores) {
        ManejadorTurnosBO m = new ManejadorTurnosBO();
        for (JugadorDTO jugadore : jugadores) {
            m.añadirJugador(jugadore);
        }
        m.asignarFichas();
        m.determinarTurnos();
        enviarPartida();
    }

    public void enviarPartida() {
        ManejadorTurnosBO m = new ManejadorTurnosBO();
        ManejadorTurnosDTO mt = m.getManejadorDTO();

        EventoIniciarPartida e = new EventoIniciarPartida();
        e.setJugadores(mt.getJugadores());
        e.setPozo(mt.getPozo());
        e.setJugadorTurno(mt.getJugadorEnTurno());

        PipeLines p = PipeLines.getInstance();
        p.crearYGuardarPipelinePartida(EventoIniciarPartida.class);
        p.enviarDatoPipeLinePartida(e);
    }

    public void avisar(Object objecto) {

        observerLobbyModel.actualizar(objecto);

    }

    @Override
    public void update(Object evento) {
        if (evento instanceof EventoRegistrarJugador e) {
            avisar(e);
        } else if (evento instanceof EventoIniciarPartida e) {
            avisar(e);
            ManejadorTurnosBO m = new ManejadorTurnosBO();
            m.cambiarManejadorTurnos(e.getManejador());
            m.inicialFicha();
            m.pasarTurno();

            avisar(CERRARVENTANA);
            LogicaRealizarJugada l = new LogicaRealizarJugada();
            l.setJugador(jugador);
            l.mostrarPantalla();
            l.avisar(jugador);
            l.avisar(e);
            l.avisar(m.getManejadorDTO());
        }

    }
}
