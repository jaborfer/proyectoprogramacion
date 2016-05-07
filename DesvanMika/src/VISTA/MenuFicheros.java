
package VISTA;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *Esta clase es un menu ficheros
 * @author Josete
 */
public class MenuFicheros extends javax.swing.JFrame {

    /**
     * Crea el menu de los ficheros, le cambia el nombre y el icono
     */
    public MenuFicheros() {
        setTitle("Principal-Desvan de Mika");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.jpg"));
        setIconImage(icon);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botonPro = new javax.swing.JButton();
        botonCli = new javax.swing.JButton();
        botonColores = new javax.swing.JButton();
        botonManualidad = new javax.swing.JButton();
        botonComponentes = new javax.swing.JButton();
        botonMateriales = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Elija una de las siguientes opciones");

        botonPro.setText("Proveedores");
        botonPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProActionPerformed(evt);
            }
        });

        botonCli.setText("Clientes");
        botonCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCliActionPerformed(evt);
            }
        });

        botonColores.setText("Colores");
        botonColores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColoresActionPerformed(evt);
            }
        });

        botonManualidad.setText("Manualidades");
        botonManualidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonManualidadActionPerformed(evt);
            }
        });

        botonComponentes.setText("Componentes");
        botonComponentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComponentesActionPerformed(evt);
            }
        });

        botonMateriales.setText("Materiales");
        botonMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMaterialesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonMateriales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonComponentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonManualidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonColores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botonCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonPro, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCli, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonColores, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonMateriales, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonManualidad, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        botonSalir.setText("Menú principal");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/** 
 * El boton proveedores cierra la ventana menu y abre ese formulario
 *  
 */
    private void botonProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProActionPerformed
        ProveedoresForm proForm = new ProveedoresForm();
        proForm.setLocationRelativeTo(null);
        proForm.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonProActionPerformed
/** 
 * Ciera la ventana para volver al principal 
 *
 */
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed
/** 
 * El boton clientes cierra la ventana menu y abre ese formulario
 *  
 */
    private void botonCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCliActionPerformed
        ClientesForm cliForm = new ClientesForm();
        cliForm.setLocationRelativeTo(null);
        cliForm.setVisible(true);
        dispose();        
    }//GEN-LAST:event_botonCliActionPerformed
/** 
 * El boton colores cierra la ventana menu y abre ese formulario
 *  
 */
    private void botonColoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColoresActionPerformed
        ColoresForm colform = new ColoresForm();
        colform.setLocationRelativeTo(null);
        colform.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonColoresActionPerformed
/** 
 * El boton manualidades cierra la ventana menu y abre ese formulario
 *  
 */
    private void botonManualidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonManualidadActionPerformed
        ManualidadForm mf = new ManualidadForm();
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonManualidadActionPerformed
/** 
 * El boton componenters cierra la ventana menu y abre ese formulario
 *  
 */
    private void botonComponentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComponentesActionPerformed
        ComponenteForm cf = new ComponenteForm();
        cf.setLocationRelativeTo(null);
        cf.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_botonComponentesActionPerformed
/** 
 * El boton materiales cierra la ventana menu y abre ese formulario
 *  
 */
    private void botonMaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMaterialesActionPerformed
        MaterialForm mf = new MaterialForm();
        mf.setLocationRelativeTo(null);
        mf.setResizable(false);
        mf.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonMaterialesActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCli;
    private javax.swing.JButton botonColores;
    private javax.swing.JButton botonComponentes;
    private javax.swing.JButton botonManualidad;
    private javax.swing.JButton botonMateriales;
    private javax.swing.JButton botonPro;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
