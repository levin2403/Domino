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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TableroPanel extends JPanel {

    private List<FichaDTO> fichasIzquierda = new ArrayList<>();
    private List<FichaDTO> fichasDerecha = new ArrayList<>();
    private FichaDTO fichaCentral;
    private List<Point> posiciones; // Lista de posiciones calculadas para las fichas
    private int espacioEntreFichas = 10; // Espacio entre fichas
    private double escala = 0.2; // Escala al 50%
    private int desplazamientoX = 0;  // Desplazamiento inicial en X
    private final int LIMITE_DESPLAZAMIENTO = 1500;
   

    public TableroPanel() {

        this.posiciones = new ArrayList<>();
        this.setBackground(new java.awt.Color(0, 153, 51));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                detectarFichaClickeada(e.getX(), e.getY());
            }
        });
    }

    private void detectarFichaClickeada(int mouseX, int mouseY) {

        
    }

    public int getDesplazamientoX() {
        return desplazamientoX;
    }

    public void setDesplazamientoX(int desplazamientoX) {
        this.desplazamientoX = desplazamientoX;
    }

    public void moverFichas(int desplazamiento) {
        // Calculamos el nuevo desplazamiento
        int nuevoDesplazamiento = desplazamientoX + desplazamiento;

        // Verificamos que el nuevo desplazamiento no exceda los límites
        if (nuevoDesplazamiento > LIMITE_DESPLAZAMIENTO) {
            desplazamientoX = LIMITE_DESPLAZAMIENTO;  // Límite hacia la derecha
        } else if (nuevoDesplazamiento < -LIMITE_DESPLAZAMIENTO) {
            desplazamientoX = -LIMITE_DESPLAZAMIENTO;  // Límite hacia la izquierda
        } else {
            desplazamientoX = nuevoDesplazamiento;  // Si no excede, aplicamos el desplazamiento
        }

        repaint();  // Vuelve a dibujar las fichas con el nuevo desplazamiento
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        int xCentro = getWidth() / 2 + desplazamientoX;
        int yCentro = getHeight() / 2;
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
            if (ficha.getConectado() == 0) {
                g2d.translate(xIzquierda + anchoFichaEscalado / 2, yCentrado + altoFichaEscalado / 2); // Mover al centro de la ficha
                g2d.scale(-1, 1); // Escalar negativamente en el eje X para voltear horizontalmente
                g2d.translate(-(xIzquierda + anchoFichaEscalado / 2), -(yCentrado + altoFichaEscalado / 2));
            }
            g2d.drawImage(image, xIzquierda, yCentrado, anchoFichaEscalado, altoFichaEscalado, this);
            g2d.setTransform(g2d.getDeviceConfiguration().getDefaultTransform());
            // Resetear la transformación si se hizo rotación
            if (ficha.isMula(ficha)) {
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

                xMula = xDerecha;
                yMula = yCentro;
                yMula += (altoFichaEscalado / 2);
                // Si es mula, realizar la rotación
                g2d.translate(xDerecha + anchoFichaEscalado / 2, yMula - altoFichaEscalado / 2); // Mover al centro de la ficha

                g2d.rotate(Math.toRadians(90));

                // Rotar 90 grados (vertical)
                g2d.translate(-(xDerecha + anchoFichaEscalado / 2), -(yMula - altoFichaEscalado / 2)); // Volver a la posición original

            }

            // Desplazamiento a la derecha
            int yCentrado = yCentro - altoFichaEscalado / 2;  // Centrado en el eje y
            if (ficha.isMula(ficha)) {
                yCentrado += (altoFichaEscalado / 2);
            }
            if (ficha.getConectado() == 0) {
                g2d.translate(xDerecha + anchoFichaEscalado / 2, yCentrado + altoFichaEscalado / 2); // Mover al centro de la ficha
                g2d.scale(-1, 1); // Escalar negativamente en el eje X para voltear horizontalmente
                g2d.translate(-(xDerecha + anchoFichaEscalado / 2), -(yCentrado + altoFichaEscalado / 2));
            }
            // Volver a la posición original

// Dibujar la imagen volteada
            g2d.drawImage(image, xDerecha, yCentrado, anchoFichaEscalado, altoFichaEscalado, this);

            g2d.setTransform(g2d.getDeviceConfiguration().getDefaultTransform());
            // Resetear la transformación si se hizo rotación
            if (ficha.isMula(ficha)) {
                xDerecha -= (anchoFichaEscalado / 2);
            }
        }

        g2d.dispose();
    }

// Ajustar las posiciones al agregar fichas
    public boolean agregarFichaIzquierda(FichaDTO ficha) {
        if (fichaCentral == null) {
            // Si no existe una ficha central, se agrega la ficha central primero
            fichaCentral = ficha;
        } else {
            // Si ya existe la ficha central, se agrega la ficha a la izquierda
            FichaDTO ultimaFichaIzquierda = fichasIzquierda.isEmpty() ? fichaCentral : fichasIzquierda.get(fichasIzquierda.size() - 1);
            int numeroExpuesto = obtenerNumeroExpuesto(ultimaFichaIzquierda, true); // Obtener el número expuesto
          
            if (puedeColocarFicha(ultimaFichaIzquierda, ficha, true)) {

                if (numeroExpuesto == ficha.getValorSuperior()) {
                    ficha.setConectado(0); // Conectar por el lado inferior
                } else if (numeroExpuesto == ficha.getValorInferior()) {
                    ficha.setConectado(1); // Conectar por el lado superior
                }
                fichasIzquierda.add(ficha); // Agregar a la izquierda
            } else {
                return false;
            }
// Agregar a la izquierda de las fichas ya existentes
        }
        repaint(); // Redibujar el panel
        return true;
    }

    public boolean agregarFichaDerecha(FichaDTO ficha) {
        if (fichaCentral == null) {
            // Si no existe una ficha central, se agrega la ficha central primero
            fichaCentral = ficha;
        } else {
            // Si ya existe la ficha central, se agrega la ficha a la derecha
            FichaDTO ultimaFichaDerecha = fichasDerecha.isEmpty() ? fichaCentral : fichasDerecha.get(fichasDerecha.size() - 1);
            if (puedeColocarFicha(ultimaFichaDerecha, ficha, false)) {
                int numeroExpuesto = obtenerNumeroExpuesto(ultimaFichaDerecha, false); // Obtener el número expuesto
                if (numeroExpuesto == ficha.getValorSuperior()) {
                    ficha.setConectado(1); // Conectar por el lado inferior
                } else if (numeroExpuesto == ficha.getValorInferior()) {
                    ficha.setConectado(0); // Conectar por el lado superior
                }
                fichasDerecha.add(ficha); // Agregar a la derecha
            } else {
                return false;
            }

        }
        repaint(); // Redibujar el panel
        return true;
    }

    private boolean puedeColocarFicha(FichaDTO ultimaFicha, FichaDTO ficha, boolean esIzquierda) {
        int numeroExpuesto = obtenerNumeroExpuesto(ultimaFicha, esIzquierda);
        return numeroExpuesto == ficha.getValorSuperior() || numeroExpuesto == ficha.getValorInferior();
    }

    private int obtenerNumeroExpuesto(FichaDTO ficha, boolean esIzquierda) {
        // Si la ficha se conectó por el lado superior (getConectado() == 0), el número expuesto es el inferior (numero2)
        // Si la ficha se conectó por el lado inferior (getConectado() == 1), el número expuesto es el superior (numero1)
        if (ficha.getConectado() == 0) {
            return esIzquierda ? ficha.getValorInferior() : ficha.getValorSuperior(); // En el extremo izquierdo, se muestra el número inferior
        } else {
            return esIzquierda ? ficha.getValorSuperior() : ficha.getValorInferior(); // En el extremo derecho, se muestra el número superior
        }
    }
}