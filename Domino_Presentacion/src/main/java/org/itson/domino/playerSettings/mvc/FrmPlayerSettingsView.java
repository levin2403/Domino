package org.itson.domino.playerSettings.mvc;

import org.itson.domino.matchSettings.mvc.*;
import org.itson.domino.welcome.mvc.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import org.itson.domino.managers.ButtonManager;
import org.itson.domino.singleton.FontSingleton;

public class FrmPlayerSettingsView extends javax.swing.JFrame {

    public FrmPlayerSettingsView() {
        initComponents();
        applyCustomFonts();
        setLocationRelativeTo(null);
        
        ButtonManager buttonManager = ButtonManager.getInstance();
        buttonManager.addCloseButton(btnClose, this);
        buttonManager.addMinimizeButton(btnMinimize, this);
        
    }
    /**
     * Creates new form FrmBienvenida
     */

    public void addNextFormButtonListener(ActionListener listener) {
        btnNextForm.addActionListener(listener);
    }

    public void addCloseButtonListener(ActionListener listener) {
        btnClose.addActionListener(listener);
    }

    public void addMinimizeButtonListener(ActionListener listener) {
        btnMinimize.addActionListener(listener);
    }

    // Métodos para la lógica de minimización y cierre
    public void minimize() {
        setState(JFrame.ICONIFIED);
    }

    public void close() {
        System.exit(0);
    }


    
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
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDomino.setText("Domino - Vice City Edition");
        jPanel1.add(lblDomino, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        btnNextForm.setText("iniciar");
        jPanel1.add(btnNextForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, -1, -1));

        btnClose.setText("cerrar");
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 30, -1, -1));

        btnMinimize.setText("minimizar");
        jPanel1.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, -1, -1));

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
        btnNextForm.setFont(customFont.getFontSize26());
        btnClose.setFont(customFont.getFontSize26());
    }

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnNextForm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDomino;
    // End of variables declaration//GEN-END:variables
}
