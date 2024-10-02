/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.domino.main;

import org.itson.domino.bienvenida.mvc.FrmBienvenidaController;
import org.itson.domino.bienvenida.mvc.FrmBienvenidaView;
import org.itson.domino.music.MusicModel;

/**
 *
 * @author gamaliel
 */
public class Domino_Presentacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MusicModel model = MusicModel.getInstance();
        FrmBienvenidaView view = new FrmBienvenidaView();
        FrmBienvenidaController controller = new FrmBienvenidaController(view);

        view.setVisible(true);
    }
    
}
