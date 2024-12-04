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
    FichaCVR convertFicha;

    public JugadorCVR() {
        convertFicha = new FichaCVR();
    }
    
    public Jugador jugadorConvertirDTOAEntidad(JugadorDTO jugadorDTO){
        String nickName = jugadorDTO.getNickName();
        String avatarURL = jugadorDTO.getAvatar().getImageURL();
        Avatar avatar = new Avatar(avatarURL);
        Jugador jugador= new Jugador(nickName, avatar);
        
        if(jugadorDTO.getFichas() == null){
            jugador.setFichas(null);
        }
        else{
            List<FichaDTO> listaFichasDTO = jugadorDTO.getFichas();
            List<Ficha> listaFichas = convertFicha.listaFichasConvertirDTOAEntidad(listaFichasDTO);
            jugador.setFichas(listaFichas);           
        }
        if(jugadorDTO.getPuntos() == 0){
            jugador.setPuntos(0);
        }
        else{
            int puntos = jugadorDTO.getPuntos();
            jugador.setPuntos(puntos);
        }
        return jugador;
    }
    
    public JugadorDTO jugadorConvertirEntidadADTO(Jugador jugador){
        String nickName = jugador.getNickName();
        String avatarURL = jugador.getAvatar().getImageURL();
        AvatarDTO avatar = new AvatarDTO(avatarURL);
        JugadorDTO jugadorDTO= new JugadorDTO(nickName, avatar);
        
        if(jugador.cantidadFichas() == 0){
            jugadorDTO.setFichas(null);
        }
        else{
            List<Ficha> listaFichas = jugador.getFichas();
            List<FichaDTO> listaFichasDTO = convertFicha.listaFichasConvertirEntidadADTO(listaFichas);
            jugadorDTO.setFichas(listaFichasDTO);
            
        }
        if(jugador.getPuntos() == 0){
            jugadorDTO.setPuntos(0);
        }
        else{
            int puntos = jugador.getPuntos();
            jugadorDTO.setPuntos(puntos);
        }
        return jugadorDTO;
    }
}

