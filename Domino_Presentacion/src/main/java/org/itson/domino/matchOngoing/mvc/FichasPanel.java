/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.matchOngoing.mvc;

import DTOs.FichaDTO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author gamaliel
 */
public class FichasPanel extends JPanel {
    private List<FichaDTO> fichas; // Lista interna de fichas
    private int espacioEntreFichas = 10; // Espacio entre cada ficha

    public FichasPanel() {
        this.fichas = new ArrayList<>(); // Inicializar la lista de fichas
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create(); // Crear un Graphics2D para transformaciones
        double escala = 0.188; // Escala al 50%

        int x = espacioEntreFichas; // Posición inicial X
        int y = espacioEntreFichas; // Posición inicial Y
        int panelWidth = getWidth(); // Ancho disponible del panel

        System.out.println(panelWidth + "mirax");
        for (FichaDTO ficha : fichas) {
            if (ficha.getIcon() != null) {
                // Cargar el ícono de la ficha
                ImageIcon icon = new ImageIcon(getClass().getResource("/tiles/" + ficha.getIcon() + ".png"));
                Image image = icon.getImage();

                // Obtener tamaño original de la imagen
                int anchoFichaOriginal = icon.getIconWidth();
                int altoFichaOriginal = icon.getIconHeight();

                // Calcular tamaño escalado
                int anchoFichaEscalado = (int) (anchoFichaOriginal * escala);
                int altoFichaEscalado = (int) (altoFichaOriginal * escala);

                // Dibujar la ficha rotada y escalada
                g2d.rotate(Math.toRadians(90), x + (altoFichaEscalado / 2.0), y + (anchoFichaEscalado / 2.0));
                g2d.drawImage(image, x, y, anchoFichaEscalado, altoFichaEscalado, this);
                g2d.rotate(-Math.toRadians(90), x + (altoFichaEscalado / 2.0), y + (anchoFichaEscalado / 2.0));

                // Ajustar posición para la siguiente ficha
                x += altoFichaEscalado + espacioEntreFichas; // Avanzar horizontalmente usando el alto escalado de la ficha rotada

                // Si no cabe en esta fila, pasar a la siguiente
                if (x + altoFichaEscalado > panelWidth) {
                    x = espacioEntreFichas; // Reiniciar X al inicio de la fila
                    y += anchoFichaEscalado + espacioEntreFichas; // Avanzar verticalmente usando el ancho escalado
                }
            }
        }

        g2d.dispose(); // Liberar el Graphics2D
    }

    // Método para agregar una ficha
    public void agregarFicha(FichaDTO ficha) {
        fichas.add(ficha); // Agregar la ficha a la lista
        repaint(); // Redibujar el panel para mostrar la nueva ficha
    }

    public void agregarFicha(List<FichaDTO> ficha) {
        fichas = ficha;  // Agregar la ficha a la lista
        repaint(); // Redibujar el panel para mostrar la nueva ficha
    }

    // Método opcional para establecer el espacio entre fichas
    public void setEspacioEntreFichas(int espacioEntreFichas) {
        this.espacioEntreFichas = espacioEntreFichas;
        repaint();
    }
}
