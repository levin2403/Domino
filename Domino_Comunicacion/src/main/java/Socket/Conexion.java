

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
import filtros.FiltroEvento;
import interfaz.IPipe;

/**
 *
 * @author Ruzzky
 * triipalosky, tripatripalosky
 * 
 */

public class Conexion extends Thread {

    private Socket socket;
    private BufferedWriter out;
    private BufferedReader in;
    private Map<Class<?>, ObserverSocket> observers;

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

    public void registrarObserver(Class<?> tipoEvento, ObserverSocket observer) {
        observers.put(tipoEvento, observer);
    }

    // Método para notificar a todos los observadores
    private Object deserializarEvento(String mensaje) {
        // Aquí deserializas el JSON en el tipo de evento correspondiente
        // Esto es un ejemplo con Gson, pero depende de tu implementación
        FiltroEvento filtroJson = new FiltroEvento();
        IPipe pipe = new PipeBasico();

        // Conectar el filtro al pipe
        pipe.setFiltro(filtroJson);
        pipe.enviar(mensaje);

        // Ejemplo de deserialización
        Object mensajeProcesado = filtroJson.getMensaje();
        
        // Si el mensaje fue procesado correctamente, notificamos a los observadores
        if (mensajeProcesado != null) {
            // Iterar sobre los observadores y notificar
            notificarObserver(mensajeProcesado);
        }

        return null; // Devuelve null si no se puede deserializar correctamente
    }

   private void notificarObserver(Object evento) {
        // Verificar el tipo de evento y notificar al observador correspondiente
        System.out.println(evento.getClass().toString());
        ObserverSocket observador = observers.get(evento.getClass());
        if (observador != null) {
            observador.update(evento);  // Notificar al observador del evento
        }
    }

    public synchronized void enviarJSON(String jsonString) {
        try {
            System.out.println("enviando algo");
            out.write(jsonString);
            out.newLine();
// Escribe la cadena JSON en el BufferedWriter
            out.flush();  // Envía el mensaje al servidor
        } catch (IOException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void run() {
        String mensaje;
        try {
            while ((mensaje = in.readLine()) != null) {//atorado
                
               
                deserializarEvento(mensaje);// Notifica solo si es un JSON válido
               
            }
        } catch (IOException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
