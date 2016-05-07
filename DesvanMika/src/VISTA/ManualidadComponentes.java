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
 * Esta clase maneja la tabla manualidad-componentes
 *
 * @author Josete
 * @version 1.0 BETA
 */
public class ManualidadComponentes extends javax.swing.JFrame {

    /**
     * La variable aux, apunta a la ventana auxiliar y clave es la primary key
     */
    JFrame aux; //esta variable apuntará a la ventana auxiliar abierta para poder cerrarla
    int claveCompoSalvada;

    /**
     * Este metodo, recibe dos parametros, un nombre de una columna y un texto
     *
     * @param Campo es un String que representa el nombre de una columna
     * @param Busca es un String que es el texto que hay que buscar
     */
    private void muestraTabla(String Campo, String Busca) {
        String consulta;
        String respuesta[] = new String[3];

        tablaComMat.setEnabled(true);
        tablaComMat.setVisible(true);
        DefaultTableModel tcm = new DefaultTableModel();
        tcm.addColumn("Manualidad");
        tcm.addColumn("Componente");
        tcm.addColumn("Cantidad");
        tablaComMat.setModel(tcm);

        consulta = "Select * from secompone where " + Campo + " LIKE'%" + Busca + "%'";

        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery(consulta);
            while (resultado.next()) {
                respuesta[0] = manualidad.getText();
                respuesta[1] = resultado.getString(2);
                respuesta[2] = resultado.getString(3);

                tcm.addRow(respuesta);
            }// fin del while
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ColoresForm.class.getName()).log(Level.SEVERE, null, ex);
        } // fin del try-catch 

    } // fin del metodo

    /**
     * Crea una ventana recibiendo por parametros la clave del manualidad que
     * formara parte de la PK de la NM
     *
     * @param clave Es un el parametro que es la clave principal de Manualidad
     * @param nombre el nombre de la manualidad
     */
    public ManualidadComponentes(int clave, String nombre) {
        this.claveCompoSalvada = clave;
        setTitle("Componentes de Manualidad - Desvan de Mika");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.jpg"));
        setIconImage(icon);
        initComponents();
        manualidad.setText(nombre);
        manualidad.setEnabled(false);
        muestraTabla("MANUALIDAD_codManualidad", String.valueOf(claveCompoSalvada));
        ListadoComponentes lc = new ListadoComponentes();
        lc.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        opcionBorrar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codComponente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        botonCerrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        manualidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComMat = new javax.swing.JTable();

        opcionBorrar.setForeground(new java.awt.Color(255, 0, 51));
        opcionBorrar.setText("ELIMINAR");
        opcionBorrar.setComponentPopupMenu(jPopupMenu1);
        opcionBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionBorrarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(opcionBorrar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Cod componente");

        jLabel2.setText("Cantidad ");

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonCerrar.setText("CERRAR");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        jLabel4.setText("Introduzca losComponentes que componen un ");

        tablaComMat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaComMat.setComponentPopupMenu(jPopupMenu1);
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
                                .addGap(85, 85, 85)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(35, 35, 35))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(botonGuardar)
                                        .addGap(14, 14, 14))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cantidad)
                                    .addComponent(codComponente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addComponent(botonCerrar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(manualidad, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(manualidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codComponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
     *
     * Este es el metodo del cerrar, que lo que hace es cerar la ventana
     */
    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    /**
     * El boton guardar, guarda en la tabla la información de la pantalla
     * pasando como parte de la clave primaria la clave que se le paso de
     * manualidad
     *
     */
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

        try {
            PreparedStatement orden = cn.prepareStatement("INSERT INTO secompone(MANUALIDAD_codManualidad, COMPONENTE_codComponente, cantidad) values(?,?,?)");
            orden.setInt(1, this.claveCompoSalvada);
            orden.setString(2, codComponente.getText());
            orden.setString(3, cantidad.getText());
            orden.executeUpdate();
            orden.close();
            JOptionPane.showMessageDialog(null, "Guardado con Exito");
            codComponente.setText("");
            cantidad.setText("");
            muestraTabla("MANUALIDAD_codManualidad", String.valueOf(claveCompoSalvada));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error, revise los datos");
            Logger.getLogger(ManualidadComponentes.class.getName()).log(Level.SEVERE, null, ex);
        }// fin del try-catch
    }//GEN-LAST:event_botonGuardarActionPerformed
    /**
     * Esta es la opción borrar del menu emergente, que lo que hace es primero
     * es comprobar que hay una fila seleccionada luego pregunta si de verdad
     * queremos borrar y en caso afirmativo borra
     *
     */
    private void opcionBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionBorrarActionPerformed
        String orden;
        int fila;
        int respuesta;

        fila = tablaComMat.getSelectedRow();
        if (fila >= 0) {
            respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que que quiere borrar La manualidad " + tablaComMat.getValueAt(fila, 1) + " compuesto de " + tablaComMat.getValueAt(fila, 2) + "?");
            if (respuesta == 0) {
                orden = "DELETE FROM secompone where MANUALIDAD_codManualidad=" + claveCompoSalvada + " and COMPONENTE_codComponente=" + tablaComMat.getValueAt(fila, 1);
                PreparedStatement pst;
                try {
                    pst = cn.prepareStatement(orden);
                    pst.executeUpdate();
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ColoresForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                muestraTabla("MANUALIDAD_codManualidad", String.valueOf(claveCompoSalvada));

            }// fin del if

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila con el boton izquierdo");
        }// fin del try-catch
    }//GEN-LAST:event_opcionBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField codComponente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField manualidad;
    private javax.swing.JMenuItem opcionBorrar;
    private javax.swing.JTable tablaComMat;
    // End of variables declaration//GEN-END:variables
}
