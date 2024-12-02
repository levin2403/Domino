package org.itson.domino.matchOngoing.mvc;

import DTOs.Acciones;
import DTOs.FichaDTO;
import DTOs.JugadorDTO;
import DTOs.ManejadorTurnosDTO;
import Eventos.EventoIniciarPartida;
import Eventos.EventoRealizarJugada;
import Eventos.EventoRegistrarJugador;
import Observer.Vista.ObserverFrmMatchOngoingView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import org.itson.domino.constants.IconPaths;
import org.itson.domino.managers.ResourceLoader;
import org.itson.domino.singleton.ButtonStyleSingleton;
import org.itson.domino.singleton.TaskbarButtonSingleton;
import org.itson.domino.singleton.FontSingleton;
import org.itson.domino.singleton.LookAndFeelSingleton;

public class FrmMatchOngoingView extends javax.swing.JFrame implements ObserverFrmMatchOngoingView {

    FrmMatchOngoingModel model;
    FichasPanel fichasPanel = new FichasPanel();
    TableroPanel tablero = new TableroPanel();

    public FrmMatchOngoingView(FrmMatchOngoingModel model) {
        this.model = model;
        //ESTABLECER LIBRERÍA DE GUI'S
        LookAndFeelSingleton.getInstance();

        //INICIO DE COMPONENTES
        initComponents();

        pnlFichas.add(fichasPanel);
//        for (int i = 0; i <= 6; i++) { // Primer número de la ficha
//            for (int j = i; j <= 6; j++) { // Segundo número de la ficha
//                FichaDTO ficha = new FichaDTO();
//                ficha.setValorInferior(j);
//                ficha.setValorSuperior(i);
//                ficha.setIcon(i + "-" + j); // Establecer el ícono con el formato "i-j"
//
//                fichasPanel.agregarFicha(ficha); // Agregar la ficha a la lista
//            }
//        }

        tPanel.add(tablero);

        //APLICACIÓN DE ESTILOS
        applyCustomFonts();
        applyButtonStyles();
        applyIconsAndBackground();

        //UBICACIÓN DE LA VENTANA
        setLocationRelativeTo(null);

//        this.pintaPrimerFicha(ficha);
        //FUNCIONES DE LOS BOTONES DE LA BARRA DE TAREAS
        TaskbarButtonSingleton taskbarButtonSIngleton = TaskbarButtonSingleton.getInstance();
        taskbarButtonSIngleton.addCloseButton(btnClose, this);
    }

    public void addEndMatchButtonListener(ActionListener listener) {
        btnEndMatch.addActionListener(listener);
    }

    public void addAccionIzquierdaButtonListener(ActionListener listener) {
        btnIzquierda.addActionListener(listener);
    }

    public void addAccionDerechaButtonListener(ActionListener listener) {
        btnDerecha.addActionListener(listener);
    }
    public void addRoboButtonListener(ActionListener listener) {
        btnPozo.addActionListener(listener);
    }

    private void applyIconsAndBackground() {
        try {
            // Aplicar fondo
            lblBackground.setIcon(ResourceLoader.loadBackground(IconPaths.MATCH_BG, 1200, 700));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void applyCustomFonts() {
        FontSingleton customFont = FontSingleton.getInstance();
//        applyFontToComponents(customFont, "Evil Empire", 80f, lblDomino);
        applyFontToComponents(customFont, "Evil Empire", 30f,
                btnEndMatch, btnClose, btnDerecha, btnIzquierda, btnPozo, moverIzquierda, moverDerecha,
                lblAvatar1, lblAvatar2, lblAvatar3, lblAvatar4,
                lblPlayer1, lblPlayer2, lblPlayer3, lblPlayer4);
    }

    private void applyFontToComponents(FontSingleton fontSingleton, String fontName, float size, JComponent... components) {
        for (JComponent component : components) {
            component.setFont(fontSingleton.getFont(fontName, size));
        }
    }

    private void applyButtonStyles() {
        ButtonStyleSingleton style = ButtonStyleSingleton.getInstance();

        style.applyButtonStyle(btnEndMatch);
        style.applyButtonStyle(btnClose);
        style.applyButtonStyle(btnIzquierda);
        style.applyButtonStyle(btnDerecha);
        style.applyButtonStyle(moverIzquierda);
        style.applyButtonStyle(moverDerecha);

    }

    public ImageIcon loadResource(String resourcePath, int x, int y) {
        URL imgURL = FrmMatchOngoingView.class.getResource("/tiles/" + resourcePath);
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image image = originalIcon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            return null;
        }
    }

    //de aqui en adelante esta la logica perrona
//    public void pintaPrimerFicha(FichaDTO ficha) {
//        JLabel labelFicha = new JLabel();
//        ImageIcon imagen = this.loadResource(ficha.getIcon(), 45, 25);
//        
//        ImageIcon imagenVertical;
//        
//        labelFicha.setSize(new Dimension(imagen.getIconWidth(), imagen.getIconHeight()));
//        
//        labelFicha.setIcon(imagen);
////        labelFicha.setIcon(this.loadResource(this.identificaFicha(ficha.getValorSuperior(), ficha.getValorInferior()), 45, 25));
//        labelFicha.setBounds(tableroPanel.getWidth() / 2, tableroPanel.getHeight() / 2, 45, 25);
//
////        labelFicha.setIcon(this.loadResource(
////                        "mula2.png", 25, 15));
////        labelFicha.setBounds(panel.getWidth()/2, panel.getHeight()/2, 25, 15);
//        
//        
//        labelFicha.setVisible(true);
//        this.tableroPanel.add(labelFicha);
//        this.tableroPanel.repaint();
//
////        return labelFicha;
//    }
    public static void main(String args[]) {
        FrmMatchOngoingModel m = new FrmMatchOngoingModel();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMatchOngoingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMatchOngoingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMatchOngoingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMatchOngoingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMatchOngoingView(m).setVisible(true);
            }
        });
    }

    public boolean colocarFichaDerecha(FichaDTO ficha) {
        if (tablero.agregarFichaDerecha(ficha)) {
            fichasPanel.removerFicha(ficha);
            return true;
        } else {
            System.out.println("nose puede");
        }
        return false;
    }

    public boolean colocarFichaIzquierda(FichaDTO ficha) {
        if (tablero.agregarFichaIzquierda(ficha)) {
            fichasPanel.removerFicha(ficha);
            return true;
        } else {
            System.out.println("nose puede");
        }
        return false;
    }

    public FichaDTO getFichaSeleccionada() {
        return fichasPanel.getFichaSeleccionada();
    }

    public void removerFicha(FichaDTO ficha) {
        fichasPanel.removerFicha(ficha);
    }

    /**
     * Creates new form FrmBienvenida
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnDerecha = new javax.swing.JButton();
        btnIzquierda = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnEndMatch = new javax.swing.JButton();
        moverDerecha = new javax.swing.JButton();
        btnPozo = new javax.swing.JButton();
        moverIzquierda = new javax.swing.JButton();
        pnlPlayer1 = new javax.swing.JPanel();
        lblAvatar1 = new javax.swing.JLabel();
        lblPlayer1 = new javax.swing.JLabel();
        lblPlayerY1 = new javax.swing.JLabel();
        lblFichas1 = new javax.swing.JLabel();
        pnlPlayer2 = new javax.swing.JPanel();
        lblAvatar2 = new javax.swing.JLabel();
        lblPlayer2 = new javax.swing.JLabel();
        lblPlayerY2 = new javax.swing.JLabel();
        lblFichas2 = new javax.swing.JLabel();
        pnlPlayer3 = new javax.swing.JPanel();
        lblAvatar3 = new javax.swing.JLabel();
        lblPlayer3 = new javax.swing.JLabel();
        lblPlayerY3 = new javax.swing.JLabel();
        lblFichas3 = new javax.swing.JLabel();
        pnlPlayer4 = new javax.swing.JPanel();
        lblAvatar4 = new javax.swing.JLabel();
        lblPlayer4 = new javax.swing.JLabel();
        lblPlayerY4 = new javax.swing.JLabel();
        lblFichas4 = new javax.swing.JLabel();
        pnlFichas = new javax.swing.JPanel();
        tPanel = new javax.swing.JPanel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDerecha.setText("Derecha");
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerechaActionPerformed(evt);
            }
        });
        jPanel1.add(btnDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        btnIzquierda.setText("Izquierda");
        btnIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzquierdaActionPerformed(evt);
            }
        });
        jPanel1.add(btnIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        btnClose.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnClose.setText("Salir de la partida");
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 300, 40));

        btnEndMatch.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnEndMatch.setText("Terminar partida");
        jPanel1.add(btnEndMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 300, -1));

        moverDerecha.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        moverDerecha.setText(">");
        moverDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverDerechaActionPerformed(evt);
            }
        });
        jPanel1.add(moverDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 420, -1, -1));

        btnPozo.setText("Robar Ficha");
        btnPozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPozoActionPerformed(evt);
            }
        });
        jPanel1.add(btnPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        moverIzquierda.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        moverIzquierda.setText("<");
        moverIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverIzquierdaActionPerformed(evt);
            }
        });
        jPanel1.add(moverIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, -1, -1));

        pnlPlayer1.setBackground(new java.awt.Color(212, 138, 138));

        lblPlayer1.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayer1.setText("Player x");

        lblPlayerY1.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayerY1.setText("(You)");

        lblFichas1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblFichas1.setText("Fichas:");

        javax.swing.GroupLayout pnlPlayer1Layout = new javax.swing.GroupLayout(pnlPlayer1);
        pnlPlayer1.setLayout(pnlPlayer1Layout);
        pnlPlayer1Layout.setHorizontalGroup(
            pnlPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer1Layout.createSequentialGroup()
                .addComponent(lblAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlayer1Layout.createSequentialGroup()
                        .addComponent(lblPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addGap(178, 178, 178))
                    .addGroup(pnlPlayer1Layout.createSequentialGroup()
                        .addComponent(lblPlayerY1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlPlayer1Layout.createSequentialGroup()
                        .addComponent(lblFichas1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlPlayer1Layout.setVerticalGroup(
            pnlPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer1Layout.createSequentialGroup()
                .addComponent(lblAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
            .addGroup(pnlPlayer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPlayer1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPlayerY1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFichas1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 420, 140));

        lblPlayer2.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayer2.setText("Player x");

        lblPlayerY2.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayerY2.setText("(You)");

        lblFichas2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblFichas2.setText("Fichas:");

        javax.swing.GroupLayout pnlPlayer2Layout = new javax.swing.GroupLayout(pnlPlayer2);
        pnlPlayer2.setLayout(pnlPlayer2Layout);
        pnlPlayer2Layout.setHorizontalGroup(
            pnlPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer2Layout.createSequentialGroup()
                .addComponent(lblAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(lblPlayerY2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(lblFichas2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPlayer2Layout.setVerticalGroup(
            pnlPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer2Layout.createSequentialGroup()
                .addComponent(lblAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
            .addGroup(pnlPlayer2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPlayer2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPlayerY2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFichas2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 420, 140));

        lblAvatar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatars/cactus.jpg"))); // NOI18N

        lblPlayer3.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayer3.setText("Player x");

        lblPlayerY3.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayerY3.setText("(You)");

        lblFichas3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblFichas3.setText("Fichas:");

        javax.swing.GroupLayout pnlPlayer3Layout = new javax.swing.GroupLayout(pnlPlayer3);
        pnlPlayer3.setLayout(pnlPlayer3Layout);
        pnlPlayer3Layout.setHorizontalGroup(
            pnlPlayer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer3Layout.createSequentialGroup()
                .addComponent(lblAvatar3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPlayer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlayer3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(lblPlayerY3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(lblFichas3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPlayer3Layout.setVerticalGroup(
            pnlPlayer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer3Layout.createSequentialGroup()
                .addComponent(lblAvatar3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
            .addGroup(pnlPlayer3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPlayer3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPlayerY3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFichas3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlPlayer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, 420, 140));

        lblPlayer4.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayer4.setText("Player x");

        lblPlayerY4.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayerY4.setText("(You)");

        lblFichas4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblFichas4.setText("Fichas:");

        javax.swing.GroupLayout pnlPlayer4Layout = new javax.swing.GroupLayout(pnlPlayer4);
        pnlPlayer4.setLayout(pnlPlayer4Layout);
        pnlPlayer4Layout.setHorizontalGroup(
            pnlPlayer4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer4Layout.createSequentialGroup()
                .addComponent(lblAvatar4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPlayer4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlayer4, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(lblPlayerY4, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(lblFichas4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPlayer4Layout.setVerticalGroup(
            pnlPlayer4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer4Layout.createSequentialGroup()
                .addComponent(lblAvatar4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
            .addGroup(pnlPlayer4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPlayer4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPlayerY4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFichas4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlPlayer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 540, 420, 140));

        pnlFichas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFichas.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(pnlFichas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 290, 500));

        tPanel.setBackground(new java.awt.Color(0, 153, 51));
        tPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tPanel.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(tPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 720, 380));

        lblBackground.setText("||");
        jPanel1.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerechaActionPerformed


    }//GEN-LAST:event_btnDerechaActionPerformed

    private void btnIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzquierdaActionPerformed

    }//GEN-LAST:event_btnIzquierdaActionPerformed

    private void moverDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moverDerechaActionPerformed
        tablero.moverFichas(-50);        // TODO add your handling code here:
    }//GEN-LAST:event_moverDerechaActionPerformed

    private void moverIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moverIzquierdaActionPerformed
        tablero.moverFichas(50);
    }//GEN-LAST:event_moverIzquierdaActionPerformed

    private void btnPozoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPozoActionPerformed

    }//GEN-LAST:event_btnPozoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDerecha;
    private javax.swing.JButton btnEndMatch;
    private javax.swing.JButton btnIzquierda;
    private javax.swing.JButton btnPozo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAvatar1;
    private javax.swing.JLabel lblAvatar2;
    private javax.swing.JLabel lblAvatar3;
    private javax.swing.JLabel lblAvatar4;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblFichas1;
    private javax.swing.JLabel lblFichas2;
    private javax.swing.JLabel lblFichas3;
    private javax.swing.JLabel lblFichas4;
    private javax.swing.JLabel lblPlayer1;
    private javax.swing.JLabel lblPlayer2;
    private javax.swing.JLabel lblPlayer3;
    private javax.swing.JLabel lblPlayer4;
    private javax.swing.JLabel lblPlayerY1;
    private javax.swing.JLabel lblPlayerY2;
    private javax.swing.JLabel lblPlayerY3;
    private javax.swing.JLabel lblPlayerY4;
    private javax.swing.JButton moverDerecha;
    private javax.swing.JButton moverIzquierda;
    private javax.swing.JPanel pnlFichas;
    private javax.swing.JPanel pnlPlayer1;
    private javax.swing.JPanel pnlPlayer2;
    private javax.swing.JPanel pnlPlayer3;
    private javax.swing.JPanel pnlPlayer4;
    private javax.swing.JPanel tPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizarVista(Object object) {
        if (object instanceof Acciones) {
                Acciones accion = (Acciones) object;

                if (accion == accion.POZOVACIO) {
                    JOptionPane.showMessageDialog(this, "Pozo vacio");
                }
            }
        else if (object instanceof JugadorDTO j) {

            model.setJugadorDto(j);

        } else if (object instanceof EventoIniciarPartida e) {
            ManejadorTurnosDTO m = e.getManejador();
            model.setJugadores(m.getJugadores());
            List<JugadorDTO> jugadores = m.getJugadores();
            List<FichaDTO> fichas = new ArrayList<>();
            int contador = 0;
            JLabel[] lblAvatares = {lblAvatar1, lblAvatar2, lblAvatar3, lblAvatar4};
            JLabel[] lblPlayers = {lblPlayer1, lblPlayer2, lblPlayer3, lblPlayer4};
            JLabel[] lblPlayersY = {lblPlayerY1, lblPlayerY2, lblPlayerY3, lblPlayerY4};

            for (int i = 0; i < jugadores.size(); i++) {
                lblPlayers[0].setForeground(Color.YELLOW);
                // Configurar imagen del avatar (ejemplo: obteniendo de un path o recurso)
                if (model.getJugadorDto().equals(jugadores.get(i))) {
                    lblPlayers[i].setText(jugadores.get(i).getNickName());
                    lblPlayersY[i].setText("YOU");
                    model.setJugadorDto(jugadores.get(i));
                    for (FichaDTO f : jugadores.get(i).getFichas()) {
                        this.fichasPanel.agregarFicha(f);
                    }

                } else {
                    lblPlayersY[i].setText("");
                    lblPlayers[i].setText(jugadores.get(i).getNickName());
                }
                String s = "/avatars/cactus.jpg";
                String d = "/" + jugadores.get(i).getAvatar().getImageURL();
                java.net.URL imgURL = getClass().getResource(d);
                if (imgURL != null) {
                    ImageIcon avatarIcon = new ImageIcon(imgURL);

                    // Escalar la imagen al tamaño del JLabel
                    Image scaledImage = avatarIcon.getImage().getScaledInstance(
                            lblAvatares[i].getWidth(),
                            lblAvatares[i].getHeight(),
                            Image.SCALE_SMOOTH
                    );

                    // Establecer el icono escalado
                    lblAvatares[i].setIcon(new ImageIcon(scaledImage));
                } else {
                }
                contador++;
            }
            if (contador == 3) {
                pnlPlayer4.setVisible(false);
            } else if (contador == 2) {
                pnlPlayer3.setVisible(false);
                pnlPlayer4.setVisible(false);
            } else if (contador == 1) {
                pnlPlayer2.setVisible(false);
                pnlPlayer3.setVisible(false);
                pnlPlayer4.setVisible(false);
            }
            // se pone la inicial

            FichaDTO mulaMasGrande = null;

            for (FichaDTO ficha : jugadores.get(0).getFichas()) {
                if (ficha.isMula(ficha)) {
                    int valorTotal = ficha.getValorSuperior() + ficha.getValorInferior(); // O la lógica que decidas
                    // Si es la primera mula o es más grande, la asignamos
                    if (mulaMasGrande == null || valorTotal > (mulaMasGrande.getValorSuperior() + mulaMasGrande.getValorInferior())) {
                        mulaMasGrande = ficha;
                    }
                }
            }
            this.colocarFichaDerecha(mulaMasGrande);

        } else if (object instanceof EventoRealizarJugada e) {
            if (!e.getJugador().equals(model.getJugadorDto())) {
                if (e.isIzquierda()) {
                    this.colocarFichaIzquierda(e.getFicha());
                } else {
                    this.colocarFichaDerecha(e.getFicha());
                }
            }
        } else if (object instanceof ManejadorTurnosDTO m) {
            
            
            JLabel[] lblfichas = {lblFichas1, lblFichas2, lblFichas3, lblFichas4};
            model.setJugadorTurno(m.getJugadorEnTurno());
            JLabel[] lblPlayers = {lblPlayer1, lblPlayer2, lblPlayer3, lblPlayer4};
            for (int i = 0; i < m.getJugadores().size(); i++) {
                if (m.getJugadores().get(i).equals(model.getJugadorDto())) {
                    this.fichasPanel.agregarFicha(m.getJugadores().get(i).getFichas());
                }
                for (int j = 0; j < lblPlayers.length; j++) {
                    if (lblPlayers[j].getText().equalsIgnoreCase(m.getJugadores().get(i).getNickName())) {
                        lblfichas[j].setText("Fichas: "+m.getJugadores().get(i).getFichas().size());
                    }
                }
            }
            for (JLabel lblPlayer : lblPlayers) {
                if (lblPlayer.getText().equalsIgnoreCase(model.getJugadorTurno().getNickName())) {
                    lblPlayer.setForeground(Color.YELLOW);
                } else {
                    lblPlayer.setForeground(Color.BLACK);
                }
            }

        }

    }
}
