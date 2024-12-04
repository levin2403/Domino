/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author gamaliel
 */
package org.itson.domino.matchOngoing.mvc;

import DTOs.FichaDTO;
import Mediator.Mediador;
import javax.swing.JOptionPane;
import org.itson.domino.constants.MusicPaths;
import org.itson.domino.singleton.MusicModelSingleton;

public class FrmMatchOngoingController {

    private FrmMatchOngoingView view;
    private FrmMatchOngoingModel model;
    private MusicModelSingleton musicModel;
    private Mediador mediator;

    public FrmMatchOngoingController(FrmMatchOngoingModel model ,FrmMatchOngoingView view) {
        this.model = model;
        this.view = view;
        this.mediator = new Mediador();
        this.musicModel = MusicModelSingleton.getInstance();

        //playMatchTheme();
        
        setupButtonListeners();
    }


    private void playMatchTheme() {
        musicModel.playMusic(MusicPaths.MATCH_THEME_1);
    }

    private void setupButtonListeners() {
        view.addAccionIzquierdaButtonListener(e -> colocarFichaIzquierda());
        view.addAccionDerechaButtonListener(e -> colocarFichaDerecha());
        view.addRoboButtonListener(e -> robarFicha());
    }
    private void colocarFichaDerecha(){
        if (!model.tuTurno()) {
             System.out.println("no es tu turno");
             return;
         }
        FichaDTO ficha =view.getFichaSeleccionada();
        if(ficha==null){
            JOptionPane.showMessageDialog(view, "Selecciona una ficha");
        }
        if ( view.colocarFichaDerecha(ficha)) {
            model.colocarDerecha(ficha);
        }
              
    }
     private void colocarFichaIzquierda(){
         if (!model.tuTurno()) {
             JOptionPane.showConfirmDialog(view, "No es tu Turno");
             return;
         }
        FichaDTO ficha =view.getFichaSeleccionada();
        if(ficha==null){
            JOptionPane.showMessageDialog(view, "Selecciona una ficha");
        }
        else if ( view.colocarFichaIzquierda(ficha)) {
            model.colocarIzquierda(ficha);
        }
              
    }
    private void robarFicha(){
        if (!model.tuTurno()) {
            JOptionPane.showConfirmDialog(view, "No es tu Turno");
             return;
         }
        model.robarFicha();
    }
    public void mensajePozo(){
         JOptionPane.showMessageDialog(view, "Selecciona una ficha");
    }
    public void abrirPantalla(){
        view.setVisible(true);
    }
    

    private void navigateToForm(Runnable action) {
        view.dispose();
        action.run();
    }
}
