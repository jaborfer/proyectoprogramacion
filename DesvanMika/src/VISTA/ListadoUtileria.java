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
 * materiales que se usan para hacer las manualidades.
 *
 * @author Josete
 */
public class ListadoUtileria extends javax.swing.JFrame {

    private void buscaUtileria() {
        String consulta;
        String respuesta[] = new String[4];
        consulta = "SELECT material.codMAterial, color.Colorprincipal, utileria.clase, material.cantidad   \n"
                + "FROM utileria , material, color\n"
                + "where utileria.MATERIAL_codMaterial=material.codMaterial and material.COLOR_idCOLOR=color.idCOLOR";

        DefaultTableModel modeloUtileria = new DefaultTableModel();
        modeloUtileria.addColumn("Nº Articulo");
        modeloUtileria.addColumn("Color");
        modeloUtileria.addColumn("Clase");
        modeloUtileria.addColumn("Cantidad");

        tablaUtileria.setModel(modeloUtileria);
        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery(consulta);
            while (resultado.next()) {
                respuesta[0] = resultado.getString(1);
                respuesta[1] = resultado.getString(2);
                respuesta[2] = resultado.getString(3);
                respuesta[3] = resultado.getString(4);

                modeloUtileria.addRow(respuesta);
            } //Fin del while
            st.close();

            tablaUtileria.setModel(modeloUtileria);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesForm.class.getName()).log(Level.SEVERE, null, ex);
        }// fin del try-catch

    } // fin del metodo

    /**
     * Crea una ventana le cambia el nombre e inicia la tabla
     */
    public ListadoUtileria() {
        initComponents();
        this.setTitle("Listado de Fieltro");
        buscaUtileria();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUtileria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tablaUtileria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaUtileria);

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
    private javax.swing.JTable tablaUtileria;
    // End of variables declaration//GEN-END:variables
}
