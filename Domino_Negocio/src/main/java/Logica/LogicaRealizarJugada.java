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
import Eventos.EventoObtenerFichaPozo;
import Eventos.EventoRealizarJugada;
import Eventos.EventoRegistrarJugador;
import ObjetosNegocio.ManejadorTurnosBO;
import ObjetosNegocio.PozoBO;
import Observer.ObserverRealizarJugada;
import Observer.ObserverSocket;
import Socket.Cliente;
import fachada.Fachada;
import fachadas.IFachada;
import filtro.FiltroJson;
import filtro.FiltroRealizarJugada;
import filtro.FiltroRegistrarJugador;
import filtro.FiltroRoboPozo;
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
        cliente.registrarObserver(EventoRealizarJugada.class, this);
        cliente.registrarObserver(EventoObtenerFichaPozo.class, this);
    }

    ObserverRealizarJugada observerRealizarJugada = new ObserverRealizarJugada() {
        @Override
        public void actualizar(Object objecto) {
            if (objecto instanceof PlayerSettingsModelDTO) {

                avisar(CERRARVENTANA);
                registrarJugador((PlayerSettingsModelDTO) objecto);
            }
            else if (objecto instanceof JugadaDTO e) {
                realizarJugada(e);
            }
            else if(objecto instanceof JugadorDTO d){
                obtenerPozo(d);
            }
            
        }
    };

    public void avisar(Object objecto) {
        observerRegistrarModel.actualizar(objecto);
        
    }
    public void obtenerPozo(JugadorDTO j){
        PozoBO p = new PozoBO();
        
        
        FichaDTO f = p.obtenerFicha();
        
        if (f==null) {
            avisar(POZOVACIO);
        }else{
            robarFicha(j, f);
        }
    }
    public void robarFicha(JugadorDTO j,FichaDTO f){
        EventoObtenerFichaPozo e = new EventoObtenerFichaPozo();
        e.setFicha(f);
        e.setJugador(j);
        IPipe<EventoObtenerFichaPozo> pipa = new PipeBasico();
        IPipe<EventoObtenerFichaPozo> pipa2 = new PipeBasico();
        FiltroRoboPozo filtroRoboPozo = new FiltroRoboPozo();
        FiltroJson filtroJson = new FiltroJson();
        pipa.setFiltro(filtroRoboPozo);
        filtroRoboPozo.setPipe(pipa2);
        pipa2.setFiltro(filtroJson);
        pipa.enviar(e);
        Cliente c = Cliente.getInstance();
        c.enviarJSON((String) filtroJson.getMensaje());
    }
    public void realizarJugada(JugadaDTO jugada){
        EventoRealizarJugada e = new EventoRealizarJugada(jugada);
        IPipe<EventoRealizarJugada> pipa = new PipeBasico();
        IPipe<EventoRealizarJugada> pipa2 = new PipeBasico();
        FiltroRealizarJugada filtroRealizarJugada = new FiltroRealizarJugada();
        FiltroJson filtroJson = new FiltroJson();
        pipa.setFiltro(filtroRealizarJugada);
        filtroRealizarJugada.setPipe(pipa2);
        pipa2.setFiltro(filtroJson);
        pipa.enviar(e);
        Cliente c = Cliente.getInstance();
        c.enviarJSON((String) filtroJson.getMensaje());
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

    public ObserverRealizarJugada getObserverRealizarJugada() {
        return observerRealizarJugada;
    }
    ObserverRealizarJugada observerRegistrarModel;

    public ObserverRealizarJugada getObserverJugadaModel() {
        return observerRegistrarModel;
    }

    public void mostrarPantalla() {
        this.observerRegistrarModel = fachada.showFrmMatchOngoing(observerRealizarJugada);
    }

    public void setObserverRealizarModel(ObserverRealizarJugada observerRealizar) {
        this.observerRegistrarModel = observerRealizar;
    }

   
    @Override
    public void update(Object evento) {
        if (evento instanceof EventoRegistrarJugador) {

            EventoRegistrarJugador r = (EventoRegistrarJugador) evento;
            if (!r.isHost()) {
                if (r.getJugador().equals(jugador)) {
                    avisar(CERRARVENTANA);
                    LogicaLobby l = LogicaLobby.getInstance();
                    l.setJugador(jugador);
                    l.mostrarPantalla();
                    l.avisar(evento);
                }

            }
        }else if(evento instanceof  EventoRealizarJugada r){
            ManejadorTurnosBO m = new ManejadorTurnosBO();            
            m.quitarFicha(r.getJugador(), r.getFicha());
            this.pasarturno();
            avisar(r);
            avisar(m.getManejadorDTO());
        }else if(evento instanceof EventoObtenerFichaPozo e){
             
             ManejadorTurnosBO m = new ManejadorTurnosBO();   
             
             m.agregarFicha(e.getJugador(), e.getFicha());
             m.eliminarFicha(e.getFicha());
             m.pasarTurno();
             avisar(m.getManejadorDTO());
        }
        

    }
      public void pasarturno(){
           ManejadorTurnosBO m = new ManejadorTurnosBO(); 
           m.pasarTurno();
      }

}