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

    IFachada fachada;  // Instancia de la fachada para interactuar con la interfaz

    private volatile static LogicaLobby instance;  // Singleton para la clase LogicaLobby
    private JugadorDTO jugador;  // Representa al jugador actual en el lobby

    // Método que garantiza que solo haya una instancia de LogicaLobby
    public static synchronized LogicaLobby getInstance() {
        if (instance == null) {
            instance = new LogicaLobby();
        }
        return instance;
    }

    // Observer para escuchar eventos y realizar acciones según el tipo de evento
    ObserverLobby observerLobbyModel;
    ObserverLobby observerLobby = new ObserverLobby() {

        @Override
        public void actualizar(Object objecto) {
            
            // Si el evento es una acción
            if (objecto instanceof Acciones) {
                Acciones accion = (Acciones) objecto;

                // Si la acción es iniciar partida
                if (accion == accion.INICIARPARTIDA) {

                }
                
            }
            // Si el evento es un ManejadorTurnosDTO, se inicia la partida
            else if (objecto instanceof ManejadorTurnosDTO m) {
                iniciarPartida(m.getJugadores());
            }
        }
    };

    // Métodos getter y setter para observerLobbyModel
    public ObserverLobby getObserverLobbyModel() {
        return observerLobbyModel;
    }

    public void setObserverLobbyModel(ObserverLobby observerLobbyModel) {
        this.observerLobbyModel = observerLobbyModel;
    }

    // Muestra la pantalla del lobby
    public void mostrarPantalla() {
        this.observerLobbyModel = fachada.showFrmLobby(observerLobby);
    }

    // Métodos getter y setter para el jugador
    public JugadorDTO getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDTO jugador) {
        this.jugador = jugador;
    }

    // Constructor de la clase, inicializa la fachada y registra los observadores
    public LogicaLobby() {
        fachada = Fachada.getFachada();
        Cliente cliente = Cliente.getInstance();
        cliente.registrarObserver(EventoRegistrarJugador.class, this);
        cliente.registrarObserver(EventoIniciarPartida.class, this);
    }
    
    // Inicia la partida con los jugadores y asigna las fichas y turnos
    public void iniciarPartida(List<JugadorDTO> jugadores){
        ManejadorTurnosBO m = new ManejadorTurnosBO();
        for (JugadorDTO jugadore : jugadores) {
            m.añadirJugador(jugadore);  // Añade jugadores al manejador de turnos
        }
        m.asignarFichas();  // Asigna fichas a los jugadores
        m.determinarTurnos();  // Determina el orden de los turnos
        enviarPartida();  // Envia la información de la partida
    }
    
    // Envía la información de la partida al servidor
    public void enviarPartida(){
        ManejadorTurnosBO m = new ManejadorTurnosBO();
        ManejadorTurnosDTO mt = m.getManejadorDTO();
        IPipe<EventoIniciarPartida> pipa = new PipeBasico();
        IPipe<EventoIniciarPartida> pipa2 = new PipeBasico();

        FiltroIniciarPartida filtroIniciarPartida = new FiltroIniciarPartida();
        FiltroJson filtroJson = new FiltroJson();
        pipa.setFiltro(filtroIniciarPartida);
        filtroIniciarPartida.setPipe(pipa2);
        pipa2.setFiltro(filtroJson);
        EventoIniciarPartida e = new EventoIniciarPartida();
        e.setJugadores(mt.getJugadores());
        e.setPozo(mt.getPozo());
        e.setJugadorTurno(mt.getJugadorEnTurno());
        pipa.enviar(e);  // Envía el evento a través del pipe
        Cliente c = Cliente.getInstance();
        c.enviarJSON((String) filtroJson.getMensaje());  // Envía el mensaje JSON al servidor
        System.out.println("enviando a server");
    }

    // Método para avisar y actualizar al observer con un objeto
    public void avisar(Object objecto) {
        System.out.println(observerLobbyModel);
        observerLobbyModel.actualizar(objecto);  // Actualiza al observer con el objeto proporcionado
    }

    // Método para manejar actualizaciones de eventos
    @Override
    public void update(Object evento) {
        // Si el evento es un EventoRegistrarJugador, lo avisa
        if (evento instanceof EventoRegistrarJugador e) {
            avisar(e);
        }
        // Si el evento es un EventoIniciarPartida, lo avisa y cambia el manejador de turnos
        else if(evento instanceof EventoIniciarPartida e){
            avisar(e);
            ManejadorTurnosBO m = new ManejadorTurnosBO();
            m.cambiarManejadorTurnos(e.getManejador());  // Cambia el manejador de turnos
            ManejadorTurnosDTO mt = m.getManejadorDTO();
            avisar(CERRARVENTANA);  // Cierra la ventana actual
            LogicaRealizarJugada l = new LogicaRealizarJugada();
            l.mostrarPantalla();  // Muestra la pantalla para realizar la jugada
            l.avisar(e);  // Informa a la siguiente lógica de la partida
        }
    }
}
