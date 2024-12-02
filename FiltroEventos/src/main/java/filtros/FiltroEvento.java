/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package filtros;

import Eventos.EventoBuscarPartida;
import Eventos.EventoEstablecerConfiguracion;
import Eventos.EventoIniciarPartida;
import Eventos.EventoObtenerFichaPozo;
import Eventos.EventoRealizarJugada;
import Eventos.EventoRegistrarJugador;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import filter.FilterDomino;
import interfaz.IPipe;

/**
 *
 * @author Dell
 */
public class FiltroEvento<T> extends FilterDomino<T> {
//Alguien puso algo que no se debia he y ese alguien tiene apariencia de cholo

    private IPipe pipaSiguiente;

    @Override
    public void procesar(T mensaje) {
        // Deserializa el JSON de manera genérica
        this.mensajeProcesado = deserializarEvento((String) mensaje);

        // Enviar el objeto procesado al siguiente pipe
        if (pipaSiguiente != null) {
            pipaSiguiente.enviar(mensajeProcesado);
        }
    }

    // Método genérico para deserializar el JSON sin conocimiento del tipo de evento
    public T deserializarEvento(String mensaje) {
        Gson gson = new Gson();

        // Parseamos el mensaje JSON para obtener el campo "tipoEvento"
        JsonObject jsonObject = JsonParser.parseString(mensaje).getAsJsonObject();
        String tipoEvento = jsonObject.get("TIPO_EVENTO").getAsString();

        // Comprobamos el valor de "tipoEvento" y deserializamos según corresponda
        switch (tipoEvento) {
            case "eventoBuscarPartida":
                return (T) gson.fromJson(mensaje, EventoBuscarPartida.class);
            case "eventoEstablecerConfiguracion":
                return (T) gson.fromJson(mensaje, EventoEstablecerConfiguracion.class);
            case "eventoRealizarJugada":
                return (T) gson.fromJson(mensaje, EventoRealizarJugada.class);
            case "eventoRegistrarJugador":
                return (T) gson.fromJson(mensaje, EventoRegistrarJugador.class);
            case "eventoIniciarPartida":
                return (T) gson.fromJson(mensaje, EventoIniciarPartida.class);
            case "eventoObtenerFichaPozo":
                return (T) gson.fromJson(mensaje, EventoObtenerFichaPozo.class);

            // Puedes agregar más casos si tienes más tipos de eventos
            default:
                return null;  // Si no coincide con ningún tipo conocido, retornamos null
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
