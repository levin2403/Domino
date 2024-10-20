package org.itson.domino.lobby.mvc;

import java.awt.event.ActionListener;
import javax.swing.JComponent;
import org.itson.domino.constants.IconPaths;
import org.itson.domino.managers.ResourceLoader;
import org.itson.domino.singleton.ButtonStyleSingleton;
import org.itson.domino.singleton.TaskbarButtonSingleton;
import org.itson.domino.singleton.FontSingleton;
import org.itson.domino.singleton.LookAndFeelSingleton;

public class FrmLobbyView extends javax.swing.JFrame {

    private FrmLobbyView model;
    
    public FrmLobbyView(FrmLobbyView model) {
        //establecemos el modelo dentro de la clase
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
        
        //FUNCIONES DE LOS BOTONES DE LA BARRA DE TAREAS
        TaskbarButtonSingleton taskbarButtonSIngleton = TaskbarButtonSingleton.getInstance();
        taskbarButtonSIngleton.addCloseButton(btnClose, this);
        taskbarButtonSIngleton.addMinimizeButton(btnMinimize, this);
    }
    /**
     * Creates new form FrmBienvenida
     */

    private void applyButtonStyles() {
        ButtonStyleSingleton style = ButtonStyleSingleton.getInstance();

        style.applyButtonStyle(btnNextForm);
        style.applyButtonStyle(btnPrevForm);
        style.applyButtonStyle(btnClose);
        style.applyButtonStyle(btnMinimize);
    }
    
    public void addNextFormButtonListener(ActionListener listener) {
        btnNextForm.addActionListener(listener);
    }
    
    public void addPrevFormButtonListener(ActionListener listener){
        btnPrevForm.addActionListener(listener);
    }
    
    private void applyIconsAndBackground() {
        try {
            // Aplicar íconos
            btnClose.setIcon(ResourceLoader.loadIcon(IconPaths.CLOSE_ICON, 24, 24));
            btnMinimize.setIcon(ResourceLoader.loadIcon(IconPaths.MINIMIZE_ICON, 24, 24));

            // Aplicar fondo
            lblBackground.setIcon(ResourceLoader.loadBackground(IconPaths.COMMON_BG, 1200, 700));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void applyCustomFonts() {
        FontSingleton customFont = FontSingleton.getInstance();
        applyFontToComponents(customFont, "Evil Empire", 80f, lblDomino);
        applyFontToComponents(customFont, "Evil Empire", 30f, lblPlayerName, btnNextForm, btnPrevForm);
    }

    private void applyFontToComponents(FontSingleton fontSingleton, String fontName, float size, JComponent... components) {
        for (JComponent component : components) {
            component.setFont(fontSingleton.getFont(fontName, size));
        }
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
        lblPlayerName = new javax.swing.JLabel();
        btnNextForm = new javax.swing.JButton();
        btnPrevForm = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDomino.setFont(new java.awt.Font("Roboto", 0, 80)); // NOI18N
        lblDomino.setText("Esperando al resto de jugadores");
        jPanel1.add(lblDomino, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        lblPlayerName.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayerName.setText("Disfruta la música que escuchas en esta sala de espera");
        jPanel1.add(lblPlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, -1, -1));

        btnNextForm.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnNextForm.setText("Comenzar la partida");
        btnNextForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextFormActionPerformed(evt);
            }
        });
        jPanel1.add(btnNextForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(861, 624, 320, 60));

        btnPrevForm.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnPrevForm.setText("Regresar");
        jPanel1.add(btnPrevForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 160, 60));

        btnClose.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, 50, 50));

        btnMinimize.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });
        jPanel1.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, 50, 50));
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

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void btnNextFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextFormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextFormActionPerformed

    /**
     * @param args the command line arguments
     */
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnNextForm;
    private javax.swing.JButton btnPrevForm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDomino;
    private javax.swing.JLabel lblPlayerName;
    // End of variables declaration//GEN-END:variables
}
