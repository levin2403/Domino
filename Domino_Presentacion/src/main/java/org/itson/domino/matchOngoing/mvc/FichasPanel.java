/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.domino.matchOngoing.mvc;

import DTOs.FichaDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class FichasPanel extends JPanel {

    private List<FichaDTO> fichas; // Lista interna de fichas
    private int espacioEntreFichas = 10; // Espacio entre cada ficha
    private FichaDTO fichaSeleccionada;

    public FichasPanel() {
        this.fichas = new ArrayList<>(); // Inicializar la lista de fichas
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                detectarFichaClickeada(e.getX(), e.getY());
            }
        });
    }
    private boolean mostrar;

    public FichaDTO getFichaSeleccionada() {
        return fichaSeleccionada;
    }

    public void setFichaSeleccionada(FichaDTO fichaSeleccionada) {
        this.fichaSeleccionada = fichaSeleccionada;
    }

private void detectarFichaClickeada(int mouseX, int mouseY) {
    double escala = 0.188; // Escala usada para dibujar las fichas
    int x = espacioEntreFichas; // Coordenada inicial X
    int y = espacioEntreFichas; // Coordenada inicial Y
    int panelWidth = getWidth(); // Ancho del panel
    fichaSeleccionada = null; // Reiniciar la ficha seleccionada


    for (FichaDTO ficha : fichas) {
        if (ficha.getIcon() != null) {
            // Cargar el ícono y calcular el tamaño escalado
            ImageIcon icon = new ImageIcon(getClass().getResource("/tiles/" + ficha.getIcon() + ".png"));
            int anchoFichaEscalado = (int) (icon.getIconWidth() * escala);
            int altoFichaEscalado = (int) (icon.getIconHeight() * escala);

            // 1. Coordenadas del centro de rotación (aproximadamente en el centro de la ficha)
            int cx = x + altoFichaEscalado / 2;  // Centro en X
            int cy = y + anchoFichaEscalado / 2; // Centro en Y

            // 2. Coordenadas de los puntos iniciales (esquinas superior izquierda)
            int x1 = x;
            int y1 = y;

            // 3. Rotar el primer punto (superior izquierdo)
            double angulo = Math.toRadians(90); // Rotación de 90 grados
            int rotadoX1 = (int) (cx + (x1 - cx) * Math.cos(angulo) - (y1 - cy) * Math.sin(angulo));
            int rotadoY1 = (int) (cy + (x1 - cx) * Math.sin(angulo) + (y1 - cy) * Math.cos(angulo));

            // 4. Calcular las coordenadas del segundo punto (inferior derecho) usando el primer punto rotado
            int rotadoX2 = rotadoX1 - altoFichaEscalado;  // Agregar la altura escalada
            int rotadoY2 = rotadoY1 + anchoFichaEscalado; // Agregar el ancho escalado

            // 5. Verificar si el clic está dentro de la hitbox (definida por los puntos rotados)
            int minX = Math.min(rotadoX1, rotadoX2);
            int maxX = Math.max(rotadoX1, rotadoX2);
            int minY = Math.min(rotadoY1, rotadoY2);
            int maxY = Math.max(rotadoY1, rotadoY2);

            if (mouseX >= minX && mouseX <= maxX && mouseY >= minY && mouseY <= maxY) {
                fichaSeleccionada = ficha; // Guardar la ficha seleccionada
                 repaint(); // Redibujar para reflejar la selección
                return; // Salir del bucle
            }

            // Ajustar posición para la siguiente ficha
            x += altoFichaEscalado + espacioEntreFichas; // Avanzar horizontalmente usando alto escalado

            // Si no cabe en esta fila, pasar a la siguiente
            if (x + altoFichaEscalado > panelWidth) {
                x = espacioEntreFichas; // Reiniciar X al inicio de la fila
                y += anchoFichaEscalado + espacioEntreFichas; // Avanzar verticalmente usando ancho escalado
            }
        }
    }

    
}


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create(); // Crear un Graphics2D para transformaciones
        double escala = 0.188; // Escala al 50%
        
        int x = espacioEntreFichas; // Posición inicial X
        int y = espacioEntreFichas; // Posición inicial Y
        int panelWidth = getWidth(); // Ancho disponible del panel
        
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
                if (ficha.equals(fichaSeleccionada)) {
                    g2d.setColor(Color.RED);
                    g2d.setStroke(new BasicStroke(3));
                    g2d.drawRect(x, y, anchoFichaEscalado, altoFichaEscalado);
                }
                g2d.rotate(-Math.toRadians(90), x + (altoFichaEscalado / 2.0), y + (anchoFichaEscalado / 2.0));
            
                // Ajustar posición para la siguiente ficha
//                double ss= x + (altoFichaEscalado / 2.0);
//                double sss= y + (anchoFichaEscalado / 2.0);
//             
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
    public void removerFicha(FichaDTO ficha) {
        fichas.remove(ficha); // Agregar la ficha a la lista
        repaint(); // Redibujar el panel para mostrar la nueva ficha
    }
    // Método opcional para establecer el espacio entre fichas
    public void setEspacioEntreFichas(int espacioEntreFichas) {
        this.espacioEntreFichas = espacioEntreFichas;
        repaint();
    }
}
