/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import java.awt.Image;
import java.awt.Toolkit;
import Clases.proveedor;
import static Principal.DesvanMika.cn;
import com.mysql.jdbc.Statement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josete
 */
public class Listados extends javax.swing.JFrame {

    private proveedor pro = null;
    private ArrayList<proveedor> listapro = null;

    /**
     * Creates new form Listados
     */
    public Listados() {
        initComponents();
        setTitle("Listados");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.jpg"));
        setIconImage(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Listado de Proveedores");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jButton2)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listapro = new ArrayList();
        File f = new File(".\\listados\\temporal.txt");
        FileWriter fw = null;
        try {
            java.sql.Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("Select * from proveedor");
            while (rs.next()) {
                String nombre = rs.getString(1);
                String direccion = rs.getString(2);
                int tel = rs.getInt(3);
                String contacto = rs.getString(4);
                pro = new proveedor(nombre, direccion, tel, contacto);
                listapro.add(pro);
            } //Fin del while

        } catch (SQLException ex) {
            Logger.getLogger(Listados.class.getName()).log(Level.SEVERE, null, ex);
        } //Fin del try
        //hasta aqui he creado la lista de proveedores, ahora la voy a guardar en un archivo

        try {

            fw = new FileWriter(f);
            cabeceraListadoProveedores(fw);
            for (proveedor p : listapro) { //
                fw.write(p.formato());
            }

        } catch (IOException ex) {
            Logger.getLogger(Listados.class.getName()).log(Level.SEVERE, null, ex);
        } //Fin del try
        if (fw != null) {
            try {
                fw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Listados.class.getName()).log(Level.SEVERE, null, ex);
            } //fin del try
        } //fin del if
 try {
            Runtime obj = Runtime.getRuntime();
           
            obj.exec("notepad "+f.getAbsolutePath());
            
        } catch (IOException ex) {
             System.out.println("IOException "+ex.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void cabeceraListadoProveedores(FileWriter fw) throws IOException {
        String lineaPro;
        StringBuilder linea = new StringBuilder("");
        linea.append(String.format("%1$-25s", "NOMBRE")).append("\t");
        linea.append(String.format("%1$-30s", "DIRECCION")).append("\t");
        linea.append(String.format("%1$-10s", "TELEFONO")).append("\t");
        linea.append(String.format("%1$-20s", "CONTACTO")).append("\r\n");
        lineaPro = new String(linea);
        fw.write(lineaPro);
        fw.write("-------------------------------------------------------------------------------------------\r\n");
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
