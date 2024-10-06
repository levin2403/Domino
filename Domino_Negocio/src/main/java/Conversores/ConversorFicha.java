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
public class ConversorFicha {

    /**
     * Constructor de la clase ConversorFicha.
     */
    public ConversorFicha() {
    }

    /**
     * Convierte un objeto LocacionDTO a un objeto Locacion.
     *
     * @param locacionDTO el objeto LocacionDTO a convertir
     * @return el objeto Locacion correspondiente, o null si locacionDTO es null
     */
    private Locacion locacionConvertirDTOAEntidad(LocacionDTO locacionDTO) {
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
    private LocacionDTO locacionConvertirEntidadADTO(Locacion locacion) {
        if (locacion == null) {
            return null;
        }
        int x = locacion.getX();
        int y = locacion.getY();

        LocacionDTO locacionDTO = new LocacionDTO(x, y);

        return locacionDTO;

    }

    /**
     * Convierte un objeto DireccionDTO a un objeto Direccion.
     *
     * @param direccionDTO el objeto DireccionDTO a convertir
     * @return el objeto Direccion correspondiente, o null si direccionDTO es
     * null
     */
    private Direccion direccionConvertirDTOAEntidad(DireccionDTO direccionDTO) {
        if (direccionDTO == null) {
            return null;
        } else {
            Direccion direccion = null;

            switch (direccionDTO) {
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
            return direccion;
        }

    }

    /**
     * Convierte un objeto Direccion a un objeto DireccionDTO.
     *
     * @param direccion el objeto Direccion a convertir
     * @return el objeto DireccionDTO correspondiente, o null si direccion es
     * null
     */
    private DireccionDTO direccionConvertirEntidadADTO(Direccion direccion) {
        if (direccion == null) {
            return null;
        } else {
            DireccionDTO direccionDTO = null;

            switch (direccion) {
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
            return direccionDTO;
        }

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
        Locacion locacionSuperior = locacionConvertirDTOAEntidad(fichaDTO.getLocacionSuperior());
        Locacion locacionInferior = locacionConvertirDTOAEntidad(fichaDTO.getLocacionInferior());
        Direccion direccion = this.direccionConvertirDTOAEntidad(fichaDTO.getDireccion());

        Ficha ficha = new Ficha(valorSuperior, valorinferior, locacionSuperior, locacionInferior, direccion);
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
        LocacionDTO locacionSuperior = locacionConvertirEntidadADTO(ficha.getLocacionSuperior());
        LocacionDTO locacionInferior = locacionConvertirEntidadADTO(ficha.getLocacionInferior());
        DireccionDTO direccion = this.direccionConvertirEntidadADTO(ficha.getDireccion());

        FichaDTO fichaDTO = new FichaDTO(valorSuperior, valorinferior, locacionSuperior, locacionInferior, direccion);
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
