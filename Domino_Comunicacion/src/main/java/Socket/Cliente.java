

package Socket;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Ruzzky
 */
public class Cliente {
    
 // Instancia única y compartida de Cliente
    private volatile static Cliente instance;
 // Objeto de conexión al servidor   
    private Conexion cone;
    
    
// Constructor privado para prevenir instanciación directa
    private Cliente() {
        
    }
    
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
                System.out.println("S");
                socket = new Socket("localhost", 1234);
                instance = new Cliente(socket);
            } catch (IOException ex) {

                return null;
            }

        }
        return instance;
    }
    
  
    
     public Cliente(Socket socket) {

      
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
     * Establece el objeto de conexión.
     *
     * @param cone Nueva conexión de tipo `Conexion`.
     */
    public void setCone(Conexion cone) {
        this.cone = cone;
    }  
}

