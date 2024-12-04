package DTOs;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *
 * @author skevi
 */
public enum Acciones implements Serializable {
    
//    Lo de aquí representan diferentes acciones que pueden ocurrir, como buscar una partida, cerrar una ventana,
//    configurar, o iniciar una partida. Es útil para organizar y manejar
//    estas acciones de manera consistente en el código. Implementa Serializable 
//    para permitir que sus valores se puedan convertir a un formato que se pueda
//    guardar o transmitir.
//    
    
    BUSCARPARTIDA,
    CERRARVENTANA,
    CONFIGURAR,
    MENU,
    CREARPARTIDA,
    DENEGADO,
    JUGADORCREADO,
    INICIARPARTIDA,
    POZOVACIO;
    //fueron agregadas otras cosas que se ocuparan
}