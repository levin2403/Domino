

package com.mycompany.domino_server;

import DTOs.ConfiguracionDTO;
import Eventos.EventoBuscarPartida;
import Eventos.EventoEstablecerConfiguracion;
import Eventos.EventoRealizarJugada;
import Eventos.EventoRegistrarJugador;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author Ruzzky alias elpaputriste :,v
 */
public class NewMain {

     /**
     * Método principal que ejecuta el flujo de prueba para convertir un evento de configuración 
     * de juego a JSON y luego intenta deserializarlo al tipo de evento correcto.
     *
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    
    public static void main(String[] args) {
        // Crear un evento de configuración de juego
        EventoEstablecerConfiguracion a = new EventoEstablecerConfiguracion();
        ConfiguracionDTO c = new ConfiguracionDTO(0, 0); // Valores iniciales kkkkk omfg
        a.setConfiguracion(c);
        // Convertir el evento a JSON usando Gson 
        //:v
        Gson g = new Gson();
        String s = g.toJson(a);
        System.out.println(s);
        
        // Intentar convertir el JSON a su tipo de evento correspondiente 
        Object o = intentarConvertirEvento(s, g);
         System.out.println(o.getClass()); // Mostrar la clase del objeto resultante

    }

    private static Object intentarConvertirEvento(String mensaje, Gson gson) {
        // Parsear el mensaje JSON para obtener el tipo de evento
        JsonObject jsonObject = JsonParser.parseString(mensaje).getAsJsonObject();
        String tipoEvento = jsonObject.get("TIPO_EVENTO").getAsString();

         // Seleccionar el tipo de evento y deserializar en la clase correspondiente
        switch (tipoEvento) {
            case "eventoBuscarPartida":
                return gson.fromJson(mensaje, EventoBuscarPartida.class);
            case "eventoEstablecerConfiguracion":
                return gson.fromJson(mensaje, EventoEstablecerConfiguracion.class);
            case "eventoRealizarJugada":
                return gson.fromJson(mensaje, EventoRealizarJugada.class);
            case "eventoRegistrarJugador":
                return gson.fromJson(mensaje, EventoRegistrarJugador.class);
            // Puedes agregar más casos si tienes más tipos de eventos
            default:
                return null;  // Retorna null si no coincide con ningún tipo conocido
        }
    }

}
