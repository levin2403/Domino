

package com.mycompany.domino_server;

import DTOs.Acciones;
import DTOs.ConfiguracionDTO;
import DTOs.JugadorDTO;
import Eventos.EventoBuscarPartida;
import Eventos.EventoEstablecerConfiguracion;
import Eventos.EventoRealizarJugada;
import Eventos.EventoRegistrarJugador;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonSyntaxException;
import java.util.Arrays;
import java.util.List;

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

    public JugadorDTO getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDTO jugador) {
        this.jugador = jugador;
    }

    @Override
    public void run() {
        Gson gson = new Gson();
        try {
            while (true) {
                String mensaje = in.readLine();
                if (mensaje != null) {
                    // Intentar convertir el mensaje JSON a EventoBuscarPartida

                    Object evento = intentarConvertirEventos(mensaje, gson);
                    System.out.println(evento.getClass().toString() + "EstoSalio");

                    if (evento instanceof EventoBuscarPartida) {
                        procesarEventoBuscarPartida((EventoBuscarPartida) evento);
                    } else if (evento instanceof EventoEstablecerConfiguracion) {
                       ;
                    } else if (evento instanceof EventoRealizarJugada) {
                        procesarEventoRealizarJugada((EventoRealizarJugada) evento);
                    } else if (evento instanceof EventoRegistrarJugador) {
                        ;
                    } else {
                        System.out.println("No se pudo identificar el tipo de evento.");
                    }

                }
            }
        } catch (IOException e) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Object intentarConvertirEvento(String mensaje, Gson gson) {
        List<Class<?>> tiposEventos = Arrays.asList(
                EventoBuscarPartida.class,
                EventoEstablecerConfiguracion.class,
                EventoRealizarJugada.class,
                EventoRegistrarJugador.class
        // Agrega más clases de eventos según sea necesario
        );
        System.out.println(mensaje);
        for (Class<?> tipoEvento : tiposEventos) {
            try {
                return gson.fromJson(mensaje, tipoEvento);
            } catch (JsonSyntaxException e) {
                // Ignorar excepción y seguir con el siguiente tipo
            }
        }
        return null;
    }

    private Object intentarConvertirEventos(String mensaje, Gson gson) {
        JsonObject jsonObject = JsonParser.parseString(mensaje).getAsJsonObject();
        String tipoEvento = jsonObject.get("TIPO_EVENTO").getAsString();

        switch (tipoEvento) {
            case "eventoBuscarPartida":
                return gson.fromJson(mensaje, EventoBuscarPartida.class);
            case "eventoEstablecerConfiguracion":
                return gson.fromJson(mensaje, EventoEstablecerConfiguracion.class);
            case "eventoRealizarJugada":
                return gson.fromJson(mensaje, EventoRealizarJugada.class);
            case "eventoRegistrarJugador":
                return gson.fromJson(mensaje, EventoRegistrarJugador.class);
            // Puedes agregar más casos si tienes más tipos de eventos
            default:
                return null;  // Retorna null si no coincide con ningún tipo conocido
        }
    }

    private void procesarEventoBuscarPartida(EventoBuscarPartida evento) throws IOException {
        if (evento.getAccion() == Acciones.BUSCARPARTIDA) {
            if (server.getC() == null) {
                evento.setRespuesta(false);
                enviarRespuesta(evento);
            } else {
                evento.setRespuesta(true);
                evento.setConfiguracion(server.getC());
                enviarRespuesta(evento);
            }

        }
    }

    



    public boolean comprobarCupo() {
        if (server.getC().getNumJugadores() >= server.getNumeroJugadores()) {
            return true;
        }
        return false;
    }

    private void procesarEventoRealizarJugada(EventoRealizarJugada evento) {
        // Procesar EventoRealizarJugada aquí
    }

    public void enviarRespuesta(Object evento) {
        try {
            Gson gson = new Gson();
            String respuestaJson = gson.toJson(evento);
            out.write(respuestaJson);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, "Error al enviar respuesta: " + e.getMessage(), e);

        }
    }

}
