/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import Conversores.FichaCVR;
import DTOs.FichaDTO;
import Entidades.Ficha;
import Entidades.Partida;
import java.util.ArrayList;
import java.util.List;
import singleton.PartidaST;

/**
 * Objeto de negocio de Pozo que funciona como controlador entre la clase 
 * de domino y la clase de negocio, contiene los metodos del objeto de dominio 
 * con la diferencia que ahora se usaran DTOs. 
 *
 * @author skevi
 */
public class PozoBO {
    
    
    
    //convertidor de ficha
    FichaCVR fichaCVR;

    public PozoBO() {
        this.fichaCVR = new FichaCVR();
    }
    
    /**
     * Obtiene un número determinado de fichas aleatorias del pozo,
     * posteriormente elimina las fichas obtenidas del pozo para mantener
     * consistencia con las fichas disponibles en el pozo.
     *
     * @param numero Número de fichas a obtener del pozo.
     * @return Lista de fichas extraídas del pozo.
     */
    public List<FichaDTO> obtenerFichas(byte numero) {
         Partida partida = PartidaST.getInstance();
        List<Ficha> fichas = partida.getManejadorTurnos().getPozo().obtenerFichas(numero);
        List<FichaDTO> fichasDTO = new ArrayList<>();
        
        for (int i = 0; i < fichas.size(); i++) {
            fichasDTO.add(fichaCVR.fichaConvertirEntidadADTO(fichas.get(i)));
        }
        
        return fichasDTO;
    }
    
    /**
     * Método que devuelve una ficha aleatoria del pozo y la elimina para
     * mantener la consistencia con la existencia de las fichas.
     * 
     * @return La ficha extraída del pozo o null si no hay fichas disponibles.
     */
    public FichaDTO obtenerFicha() {
         Partida partida = PartidaST.getInstance();
        FichaDTO ficha = fichaCVR.fichaConvertirEntidadADTO(partida.getManejadorTurnos().getPozo().
                obtenerFicha());
        
        return ficha;
    }
    
    /**
     * Metodo para obtener el numero de fichas restantes en el pozo.
     * 
     * @return Numero de fichas restantes en el pozo.
     */
    public int fichasDisponibles(){
         Partida partida = PartidaST.getInstance();
        return partida.getManejadorTurnos().getPozo().fichasDisponibles();
    }
    
}

