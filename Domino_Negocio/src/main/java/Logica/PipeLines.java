/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import com.mycompany.filtroterminarpartida.FiltroTerminarPartida;
import filtro.FiltroBuscarPartida;
import filtro.FiltroConfiguracion;
import filtro.FiltroIniciarPartida;
import filtro.FiltroJson;
import filtro.FiltroRealizarJugada;
import filtro.FiltroRegistrarJugador;
import filtro.FiltroRoboPozo;
import interfaz.IPipe;
import pipe.PipeBasico;

/**
 *
 * @author Dell
 */
public class PipeLines {

    // Instancia única de PipeLines (Singleton)
    private volatile static PipeLines instance;

    // Pipelines para las diferentes etapas del juego (partida, juego y terminar)
    private IPipe<?> pipeLinePartida;
    private IPipe<?> pipeLineJuego;
    private IPipe<?> pipeLineTerminar;

    /**
     * Obtiene la instancia única de PipeLines utilizando el patrón Singleton.
     * @return La instancia de PipeLines.
     */
    public static synchronized PipeLines getInstance() {
        if (instance == null) {
            instance = new PipeLines();
        }
        return instance;
    }

    /**
     * Constructor de la clase PipeLines.
     * Inicializa la clase, pero no configura los pipelines.
     */
    public PipeLines() {
    }

    /**
     * Crea y configura un pipeline para el juego.
     * 
     * Este pipeline se compone de varios filtros que procesan los datos de la jugada.
     * @param <T> El tipo de los datos que manejará el pipeline.
     * @return El pipeline de juego configurado.
     */
    public <T> IPipe<T> crearPipeLineJuego() {
        IPipe<T> pipa = new PipeBasico<>();
        IPipe<T> pipa2 = new PipeBasico<>();
        IPipe<T> pipa3 = new PipeBasico<>();
        
        // Filtros para el pipeline de juego
        FiltroRoboPozo filtroRoboPozo = new FiltroRoboPozo();
        FiltroRealizarJugada filtroRealizarJugada = new FiltroRealizarJugada(); // Este filtro debe ser específico para T
        FiltroJson filtroJson = new FiltroJson();

        // Configuración de los filtros y pipes
        pipa.setFiltro(filtroRealizarJugada);
        filtroRealizarJugada.setPipe(pipa2);
        pipa2.setFiltro(filtroRoboPozo);
        filtroRoboPozo.setPipe(pipa3);
        pipa3.setFiltro(filtroJson);

        return pipa;
    }

    /**
     * Crea y configura un pipeline para la partida.
     * 
     * Este pipeline incluye varios filtros para procesar la configuración de la partida y el registro del jugador.
     * @param <T> El tipo de los datos que manejará el pipeline.
     * @return El pipeline de partida configurado.
     */
    public <T> IPipe<T> crearPipeLinePartida() {
        IPipe<T> pipa = new PipeBasico<>();
        IPipe<T> pipa2 = new PipeBasico<>();
        IPipe<T> pipa3 = new PipeBasico<>();
        IPipe<T> pipa4 = new PipeBasico<>();
        IPipe<T> pipa5 = new PipeBasico<>();
        
        // Filtros para el pipeline de partida
        FiltroConfiguracion filtroConfiguracion = new FiltroConfiguracion();
        FiltroBuscarPartida filtroPartida = new FiltroBuscarPartida();
        FiltroRegistrarJugador filtroRegistrarJugador = new FiltroRegistrarJugador();
        FiltroIniciarPartida filtroIniciarPartida = new FiltroIniciarPartida();
        FiltroJson filtroJson = new FiltroJson();

        // Configuración de los filtros y pipes
        pipa.setFiltro(filtroConfiguracion);
        filtroConfiguracion.setPipe(pipa2);
        pipa2.setFiltro(filtroPartida);
        filtroPartida.setPipe(pipa3);
        pipa3.setFiltro(filtroRegistrarJugador);
        filtroRegistrarJugador.setPipe(pipa4);
        pipa4.setFiltro(filtroIniciarPartida);
        filtroIniciarPartida.setPipe(pipa5);
        pipa5.setFiltro(filtroJson);

        return pipa;
    }

    /**
     * Crea y configura un pipeline para terminar la partida.
     * 
     * Este pipeline incluye filtros para la terminación de la partida y votación.
     * @param <T> El tipo de los datos que manejará el pipeline.
     * @return El pipeline para terminar configurado.
     */
    public <T> IPipe<T> crearPipeLineTerminar() {
        IPipe<T> pipa = new PipeBasico<>();
        IPipe<T> pipa2 = new PipeBasico<>();
        IPipe<T> pipa3 = new PipeBasico<>();
        IPipe<T> pipa4 = new PipeBasico<>();
        
        // Filtros para el pipeline de terminar
        FiltroTerminarPartida filtroTerminar = new FiltroTerminarPartida();
        FiltroVotacion filtroVotacion = new FiltroVotacion();
        FiltroSalirPartida filtroSalirPartida = new FiltroSalirPartida();
        FiltroJson filtroJson = new FiltroJson();

        // Configuración de los filtros y pipes
        pipa.setFiltro(filtroSalirPartida);
        filtroSalirPartida.setPipe(pipa2);
        pipa2.setFiltro(filtroVotacion);
        filtroVotacion.setPipe(pipa3);
        pipa3.setFiltro(filtroTerminar);
        filtroTerminar.setPipe(pipa4);
        pipa4.setFiltro(filtroJson);

        return pipa;
    }

    /**
     * Crea y guarda un pipeline para la partida.
     * 
     * Este método configura el pipeline de la partida usando el método `crearPipeLinePartida()`.
     * @param <T> El tipo de los datos que manejará el pipeline.
     * @param tipoClase La clase que representa el tipo de los datos.
     */
    public <T> void crearYGuardarPipelinePartida(Class<T> tipoClase) {
        this.pipeLinePartida = crearPipeLinePartida();
    }

    /**
     * Crea y guarda un pipeline para terminar la partida.
     * @param tipoClase La clase que representa el tipo de los datos.
     */
    public <T> void crearYGuardarPipelineTerminar(Class<T> tipoClase) {
        this.pipeLineTerminar = crearPipeLineTerminar();
    }

    /**
     * Crea y guarda un pipeline para el juego.
     * @param tipoClase La clase que representa el tipo de los datos.
     */
    public <T> void crearYGuardarPipelineJuego(Class<T> tipoClase) {
        this.pipeLineJuego = crearPipeLineJuego();
    }

    /**
     * Envía un dato a través del pipeline del juego.
     * @param <T> El tipo de los datos.
     * @param dato El dato a enviar.
     */
    @SuppressWarnings("unchecked")
    public <T> void enviarDatoPipeLineJuego(T dato) {
        if (pipeLineJuego == null) {
            throw new IllegalStateException("El pipeline de juego no está configurado.");
        }
        try {
            ((IPipe<T>) pipeLineJuego).enviar(dato);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("El tipo del dato no coincide con el tipo del pipeline configurado.", e);
        }
    }

    /**
     * Envía un dato a través del pipeline de terminar la partida.
     * @param <T> El tipo de los datos.
     * @param dato El dato a enviar.
     */
    @SuppressWarnings("unchecked")
    public <T> void enviarDatoPipeLineTerminar(T dato) {
        if (pipeLineTerminar == null) {
            throw new IllegalStateException("El pipeline de terminar no está configurado.");
        }
        try {
            ((IPipe<T>) pipeLineTerminar).enviar(dato);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("El tipo del dato no coincide con el tipo del pipeline configurado.", e);
        }
    }

    /**
     * Envía un dato a través del pipeline de la partida.
     * @param <T> El tipo de los datos.
     * @param dato El dato a enviar.
     */
    @SuppressWarnings("unchecked")
    public <T> void enviarDatoPipeLinePartida(T dato) {
        if (pipeLinePartida == null) {
            throw new IllegalStateException("El pipeline no está configurado.");
        }
        try {
            ((IPipe<T>) pipeLinePartida).enviar(dato);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("El tipo del dato no coincide con el tipo del pipeline configurado.", e);
        }
    }
}
