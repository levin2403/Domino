/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conversores;

import DTOs.DireccionDTO;
import DTOs.FichaDTO;
import DTOs.LocacionDTO;
import Entidades.Direccion;
import Entidades.Ficha;
import Entidades.Locacion;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase ConversorFicha se encarga de convertir entre objetos de tipo DTO y
 * entidades del modelo de dominio. Esta clase proporciona métodos para
 * convertir localizaciones, direcciones y fichas entre sus representaciones en
 * DTO y en entidades.
 *
 * @author Dell
 */
public class FichaCVR {
    
    private LocacionCVR converLoca;
    private DireccionCVR converDirec;

    /**
     * Constructor de la clase ConversorFicha.
     */
    public FichaCVR() {
        converLoca = new LocacionCVR();
        converDirec = new DireccionCVR();
    }

    /**
     * Convierte un objeto FichaDTO a un objeto Ficha.
     *
     * @param fichaDTO el objeto FichaDTO a convertir
     * @return el objeto Ficha correspondiente
     */
    public Ficha fichaConvertirDTOAEntidad(FichaDTO fichaDTO) {
        int valorSuperior = fichaDTO.getValorSuperior();
        int valorinferior = fichaDTO.getValorInferior();
        Locacion centerLocacion = converLoca.locacionConvertirDTOAEntidad(fichaDTO.getCenterLocacion());
        Direccion direccionLado = converDirec.direccionConvertirDTOAEntidad(fichaDTO.getDireccionLado());
        Direccion direccionPosicion = converDirec.direccionConvertirDTOAEntidad(fichaDTO.getDireccionPosicion());

        Ficha ficha = new Ficha(valorSuperior, valorinferior, centerLocacion, direccionLado, direccionPosicion);
        return ficha;
    }

    /**
     * Convierte un objeto Ficha a un objeto FichaDTO.
     *
     * @param ficha el objeto Ficha a convertir
     * @return el objeto FichaDTO correspondiente
     */
    public FichaDTO fichaConvertirEntidadADTO(Ficha ficha) {
        int valorSuperior = ficha.getValorSuperior();
        int valorinferior = ficha.getValorInferior();
        LocacionDTO centerLocacion = converLoca.locacionConvertirEntidadADTO(ficha.getCenterLocacion());
        DireccionDTO direccionLado = converDirec.direccionConvertirEntidadADTO(ficha.getDireccionLado());
        DireccionDTO direccionPosicion = converDirec.direccionConvertirEntidadADTO(ficha.getDireccionPosicion());

        FichaDTO fichaDTO = new FichaDTO(valorSuperior, valorinferior, centerLocacion, direccionLado, direccionPosicion);
        return fichaDTO;
    }

    /**
     * Convierte una lista de objetos FichaDTO a una lista de objetos Ficha.
     *
     * @param fichasDTO la lista de objetos FichaDTO a convertir
     * @return la lista de objetos Ficha correspondientes
     */
    public List<Ficha> listaFichasConvertirDTOAEntidad(List<FichaDTO> fichasDTO) {
        List<Ficha> fichas = new ArrayList<>();
        for (FichaDTO fichaDTO : fichasDTO) {
            Ficha ficha = this.fichaConvertirDTOAEntidad(fichaDTO);
            fichas.add(ficha);
        }
        return fichas;
    }

    /**
     * Convierte una lista de objetos Ficha a una lista de objetos FichaDTO.
     *
     * @param fichas la lista de objetos Ficha a convertir
     * @return la lista de objetos FichaDTO correspondientes
     */
    public List<FichaDTO> listaFichasConvertirEntidadADTO(List<Ficha> fichas) {
        List<FichaDTO> fichasDTO = new ArrayList<>();

        for (Ficha ficha : fichas) {
            FichaDTO fichaDTO = this.fichaConvertirEntidadADTO(ficha);
            fichasDTO.add(fichaDTO);
        }
        return fichasDTO;
    }

}
