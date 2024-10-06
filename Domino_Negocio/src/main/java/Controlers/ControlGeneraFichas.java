/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import Conversores.ConversorFicha;
import DTOs.FichaDTO;
import Entidades.Direccion;
import Entidades.FabricaFichas;
import Entidades.Ficha;
import java.util.List;

/**
 * La clase ControlGeneraFichas se encarga de la generación de fichas 
 * utilizando una fábrica de fichas y un conversor para transformar 
 * las entidades en DTOs y viceversa.
 * @author Dell
 */
public class ControlGeneraFichas {
    
    
    /**
     * Constructor de la clase ControlGeneraFichas.
     */
    public ControlGeneraFichas() {
    }

    /**
     * Genera una lista de objetos FichaDTO.
     * 
     * Utiliza la clase FabricaFichas para crear fichas y luego las convierte 
     * a su representación DTO utilizando ConversorFicha.
     *
     * @return una lista de objetos FichaDTO generados
     */
    public List<FichaDTO> generaFichas() {
        ConversorFicha convert = new ConversorFicha();
        FabricaFichas fabricaFichas = new FabricaFichas();
        
        List<Ficha> fichasGen = fabricaFichas.crearFichas();
        List<FichaDTO> fichasDTO = convert.listaFichasConvertirEntidadADTO(fichasGen);
        return fichasDTO;
    }
}
