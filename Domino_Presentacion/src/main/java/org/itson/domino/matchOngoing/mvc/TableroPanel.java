/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.matchOngoing.mvc;

import DTOs.FichaDTO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author gamaliel
 */
public class TableroPanel extends JPanel {
    private List<FichaDTO> fichasIzquierda = new ArrayList<>();
    private List<FichaDTO> fichasDerecha = new ArrayList<>();
    private FichaDTO fichaCentral;
    private List<Point> posiciones; // Lista de posiciones calculadas para las fichas
    private int espacioEntreFichas = 10; // Espacio entre fichas
    private double escala = 0.2; // Escala al 50%

    public TableroPanel() {

        this.posiciones = new ArrayList<>();
        this.setBackground(new java.awt.Color(0, 153, 51));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        int xCentro = getWidth() / 2;  // Centro del panel
        int yCentro = getHeight() / 2; // Centro del panel
        int espacioEntreFichas = 0;   // Ajusta esto según sea necesario
        double escala = 0.2;  // Ajusta la escala si es necesario

        // Dibujar fichas a la izquierda
        // Dibujar fichas a la izquierda
        int xIzquierda = xCentro;
        for (int i = 0; i < fichasIzquierda.size(); i++) {
            FichaDTO ficha = fichasIzquierda.get(i);
            int yMula = 0;
            int xMula = 0;
            // Cargar el ícono de la ficha
            ImageIcon icon = new ImageIcon(getClass().getResource("/tiles/" + ficha.getIcon() + ".png"));
            Image image = icon.getImage();
            int anchoFichaEscalado = (int) (icon.getIconWidth() * escala);
            int altoFichaEscalado = (int) (icon.getIconHeight() * escala);

            // Calculando la posición
            if (i == 0) {
                xIzquierda -= (anchoFichaEscalado + (anchoFichaEscalado / 4) + espacioEntreFichas); // Primer elemento
            } else {
                xIzquierda -= (anchoFichaEscalado + espacioEntreFichas); // Resto de los elementos
            }

            // Si es una ficha mula, rotarla
            if (ficha.isMula(ficha)) {
                System.out.println("es mula");

                // Ajustar la posición para la ficha mula
                xMula = xIzquierda;
                yMula = yCentro;
                yMula += (altoFichaEscalado / 2);

                // Realizar la rotación
                g2d.translate(xIzquierda + anchoFichaEscalado / 2, yMula - altoFichaEscalado / 2); // Mover al centro de la ficha
                g2d.rotate(Math.toRadians(90)); // Rotar 90 grados (vertical)
                g2d.translate(-(xIzquierda + anchoFichaEscalado / 2), -(yMula - altoFichaEscalado / 2)); // Volver a la posición original
            }

            // Desplazamiento a la izquierda
            int yCentrado = yCentro - altoFichaEscalado / 2; // Centrado en el eje Y
            if (ficha.isMula(ficha)) {
                yCentrado -= (altoFichaEscalado / 2); // Ajuste vertical si es una mula
            }

            // Dibujar la ficha
            g2d.drawImage(image, xIzquierda, yCentrado, anchoFichaEscalado, altoFichaEscalado, this);

            // Resetear la transformación si se hizo rotación
            if (ficha.isMula(ficha)) {
                g2d.setTransform(g2d.getDeviceConfiguration().getDefaultTransform());
                xIzquierda += (anchoFichaEscalado / 2); // Ajuste al final de la rotación
            }
        }

        // Dibujar la ficha central (solo rotada si es la ficha central)
        if (fichaCentral != null) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/tiles/" + fichaCentral.getIcon() + ".png"));
            Image image = icon.getImage();
            int anchoFichaEscalado = (int) (icon.getIconWidth() * escala);
            int altoFichaEscalado = (int) (icon.getIconHeight() * escala);

            int xCentral = xCentro - anchoFichaEscalado / 2;  // Centrando la ficha en el eje X
            int yCentral = yCentro - altoFichaEscalado / 2;   // Centrando la ficha en el eje Y

            // Si es la ficha central, la rotamos 90 grados
            g2d.translate(xCentral + anchoFichaEscalado / 2, yCentral + altoFichaEscalado / 2); // Mover al centro de la ficha
            g2d.rotate(Math.toRadians(90)); // Rotar 90 grados (vertical)
            g2d.translate(-(xCentral + anchoFichaEscalado / 2), -(yCentral + altoFichaEscalado / 2)); // Volver a la posición original

            // Dibujar la ficha central rotada
            g2d.drawImage(image, xCentral, yCentral, anchoFichaEscalado, altoFichaEscalado, this);

            // Resetear la transformación después de dibujar la ficha central rotada
            g2d.setTransform(g2d.getDeviceConfiguration().getDefaultTransform());
        }

        // Dibujar fichas a la derecha
        int xDerecha = xCentro;
        for (int i = 0; i < fichasDerecha.size(); i++) {
            FichaDTO ficha = fichasDerecha.get(i);
            int yMula = 0;
            int xMula = 0;
            // Cargar el ícono de la ficha
            ImageIcon icon = new ImageIcon(getClass().getResource("/tiles/" + ficha.getIcon() + ".png"));
            Image image = icon.getImage();
            int anchoFichaEscalado = (int) (icon.getIconWidth() * escala);
            int altoFichaEscalado = (int) (icon.getIconHeight() * escala);

            // Calculando la posición
            if (i == 0) {
                xDerecha += ((anchoFichaEscalado / 4) + espacioEntreFichas);
            } else {
                xDerecha += (anchoFichaEscalado + espacioEntreFichas);
            }

            // Si es una ficha mula, rotarla
            if (ficha.isMula(ficha)) {

                System.out.println("es mula");
                xMula = xDerecha;
                yMula = yCentro;
                yMula += (altoFichaEscalado / 2);
                // Si es mula, realizar la rotación
                g2d.translate(xDerecha + anchoFichaEscalado / 2, yMula - altoFichaEscalado / 2); // Mover al centro de la ficha
                g2d.rotate(Math.toRadians(90)); // Rotar 90 grados (vertical)
                g2d.translate(-(xDerecha + anchoFichaEscalado / 2), -(yMula - altoFichaEscalado / 2)); // Volver a la posición original

            }

            // Desplazamiento a la derecha
            int yCentrado = yCentro - altoFichaEscalado / 2;  // Centrado en el eje y
            if (ficha.isMula(ficha)) {
                yCentrado += (altoFichaEscalado / 2);
            }

            g2d.drawImage(image, xDerecha, yCentrado, anchoFichaEscalado, altoFichaEscalado, this);

            // Resetear la transformación si se hizo rotación
            if (ficha.isMula(ficha)) {
                g2d.setTransform(g2d.getDeviceConfiguration().getDefaultTransform());
                xDerecha -= (anchoFichaEscalado / 2);
            }
        }

        g2d.dispose();
    }

// Ajustar las posiciones al agregar fichas
    public void agregarFichaIzquierda(FichaDTO ficha) {
        if (fichaCentral == null) {
            // Si no existe una ficha central, se agrega la ficha central primero
            fichaCentral = ficha;
        } else {
            // Si ya existe la ficha central, se agrega la ficha a la izquierda
            fichasIzquierda.add(ficha); // Agregar a la izquierda de las fichas ya existentes
        }
        repaint(); // Redibujar el panel
    }

    public void agregarFichaDerecha(FichaDTO ficha) {
        if (fichaCentral == null) {
            // Si no existe una ficha central, se agrega la ficha central primero
            fichaCentral = ficha;
        } else {
            // Si ya existe la ficha central, se agrega la ficha a la derecha
            fichasDerecha.add(ficha); // Agregar a la derecha de las fichas ya existentes
        }
        repaint(); // Redibujar el panel
    }
}
