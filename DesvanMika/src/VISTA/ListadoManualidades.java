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
 * Esta clase lo que hace es abrir una ventana ventana e imprime una lista de
 * manualidades.
 *
 * @author Josete
 */
public class ListadoManualidades extends javax.swing.JFrame {

    /**
     * Este metodo saca por pantalla un listado de todas las manualidades
     */
    private void buscaManu() {
        String consulta;
        String respuesta[] = new String[3];
        consulta = "SELECT codManualidad, nombre, observaciones FROM Manualidad ORDER BY nombre";

        DefaultTableModel modeloMan = new DefaultTableModel();
        modeloMan.addColumn("Nº manualidad");
        modeloMan.addColumn("nombre");
        modeloMan.addColumn("observaciones");

        tablaManu.setModel(modeloMan);
        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery(consulta);
            while (resultado.next()) {
                respuesta[0] = resultado.getString(1);
                respuesta[1] = resultado.getString(2);
                respuesta[2] = resultado.getString(3);

                modeloMan.addRow(respuesta);
            } //Fin del while
            st.close();
            tablaManu.setModel(modeloMan);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesForm.class.getName()).log(Level.SEVERE, null, ex);
        } // fin del try-catch

    } // fin del modelo

    /**
     * Crea una ventana, le cambia el nombre y saca la tabla
     */
    public ListadoManualidades() {
        initComponents();
        this.setTitle("Listado de Manualidades");
        buscaManu();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaManu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tablaManu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaManu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaManu;
    // End of variables declaration//GEN-END:variables
}
