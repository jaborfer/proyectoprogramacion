
package VISTA;

import static Principal.DesvanMika.cn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase solamente imprime una ventana auxiliar para mostrar tos los clientes
 * es un ejemplo de JInternalFrame que no es el mas adecuado pero queria poner un ejemplo
 * 
 * @author Josete
 */
public class ListaClientes extends javax.swing.JInternalFrame {

    private void buscaCli(String campo, String texto) {
        String consulta;
        String respuesta[] = new String[3];
        consulta = "SELECT * FROM cliente WHERE " + campo + " like'%" + texto + "%'";

        DefaultTableModel modeloCli = new DefaultTableModel();
        modeloCli.addColumn("Nº Cli");
        modeloCli.addColumn("Nombre");
        modeloCli.addColumn("Apellidos");

        tablaCli.setModel(modeloCli);
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
            tablaCli.setModel(modeloCli);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesForm.class.getName()).log(Level.SEVERE, null, ex);
        } // fin del try-catch

    } //fin del metodo

    /**
     * crea el internalFrame y llena la tabla
     */
    public ListaClientes() {
        initComponents();

        buscaCli("nombre", "");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCli = new javax.swing.JTable();

        setClosable(true);
        setOpaque(true);

        tablaCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCli);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JTable tablaCli;
    // End of variables declaration//GEN-END:variables
}
