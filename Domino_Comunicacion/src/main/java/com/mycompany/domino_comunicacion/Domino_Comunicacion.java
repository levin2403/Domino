/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.domino_comunicacion;

import Socket.Cliente;

/**
 *
 * @author Ruzzky
 */
public class Domino_Comunicacion {

    public static void main(String[] args) {
       Cliente c = Cliente.getInstance();
        c.enviarJSON("muy buenas a todos guapisimos, aqui vegetta777 en un nuevo directo de Karmaland" );
    }
}
