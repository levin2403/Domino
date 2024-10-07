/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conversores;

import DTOs.LocacionDTO;
import Entidades.Locacion;

/**
 *
 * @author Dell
 */
public class ConversorLocacion {

    public ConversorLocacion() {
    }
    
    /**
     * Convierte un objeto LocacionDTO a un objeto Locacion.
     *
     * @param locacionDTO el objeto LocacionDTO a convertir
     * @return el objeto Locacion correspondiente, o null si locacionDTO es null
     */
    public Locacion locacionConvertirDTOAEntidad(LocacionDTO locacionDTO) {
        if (locacionDTO == null) {
            return null;
        }
        int x = locacionDTO.getX();
        int y = locacionDTO.getY();

        Locacion locacion = new Locacion(x, y);

        return locacion;

    }

    /**
     * Convierte un objeto Locacion a un objeto LocacionDTO.
     *
     * @param locacion el objeto Locacion a convertir
     * @return el objeto LocacionDTO correspondiente, o null si locacion es null
     */
    public LocacionDTO locacionConvertirEntidadADTO(Locacion locacion) {
        if (locacion == null) {
            return null;
        }
        int x = locacion.getX();
        int y = locacion.getY();

        LocacionDTO locacionDTO = new LocacionDTO(x, y);

        return locacionDTO;

    }
    
}
