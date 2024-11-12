

package com.mycompany.domino_server;

import DTOs.JugadorDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

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
    
    //ocupare esto 
}
