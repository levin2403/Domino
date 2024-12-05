package Socket;

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
    // Clase singleton que gestiona la conexión del cliente con el servidor

    private volatile static Cliente instance; // Instancia única de Cliente
    private Conexion cone; // Objeto para gestionar la conexión

    private Cliente() {  
        // Constructor privado para evitar instanciación externa
    }

    public static synchronized Cliente getInstance() {  
        // Devuelve la instancia única de Cliente, creando una nueva si no existe
        if (instance == null) {
            Socket socket;
            try {
                socket = new Socket("10.202.91.83", 3012); // Conecta al servidor en localhost y puerto 1234
                instance = new Cliente(socket); // Crea una nueva instancia de Cliente
            } catch (IOException ex) {
                return null; // Devuelve null si ocurre un error al conectar
            }
        }
        return instance;
    }

    public Cliente(Socket socket) {  
        // Constructor que inicializa la conexión y la arranca
        cone = new Conexion(socket);
        cone.start();
    }

    public Conexion getCone() {  
        return cone; // Obtiene la conexión actual
    }

    public void registrarObserver(Class<?> tipoEvento, ObserverSocket observer) {  
        // Registra un observer para eventos específicos en la conexión
        cone.registrarObserver(tipoEvento, observer);
    }

    public void setCone(Conexion cone) {  
        this.cone = cone; // Establece una nueva conexión
    }

    public void enviarJSON(String json) {  
        // Envía un mensaje JSON al servidor a través de la conexión
        if (cone != null) {
            cone.enviarJSON(json); // Llama al método enviarJSON de Conexion
        } else {
            System.out.println("Conexión no establecida."); // Mensaje si no hay conexión
        }
    }
}
