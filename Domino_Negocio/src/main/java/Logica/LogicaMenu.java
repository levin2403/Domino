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

    IFachada fachada;
    private volatile static LogicaMenu instance;

    public static synchronized LogicaMenu getInstance() {
        if (instance == null) {
            instance = new LogicaMenu();
        }
        return instance;
    }

    public LogicaMenu() {
        fachada = Fachada.getFachada();
        getObserverMenu();
        Cliente cliente = Cliente.getInstance();
        cliente.registrarObserver(EventoBuscarPartida.class, this);
    }
    ObserverMenuLogica observerMenu = new ObserverMenuLogica() {
        @Override
        public void actualizar(Object objecto) {
            if (objecto instanceof Acciones) {
                Acciones accion = (Acciones) objecto;

                if (accion == accion.BUSCARPARTIDA) {

                    buscarPartida();
                }
                if (accion == accion.CONFIGURAR) {
                    avisar(CERRARVENTANA);
                    LogicaEstablecerConfiguracion l = LogicaEstablecerConfiguracion.getInstance();
                    l.mostrarPantalla();
                }
            }
        }

    };

    ObserverMenuLogica observerMenuModel;

    public ObserverMenuLogica getObservableMenuLogica() {
        return observerMenuModel;
    }

    public void setObserverMenuModel(ObserverMenuLogica observeRMenu) {
        this.observerMenuModel = observeRMenu;
    }

    public ObserverMenuLogica getObserverMenu() {
        return observerMenu;
    }

    public void buscarPartida() {
        IPipe<EventoBuscarPartida> pipa = new PipeBasico();
        IPipe<EventoBuscarPartida> pipa2 = new PipeBasico();

        FiltroBuscarPartida filtroBuscarPartida = new FiltroBuscarPartida();
        FiltroJson filtroJson = new FiltroJson();
        pipa.setFiltro(filtroBuscarPartida);
        filtroBuscarPartida.setPipe(pipa2);
        pipa2.setFiltro(filtroJson);
        EventoBuscarPartida b = new EventoBuscarPartida();
        pipa.enviar(b);
        enviarAlServer((String) filtroJson.getMensaje());
    }

    public void enviarAlServer(String mensaje) {
        Cliente cliente = Cliente.getInstance();

        if (cliente != null) {

            cliente.enviarJSON(mensaje);
        } else {
            System.out.println("No se pudo obtener la instancia del cliente.");
        }
    }

    public void avisar(Object objecto) {

        observerMenuModel.actualizar(objecto);

    }

    public void mostrarPantalla() {
        this.observerMenuModel = fachada.showFrmWelcome(observerMenu);
    }

    @Override
    public void update(Object evento) {
        if (evento instanceof EventoBuscarPartida) {
            EventoBuscarPartida e = (EventoBuscarPartida) evento;
            if (((EventoBuscarPartida) evento).isRespuesta()) {
                avisar(CERRARVENTANA);
                ConfiguracionBO c = new ConfiguracionBO();

                c.setFichasPorJugador((byte) e.getConfiguracion().getFichasARepartir());
                c.setNumJugadores((byte) e.getConfiguracion().getNumJugadores());
                LogicaRegistrarJugador r = LogicaRegistrarJugador.getInstance();
                r.mostrarPantalla();
            }else{
                avisar(DENEGADO);
            }
        }
    }
}
