/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conversores;

import DTOs.FichaDTO;
import DTOs.TableroDTO;
import Entidades.Ficha;
import Entidades.Tablero;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class TableroCVR {
    FichaCVR convertFicha;

    public TableroCVR() {
        convertFicha = new FichaCVR();
    }
    
    public Tablero convertirTableroDTOAEntidad(TableroDTO tableroDTO){
        LinkedList<Ficha> fichasEnt = new LinkedList<>();
        List<FichaDTO> fichasDTO = tableroDTO.getFichasTablero();
        for (FichaDTO fichaDTO : fichasDTO) {
            Ficha ficha = convertFicha.fichaConvertirDTOAEntidad(fichaDTO);
            fichasEnt.add(ficha);
        }
        
        Tablero tablero = new Tablero(fichasEnt);
        
        return tablero;
    }
    
    public TableroDTO convertirTableroEntidadADTO(Tablero tablero){
        List<FichaDTO> fichasDTO = new ArrayList<>();
        LinkedList<Ficha> fichasEnt = tablero.getFichas();
        for (Ficha ficha : fichasEnt) {
            FichaDTO fichaDTO = convertFicha.fichaConvertirEntidadADTO(ficha);
            fichasDTO.add(fichaDTO);
        }
        
        TableroDTO tableroDTO = new TableroDTO(fichasDTO);
        
        return tableroDTO;
    }
    
}
