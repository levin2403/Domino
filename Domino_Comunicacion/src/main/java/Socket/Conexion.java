

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

/**
 *
 * @author Ruzzky
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

}
