/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.bienvenida.mvc;

import org.itson.domino.music.MusicModel;

/**
 *
 * @author gamaliel
 */

public class FrmBienvenidaController {
    private FrmBienvenidaView view;
    private MusicModel musicModel;

    public FrmBienvenidaController(FrmBienvenidaView view) {
        this.view = view;
        this.musicModel = MusicModel.getInstance();
        
        musicModel.playMusic("resources/xD.mp3");
    }
}

