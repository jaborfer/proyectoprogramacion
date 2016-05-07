/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import static Principal.DesvanMika.cn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase abre una JInternalFrame y muestra una lista de colores
 * @author Josete
 */
public class ListaColores extends javax.swing.JInternalFrame {

    private void buscaColor() {
        String consulta;
        String respuesta[] = new String[3];
        consulta = "SELECT * FROM COLOR ORDER BY colorprincipal, subcolor";

        DefaultTableModel modeloCli = new DefaultTableModel();
        modeloCli.addColumn("Nº Color");
        modeloCli.addColumn("Color");
        modeloCli.addColumn("Subcolor");

        tablacolor.setModel(modeloCli);
        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery(consulta);
            while (resultado.next()) {
                respuesta[0] = resultado.getString(1);
                respuesta[1] = resultado.getString(2);
                respuesta[2] = resultado.getString(3);

                modeloCli.addRow(respuesta);
            } //Fin del while
            st.close();
            tablacolor.setModel(modeloCli);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesForm.class.getName()).log(Level.SEVERE, null, ex);
        } // fin del try-catch

    } 

    /**
     * Crea la ventana y saca una lista de tpdos los colores
     */
    public ListaColores() {
        initComponents();
        buscaColor();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablacolor = new javax.swing.JTable();

        setClosable(true);
        setDesktopIcon(getDesktopIcon());
        setOpaque(true);

        tablacolor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablacolor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablacolor;
    // End of variables declaration//GEN-END:variables
}
