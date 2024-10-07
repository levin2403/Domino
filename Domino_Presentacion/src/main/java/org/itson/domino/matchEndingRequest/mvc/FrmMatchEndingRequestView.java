package org.itson.domino.matchEndingRequest.mvc;

import java.awt.event.ActionListener;
import javax.swing.JComponent;
import org.itson.domino.constants.IconPaths;
import org.itson.domino.managers.ResourceLoader;
import org.itson.domino.singleton.ButtonStyleSingleton;
import org.itson.domino.singleton.FontSingleton;
import org.itson.domino.singleton.LookAndFeelSingleton;

public class FrmMatchEndingRequestView extends javax.swing.JFrame {

    public FrmMatchEndingRequestView() {
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
    }
    
    public void addNextFormButtonListener(ActionListener listener) {
        btnEndMatch.addActionListener(listener);
    }
    
    public void addPrevFormButtonListener(ActionListener listener) {
        btnContinueMatch.addActionListener(listener);
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
        applyFontToComponents(customFont, "Evil Empire", 80f, lblDomino);
        applyFontToComponents(customFont, "Evil Empire", 30f, 
                btnEndMatch, btnContinueMatch, 
                lblPlayer, lblQuestion, lblHas, lblPlayerName, lblProposed);
    }

    private void applyFontToComponents(FontSingleton fontSingleton, String fontName, float size, JComponent... components) {
        for (JComponent component : components) {
            component.setFont(fontSingleton.getFont(fontName, size));
        }
    }
    
    private void applyButtonStyles() {
        ButtonStyleSingleton style = ButtonStyleSingleton.getInstance();

        style.applyButtonStyle(btnEndMatch);
        style.applyButtonStyle(btnContinueMatch);
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
        lblDomino = new javax.swing.JLabel();
        btnEndMatch = new javax.swing.JButton();
        btnContinueMatch = new javax.swing.JButton();
        lblProposed = new javax.swing.JLabel();
        lblPlayer = new javax.swing.JLabel();
        lblPlayerName = new javax.swing.JLabel();
        lblHas = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDomino.setFont(new java.awt.Font("Roboto", 0, 80)); // NOI18N
        lblDomino.setText("Espera.");
        jPanel1.add(lblDomino, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, 100));

        btnEndMatch.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnEndMatch.setText("Sí. Deseo terminar la partida");
        jPanel1.add(btnEndMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 400, -1));

        btnContinueMatch.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnContinueMatch.setText("No. Deseo continuar la partida");
        jPanel1.add(btnContinueMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 400, -1));

        lblProposed.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblProposed.setText("propuesto terminar la partida en este punto.");
        jPanel1.add(lblProposed, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        lblPlayer.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayer.setText("El jugador ");
        jPanel1.add(lblPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        lblPlayerName.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayerName.setText("xxxxxxxxxxxxxxxxxxx");
        jPanel1.add(lblPlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        lblHas.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblHas.setText("ha");
        jPanel1.add(lblHas, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, -1, -1));

        lblQuestion.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblQuestion.setText("¿Deseas terminar la partida?");
        jPanel1.add(lblQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, -1));
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
    private javax.swing.JButton btnContinueMatch;
    private javax.swing.JButton btnEndMatch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDomino;
    private javax.swing.JLabel lblHas;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblProposed;
    private javax.swing.JLabel lblQuestion;
    // End of variables declaration//GEN-END:variables
}
