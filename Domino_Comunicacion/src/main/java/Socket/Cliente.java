package Socket;

import Eventos.EventoBuscarPartida;
import Observer.ObserverSocket;
import java.io.IOException;
import java.net.Socket;

/**
 * Clase Cliente
 *
 * Esta clase implementa el patrón Singleton para crear una única instancia de
 * cliente que se conecta a un servidor en localhost en el puerto 1234. Gestiona
 * una conexión establecida a través de la clase `Conexion` y permite el envío
 * de mensajes en formato JSON al servidor, además de registrar observadores
 * para escuchar eventos específicos.
 *
 *
 * @author Ruzzky
 */
public class Cliente {

    private volatile static Cliente instance;
    private Conexion cone;

    private Cliente() {
    }

    public static synchronized Cliente getInstance() {

        if (instance == null) {
            Socket socket;
            try {
                socket = new Socket("localhost", 1234);
                instance = new Cliente(socket);
            } catch (IOException ex) {

                return null;
            }

        }
        return instance;
    }

    public Cliente(Socket socket) {

        cone = new Conexion(socket);
        cone.start();
    }

    public Conexion getCone() {
        return cone;
    }

    public void registrarObserver(Class<?> tipoEvento, ObserverSocket observer) {
        cone.registrarObserver(tipoEvento, observer);
    }

    public void setCone(Conexion cone) {
        this.cone = cone;
    }

    public void enviarJSON(String json) {
        if (cone != null) {
            cone.enviarJSON(json);  // Utiliza el método enviarJSON de Conexion
        } else {
            System.out.println("Conexión no establecida.");
        }
    }
}
