/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import DTOs.ConfiguracionDTO;
import Mediator.Mediador;
import ObjetosNegocio.ConfiguracionBO;
import org.itson.domino.matchSettings.mvc.FrmMatchSettingsModel;
import org.itson.domino.playerSettings.mvc.FrmPlayerSettingsModel;

/**
 *
 * @author skevi
 */
public class EstablecerConfiguracion {
    
    //instancia golbal de la configuracion
    ConfiguracionBO configuracion; 

    //instancia para obtener la informacion del frame correspondiente
    FrmMatchSettingsModel settingsModel;
    
    /**
     * Constructor de la clase.
     */
    public EstablecerConfiguracion() {

        //iniciamos instancia del modelo
        this.settingsModel = new FrmMatchSettingsModel(); 
           
    }
    
    /**
     * Establecemos la configuracion al singletone para su uso en otras clases.
     */
    public void establecerConfiguracionInicial(){
        int numfichas = settingsModel.getNumberOfTiles(); // numero de fichas
        int numJugadores = settingsModel.getNumberOfPlayers(); //numero de jugadores
        
        //instanciamos una nueva configuracion con los datos del modelo
        ConfiguracionDTO configuracion = 
                new ConfiguracionDTO(numfichas, numJugadores);
        
        //establecemos la nueva configuracion a la instancia global 
        configuracion.setFichasARepartir(numfichas);
        configuracion.setNumJugadores(numJugadores);
        
        //pasamos la configuracion a su primera pipe
        //para que se vaya al servidor.
        
    }
    
    public void siguienteFrame(){
        //Creas el mediador
        Mediador mediador = new Mediador();
        //Creas el siguiente evento (este aun  no se usa pero es para abrir el frame)
        RegistrarJugador rJ= new RegistrarJugador();
        //EL metodo del mediador regresa un modelo para poderlo asignar al evento que le corresponde
        FrmPlayerSettingsModel model= mediador.showFrmPlayerSettings(rJ); //pides al mediador que abra el frame y guardas el modelo de ese frame
        rJ.setPsm(model);//asiganas el modelo al Evento para decir que a ese modelo observara.
    }
    
    //Aqui estara el observer 
    
}
