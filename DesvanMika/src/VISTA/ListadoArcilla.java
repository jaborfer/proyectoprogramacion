
package VISTA;

import static Principal.DesvanMika.cn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase lo que hace es abrir una ventana ventana e imprime una lista 
 * de arcillas.
 * @author Josete
 */
public class ListadoArcilla extends javax.swing.JFrame {

    private void buscaArcilla() {
        String consulta;
        String respuesta[] = new String[4];
        consulta = "SELECT material.codMAterial, color.Colorprincipal, arcilla_polimerica.Cocida, material.cantidad   \n"
                + "FROM arcilla_polimerica , material, color\n"
                + "where arcilla_polimerica.MATERIAL_codMaterial=material.codMaterial and material.COLOR_idCOLOR=color.idCOLOR";

        DefaultTableModel modeloTela = new DefaultTableModel();
        modeloTela.addColumn("Nº Arcilla");
        modeloTela.addColumn("Color");
        modeloTela.addColumn("¿Para cocer?");
        modeloTela.addColumn("Cantidad");

        tablaArcilla.setModel(modeloTela);
        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery(consulta);
            while (resultado.next()) {
                respuesta[0] = resultado.getString(1);
                respuesta[1] = resultado.getString(2);
                respuesta[2] = resultado.getString(3);
                respuesta[3] = resultado.getString(4);
                if (respuesta[3] == "1") {
                    respuesta[3] = "Si";
                } else {
                    respuesta[3] = "No";
                } //fin del if
                modeloTela.addRow(respuesta);
            } //Fin del while
            st.close();

            tablaArcilla.setModel(modeloTela);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesForm.class.getName()).log(Level.SEVERE, null, ex);
        } //fin del try -catch

    } // fin del metodo

    /**
     * Crea una ventana tipo listadoArcilla y le cambia el nombre a la ventana
     */
    public ListadoArcilla() {
        initComponents();
        this.setTitle("Listado de Arcillas");
        buscaArcilla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaArcilla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tablaArcilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaArcilla);

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
    private javax.swing.JTable tablaArcilla;
    // End of variables declaration//GEN-END:variables
}
