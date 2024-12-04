/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author gamaliel
 */
package org.itson.domino.welcome.mvc;

import Mediator.Mediador;
import org.itson.domino.constants.MusicPaths;
import org.itson.domino.singleton.MusicModelSingleton;

public class FrmWelcomeController {
    private FrmWelcomeModel model;  // Instancia del modelo
    private FrmWelcomeView view;    // Instancia de la vista
    private MusicModelSingleton musicModel;  // Singleton de música
    private Mediador mediator;  // Mediador para la comunicación entre componentes

    // Constructor del controlador, que inicializa el modelo, la vista, y otros componentes
    public FrmWelcomeController(FrmWelcomeModel model) {
        this.model = model;
        this.view = new FrmWelcomeView(model);  // Crea la vista asociada al modelo
        this.model.registrarObservadorView(view);  // Registra la vista como observador del modelo
        this.musicModel = MusicModelSingleton.getInstance();  // Obtiene la instancia de música
        this.mediator = new Mediador();  // Inicializa el mediador
        playMainTheme();  // Reproduce el tema principal
        setupButtonListeners();  // Configura los oyentes para los botones
    }

    // Método para reproducir la música del tema principal
    private void playMainTheme() {
        musicModel.playMusic(MusicPaths.MAIN_THEME);  // Reproduce la música utilizando la ruta del tema
    }

    // Método para hacer visible la vista de bienvenida
    public void mostrarPantalla() {
        view.setVisible(true);  // Muestra la pantalla de bienvenida
    }

    // Configura los oyentes de los botones de la vista
    private void setupButtonListeners() {
        view.addNextFormButtonListener(e -> openNextForm());  // Configura el botón "Siguiente"
        view.addBuscarFormBotonListener(e -> buscarPartida());  // Configura el botón "Buscar Partida"
    }

    // Método que solicita al modelo buscar una partida
    private void buscarPartida() {
        model.buscarPartida();  // Llama al modelo para buscar la partida
    }

    // Método que solicita al modelo configurar la siguiente vista
    private void openNextForm() {
        model.configurar();  // Llama al modelo para configurar la siguiente vista o acción
    }

    // Método auxiliar para navegar entre formularios (aunque no se utiliza en este caso)
    private void navigateToForm(Runnable action) {
        view.dispose();  // Cierra la vista actual
        action.run();  // Ejecuta la acción proporcionada para mostrar la siguiente vista
    }
}
