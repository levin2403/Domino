

package com.mycompany.domino_server;

import DTOs.JugadorDTO;
import Eventos.EventoBuscarPartida;
import Eventos.EventoEstablecerConfiguracion;
import Eventos.EventoRealizarJugada;
import Eventos.EventoRegistrarJugador;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruzzky
 */
public class Jugador extends Thread {

    private Socket clientSocket;
    private BufferedWriter out;
    private BufferedReader in;
    private Servidor server;
    private JugadorDTO jugador;
    
        public Jugador(Socket clientSocket, Servidor server) {
        this.clientSocket = clientSocket;
        this.server = server;

        try {
            // Cambiar ObjectOutputStream por BufferedWriter
            this.out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Jugador(JugadorDTO jugador) {
        this.jugador = jugador;
    }
        
        
   //algo asi debe de comenzar a ser el orden 
    public void run() {

    }

    private Object intentarConvertirEvento(String mensaje, Gson gson) {

    }

    private Object intentarConvertirEventos(String mensaje, Gson gson) {

    

    //private void procesarEventoBuscarPartida( )  {

    }

    private void procesarEventoEstablecerConfiguracion(EventoEstablecerConfiguracion evento) throws IOException {


    }

    private void procesarEventoRegistrarJugador(EventoRegistrarJugador e) throws IOException {
  

    }

    public boolean comprobarCupo() {

    }

    private void procesarEventoRealizarJugada(EventoRealizarJugada evento) {
        // Procesar EventoRealizarJugada aquí
    }

    public void enviarRespuesta(Object evento) {
        
        
    }
    
}
