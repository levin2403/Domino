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

    // Constructor que inicializa el modelo, vista, mediador y música.
    public FrmMatchOngoingController(FrmMatchOngoingModel model ,FrmMatchOngoingView view) {
        this.model = model;
        this.view = view;
        this.mediator = new Mediador();
        this.musicModel = MusicModelSingleton.getInstance();

        playMatchTheme();  // Reproducir la música de la partida (comentado temporalmente).
        
        setupButtonListeners(); // Configura los escuchadores de los botones.
    }

    // Método para reproducir la música del tema de la partida.
    private void playMatchTheme() {
        musicModel.playMusic(MusicPaths.MATCH_THEME_1);
    }

    // Configura los escuchadores de eventos de los botones.
    private void setupButtonListeners() {
        view.addAccionIzquierdaButtonListener(e -> colocarFichaIzquierda());
        view.addAccionDerechaButtonListener(e -> colocarFichaDerecha());
        view.addRoboButtonListener(e -> robarFicha());
    }

    // Lógica para colocar una ficha a la derecha si es el turno del jugador.
    private void colocarFichaDerecha() {
        if (!model.tuTurno()) {
            System.out.println("no es tu turno");
            return;
        }
        FichaDTO ficha = view.getFichaSeleccionada();
        if(ficha == null) {
            JOptionPane.showMessageDialog(view, "Selecciona una ficha");
        } else if (view.colocarFichaDerecha(ficha)) {
            model.colocarDerecha(ficha);
        }
    }

    // Lógica para colocar una ficha a la izquierda si es el turno del jugador.
    private void colocarFichaIzquierda() {
        if (!model.tuTurno()) {
            JOptionPane.showConfirmDialog(view, "No es tu Turno");
            return;
        }
        FichaDTO ficha = view.getFichaSeleccionada();
        if(ficha == null) {
            JOptionPane.showMessageDialog(view, "Selecciona una ficha");
        } else if (view.colocarFichaIzquierda(ficha)) {
            model.colocarIzquierda(ficha);
        }
    }

    // Lógica para robar una ficha si es el turno del jugador.
    private void robarFicha() {
        if (!model.tuTurno()) {
            JOptionPane.showConfirmDialog(view, "No es tu Turno");
            return;
        }
        model.robarFicha();
    }

    // Muestra un mensaje cuando se debe seleccionar una ficha.
    public void mensajePozo() {
        JOptionPane.showMessageDialog(view, "Selecciona una ficha");
    }

    // Hace visible la vista de la pantalla.
    public void abrirPantalla() {
        view.setVisible(true);
    }

    // Navega entre formularios (cierra la vista actual y ejecuta una acción).
    private void navigateToForm(Runnable action) {
        view.dispose();
        action.run();
    }
}
