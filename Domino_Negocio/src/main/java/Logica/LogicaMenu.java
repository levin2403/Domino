/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import DTOs.Acciones;
import static DTOs.Acciones.CERRARVENTANA;
import static DTOs.Acciones.DENEGADO;
import Eventos.EventoBuscarPartida;
import ObjetosNegocio.ConfiguracionBO;
import Observer.ObserverMenuLogica;
import Observer.ObserverSocket;
import Socket.Cliente;
import fachada.Fachada;
import fachadas.IFachada;
import filtro.FiltroBuscarPartida;
import filtro.FiltroJson;
import interfaz.IPipe;
import pipe.PipeBasico;

/**
 *
 * @author skevi
 */

public class LogicaMenu implements ObserverSocket {

    IFachada fachada;  // Interfaz para interactuar con la fachada
    private volatile static LogicaMenu instance;  // Singleton para garantizar una única instancia

    // Método para obtener la instancia única de LogicaMenu
    public static synchronized LogicaMenu getInstance() {
        if (instance == null) {
            instance = new LogicaMenu();
        }
        return instance;
    }

    // Constructor de la clase
    public LogicaMenu() {
        fachada = Fachada.getFachada();  // Inicializa la fachada
        getObserverMenu();  // Obtiene el observer del menú
        Cliente cliente = Cliente.getInstance();  // Obtiene la instancia del cliente
        cliente.registrarObserver(EventoBuscarPartida.class, this);  // Registra el observer para eventos de búsqueda de partida
    }

    // Observer para escuchar las acciones del menú (como buscar partida o configurar)
    ObserverMenuLogica observerMenu = new ObserverMenuLogica() {
        @Override
        public void actualizar(Object objecto) {
            if (objecto instanceof Acciones) {
                Acciones accion = (Acciones) objecto;

                // Si la acción es buscar partida, se ejecuta el método buscarPartida
                if (accion == accion.BUSCARPARTIDA) {
                    buscarPartida();
                }
                // Si la acción es configurar, se cierra la ventana actual y muestra la pantalla de configuración
                if (accion == accion.CONFIGURAR) {
                    avisar(CERRARVENTANA);
                    LogicaEstablecerConfiguracion l = LogicaEstablecerConfiguracion.getInstance();
                    l.mostrarPantalla();
                }
            }
        }
    };

    ObserverMenuLogica observerMenuModel;

    // Métodos getter y setter para el observerMenuModel
    public ObserverMenuLogica getObservableMenuLogica() {
        return observerMenuModel;
    }

    public void setObserverMenuModel(ObserverMenuLogica observeRMenu) {
        this.observerMenuModel = observeRMenu;
    }

    // Método para obtener el observer del menú
    public ObserverMenuLogica getObserverMenu() {
        return observerMenu;
    }

    // Método para buscar una partida y enviar la solicitud al servidor
    public void buscarPartida() {
        IPipe<EventoBuscarPartida> pipa = new PipeBasico();
        IPipe<EventoBuscarPartida> pipa2 = new PipeBasico();

        FiltroBuscarPartida filtroBuscarPartida = new FiltroBuscarPartida();
        FiltroJson filtroJson = new FiltroJson();
        pipa.setFiltro(filtroBuscarPartida);
        filtroBuscarPartida.setPipe(pipa2);
        pipa2.setFiltro(filtroJson);
        EventoBuscarPartida b = new EventoBuscarPartida();
        pipa.enviar(b);  // Envía el evento de búsqueda de partida a través del pipe
        enviarAlServer((String) filtroJson.getMensaje());  // Envía el mensaje al servidor
    }

    // Método para enviar el mensaje al servidor
    public void enviarAlServer(String mensaje) {
        Cliente cliente = Cliente.getInstance();

        if (cliente != null) {
            cliente.enviarJSON(mensaje);  // Envía el mensaje JSON al servidor
        } else {
            System.out.println("No se pudo obtener la instancia del cliente.");
        }
    }

    // Método para avisar al observer de una actualización
    public void avisar(Object objecto) {
        observerMenuModel.actualizar(objecto);  // Notifica al observer con el objeto proporcionado
    }

    // Método para mostrar la pantalla de bienvenida del menú
    public void mostrarPantalla() {
        this.observerMenuModel = fachada.showFrmWelcome(observerMenu);  // Muestra la pantalla del menú
    }

    // Método para manejar las actualizaciones de eventos
    @Override
    public void update(Object evento) {
        System.out.println("observer me aviso");

        // Si el evento es un EventoBuscarPartida
        if (evento instanceof EventoBuscarPartida) {
            EventoBuscarPartida e = (EventoBuscarPartida) evento;

            // Si la respuesta es positiva, cierra la ventana y muestra la pantalla de registro de jugador
            if (e.isRespuesta()) {
                avisar(CERRARVENTANA);
                ConfiguracionBO c = new ConfiguracionBO();
                c.setFichasPorJugador((byte) e.getConfiguracion().getFichasARepartir());
                c.setNumJugadores((byte) e.getConfiguracion().getNumJugadores());
                LogicaRegistrarJugador r = LogicaRegistrarJugador.getInstance();
                r.mostrarPantalla();
            } else {
                // Si la respuesta es negativa, avisa de la denegación
                avisar(DENEGADO);
            }
        }
    }
}
