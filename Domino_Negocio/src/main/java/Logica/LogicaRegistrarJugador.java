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

    // Instancia del manejador de turnos
    ManejadorTurnosBO manejadorTurnos;
    JugadorDTO jugador = null;
    IFachada fachada;
    private volatile static LogicaRegistrarJugador instance;

    // Método para obtener la instancia única de LogicaRegistrarJugador (Singleton)
    public static synchronized LogicaRegistrarJugador getInstance() {
        if (instance == null) {
            instance = new LogicaRegistrarJugador();
        }
        return instance;
    }

    /**
     * Constructor que inicializa la clase.
     * Registra el observer para el evento de registro de jugador.
     */
    public LogicaRegistrarJugador() {
        this.fachada = Fachada.getFachada();  // Inicializa la fachada
        manejadorTurnos = new ManejadorTurnosBO();  // Inicializa el manejador de turnos
        Cliente cliente = Cliente.getInstance();  // Obtiene la instancia del cliente
        cliente.registrarObserver(EventoRegistrarJugador.class, this);  // Registra el observer para registrar jugador
    }

    // Observer para registrar jugadores
    ObserverRegistrarJugador observerRegistrarJugador = new ObserverRegistrarJugador() {
        @Override
        public void actualizarRegistrarJugador(Object objecto) {
            // Si el objeto es PlayerSettingsModelDTO, registra al jugador
            if (objecto instanceof PlayerSettingsModelDTO) {

                avisar(CERRARVENTANA);  // Cierra la ventana actual
                registrarJugador((PlayerSettingsModelDTO) objecto);  // Registra al jugador
            }
        }
    };

    // Método para avisar al observer de una actualización
    public void avisar(Object objecto) {
        observerRegistrarModel.actualizarRegistrarJugador(objecto);  // Notifica al observer con el objeto proporcionado
    }

    // Getter para obtener el observer de registrar jugador
    public ObserverRegistrarJugador getObserverRegistrarJugador() {
        return observerRegistrarJugador;
    }

    ObserverRegistrarJugador observerRegistrarModel;

    // Getter para obtener el modelo de observer de registro de jugador
    public ObserverRegistrarJugador getObserverRegistrarModel() {
        return observerRegistrarModel;
    }

    // Método para mostrar la pantalla de configuración del jugador
    public void mostrarPantalla() {
        this.observerRegistrarModel = fachada.showFrmPlayerSettings(observerRegistrarJugador);  // Muestra la pantalla de configuración
    }

    // Setter para establecer el observer de registro de jugador
    public void setObserverRegistrarModel(ObserverRegistrarJugador observerRegistrarModel) {
        this.observerRegistrarModel = observerRegistrarModel;
    }

    // Método para registrar a un jugador
    public void registrarJugador(PlayerSettingsModelDTO p) {
        EventoRegistrarJugador e = new EventoRegistrarJugador();  // Crea el evento de registrar jugador
        jugador = new JugadorDTO(p.getPlayerName(), new AvatarDTO(p.getImagen()));  // Crea el jugador con nombre y avatar
        e.setPlayer(p);  // Establece el player en el evento
        e.setHost(false);  // Marca que el jugador no es el host
        
        PipeLines pipe = PipeLines.getInstance();  // Obtiene la instancia de PipeLines
        pipe.crearYGuardarPipelinePartida(EventoRegistrarJugador.class);  // Crea y guarda el pipeline para registrar jugador
        pipe.enviarDatoPipeLinePartida(e);  // Envía el evento de registrar jugador al pipeline
    }

    // Método que maneja los eventos de actualización
    @Override
    public void update(Object evento) {
        // Si el evento es de registrar jugador
        if (evento instanceof EventoRegistrarJugador) {

            EventoRegistrarJugador r = (EventoRegistrarJugador) evento;
            if (!r.isHost()) {
                // Si no es el host, verifica si el jugador es el mismo que el actual
                System.out.println(r.getPlayer().getPlayerName() + "qpss");
                if (r.getJugador().equals(jugador)) {
                    avisar(CERRARVENTANA);  // Cierra la ventana
                    LogicaLobby l = LogicaLobby.getInstance();  // Obtiene la instancia de LogicaLobby
                    l.setJugador(jugador);  // Establece el jugador en el lobby
                    l.mostrarPantalla();  // Muestra la pantalla del lobby
                    l.avisar(evento);  // Envía el evento al lobby
                }
            }
        }
    }
}

