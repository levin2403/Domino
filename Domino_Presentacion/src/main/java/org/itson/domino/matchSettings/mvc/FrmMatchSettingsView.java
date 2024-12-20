package org.itson.domino.matchSettings.mvc;

import DTOs.Acciones;
import Observer.Vista.ObserverFrmSettingsView;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import org.itson.domino.constants.IconPaths;
import org.itson.domino.managers.ResourceLoader;
import org.itson.domino.singleton.ButtonStyleSingleton;
import org.itson.domino.singleton.TaskbarButtonSingleton;
import org.itson.domino.singleton.FontSingleton;
import org.itson.domino.singleton.LookAndFeelSingleton;

public class FrmMatchSettingsView extends javax.swing.JFrame implements ObserverFrmSettingsView {

    private FrmMatchSettingsModel model;
    
    public FrmMatchSettingsView(FrmMatchSettingsModel model) {
        //instancia del modelo
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
    
    public void addNextFormButtonListener(ActionListener listener) {
        btnNextForm.addActionListener(listener);
    }
    
    public void addPrevFormButtonListener(ActionListener listener){
        btnPrevForm.addActionListener(listener);
    }
    
    public void addPlayersComboBoxListener(ActionListener listener){
        cmbPlayers.addActionListener(listener);
    }

    public void addTilesComboBoxListener(ActionListener listener){
        cmbTiles.addActionListener(listener);
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
        applyFontToComponents(customFont, "Evil Empire", 30f, lblPlayers, lblFichas, btnNextForm, btnPrevForm, cmbTiles, cmbPlayers);
    }

    private void applyFontToComponents(FontSingleton fontSingleton, String fontName, float size, JComponent... components) {
        for (JComponent component : components) {
            component.setFont(fontSingleton.getFont(fontName, size));
        }
    }
    
    private void applyButtonStyles() {
        ButtonStyleSingleton style = ButtonStyleSingleton.getInstance();

        style.applyButtonStyle(btnNextForm);
        style.applyButtonStyle(btnPrevForm);
        style.applyButtonStyle(btnClose);
        style.applyButtonStyle(btnMinimize);
    }
    
    public int getSelectedPlayers() {
        String selectedValue = (String) cmbPlayers.getSelectedItem();
        return selectedValue != null ? Integer.parseInt(selectedValue) : 2; // valor por defecto
    }

    public int getSelectedTiles() {
        String selectedValue = (String) cmbTiles.getSelectedItem();
        return selectedValue != null ? Integer.parseInt(selectedValue) : 3; // valor por defecto
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
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
        btnPrevForm = new javax.swing.JButton();
        btnNextForm = new javax.swing.JButton();
        lblFichas = new javax.swing.JLabel();
        lblPlayers = new javax.swing.JLabel();
        cmbPlayers = new javax.swing.JComboBox<>();
        cmbTiles = new javax.swing.JComboBox<>();
        btnClose = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDomino.setFont(new java.awt.Font("Roboto", 0, 80)); // NOI18N
        lblDomino.setText("Configuración de la partida");
        jPanel1.add(lblDomino, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 100));

        btnPrevForm.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnPrevForm.setText("Regresar");
        jPanel1.add(btnPrevForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 160, 60));

        btnNextForm.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnNextForm.setText("Continuar");
        jPanel1.add(btnNextForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(1021, 624, 160, 60));

        lblFichas.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblFichas.setText("Cantidad de fichas a entregar:");
        jPanel1.add(lblFichas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        lblPlayers.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        lblPlayers.setText("Cantidad de jugadores:");
        jPanel1.add(lblPlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        cmbPlayers.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        cmbPlayers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4" }));
        jPanel1.add(cmbPlayers, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 320, 50));

        cmbTiles.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        cmbTiles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7" }));
        jPanel1.add(cmbTiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 320, 50));

        btnClose.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, 50, 50));

        btnMinimize.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnNextForm;
    private javax.swing.JButton btnPrevForm;
    private javax.swing.JComboBox<String> cmbPlayers;
    private javax.swing.JComboBox<String> cmbTiles;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDomino;
    private javax.swing.JLabel lblFichas;
    private javax.swing.JLabel lblPlayers;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizarVista(Object object) {
      if(object instanceof Acciones){
           if (object instanceof Acciones) {
                Acciones accion = (Acciones) object;
                
                if (accion== accion.CERRARVENTANA) {
                    this.dispose();
                }
            }
      }
    }
}
