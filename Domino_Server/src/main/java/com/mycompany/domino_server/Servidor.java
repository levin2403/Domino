

package com.mycompany.domino_server;

import DTOs.ConfiguracionDTO;
import DTOs.JugadorDTO;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *La clase Servidor representa un servidor que 
 * maneja muchas conexiones de clientes
 * Este servidor escucha las conexiones de los clientes y permite 
 * la configuración y el intercambio de datos entre los jugadores conectados.
 *
 * @author Ruzzky
 */
public class Servidor {
    
    
    // Lista de jugadores conectados al servidor 
    //es pá q sepan tambn pq la hice 
    private List<Jugador> clienteJugadores = new ArrayList<>();

    // Configuración actual del juego
    private ConfiguracionDTO c =null;
    
     // Número de jugadores permitidos
    private int numeroJugadores;
    
    // Variable de control para verificar si la configuración está activa
     private volatile boolean configuracionActiva = false;
     
    /**
     * Agrega un jugador a la lista de jugadores conectados.
     * 
     * @param jugador El objeto Jugador que se va a agregar.
     */ 
    public void addClienteJugadores(Jugador jugador) {
        clienteJugadores.add(jugador);
    }
    
    /**
     * Obtiene la configuración actual del juego.
     * 
     * @return La configuración del juego en un objeto ConfiguracionDTO.
     */
    public ConfiguracionDTO getC() {
        return c;
    }
    
    /**
     * Convierte y devuelve la lista de jugadores conectados en una lista de objetos JugadorDTO.
     * Esto facilita la transferencia de datos de los jugadores en un formato estándar.
     * 
     * @return Lista de jugadores en formato JugadorDTO.
     */
    public List<JugadorDTO> getJugadoresDTO(){
        List<JugadorDTO> jugadores = new ArrayList<>();
        for (Jugador clienteJugadore : clienteJugadores) {
            
        }
        return jugadores;
    }
    /**
     * Obtiene la lista de jugadores conectados al servidor.
     * 
     * @return Lista de objetos Jugador.
     */
    public List<Jugador> getClienteJugadores() {
        return clienteJugadores;
    }
    
    /**
     * Envía un objeto de evento a todos los jugadores conectados.
     * 
     * @param evento El objeto que se enviará a cada jugador.
     */
     public void enviarATodos(Object evento) {
        for (Jugador jugador : clienteJugadores) {
            jugador.enviarRespuesta(evento); // Llama al método de Jugador
        }
    }
     
    /**
     * Establece la lista de jugadores conectados.
     * 
     * @param clienteJugadores La nueva lista de jugadores.
     */ 
    public void setClienteJugadores(List<Jugador> clienteJugadores) {
        this.clienteJugadores = clienteJugadores;
    }
    
    /**
     * Obtiene el número de jugadores configurado para el juego.
     * 
     * @return El número de jugadores.
     */
    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    /**
     * Establece el número de jugadores permitido para el juego.
     * 
     * @param numeroJugadores El número de jugadores.
     */
    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    /**
     * Establece la configuración actual del juego.
     * 
     * @param c La configuración en un objeto ConfiguracionDTO.
     */
    public void setC(ConfiguracionDTO c) {
        this.c = c;
    }

    /**
     * Verifica si la configuración está activa.
     * 
     * @return true si la configuración está activa; false en caso contrario.
     */
    public boolean isConfiguracionActiva() {
        return configuracionActiva;
    }

    /**
     * Establece el estado de activación de la configuración.
     * 
     * @param configuracionActiva true para activar la configuración; false para desactivarla.
     */
    public void setConfiguracionActiva(boolean configuracionActiva) {
        this.configuracionActiva = configuracionActiva;
    }
    
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);

        System.out.println("Servidor inicializado en el puerto 1234");

        Servidor server = new Servidor();

        while (true) {
            Socket s = ss.accept();
            System.out.println("Nueva conexión por parte de cliente: " + s);

            // Crear un nuevo jugador (cliente) y agregarlo a la lista
            Jugador client = new Jugador(s, server);
            server.addClienteJugadores(client);
            client.start();
        }
    }
}
