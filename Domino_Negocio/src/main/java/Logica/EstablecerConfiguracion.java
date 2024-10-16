/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import DTOs.ConfiguracionDTO;
import Singleton.ConfiguracionInicialST;
import org.itson.domino.matchSettings.mvc.FrmMatchSettingsModel;

/**
 *
 * @author skevi
 */
public class EstablecerConfiguracion {
    
    //instancia golbal de la configuracion
    ConfiguracionInicialST configuracionInicial; 

    //instancia para obtener la informacion del frame correspondiente
    FrmMatchSettingsModel settingsModel;
    
    /**
     * Constructor de la clase;
     */
    public EstablecerConfiguracion() {

        //iniciamos instancia del modelo
        this.settingsModel = new FrmMatchSettingsModel(); 
    }
    
    /**
     * Establecemos la configuracion al singletone para su uso en otras clases
     */
    public void establecerConfiguracionInicial(){
        int numfichas = settingsModel.getNumberOfTiles(); // numero de fichas
        int numJugadores = settingsModel.getNumberOfPlayers(); //numero de jugadores
        
        //instanciamos una nueva configuracion con los datos del modelo
        ConfiguracionDTO configuracion = 
                new ConfiguracionDTO(numfichas, numJugadores);
        
        //establecemos la nueva configuracion a la instancia global 
        configuracionInicial.setInstance(configuracion); 
    }
    
}
