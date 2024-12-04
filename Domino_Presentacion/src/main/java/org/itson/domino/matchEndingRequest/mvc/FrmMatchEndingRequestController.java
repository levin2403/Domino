/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */

package org.itson.domino.matchEndingRequest.mvc;

import Mediator.Mediador;
import org.itson.domino.constants.MusicPaths;
import org.itson.domino.singleton.MusicModelSingleton;
public class FrmMatchEndingRequestController {
    
    private FrmMatchEndingRequestModel model; // Modelo de la pantalla de solicitud de finalización de partida
    private FrmMatchEndingRequestView view; // Vista asociada a la pantalla
    private MusicModelSingleton musicModel; // Singleton para la gestión de música
    private Mediador mediator; // Mediador para la comunicación entre vistas y controladores
    
    /**
     * Constructor que inicializa el controlador con el modelo, la vista, y otros componentes.
     * Además, configura la música y los oyentes de los botones de la vista.
     * @param model El modelo asociado a la vista.
     * @param view La vista asociada al modelo.
     */
    public FrmMatchEndingRequestController(FrmMatchEndingRequestModel model, FrmMatchEndingRequestView view) {
        this.model = model;
        this.view = view;
        this.mediator = new Mediador();
        this.musicModel = MusicModelSingleton.getInstance();
        
        // Reproduce el tema de la solicitud de finalización de partida.
        playRequestTheme();
        
        // Configura los oyentes de los botones en la vista.
        setupButtonListeners();
    }

    /**
     * Reproduce la música de fondo asociada con la solicitud de finalización de partida.
     */
    private void playRequestTheme() {
        musicModel.playMusic(MusicPaths.REQUEST_THEME);
    }
    
    /**
     * Configura los oyentes de los botones "Siguiente" y "Anterior" en la vista.
     */
    private void setupButtonListeners() {
        view.addNextFormButtonListener(e -> openNextForm());
        view.addPrevFormButtonListener(e -> openPrevForm());
    }
    
    /**
     * Abre el siguiente formulario (en este caso, cierra la aplicación).
     */
    private void openNextForm() {
        System.exit(0);
    }

    /**
     * Hace visible la vista de la pantalla de solicitud de finalización de partida.
     */
    public void abrirPantalla() {
        System.out.println("estrueos");
        view.setVisible(true);
    }

    /**
     * Abre el formulario anterior, aunque actualmente no está implementado.
     */
    private void openPrevForm() {
        // navigateToForm(() -> mediator.showFrmMatchOngoing());
    }

    /**
     * Navega a un formulario dado y cierra la vista actual.
     * @param action Acción que se ejecuta para mostrar el siguiente formulario.
     */
    private void navigateToForm(Runnable action) {
        view.dispose();
        action.run();
    }
}
