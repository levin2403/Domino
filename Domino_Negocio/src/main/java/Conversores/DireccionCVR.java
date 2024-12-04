/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conversores;

import DTOs.DireccionDTO;
import Entidades.Direccion;
import static Entidades.Direccion.ABAJO;
import static Entidades.Direccion.ARRIBA;
import static Entidades.Direccion.DERECHA;
import static Entidades.Direccion.IZQUIERDA;

/**
 *
 * @author Dell
 */

public class DireccionCVR {  
    // Clase que maneja la conversión entre objetos DireccionDTO y Direccion

    public DireccionCVR() {  
    }

    /**
     * Convierte un objeto DireccionDTO a un objeto Direccion.
     *
     * @param direccionDTO el objeto DireccionDTO a convertir
     * @return el objeto Direccion correspondiente, o null si direccionDTO es
     * null
     */
    public Direccion direccionConvertirDTOAEntidad(DireccionDTO direccionDTO) {  
        if (direccionDTO == null) {  
            return null; // Si el objeto DireccionDTO es nulo, retorna nulo
        } else {  
            Direccion direccion = null;

            switch (direccionDTO) {  // Realiza la conversión según el valor de direccionDTO
                case ABAJO:
                    direccion = Direccion.ABAJO;
                    break;
                case ARRIBA:
                    direccion = Direccion.ARRIBA;
                    break;
                case DERECHA:
                    direccion = Direccion.DERECHA;
                    break;
                case IZQUIERDA:
                    direccion = Direccion.IZQUIERDA;
                    break;
            }
            return direccion;  // Devuelve el objeto Direccion correspondiente
        }
    }

    /**
     * Convierte un objeto Direccion a un objeto DireccionDTO.
     *
     * @param direccion el objeto Direccion a convertir
     * @return el objeto DireccionDTO correspondiente, o null si direccion es
     * null
     */
    public DireccionDTO direccionConvertirEntidadADTO(Direccion direccion) {  
        if (direccion == null) {  
            return null; // Si el objeto Direccion es nulo, retorna nulo
        } else {  
            DireccionDTO direccionDTO = null;

            switch (direccion) {  // Realiza la conversión según el valor de direccion
                case ABAJO:
                    direccionDTO = DireccionDTO.ABAJO;
                    break;
                case ARRIBA:
                    direccionDTO = DireccionDTO.ARRIBA;
                    break;
                case DERECHA:
                    direccionDTO = DireccionDTO.DERECHA;
                    break;
                case IZQUIERDA:
                    direccionDTO = DireccionDTO.IZQUIERDA;
                    break;
            }
            return direccionDTO;  // Devuelve el objeto DireccionDTO correspondiente
        }
    }
}
