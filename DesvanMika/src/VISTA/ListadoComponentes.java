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
 * componentes.
 *
 * @author Josete
 */
public class ListadoComponentes extends javax.swing.JFrame {

    private void buscaCompo() {
        String consulta;
        String respuesta[] = new String[3];
        consulta = "SELECT * from componente order by nombre";

        DefaultTableModel modeloCompo = new DefaultTableModel();
        modeloCompo.addColumn("Nº componente");
        modeloCompo.addColumn("Nombre");
        modeloCompo.addColumn("Precio");

        listadoComponentes.setModel(modeloCompo);
        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery(consulta);
            while (resultado.next()) {
                respuesta[0] = resultado.getString(1);
                respuesta[1] = resultado.getString(2);
                respuesta[2] = resultado.getString(3);

                modeloCompo.addRow(respuesta);
            } //Fin del while
            st.close();

            listadoComponentes.setModel(modeloCompo);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * crea una ventana, le cambia el nombre y saca el listado de componentes
     */
    public ListadoComponentes() {
        initComponents();
        this.setTitle("Listado de Componentes");
        buscaCompo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listadoComponentes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        listadoComponentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(listadoComponentes);

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
    private javax.swing.JTable listadoComponentes;
    // End of variables declaration//GEN-END:variables
}
