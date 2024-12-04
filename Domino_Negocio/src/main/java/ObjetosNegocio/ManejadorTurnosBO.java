/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import Conversores.FichaCVR;
import Conversores.JugadorCVR;
import Conversores.ManejadorTurnosCVR;
import DTOs.FichaDTO;
import DTOs.JugadorDTO;
import DTOs.ManejadorTurnosDTO;
import Entidades.Jugador;
import Entidades.ManejadorTurnos;
import Entidades.Partida;
import singleton.PartidaST;

/**
 * Objeto de negocio de ManejadorTurnos que funciona como controlador entre la
 * clase de domino y la clase de negocio, contiene los metodos del objeto de
 * dominio con la diferencia que ahora se usaran DTOs.
 *
 * @author skevi
 */
public class ManejadorTurnosBO {

    //instancia del singletone de partida.
    //convertidor para jugador.
    private JugadorCVR jugadorCVR;

    private FichaCVR fichaCVR;

    /**
     * Contructor de la clase.
     */
    public ManejadorTurnosBO() {
        this.fichaCVR = new FichaCVR();
        this.jugadorCVR = new JugadorCVR();
    }

    /**
     * Metodo que determina turnos aleatorios para los jugadores, este metodo se
     * ejecutara unicamente una sola vez, el iniciar la partida. Igualmente
     * asignara a un jugador en turno al momento de ejecutarse.
     */
    public void determinarTurnos() {
        Partida partida = PartidaST.getInstance();
        partida.getManejadorTurnos().asignarTurnos();
    }

    /**
     * Metodo que añade a un jugador a la lista actual de jugadores.
     */
    public void añadirJugador(JugadorDTO jugador) {
        //Convertimos el jugador recibido en el parametro
        Jugador jugadorEntidad = jugadorCVR.
                jugadorConvertirDTOAEntidad(jugador);
        Partida partida = PartidaST.getInstance();
        // pasamos el jugador a dominio
        partida.getManejadorTurnos().añadirJugador(jugadorEntidad);
    }

    public void cambiarManejadorTurnos(ManejadorTurnosDTO m) {
        ManejadorTurnosCVR manejadorCVR = new ManejadorTurnosCVR();
        ManejadorTurnos manejador = manejadorCVR.toEntity(m);
        Partida partida = PartidaST.getInstance();
        // pasamos el jugador a dominio
        partida.setManejadorTurnos(manejador);
    }

    /**
     * Metodo que elimina a un jugador de la lista actual de jugadores en caso
     * de abandono de la partida.
     *
     */
    public int cantidaFichas() {
        Partida partida = PartidaST.getInstance();
        return partida.getManejadorTurnos().getPozo().fichasDisponibles();
    }

    public void asignarFichas() {

        Partida partida = PartidaST.getInstance();
        partida.getManejadorTurnos().asignarFichas(partida.getConfiguracion().getFichasPorJugador());
    }

    public void eliminarFicha(FichaDTO f) {
        Partida partida = PartidaST.getInstance();
        partida.getManejadorTurnos().getPozo().quitarFicha(fichaCVR.fichaConvertirDTOAEntidad(f));
    }

    public void eliminarJugador(JugadorDTO jugador) {
        //Convertimos el jugador recibido en el parametro
        Jugador jugadorEntidad = jugadorCVR.
                jugadorConvertirDTOAEntidad(jugador);
        Partida partida = PartidaST.getInstance();
        partida.getManejadorTurnos().eliminarJugador(jugadorEntidad);
    }

    /**
     * Metodo para obtener el jugador que se encuentra en turno.
     *
     * @return Jugador en turno.
     */
    public JugadorDTO getJugadorEnturno() {
        Partida partida = PartidaST.getInstance();
        JugadorDTO jugador = jugadorCVR.
                jugadorConvertirEntidadADTO(partida.getManejadorTurnos().
                        getJugadorEnturno());

        return jugador;
    }

    public ManejadorTurnosDTO getManejadorDTO() {
        ManejadorTurnosCVR manejadorCVR = new ManejadorTurnosCVR();
        Partida partida = PartidaST.getInstance();
        return manejadorCVR.toDTO(partida.getManejadorTurnos());
    }

    public void inicialFicha() {
        ManejadorTurnosCVR manejadorCVR = new ManejadorTurnosCVR();
        Partida partida = PartidaST.getInstance();
        ManejadorTurnosDTO m = manejadorCVR.toDTO(partida.getManejadorTurnos());
        JugadorDTO jugador = m.getJugadores().get(0);
        FichaDTO mulaMasGrande = null;

        for (FichaDTO ficha : jugador.getFichas()) {
            if (ficha.isMula(ficha)) {
                int valorTotal = ficha.getValorSuperior() + ficha.getValorInferior(); // O la lógica que decidas
                // Si es la primera mula o es más grande, la asignamos
                if (mulaMasGrande == null || valorTotal > (mulaMasGrande.getValorSuperior() + mulaMasGrande.getValorInferior())) {
                    mulaMasGrande = ficha;
                }
            }
        }
        this.quitarFicha(jugador, mulaMasGrande);
    }

    public void quitarFicha(JugadorDTO j, FichaDTO f) {
        ManejadorTurnosCVR manejadorCVR = new ManejadorTurnosCVR();
        Partida partida = PartidaST.getInstance();
        ManejadorTurnosDTO m = manejadorCVR.toDTO(partida.getManejadorTurnos());
        for (int i = 0; i < m.getJugadores().size(); i++) {
            if (m.getJugadores().get(i).equals(j)) {
                m.getJugadores().get(i).eliminarFicha(f);
            }
        }
        this.cambiarManejadorTurnos(m);
    }

    public void agregarFicha(JugadorDTO j, FichaDTO f) {
        ManejadorTurnosCVR manejadorCVR = new ManejadorTurnosCVR();
        Partida partida = PartidaST.getInstance();
        ManejadorTurnosDTO m = manejadorCVR.toDTO(partida.getManejadorTurnos());
        for (int i = 0; i < m.getJugadores().size(); i++) {
            if (m.getJugadores().get(i).equals(j)) {
                System.out.println("fichas" + m.getJugadores().get(i).cantidadFichas());
                m.getJugadores().get(i).añadirFicha(f);
                System.out.println("fichas" + m.getJugadores().get(i).cantidadFichas());
            }
        }
        this.cambiarManejadorTurnos(m);
    }

    /**
     * Metodo para pasar de turno en caso de que el jugador que se encontraba en
     * turno ya haya realizado su jugada.
     *
     */
    public void pasarTurno() {
        Partida partida = PartidaST.getInstance();

        partida.getManejadorTurnos().pasarTurno();
    }

}
