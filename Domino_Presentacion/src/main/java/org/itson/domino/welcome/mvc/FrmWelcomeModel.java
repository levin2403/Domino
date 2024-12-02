/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.welcome.mvc;

import DTOs.Acciones;
import Observable.ObservableMenuLogica;
import Observer.ObserverMenuLogica;
import Observer.Vista.ObserverFrmPlayerSettingsView;
import Observer.Vista.ObserverFrmWelcomeView;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author gamaliel
 */
public class FrmWelcomeModel implements ObservableMenuLogica, ObserverMenuLogica {

    private ObserverMenuLogica observer;

    ObserverMenuLogica observable = new ObserverMenuLogica() {
        @Override
        public void actualizar(Object objecto) {
           observerView.actualizarVista(objecto);
        }

    };

    private ObserverFrmWelcomeView observerView;

    private ImageIcon createImageIcon(String path, int x, int y,
            String extension) throws Exception {
        URL imgURL = FrmWelcomeView.class.getResource("/icons/" + path + "."
                + extension);
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image image = originalIcon.getImage().getScaledInstance(x, y,
                    Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            throw new Exception("No se pudo encontrar el archivo de imagen");
        }
    }

    public ObserverMenuLogica getObservable() {
        return observable;
    }

    public void setObservable(ObserverMenuLogica observable) {
        this.observable = observable;
    }
    
    
    public void buscarPartida() {
        notificar(Acciones.BUSCARPARTIDA);
    }
     public void configurar() {
        notificar(Acciones.CONFIGURAR);
    }

    @Override
    public void registrarObservador(ObserverMenuLogica o) {
        this.observer = o;
    }

    @Override
    public void registrarObservadorView(ObserverFrmWelcomeView o) {
        this.observerView = o;
    }

    @Override
    public void notificar(Object objecto) {
        observer.actualizar(objecto);
    }

    @Override
    public void actualizar(Object objecto) {
       
        
    }

}