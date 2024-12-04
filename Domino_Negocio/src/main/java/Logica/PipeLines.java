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
    private volatile static PipeLines instance;
    private IPipe<?> pipeLinePartida;
    private IPipe<?> pipeLineJuego;
    private IPipe<?> pipeLineTerminar;

    public static synchronized PipeLines getInstance() {
        if (instance == null) {
            instance = new PipeLines();
        }
        return instance;
    }

    public PipeLines() {

    }

    public <T> IPipe<T> crearPipeLineJuego() {
        IPipe<T> pipa = new PipeBasico<>();
        IPipe<T> pipa2 = new PipeBasico<>();
        IPipe<T> pipa3 = new PipeBasico<>();
        FiltroRoboPozo filtroRoboPozo = new FiltroRoboPozo();
        FiltroRealizarJugada filtroRealizarJugada = new FiltroRealizarJugada();// Este filtro debe ser específico para T
        FiltroJson filtroJson = new FiltroJson();

        pipa.setFiltro(filtroRealizarJugada);
        
        filtroRealizarJugada.setPipe(pipa2);
        
        pipa2.setFiltro(filtroRoboPozo);
        
        filtroRoboPozo.setPipe(pipa3);
        
        pipa3.setFiltro(filtroJson);

        return pipa;
    }
    

    public <T> IPipe<T> crearPipeLinePartida() {
        IPipe<T> pipa = new PipeBasico<>();
        IPipe<T> pipa2 = new PipeBasico<>();
        IPipe<T> pipa3 = new PipeBasico<>();
        IPipe<T> pipa4 = new PipeBasico<>();
        IPipe<T> pipa5 = new PipeBasico<>();

        FiltroConfiguracion filtroConfiguracion = new FiltroConfiguracion();
        FiltroBuscarPartida filtroPartida = new FiltroBuscarPartida();
        FiltroRegistrarJugador filtroRegistrarJugador = new FiltroRegistrarJugador();
        FiltroIniciarPartida filtroIniciarPartida = new FiltroIniciarPartida();
        FiltroJson filtroJson = new FiltroJson();
        
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

    public <T> IPipe<T> crearPipeLineTerminar() {
        IPipe<T> pipa = new PipeBasico<>();
        IPipe<T> pipa2 = new PipeBasico<>();

        FiltroTerminarPartida filtroTerminar = new FiltroTerminarPartida();
        
        // Este filtro debe ser específico para T
        FiltroJson filtroJson = new FiltroJson();

        pipa.setFiltro(filtroTerminar);
        filtroTerminar.setPipe(pipa2);
        pipa2.setFiltro(filtroJson);

        return pipa;
    }

    public <T> void crearYGuardarPipelinePartida(Class<T> tipoClase) {
        this.pipeLinePartida = crearPipeLinePartida();
    }

    public <T> void crearYGuardarPipelineTerminar(Class<T> tipoClase) {
        this.pipeLineTerminar = crearPipeLineTerminar();
    }

    public <T> void crearYGuardarPipelineJuego(Class<T> tipoClase) {
        this.pipeLineJuego = crearPipeLineJuego();
    }

    @SuppressWarnings("unchecked")
    public <T> void enviarDatoPipeLineJuego(T dato) {
        if (pipeLineJuego == null) {
            throw new IllegalStateException("El pipeline de juego no está configurado.");
        }
        try {
           
            ((IPipe<T>) pipeLineJuego).enviar(dato);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(
                    "El tipo del dato no coincide con el tipo del pipeline configurado.", e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> void enviarDatoPipeLineTerminar(T dato) {
        if (pipeLineTerminar == null) {
            throw new IllegalStateException("El pipeline de terminar no está configurado.");
        }
        try {
         
            ((IPipe<T>) pipeLineTerminar).enviar(dato);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(
                    "El tipo del dato no coincide con el tipo del pipeline configurado.", e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> void enviarDatoPipeLinePartida(T dato) {
        if (pipeLinePartida == null) {
            throw new IllegalStateException("El pipeline no está configurado.");
        }
        try {
            
            ((IPipe<T>) pipeLinePartida).enviar(dato);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(
                    "El tipo del dato no coincide con el tipo del pipeline configurado.", e);
        }
    }
}
