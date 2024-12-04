/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conversores;

import DTOs.FichaDTO;
import DTOs.PozoDTO;
import Entidades.Ficha;
import Entidades.Pozo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 * @author RUZZKY
 * alias el q quiereayudarentodoalafuerzapqnolegustaqueparezcaquenohacenada
 */
public class PozoCVR {
       
    private FichaCVR fichaCVR; // Instanciamos el conversor de Ficha

    public PozoCVR() {
        fichaCVR = new FichaCVR(); // Inicializamos el conversor de Ficha
    }
    
    // Convertir PozoDTO a Pozo
    public Pozo toEntity(PozoDTO pozoDTO) {
        // Creamos un Pozo vacío
        Pozo pozo = new Pozo();

        // Si el PozoDTO contiene fichas, las convertimos a fichas de la entidad Pozo
        if (pozoDTO.getFichasPozo() != null) {
            List<Ficha> fichas = new ArrayList<>();
            for (FichaDTO fichaDTO : pozoDTO.getFichasPozo()) {
                Ficha ficha = fichaCVR.fichaConvertirDTOAEntidad(fichaDTO); // Convertimos FichaDTO a Ficha
                fichas.add(ficha);
            }
            // Ahora las fichas están en el pozo
            pozo.setPozo(fichas);
        }

        return pozo;
    }

    // Convertir Pozo a PozoDTO
    public PozoDTO toDTO(Pozo pozo) {
        // Creamos un PozoDTO vacío
        PozoDTO pozoDTO = new PozoDTO();

        // Obtenemos las fichas del pozo
        List<FichaDTO> fichasDTO = new ArrayList<>();
        for (Ficha ficha : pozo.getPozo()) {
            FichaDTO fichaDTO = fichaCVR.fichaConvertirEntidadADTO(ficha); // Convertimos Ficha a FichaDTO
            fichasDTO.add(fichaDTO);
        }

        // Establecemos las fichas en el PozoDTO
        pozoDTO.setFichasPozo(fichasDTO);

        return pozoDTO;
    }
}
