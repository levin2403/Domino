/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license   
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import DTOs.Acciones;
import static DTOs.Acciones.CERRARVENTANA;
import DTOs.ConfiguracionDTO;
import Eventos.EventoEstablecerConfiguracion;
import Eventos.EventoRegistrarJugador;
import ObjetosNegocio.ConfiguracionBO;
import Observer.ObserverEstablecerConfiguracion;
import Observer.ObserverSocket;
import Socket.Cliente;
import fachada.Fachada;
import fachadas.IFachada;
import filtro.FiltroConfiguracion;
import filtro.FiltroJson;
import interfaz.IPipe;
import pipe.PipeBasico;

/**
 *
 * @author skevi
 */
public class LogicaEstablecerConfiguracion implements ObserverSocket {

    //instancia golbal de la configuracion
    IFachada fachada;
    private volatile static LogicaEstablecerConfiguracion instance;

    public static synchronized LogicaEstablecerConfiguracion getInstance() {
        if (instance == null) {
            instance = new LogicaEstablecerConfiguracion();
        }
        return instance;
    }

    /**
     * Constructor de la clase.
     */
    public LogicaEstablecerConfiguracion() {

        //iniciamos instancia del modelo
        fachada = Fachada.getFachada();
        Cliente cliente = Cliente.getInstance();
        cliente.registrarObserver(EventoRegistrarJugador.class, this);
        cliente.registrarObserver(EventoEstablecerConfiguracion.class, this);

    }
    ObserverEstablecerConfiguracion observerConfigModel;
    ObserverEstablecerConfiguracion observerConfig = new ObserverEstablecerConfiguracion() {

        @Override
        public void actualizarConfiguracion(Object objecto) {
            if (objecto instanceof Acciones) {
                Acciones accion = (Acciones) objecto;

                if (accion == accion.MENU) {
                    avisar(CERRARVENTANA);
                    LogicaMenu m = LogicaMenu.getInstance();
                    m.mostrarPantalla();
                }

            } else if (objecto instanceof ConfiguracionDTO) {
                ConfiguracionDTO c = (ConfiguracionDTO) objecto;
                crearPartida(c);
                avisar(CERRARVENTANA);
            }
        }

    };

    public ObserverEstablecerConfiguracion getObserverConfig() {
        return observerConfigModel;
    }

    public void setObserverConfig(ObserverEstablecerConfiguracion observerMenu) {
        this.observerConfigModel = observerMenu;
    }

    public void mostrarPantalla() {
        this.observerConfigModel = fachada.showFrmMatchSettings(observerConfig);
    }

    public void crearPartida(ConfiguracionDTO c) {
        IPipe<EventoEstablecerConfiguracion> pipa = new PipeBasico();
        IPipe<EventoEstablecerConfiguracion> pipa2 = new PipeBasico();

        FiltroConfiguracion filtroConfiguracion = new FiltroConfiguracion();
        FiltroJson filtroJson = new FiltroJson();
        pipa.setFiltro(filtroConfiguracion);
        filtroConfiguracion.setPipe(pipa2);
        pipa2.setFiltro(filtroJson);
        EventoEstablecerConfiguracion e = new EventoEstablecerConfiguracion();
        e.setConfiguracion(c);
        pipa.enviar(e);

        Cliente cliente = Cliente.getInstance();
        cliente.enviarJSON((String) filtroJson.getMensaje());
    }

    /**
     * Establecemos la configuracion al singletone para su uso en otras clases.
     */
//    public void establecerConfiguracionInicial(){
//        int numfichas = settingsModel.getNumberOfTiles(); // numero de fichas
//        int numJugadores = settingsModel.getNumberOfPlayers(); //numero de jugadores
//        
//        //instanciamos una nueva configuracion con los datos del modelo
//        ConfiguracionDTO configuracion = 
//                new ConfiguracionDTO(numfichas, numJugadores);
//        
//        //establecemos la nueva configuracion a la instancia global 
//        configuracion.setFichasARepartir(numfichas);
//        configuracion.setNumJugadores(numJugadores);
//        
//        //pasamos la configuracion a su primera pipe
//        //para que se vaya al servidor.
//        
//    }
    public void avisar(Object objecto) {

        observerConfigModel.actualizarConfiguracion(objecto);

    }

    public void siguienteFrame() {
        //Creas el mediador (Hacer fachada al mediador y hacer el mediador singleton)
        //Creas el siguiente evento (este aun  no se usa pero es para abrir el frame)
        LogicaRegistrarJugador rJ = new LogicaRegistrarJugador();
        Observer.ObserverRegistrarJugador observer = rJ.getObserverRegistrarJugador();
        //EL metodo del mediador regresa un modelo para poderlo asignar al evento que le corresponde
        fachada.showFrmPlayerSettings(observer); //pides al mediador que abra el frame y guardas el modelo de ese frame
    }

    //Aqui estara el observer 
    @Override
    public void update(Object evento) {
//        
        if (evento instanceof EventoEstablecerConfiguracion) {
            EventoEstablecerConfiguracion r = (EventoEstablecerConfiguracion) evento;

            avisar(CERRARVENTANA);
            ConfiguracionBO c = new ConfiguracionBO();
            c.setFichasPorJugador((byte) r.getConfiguracion().getFichasARepartir());
            c.setNumJugadores((byte) r.getConfiguracion().getNumJugadores());
            
            LogicaRegistrarJugador l = LogicaRegistrarJugador.getInstance();
            l.mostrarPantalla();
            
        }
    }

}
