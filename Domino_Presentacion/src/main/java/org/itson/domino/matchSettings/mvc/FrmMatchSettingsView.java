package org.itson.domino.matchSettings.mvc;

import java.awt.event.ActionListener;
import org.itson.domino.managers.ButtonManager;
import org.itson.domino.singleton.FontSingleton;

public class FrmMatchSettingsView extends javax.swing.JFrame {

    public FrmMatchSettingsView() {
        initComponents();
        applyCustomFonts();
        setLocationRelativeTo(null);
        
        ButtonManager buttonManager = ButtonManager.getInstance();
        buttonManager.addCloseButton(btnClose, this);
        buttonManager.addMinimizeButton(btnMinimize, this);
    }
    
    public void addNextFormButtonListener(ActionListener listener) {
        btnNextForm.addActionListener(listener);
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
        btnNextForm = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        lblFichas = new javax.swing.JLabel();
        lblPlayers = new javax.swing.JLabel();
        cmbPlayers = new javax.swing.JComboBox<>();
        cmbFichas = new javax.swing.JComboBox<>();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDomino.setFont(new java.awt.Font("Roboto", 0, 80)); // NOI18N
        lblDomino.setText("Configuración de la partida");
        jPanel1.add(lblDomino, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 100));

        btnNextForm.setText("Continuar");
        jPanel1.add(btnNextForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, -1, -1));

        btnClose.setText("cerrar");
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 30, -1, -1));

        btnMinimize.setText("minimizar");
        jPanel1.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, -1, -1));

        lblFichas.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblFichas.setText("Cantidad de fichas a entregar:");
        jPanel1.add(lblFichas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        lblPlayers.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayers.setText("Cantidad de jugadores:");
        jPanel1.add(lblPlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        cmbPlayers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbPlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 320, 50));

        cmbFichas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbFichas, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 320, 50));

        lblBackground.setIcon(new javax.swing.ImageIcon("/home/gamaliel/Documentos/Domino/Domino_Presentacion/resources/synthwaveBackground.jpg")); // NOI18N
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

    /**
     * @param args the command line arguments
     */
    
    private void applyCustomFonts() {
        FontSingleton customFont = FontSingleton.getInstance();
        lblDomino.setFont(customFont.getFontSize80());
        btnNextForm.setFont(customFont.getFontSize20());
        btnClose.setFont(customFont.getFontSize20());
        btnMinimize.setFont(customFont.getFontSize20());
        lblPlayers.setFont(customFont.getFontSize30());
        lblFichas.setFont(customFont.getFontSize30());
        cmbFichas.setFont(customFont.getFontSize30());
        cmbPlayers.setFont(customFont.getFontSize30());
    }

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnNextForm;
    private javax.swing.JComboBox<String> cmbFichas;
    private javax.swing.JComboBox<String> cmbPlayers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDomino;
    private javax.swing.JLabel lblFichas;
    private javax.swing.JLabel lblPlayers;
    // End of variables declaration//GEN-END:variables
}
