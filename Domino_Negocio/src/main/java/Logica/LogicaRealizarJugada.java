/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import static DTOs.Acciones.CERRARVENTANA;
import static DTOs.Acciones.POZOVACIO;
import DTOs.AvatarDTO;
import DTOs.FichaDTO;
import DTOs.JugadaDTO;
import DTOs.JugadorDTO;
import DTOs.PlayerSettingsModelDTO;
import Eventos.EventoEstablecerConfiguracion;
import Eventos.EventoObtenerFichaPozo;
import Eventos.EventoPartidaTerminada;
import Eventos.EventoRealizarJugada;
import Eventos.EventoRegistrarJugador;
import ObjetosNegocio.ManejadorTurnosBO;
import ObjetosNegocio.PozoBO;
import Observer.ObserverRealizarJugada;
import Observer.ObserverSocket;
import Socket.Cliente;
import fachada.Fachada;
import fachadas.IFachada;

/**
 *
 * @author skevi
 */
public class LogicaRealizarJugada implements ObserverSocket {

    // Instancia del manejador de turnos
    ManejadorTurnosBO manejadorTurnos;
    JugadorDTO jugador = null;
    IFachada fachada;
    private volatile static LogicaRealizarJugada instance;

    // Método para obtener la instancia única de LogicaRealizarJugada (Singleton)
    public static synchronized LogicaRealizarJugada getInstance() {
        if (instance == null) {
            instance = new LogicaRealizarJugada();
        }
        return instance;
    }

    /**
     * Constructor que inicializa la clase
     * Registra observadores para diferentes eventos
     */
    public LogicaRealizarJugada() {
        this.fachada = Fachada.getFachada();  // Inicializa la fachada
        manejadorTurnos = new ManejadorTurnosBO();  // Inicializa el manejador de turnos
        Cliente cliente = Cliente.getInstance();  // Obtiene la instancia del cliente
        cliente.registrarObserver(EventoRegistrarJugador.class, this);  // Registra el observer para registrar jugador
        cliente.registrarObserver(EventoRealizarJugada.class, this);  // Registra el observer para realizar jugada
        cliente.registrarObserver(EventoObtenerFichaPozo.class, this);  // Registra el observer para obtener ficha del pozo
        cliente.registrarObserver(EventoPartidaTerminada.class, this);  // Registra el observer para terminar partida
    }

    // Getter para obtener el jugador actual
    public JugadorDTO getJugador() {
        System.out.println(jugador.getNickName() + "soy ese ajajajjajaja");
        return jugador;
    }

    // Setter para asignar un jugador a la variable jugador
    public void setJugador(JugadorDTO jugador) {
        this.jugador = jugador;
    }

    // Observer para realizar jugadas
    ObserverRealizarJugada observerRealizarJugada = new ObserverRealizarJugada() {
        @Override
        public void actualizar(Object objecto) {
            // Si el objeto es PlayerSettingsModelDTO, se registra el jugador
            if (objecto instanceof PlayerSettingsModelDTO) {

                avisar(CERRARVENTANA);  // Cierra la ventana actual
                registrarJugador((PlayerSettingsModelDTO) objecto);  // Registra al jugador
            }
            // Si el objeto es JugadaDTO, se procesa la jugada
            else if (objecto instanceof JugadaDTO e) {
                if (e.getJugador().getFichas().size() <= 0) {
                    terminarPartida(e);  // Si no tiene fichas, termina la partida
                } else {
                    realizarJugada(e);  // Si tiene fichas, realiza la jugada
                }
            }
            // Si el objeto es JugadorDTO, se obtiene ficha del pozo
            else if (objecto instanceof JugadorDTO d) {
                obtenerPozo(d);  // Llama al método para obtener ficha del pozo
            }

        }
    };

    // Método para avisar al observer de una actualización
    public void avisar(Object objecto) {
        observerRegistrarModel.actualizar(objecto);  // Notifica al observer con el objeto proporcionado
    }

    // Método para obtener ficha del pozo para un jugador
    public void obtenerPozo(JugadorDTO j) {
        PozoBO p = new PozoBO();  // Crea un nuevo PozoBO

        FichaDTO f = p.obtenerFicha();  // Obtiene una ficha del pozo

        if (f == null) {
            avisar(POZOVACIO);  // Si no hay ficha, avisa que el pozo está vacío
        } else {
            robarFicha(j, f);  // Si hay ficha, la roba el jugador
        }
    }

    // Método para terminar la partida cuando un jugador no tiene fichas
    public void terminarPartida(JugadaDTO o) {

        EventoPartidaTerminada d = new EventoPartidaTerminada();  // Crea un evento de partida terminada
        ManejadorTurnosBO m = new ManejadorTurnosBO();  // Crea el manejador de turnos
        d.setPrimerLugar(jugador);  // Establece al jugador como primer lugar
        d.setJugadores(m.getManejadorDTO().getJugadores());  // Obtiene los jugadores y los establece

        PipeLines p = PipeLines.getInstance();  // Obtiene la instancia de PipeLines
        
        p.crearYGuardarPipelineJuego(EventoPartidaTerminada.class);  // Crea y guarda el pipeline de la partida terminada
        
        p.enviarDatoPipeLineJuego(d);  // Envía el evento de partida terminada a través del pipeline
    }

    // Método para robar una ficha del pozo
    public void robarFicha(JugadorDTO j, FichaDTO f) {
        EventoObtenerFichaPozo e = new EventoObtenerFichaPozo();  // Crea el evento de obtener ficha del pozo
        e.setFicha(f);  // Establece la ficha robada
        e.setJugador(j);  // Establece el jugador que robó la ficha

        PipeLines p = PipeLines.getInstance();  // Obtiene la instancia de PipeLines
        
        p.crearYGuardarPipelineJuego(EventoObtenerFichaPozo.class);  // Crea y guarda el pipeline para obtener ficha
        
        p.enviarDatoPipeLineJuego(e);  // Envía el evento de obtener ficha al pipeline
    }

    // Método para realizar la jugada de un jugador
    public void realizarJugada(JugadaDTO jugada) {
        EventoRealizarJugada e = new EventoRealizarJugada(jugada);  // Crea el evento de realizar jugada

        PipeLines p = PipeLines.getInstance();  // Obtiene la instancia de PipeLines
        
        p.crearYGuardarPipelineJuego(EventoRealizarJugada.class);  // Crea y guarda el pipeline para realizar jugada
        
        p.enviarDatoPipeLineJuego(e);  // Envía el evento de jugada al pipeline
    }

    // Método para registrar al jugador
    public void registrarJugador(PlayerSettingsModelDTO p) {
        EventoRegistrarJugador e = new EventoRegistrarJugador();  // Crea el evento de registrar jugador
        jugador = new JugadorDTO(p.getPlayerName(), new AvatarDTO(p.getImagen()));  // Crea un jugador con el nombre y avatar
        e.setPlayer(p);  // Establece el player en el evento
        e.setHost(false);  // El jugador no es el host

        PipeLines pipe = PipeLines.getInstance();  // Obtiene la instancia de PipeLines
        pipe.crearYGuardarPipelinePartida(EventoRegistrarJugador.class);  // Crea y guarda el pipeline para registrar jugador
        pipe.enviarDatoPipeLinePartida(e);  // Envía el evento de registrar jugador al pipeline
    }

    // Getter para obtener el observer de realizar jugada
    public ObserverRealizarJugada getObserverRealizarJugada() {
        return observerRealizarJugada;
    }

    ObserverRealizarJugada observerRegistrarModel;

    // Getter para obtener el modelo de observer de jugada
    public ObserverRealizarJugada getObserverJugadaModel() {
        return observerRegistrarModel;
    }

    // Método para mostrar la pantalla de la partida en curso
    public void mostrarPantalla() {
        LogicaTerminarPartida T = LogicaTerminarPartida.getInstance();  // Obtiene la instancia de LogicaTerminarPartda
        this.observerRegistrarModel = fachada.showFrmMatchOngoing(observerRealizarJugada);  // Muestra la pantalla de la partida en curso
    }

    // Setter para establecer el observer de realizar jugada
    public void setObserverRealizarModel(ObserverRealizarJugada observerRealizar) {
        this.observerRegistrarModel = observerRealizar;
    }

    // Método que maneja los eventos de actualización
    @Override
    public void update(Object evento) {
        // Si el evento es de registrar jugador
        if (evento instanceof EventoRegistrarJugador) {
            EventoRegistrarJugador r = (EventoRegistrarJugador) evento;
            if (!r.isHost()) {
                // Si no es el host, verifica si el jugador es el mismo que el actual
                if (r.getJugador().equals(jugador)) {
                    avisar(CERRARVENTANA);  // Cierra la ventana
                    LogicaLobby l = LogicaLobby.getInstance();  // Obtiene la instancia de LogicaLobby
                    l.setJugador(jugador);  // Establece el jugador en el lobby
                    l.mostrarPantalla();  // Muestra la pantalla del lobby
                    l.avisar(evento);  // Envía el evento al lobby
                }
            }
        } else if (evento instanceof EventoRealizarJugada r) {
            ManejadorTurnosBO m = new ManejadorTurnosBO();
            m.quitarFicha(r.getJugador(), r.getFicha());  // Quita la ficha del jugador
            this.pasarturno();  // Pasa el turno al siguiente jugador
            avisar(r);  // Notifica la jugada
            avisar(m.getManejadorDTO());  // Notifica el estado del manejador de turnos
        } else if (evento instanceof EventoObtenerFichaPozo e) {
            ManejadorTurnosBO m = new ManejadorTurnosBO();
            m.agregarFicha(e.getJugador(), e.getFicha());  // Agrega la ficha al jugador
            m.eliminarFicha(e.getFicha());  // Elimina la ficha del pozo
            m.pasarTurno();  // Pasa el turno al siguiente jugador
            avisar(m.getManejadorDTO());  // Notifica el estado del manejador de turnos
        } else if (evento instanceof EventoPartidaTerminada e) {
            LogicaTerminarPartida t = LogicaTerminarPartida.getInstance();  // Obtiene la instancia de LogicaTerminarPartda
            avisar(CERRARVENTANA);  // Cierra la ventana
            t.mostrarPantalla();  // Muestra la pantalla de la partida terminada
            t.avisar(e);  // Envía el evento de partida terminada
        }
    }

    // Método para pasar el turno al siguiente jugador
    public void pasarturno() {
        ManejadorTurnosBO m = new ManejadorTurnosBO();
        m.pasarTurno();  // Llama al método para pasar el turno
    }

}
