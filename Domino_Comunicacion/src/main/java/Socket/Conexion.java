

package Socket;

import Observer.ObserverSocket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pipe.PipeBasico;

/**
 *
 * @author Ruzzky
 */
import filtros.FiltroEvento;
import interfaz.IPipe;
public class Conexion extends Thread {

    private Socket socket;
    private BufferedWriter out;
    private BufferedReader in;
    private Map<Class<?>, ObserverSocket> observers;
    
      /**
     * Constructor de la clase Conexion.
     *
     * @param socket El socket que conecta al cliente con el servidor.
     */

    public Conexion(Socket socket) {
        this.socket = socket;
        this.observers = new HashMap<>();
        try {
            // Cambiar ObjectOutputStream por BufferedWriter
            this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
     /**
     * Registra un observador para un tipo de evento específico.
     *
     * @param tipoEvento Clase del evento que se desea observar.
     * @param observer Observador que escucha el evento.
     */
    
        public void registrarObserver(Class<?> tipoEvento, ObserverSocket observer) {
        observers.put(tipoEvento, observer);
    }
    
         /**
     * Deserializa un mensaje en formato JSON y lo convierte en un evento específico,
     * notificando a los observadores correspondientes si el evento es válido.
     *
     * @param mensaje El mensaje en formato JSON recibido.
     * @return Devuelve null si no se puede deserializar correctamente.
     */
    private Object deserializarEvento(String mensaje) {
        FiltroEvento filtroJson = new FiltroEvento();
        IPipe pipe = new PipeBasico();

        // Conectar el filtro al pipe y enviar el mensaje para procesarlo
        pipe.setFiltro(filtroJson);
        pipe.enviar(mensaje);

        // Obtener el mensaje procesado
        Object mensajeProcesado = filtroJson.getMensaje();

        // Notificar observadores si el mensaje es válido
        if (mensajeProcesado != null) {
            notificarObserver(mensajeProcesado);
        }

        return null;
    }

    /**
     * Notifica al observador correspondiente del tipo de evento procesado.
     *
     * @param evento Evento procesado a partir del mensaje recibido.
     */
    private void notificarObserver(Object evento) {
        System.out.println(evento.getClass().toString());
        ObserverSocket observador = observers.get(evento.getClass());
        if (observador != null) {
            observador.update(evento);  // Notificar al observador del evento
        }
    }

    /**
     * Envía un mensaje en formato JSON al servidor.
     *
     * @param jsonString Cadena JSON que se desea enviar.
     */
    public synchronized void enviarJSON(String jsonString) {
        try {
            out.write(jsonString);
            out.newLine();
            out.flush();  // Envía el mensaje al servidor
        } catch (IOException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Método run del hilo, escucha mensajes del servidor y los procesa.
     * Si se recibe un mensaje, intenta deserializarlo y notificar a los observadores.
     */
    @Override
    public void run() {
        String mensaje;
        try {
            while ((mensaje = in.readLine()) != null) {
                System.out.println("Mensaje recibido del servidor.");
                deserializarEvento(mensaje);
            }
        } catch (IOException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
