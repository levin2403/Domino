

package com.mycompany.domino_server;

import DTOs.Acciones;
import Eventos.EventoBuscarPartida;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * La clase Cliente permite la conexión a un servidor mediante sockets para enviar y recibir
 * mensajes en formato JSON. Este cliente se comunica con el servidor, enviando una solicitud
 * para buscar una partida de dominó y recibiendo una respuesta del servidor. 
 * xdxdxd LMFAO Lol osea OMG en plan holy shit
 *
 *
 * @author Ruzzky
 */
public class Cliente {
    // Dirección y puerto del servidor
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;
    
    public static void main(String[] args) {
        
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);//PUERTO Y DIRECCION PORFAVORE, ES LO PRINCIPAL Q SE OCUPA
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Crear un objeto EventoBuscarPartida
            EventoBuscarPartida evento = new EventoBuscarPartida();
            evento.setAccion(Acciones.BUSCARPARTIDA);

            // Convertir el objeto EventoBuscarPartida a JSON usando Gson
            Gson gson = new Gson();
            String jsonParaEnviar = gson.toJson(evento);

            // Enviar el JSON como String
            System.out.println("enviando"+jsonParaEnviar);
            out.write(jsonParaEnviar);
            out.newLine(); // Añadir una nueva línea para indicar fin del mensaje
            out.flush();

            // Leer la respuesta JSON del servidor
            String respuestaJson = in.readLine();
            EventoBuscarPartida respuestaEvento = gson.fromJson(respuestaJson, EventoBuscarPartida.class);

            // Mostrar la respuesta
            System.out.println("Respuesta del servidor: " + respuestaEvento.getRespuestaString());
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
    
}
