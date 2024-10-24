package org.itson.domino.matchOngoing.mvc;

import DTOs.FichaDTO;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.itson.domino.constants.IconPaths;
import org.itson.domino.managers.ResourceLoader;
import org.itson.domino.singleton.ButtonStyleSingleton;
import org.itson.domino.singleton.TaskbarButtonSingleton;
import org.itson.domino.singleton.FontSingleton;
import org.itson.domino.singleton.LookAndFeelSingleton;

public class FrmMatchOngoingView extends javax.swing.JFrame {

    FrmMatchOngoingModel model;
    
    public FrmMatchOngoingView(FrmMatchOngoingModel model) {
        this.model = model;
        //ESTABLECER LIBRERÍA DE GUI'S
        LookAndFeelSingleton.getInstance();

        //INICIO DE COMPONENTES
        initComponents();

        //APLICACIÓN DE ESTILOS
        applyCustomFonts();
        applyButtonStyles();
        applyIconsAndBackground();

        //UBICACIÓN DE LA VENTANA
        setLocationRelativeTo(null);
        
        FichaDTO ficha = new FichaDTO(2, 2);
        
//        this.pintaPrimerFicha(ficha);
        

        //FUNCIONES DE LOS BOTONES DE LA BARRA DE TAREAS
        TaskbarButtonSingleton taskbarButtonSIngleton = TaskbarButtonSingleton.getInstance();
        taskbarButtonSIngleton.addCloseButton(btnClose, this);
    }
    
    public void addEndMatchButtonListener(ActionListener listener) {
        btnEndMatch.addActionListener(listener);
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
                btnEndMatch, btnClose,
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMatchOngoingView(m).setVisible(true);
            }
        });
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
        btnClose = new javax.swing.JButton();
        btnEndMatch = new javax.swing.JButton();
        pnlPlayer1 = new javax.swing.JPanel();
        lblAvatar1 = new javax.swing.JLabel();
        lblPlayer1 = new javax.swing.JLabel();
        pnlPlayer2 = new javax.swing.JPanel();
        lblAvatar2 = new javax.swing.JLabel();
        lblPlayer2 = new javax.swing.JLabel();
        pnlPlayer3 = new javax.swing.JPanel();
        lblAvatar3 = new javax.swing.JLabel();
        lblPlayer3 = new javax.swing.JLabel();
        pnlPlayer4 = new javax.swing.JPanel();
        lblAvatar4 = new javax.swing.JLabel();
        lblPlayer4 = new javax.swing.JLabel();
        pnlLeftTiles = new javax.swing.JPanel();
        tableroPanel = new javax.swing.JPanel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClose.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnClose.setText("Salir de la partida");
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 300, 40));

        btnEndMatch.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnEndMatch.setText("Terminar partida");
        jPanel1.add(btnEndMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 300, -1));

        lblPlayer1.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayer1.setText("Player x");

        javax.swing.GroupLayout pnlPlayer1Layout = new javax.swing.GroupLayout(pnlPlayer1);
        pnlPlayer1.setLayout(pnlPlayer1Layout);
        pnlPlayer1Layout.setHorizontalGroup(
            pnlPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer1Layout.createSequentialGroup()
                .addComponent(lblAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPlayer1Layout.setVerticalGroup(
            pnlPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer1Layout.createSequentialGroup()
                .addComponent(lblAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlPlayer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPlayer1)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jPanel1.add(pnlPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 420, 140));

        lblPlayer2.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayer2.setText("Player x");

        javax.swing.GroupLayout pnlPlayer2Layout = new javax.swing.GroupLayout(pnlPlayer2);
        pnlPlayer2.setLayout(pnlPlayer2Layout);
        pnlPlayer2Layout.setHorizontalGroup(
            pnlPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer2Layout.createSequentialGroup()
                .addComponent(lblAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 420, 140));

        lblPlayer3.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayer3.setText("Player x");

        javax.swing.GroupLayout pnlPlayer3Layout = new javax.swing.GroupLayout(pnlPlayer3);
        pnlPlayer3.setLayout(pnlPlayer3Layout);
        pnlPlayer3Layout.setHorizontalGroup(
            pnlPlayer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer3Layout.createSequentialGroup()
                .addComponent(lblAvatar3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPlayer3, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlPlayer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, 420, 140));

        lblPlayer4.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayer4.setText("Player x");

        javax.swing.GroupLayout pnlPlayer4Layout = new javax.swing.GroupLayout(pnlPlayer4);
        pnlPlayer4.setLayout(pnlPlayer4Layout);
        pnlPlayer4Layout.setHorizontalGroup(
            pnlPlayer4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer4Layout.createSequentialGroup()
                .addComponent(lblAvatar4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPlayer4, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlPlayer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 540, 420, 140));

        pnlLeftTiles.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(pnlLeftTiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 290, 500));

        tableroPanel.setBackground(new java.awt.Color(0, 153, 51));
        tableroPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableroPanel.setLayout(null);
        jPanel1.add(tableroPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 720, 380));

        lblBackground.setText("jLabel2");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnEndMatch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAvatar1;
    private javax.swing.JLabel lblAvatar2;
    private javax.swing.JLabel lblAvatar3;
    private javax.swing.JLabel lblAvatar4;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblPlayer1;
    private javax.swing.JLabel lblPlayer2;
    private javax.swing.JLabel lblPlayer3;
    private javax.swing.JLabel lblPlayer4;
    private javax.swing.JPanel pnlLeftTiles;
    private javax.swing.JPanel pnlPlayer1;
    private javax.swing.JPanel pnlPlayer2;
    private javax.swing.JPanel pnlPlayer3;
    private javax.swing.JPanel pnlPlayer4;
    private javax.swing.JPanel tableroPanel;
    // End of variables declaration//GEN-END:variables
}
