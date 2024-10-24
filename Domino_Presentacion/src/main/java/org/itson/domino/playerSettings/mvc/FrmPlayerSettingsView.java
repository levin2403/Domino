package org.itson.domino.playerSettings.mvc;

import Observable.ObservableRegistrarJugador;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import org.itson.domino.constants.IconPaths;
import org.itson.domino.managers.AvatarManager;
import org.itson.domino.managers.ResourceLoader;
import org.itson.domino.singleton.ButtonStyleSingleton;
import org.itson.domino.singleton.TaskbarButtonSingleton;
import org.itson.domino.singleton.FontSingleton;
import org.itson.domino.singleton.LookAndFeelSingleton;
import Observer.Vista.ObserverFrmPlayerSettingsView;

public class FrmPlayerSettingsView extends javax.swing.JFrame implements ObserverFrmPlayerSettingsView{

    private final AvatarManager avatarManager;
    private ObservableRegistrarJugador observable;

    public FrmPlayerSettingsView() {
        //ESTABLECER LIBRERÍA DE GUI'S
        LookAndFeelSingleton.getInstance();
        
        initComponents();
        
        this.avatarManager = new AvatarManager();

        updateAvatarDisplay(avatarManager.getCurrentAvatarPath());
        
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
        style.applyButtonStyle(btnPrevAvatar);
        style.applyButtonStyle(btnNextAvatar);
    }
    
    private void applyIconsAndBackground() {
        try {
            // Aplicar íconos
            btnClose.setIcon(ResourceLoader.loadIcon(IconPaths.CLOSE_ICON, 24, 24));
            btnMinimize.setIcon(ResourceLoader.loadIcon(IconPaths.MINIMIZE_ICON, 24, 24));
            btnPrevAvatar.setIcon(ResourceLoader.loadIcon(IconPaths.PREV_ICON, 24, 24));
            btnNextAvatar.setIcon(ResourceLoader.loadIcon(IconPaths.NEXT_ICON, 24, 24));

            // Aplicar fondo
            lblBackground.setIcon(ResourceLoader.loadBackground(IconPaths.COMMON_BG, 1200, 700));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAvatarDisplay(String avatarPath) {
        try {
            URL imageUrl = getClass().getClassLoader().getResource(avatarPath);
            if (imageUrl != null) {
                ImageIcon avatarIcon = new ImageIcon(imageUrl);
                Image image = avatarIcon.getImage().getScaledInstance(
                        lblAvatarDisplay.getWidth(), lblAvatarDisplay.getHeight(), Image.SCALE_SMOOTH);
                lblAvatarDisplay.setIcon(new ImageIcon(image));
            } else {
                System.err.println("Error: No se pudo encontrar la imagen en la ruta: " + avatarPath);
            }
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

    
    public void addNextFormButtonListener(ActionListener listener) {
        btnNextForm.addActionListener(listener);
    }
    
    public void addPrevFormButtonListener(ActionListener listener){
        btnPrevForm.addActionListener(listener);
    }

    public void addNextAvatarListener(ActionListener listener) {
        btnNextAvatar.addActionListener(listener);
    }

    public void addPrevAvatarListener(ActionListener listener) {
        btnPrevAvatar.addActionListener(listener);
    }
    
    public String getPlayerName() {
        return txtName.getText();
    }

    private void applyCustomFonts() {
        FontSingleton customFont = FontSingleton.getInstance();
        applyFontToComponents(customFont, "Evil Empire", 80f, lblDomino);
        applyFontToComponents(customFont, "Evil Empire", 30f, 
                lblAvatar, lblPlayerName, btnNextForm, btnPrevForm);
        applyFontToComponents(customFont, "Montserrat", 30f, txtName);
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
        lblAvatar = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnNextForm = new javax.swing.JButton();
        btnPrevForm = new javax.swing.JButton();
        pnlPlayerAvatar = new javax.swing.JPanel();
        btnNextAvatar = new javax.swing.JButton();
        btnPrevAvatar = new javax.swing.JButton();
        lblAvatarDisplay = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDomino.setFont(new java.awt.Font("Roboto", 0, 80)); // NOI18N
        lblDomino.setText("Configuración del jugador");
        jPanel1.add(lblDomino, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lblPlayerName.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayerName.setText("Nickname del jugador:");
        jPanel1.add(lblPlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        lblAvatar.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblAvatar.setText("Elige un avatar:");
        jPanel1.add(lblAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        txtName.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        txtName.setToolTipText("");
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 420, 50));

        btnNextForm.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnNextForm.setText("Continuar");
        jPanel1.add(btnNextForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(1021, 624, 160, 60));

        btnPrevForm.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnPrevForm.setText("Regresar");
        jPanel1.add(btnPrevForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 160, 60));

        pnlPlayerAvatar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlPlayerAvatar.add(btnNextAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 60, 290));
        pnlPlayerAvatar.add(btnPrevAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 290));
        pnlPlayerAvatar.add(lblAvatarDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 300, 290));

        jPanel1.add(pnlPlayerAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, 290));

        btnClose.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, 50, 50));

        btnMinimize.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });
        jPanel1.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, 50, 50));

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

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMinimizeActionPerformed

    /**
     * @param args the command line arguments
     */
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnNextAvatar;
    private javax.swing.JButton btnNextForm;
    private javax.swing.JButton btnPrevAvatar;
    private javax.swing.JButton btnPrevForm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblAvatarDisplay;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDomino;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JPanel pnlPlayerAvatar;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizarVista(ObservableRegistrarJugador observable) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
