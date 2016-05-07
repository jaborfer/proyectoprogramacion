/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import static Principal.DesvanMika.cn;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Josete
 * @version 1.0 BETA
 */
public class CompraMaterial extends javax.swing.JFrame {

    /**
     * Esta varuale de clase es la que utilizamos como auxiliar para abrir y
     * cerrar las ventanas auxiliares
     */
    private JFrame aux; //esta variable apuntará a la ventana auxiliar abierta para poder cerrarla

    /**
     * Crea la ventana y le cambia el nombre y el icono
     */
    public CompraMaterial() {
        setTitle("Compras - Desvan de Mika");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.jpg"));
        setIconImage(icon);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codMat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tipoMat = new javax.swing.JComboBox<>();
        BotonCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Cod Material");

        jLabel2.setText("Cantidad comprada");

        jLabel3.setText("Precio Total");

        precio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                precioFocusLost(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tipoMat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "ABALORIO", "ARCILLA_POLIMERICA", "FIELTRO", "UTILERIA", "TELA" }));
        tipoMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoMatActionPerformed(evt);
            }
        });

        BotonCerrar.setText("CERRAR");
        BotonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(55, 55, 55)
                                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                    .addComponent(codMat)))
                            .addComponent(tipoMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(BotonCerrar)))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(tipoMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(BotonCerrar)
                .addContainerGap(35, Short.MAX_VALUE))
        );

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
     * Este método lo que hace es que al cambiar la seleccion del jcomboBox abre
     * la ventana correspondiente a la clase de material seleccionado aqui
     * tenemos un ejemplo de polimorfismo.
     */
    private void tipoMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoMatActionPerformed

        if (aux != null) {
            aux.dispose();
        } // lo primero es cerrar si había una ventana abierta
        switch (tipoMat.getSelectedIndex()) {

            case 1:
                aux = new ListadoAbalorios(); //(ejemplo de polimorfismo)
                break;

            case 2:
                aux = new ListadoArcilla();
                break;

            case 3:
                aux = new ListadoFieltro();
                break;

            case 4:
                aux = new ListadoUtileria();
                break;

            case 5:
                aux = new ListadoTelas();
                break;

        } //fin del switch
        aux.setEnabled(true);
        aux.setVisible(true);
    }//GEN-LAST:event_tipoMatActionPerformed

    /**
     * El boton cerrar, cierra primero si hay alguna ventana auxiliar y luego la
     * venta materiales
     *
     */
    private void BotonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarActionPerformed
        if (aux != null) {
            aux.dispose();
        }
        dispose();
    }//GEN-LAST:event_BotonCerrarActionPerformed
    /**
     * Cuando el campo pierde el foco, automaticamente cambia las , por . para
     * que sea compatible con la base de datos ejemplo de listener
     */
    private void precioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precioFocusLost
        precio.setText(precio.getText().replace(',', '.'));
    }//GEN-LAST:event_precioFocusLost

    /**
     * Este método lo que hace es coger los datos, calcular el precio por unidad
     * comprobar que como minimo es de 1 centimo y luego actualiza aux base de
     * datos sumando aux cantidad y recalculando el nuevo precio por unidad. he
     * usado tantas variables por claridad, por no meter un select de 4 lineas
     */

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double precioUnidad;
        int cantidadComprada;
        double precioGuardado;
        int cantidadExistencias;
        int cantidadTotal;
        double nuevoPrecio;
        String orden;
        if (codMat.getText().equals("") || cantidad.getText().equals("") || precio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Introduzca todos los datos");
        } else {
            cantidadComprada = Integer.parseInt(cantidad.getText());
            precioUnidad = Double.parseDouble(precio.getText()) / cantidadComprada;
            if (precioUnidad < 0.01) {
                precioUnidad = 0.01;
            }//fin del if interior
            orden = "Select preciocoste, cantidad from material where codmaterial=" + codMat.getText();
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(orden);
                rs.next();
                precioGuardado = rs.getDouble(1);
                cantidadExistencias = rs.getInt(2);
                cantidadTotal = cantidadExistencias + cantidadComprada;
                nuevoPrecio = (cantidadComprada * precioUnidad + cantidadExistencias * precioGuardado) / cantidadTotal;
                if (nuevoPrecio < 0.01) {
                    nuevoPrecio = 0.01;
                }//fin del otro if interno
                // Hasta aqui hemos leido y calculado los nuevos datos, ahora falta guardarlo.
                PreparedStatement pst = cn.prepareStatement("update material set preciocoste=?, cantidad=? where codmaterial=" + codMat.getText());
                pst.setDouble(1, nuevoPrecio);
                pst.setInt(2, cantidadTotal);
                pst.executeUpdate();
                st.close();
                pst.close();
                JOptionPane.showMessageDialog(null, "Compra correcta");
                cantidad.setText("");
                precio.setText("");
                codMat.setText("");
                tipoMat.setSelectedIndex(0);
                aux.dispose();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer, compruebe que el material existe");
                Logger.getLogger(CompraMaterial.class.getName()).log(Level.SEVERE, null, ex);
            } //fin del try-catch //fin del try-catch

        } // fin del if exterior
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCerrar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField codMat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField precio;
    private javax.swing.JComboBox<String> tipoMat;
    // End of variables declaration//GEN-END:variables
}
