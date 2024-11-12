package Socket;

import Eventos.EventoBuscarPartida;
import Observer.ObserverSocket;
import java.io.IOException;
import java.net.Socket;

/**
 * Clase Cliente
 *
 * Esta clase implementa el patrón Singleton para crear una única instancia de cliente 
 * que se conecta a un servidor en localhost en el puerto 1234. Gestiona una conexión 
 * establecida a través de la clase `Conexion` y permite el envío de mensajes en formato JSON 
 * al servidor, además de registrar observadores para escuchar eventos específicos.
 * 
 * 
 * @author Ruzzky
 */
public class Cliente {

    // Instancia única y compartida de Cliente
    private volatile static Cliente instance;
    // Objeto de conexión al servidor
    private Conexion cone;

    // Constructor privado para prevenir instanciación directa
    private Cliente() {}

    /**
     * Obtiene la instancia única de Cliente.
     * Si la instancia aún no existe, intenta crear una nueva conexión al servidor 
     * en el puerto especificado (1234) en localhost.
     *
     * @return La instancia única de Cliente o null si ocurre un error.
     */
    public static synchronized Cliente getInstance() {
        if (instance == null) {
            Socket socket;
            try {
                System.out.println("Estableciendo conexión...");
                socket = new Socket("localhost", 1234);
                instance = new Cliente(socket);
            } catch (IOException ex) {
                System.out.println("No se pudo establecer la conexión.");
                return null;
            }
        }
        return instance;
    }

    /**
     * Constructor privado que inicializa la conexión con el socket especificado.
     *
     * @param socket Socket ya conectado al servidor.
     */
    public Cliente(Socket socket) {
        cone = new Conexion(socket);
        cone.start(); // Inicia el hilo de conexión
    }

    /**
     * Devuelve el objeto de conexión actual.
     *
     * @return La conexión actual (`Conexion`).
     */
    public Conexion getCone() {
        return cone;
    }

    /**
     * Registra un observador para un tipo de evento específico.
     *
     * @param tipoEvento Clase del evento a observar.
     * @param observer Observador que escucha el evento.
     */
    public void registrarObserver(Class<?> tipoEvento, ObserverSocket observer) {
        cone.registrarObserver(tipoEvento, observer);
    }

    /**
     * Establece el objeto de conexión.
     *
     * @param cone Nueva conexión de tipo `Conexion`.
     */
    public void setCone(Conexion cone) {
        this.cone = cone;
    }

    /**
     * Envía un mensaje en formato JSON al servidor.
     * Si la conexión no está establecida, imprime un mensaje de error.
     *
     * @param json Cadena en formato JSON a enviar.
     */
    public void enviarJSON(String json) {
        if (cone != null) {
           
        } else {
            System.out.println("Conexión no establecida.");
        }
    }
}
