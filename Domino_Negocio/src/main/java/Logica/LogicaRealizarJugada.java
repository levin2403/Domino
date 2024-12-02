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
import ObjetosNegocio.ManejadorTurnosBO;
import Observer.ObserverRealizarJugada;
import Observer.ObserverSocket;
import Socket.Cliente;
import fachada.Fachada;
import fachadas.IFachada;
import filtro.FiltroJson;
import filtro.FiltroRegistrarJugador;
import interfaz.IPipe;
import pipe.PipeBasico;

/**
 *
 * @author skevi
 */
public class LogicaRealizarJugada implements ObserverSocket{
    
    //intancia del manejador de turnos 
    ManejadorTurnosBO manejadorTurnos;
    JugadorDTO jugador = null;
    IFachada fachada;
    ObserverRealizarJugada observerRegistrarModel;
    private volatile static LogicaRealizarJugada instance;

    public static synchronized LogicaRealizarJugada getInstance() {
        if (instance == null) {
            instance = new LogicaRealizarJugada();
        }
        return instance;
    }

    /**
     * Constructor que inicializa la clase
     */
    public LogicaRealizarJugada() {
        this.fachada = Fachada.getFachada();
        manejadorTurnos = new ManejadorTurnosBO();
        Cliente cliente = Cliente.getInstance();
        cliente.registrarObserver(EventoRegistrarJugador.class, this);
    }

    ObserverRealizarJugada observerRealizarJugada = new ObserverRealizarJugada() {
        @Override
        public void actualizar(Object objecto) {
            if (objecto instanceof PlayerSettingsModelDTO) {

                avisar(CERRARVENTANA);
                registrarJugador((PlayerSettingsModelDTO) objecto);
            }
        }
    };

    public void avisar(Object objecto) {
        observerRegistrarModel.actualizar(objecto);

    }

    public ObserverRealizarJugada getObserverRealizarJugada() {
        return observerRealizarJugada;
    }
   

    public ObserverRealizarJugada getObserverJugadaModel() {
        return observerRegistrarModel;
    }

    public void mostrarPantalla() {
//        this.observerRegistrarModel = fachada.showFrmMatchOngoing(observerRealizarJugada);
    }

    public void setObserverRealizarModel(ObserverRealizarJugada observerRealizar) {
        this.observerRegistrarModel = observerRealizar;
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