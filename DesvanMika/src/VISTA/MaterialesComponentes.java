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
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase maneja la tabla relacion NM entre un componente y sus materiales
 *
 * @author Josete
 * @version 1.0 BETA
 */
public class MaterialesComponentes extends javax.swing.JFrame {

    /**
     * Los atributos de clase Jframe apuntara a la ventana auxiliar para poder
     * luego abrirla y cerrarla y claveCompoSalvada, es la clave principal del
     * componente
     */
    JFrame aux; //esta variable apuntará a la ventana auxiliar abierta para poder cerrarla
    int claveCompoSalvada;

    /**
     * El Procedimiento nyestra tabla recibe un nombre de un campo y un texto a
     * buscar lo busca y lo saque en una tabla
     *
     * @param Campo Es un string que representa el nombre del campo
     * @param Busca Es un string que representa la cadena a busar
     */
    private void muestraTabla(String Campo, String Busca) {
        String consulta;
        String respuesta[] = new String[3];

        tablaComMat.setEnabled(true);
        tablaComMat.setVisible(true);
        DefaultTableModel tcm = new DefaultTableModel();
        tcm.addColumn("Componente");
        tcm.addColumn("Material");
        tcm.addColumn("Cantidad");
        tablaComMat.setModel(tcm);

        consulta = "Select * from formado where " + Campo + " LIKE'%" + Busca + "%'";

        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery(consulta);
            while (resultado.next()) {
                respuesta[0] = componente.getText();
                respuesta[1] = resultado.getString(2);
                respuesta[2] = resultado.getString(3);

                tcm.addRow(respuesta);
            }// fin del while
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ColoresForm.class.getName()).log(Level.SEVERE, null, ex);
        }//fin del try-catch

    }// fin del metodo

    /**
     * Crea el formulario materiales- componentes recibiendo una clave y un
     * nombre de un componente
     *
     * @param clave Es un entero clave principal del componente
     * @param nombre es el nombre del componente
     */
    public MaterialesComponentes(int clave, String nombre) {
        this.claveCompoSalvada = clave;
        setTitle("Materiales de componentes - Desvan de Mika");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.jpg"));
        setIconImage(icon);

        initComponents();
        componente.setText(nombre);
        componente.setEnabled(false);
        muestraTabla("COMPONENTE_codComponente", String.valueOf(claveCompoSalvada));

    } //fin del metodo

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcionBorrar = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codMat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        tipoMat = new javax.swing.JComboBox<>();
        botonCerrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        componente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComMat = new javax.swing.JTable();

        jMenuItem2.setForeground(new java.awt.Color(255, 0, 51));
        jMenuItem2.setText("ELIMINAR");
        jMenuItem2.setComponentPopupMenu(opcionBorrar);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        opcionBorrar.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Cod Material");

        jLabel2.setText("Cantidad ");

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        tipoMat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "ABALORIO", "ARCILLA_POLIMERICA", "FIELTRO", "UTILERIA", "TELA" }));
        tipoMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoMatActionPerformed(evt);
            }
        });

        botonCerrar.setText("CERRAR");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        jLabel4.setText("Introduzca los materiales que componen un ");

        tablaComMat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaComMat.setComponentPopupMenu(opcionBorrar);
        jScrollPane1.setViewportView(tablaComMat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tipoMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel1))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(botonGuardar)
                                                .addGap(14, 14, 14)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cantidad)
                                            .addComponent(codMat, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(36, 36, 36)
                                .addComponent(botonCerrar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(componente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(componente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(tipoMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(botonCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
     * Al seleccionar un material saca la ventana correspondiente al tipo de
     * material
     *
     */
    private void tipoMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoMatActionPerformed
        if (aux != null) {
            aux.dispose();
        }
        switch (tipoMat.getSelectedIndex()) {

            case 1:
                aux = new ListadoAbalorios();
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
     * Este es el boton Salir, que lo que hace es cerrar la ventana
     *
     */
    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        if (aux != null) {
            aux.dispose();
        }
        dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    /**
     * El boton guardar prepara el insert, y lo ejecuta para introducir en la
     * tabla
     *
     */
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

        try {
            
            PreparedStatement orden = cn.prepareStatement("INSERT INTO FORMADO(COMPONENTE_codComponente,MATERIAL_codMaterial, cantidad) values(?,?,?)");
            orden.setInt(1, this.claveCompoSalvada);
            orden.setString(2, codMat.getText());
            orden.setString(3, cantidad.getText());
            orden.executeUpdate();
            orden.close();
            JOptionPane.showMessageDialog(null, "Guardado con Exito");
            codMat.setText("");
            cantidad.setText("");
            muestraTabla("COMPONENTE_codComponente", String.valueOf(claveCompoSalvada));
            aux.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error, revise los datos");
            Logger.getLogger(MaterialesComponentes.class.getName()).log(Level.SEVERE, null, ex);
        } //fin 
    }//GEN-LAST:event_botonGuardarActionPerformed

    /**
     * Esta es la opción borrar del menu, comprueba que haya una fila y borra la
     * fila
     *
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        String orden;
        int fila;
        int respuesta;

        fila = tablaComMat.getSelectedRow();
        if (fila >= 0) {
            respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que que quiere borrar el componente" + tablaComMat.getValueAt(fila, 1) + " compuesto de " + tablaComMat.getValueAt(fila, 2) + "?");
            if (respuesta == 0) {
                orden = "DELETE FROM formado where COMPONENTE_codComponente=" + claveCompoSalvada + " and MATERIAL_codMaterial=" + tablaComMat.getValueAt(fila, 1);
                PreparedStatement pst;
                try {
                    pst = cn.prepareStatement(orden);
                    pst.executeUpdate();
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ColoresForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                muestraTabla("COMPONENTE_codComponente", String.valueOf(claveCompoSalvada));

            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila con el boton izquierdo");
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField codMat;
    private javax.swing.JTextField componente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu opcionBorrar;
    private javax.swing.JTable tablaComMat;
    private javax.swing.JComboBox<String> tipoMat;
    // End of variables declaration//GEN-END:variables
}
