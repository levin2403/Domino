/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package filtro;

import Socket.Cliente;
import com.google.gson.Gson;
import filter.FilterDomino;
import interfaz.IPipe;

/**
 *
 * @author Dell
 */
public class FiltroJson<T> extends FilterDomino<T>{

    private IPipe pipaSiguiente; 
    
    @Override
    public void procesar(T mensaje) {
        Gson gson = new Gson();
       this.mensajeProcesado = (T) gson.toJson(mensaje);
        if (pipaSiguiente != null) {
            pipaSiguiente.enviar(mensajeProcesado); // Envía el JSON al siguiente pipe si existe
        }else{
              Cliente cliente = Cliente.getInstance();
              cliente.enviarJSON((String) this.mensajeProcesado);
        }
       
    }

    public IPipe getPipe() {
        return pipaSiguiente;
    }

    public void setPipe(IPipe pipaSiguiente) {
        this.pipaSiguiente = pipaSiguiente;
    }

    @Override
    public T getMensaje() {
        return mensajeProcesado;
    }
}
