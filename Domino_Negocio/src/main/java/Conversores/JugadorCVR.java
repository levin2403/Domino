/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conversores;

import DTOs.AvatarDTO;
import DTOs.FichaDTO;
import DTOs.JugadorDTO;
import Entidades.Avatar;
import Entidades.Ficha;
import Entidades.Jugador;
import java.util.List;

/**
 *
 * @author Dell
 */
public class JugadorCVR {  
    // Clase que maneja la conversión entre objetos JugadorDTO y Jugador

    FichaCVR convertFicha;  // Instancia para convertir las fichas asociadas al jugador

    public JugadorCVR() {  
        convertFicha = new FichaCVR();  // Inicializa la conversión de fichas
    }

    /**
     * Convierte un objeto JugadorDTO a un objeto Jugador.
     *
     * @param jugadorDTO el objeto JugadorDTO a convertir
     * @return el objeto Jugador correspondiente
     */
    public Jugador jugadorConvertirDTOAEntidad(JugadorDTO jugadorDTO) {  
        String nickName = jugadorDTO.getNickName();  // Obtiene el nombre del jugador
        String avatarURL = jugadorDTO.getAvatar().getImageURL();  // Obtiene la URL del avatar
        Avatar avatar = new Avatar(avatarURL);  // Crea un nuevo objeto Avatar con la URL

        Jugador jugador = new Jugador(nickName, avatar);  // Crea un nuevo jugador con el nombre y el avatar

        if (jugadorDTO.getFichas() == null) {  // Si no tiene fichas asignadas
            jugador.setFichas(null);
        } else {  
            List<FichaDTO> listaFichasDTO = jugadorDTO.getFichas();  // Obtiene la lista de fichas DTO
            List<Ficha> listaFichas = convertFicha.listaFichasConvertirDTOAEntidad(listaFichasDTO);  // Convierte la lista de fichas DTO a Ficha
            jugador.setFichas(listaFichas);  // Asigna la lista de fichas al jugador
        }

        if (jugadorDTO.getPuntos() == 0) {  // Si los puntos son 0
            jugador.setPuntos(0);  // Asigna 0 puntos al jugador
        } else {  
            int puntos = jugadorDTO.getPuntos();  // Obtiene los puntos del jugador
            jugador.setPuntos(puntos);  // Asigna los puntos al jugador
        }

        System.out.println(jugador.toString());  // Imprime el jugador
        return jugador;  // Devuelve el objeto Jugador
    }

    /**
     * Convierte un objeto Jugador a un objeto JugadorDTO.
     *
     * @param jugador el objeto Jugador a convertir
     * @return el objeto JugadorDTO correspondiente
     */
    public JugadorDTO jugadorConvertirEntidadADTO(Jugador jugador) {  
        String nickName = jugador.getNickName();  // Obtiene el nombre del jugador
        String avatarURL = jugador.getAvatar().getImageURL();  // Obtiene la URL del avatar
        AvatarDTO avatar = new AvatarDTO(avatarURL);  // Crea un objeto AvatarDTO con la URL del avatar

        JugadorDTO jugadorDTO = new JugadorDTO(nickName, avatar);  // Crea un objeto JugadorDTO con el nombre y el avatar

        if (jugador.cantidadFichas() == 0) {  // Si el jugador no tiene fichas
            jugadorDTO.setFichas(null);  // Asigna null a la lista de fichas
        } else {  
            List<Ficha> listaFichas = jugador.getFichas();  // Obtiene la lista de fichas
            List<FichaDTO> listaFichasDTO = convertFicha.listaFichasConvertirEntidadADTO(listaFichas);  // Convierte las fichas de Jugador a FichaDTO
            jugadorDTO.setFichas(listaFichasDTO);  // Asigna la lista de fichas DTO al jugadorDTO
        }

        if (jugador.getPuntos() == 0) {  // Si los puntos son 0
            jugadorDTO.setPuntos(0);  // Asigna 0 puntos al jugadorDTO
        } else {  
            int puntos = jugador.getPuntos();  // Obtiene los puntos del jugador
            jugadorDTO.setPuntos(puntos);  // Asigna los puntos al jugadorDTO
        }

        return jugadorDTO;  // Devuelve el objeto JugadorDTO
    }
}

