/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.bienvenida.mvc;

import org.itson.domino.configuracion.mvc.FrmConfiguracionView;
import org.itson.domino.managers.ViewManager;
import org.itson.domino.music.MusicModel;

/**
 *
 * @author gamaliel
 */

public class FrmBienvenidaController {
    private FrmBienvenidaView view;
    private MusicModel musicModel;
    private ViewManager viewManager;

    public FrmBienvenidaController(FrmBienvenidaView view, ViewManager viewManager) {
        this.view = view;
        this.musicModel = MusicModel.getInstance();
        this.viewManager = viewManager;
        
        musicModel.playMusic("resources/xD.mp3");
        this.view.addNextFormButtonListener(e -> openNextForm());
    }

    private void openNextForm() {
        FrmConfiguracionView siguienteView = new FrmConfiguracionView();
        viewManager.showView(siguienteView);
    }
}
