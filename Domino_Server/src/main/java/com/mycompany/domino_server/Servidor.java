

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
    
    private List<Jugador> clienteJugadores = new ArrayList<>();

    private ConfiguracionDTO c =null;
    private int numeroJugadores;
     private volatile boolean configuracionActiva = false;
    public void addClienteJugadores(Jugador jugador) {
        clienteJugadores.add(jugador);
    }
    
    public ConfiguracionDTO getC() {
        return c;
    }
    
    
    public List<JugadorDTO> getJugadoresDTO(){
        List<JugadorDTO> jugadores = new ArrayList<>();
        for (Jugador clienteJugadore : clienteJugadores) {
            
        }
        return jugadores;
    }
    public List<Jugador> getClienteJugadores() {
        return clienteJugadores;
    }
     public void enviarATodos(Object evento) {
        for (Jugador jugador : clienteJugadores) {
            jugador.enviarRespuesta(evento); // Llama al método de Jugador
        }
    }
    public void setClienteJugadores(List<Jugador> clienteJugadores) {
        this.clienteJugadores = clienteJugadores;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    public void setC(ConfiguracionDTO c) {
        this.c = c;
    }

    public boolean isConfiguracionActiva() {
        return configuracionActiva;
    }

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
