/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import Procedimientos.Utilidades;
import static Principal.DesvanMika.cn;
import Clases.proveedor;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase se encarga de gestionar la venana de proveedores
 *
 * @author Josete
 */
public class ProveedoresForm extends javax.swing.JFrame {

    private Utilidades u;
    proveedor p;
    public String clavePrincipalSalvada = ""; // esta es una variable auxiliar que vale para todas las actualizaciones de datos

    /**
     * Al pulsar el boton busqueda de proveedores, prepara la tabla para ver los
     * resultados
     */
    private void mostrarTablaPro() {
        tablaPro.setEnabled(true);
        tablaPro.setVisible(true);
        DefaultTableModel modeloPro = new DefaultTableModel();
        modeloPro.addColumn("Nombre");
        modeloPro.addColumn("Dirección");
        modeloPro.addColumn("Teléfono");
        modeloPro.addColumn("Contacto");
        tablaPro.setModel(modeloPro);

    }

    /**
     * Este metodo muestra la tabla de proveedores buscando los datos segun el
     * campo pasado y lo que queremos que se busque en el.
     *
     * @param campo Es un string que representa el campo donde vamos a buscar
     * @param texto Es el texto que queremos buscar
     */
    private void buscaPro(String campo, String texto) {
        String consulta;
        String respuesta[] = new String[4];
        consulta = "SELECT * FROM PROVEEDOR WHERE " + campo + " like'%" + texto + "%'";
        DefaultTableModel modeloPro = new DefaultTableModel();
        modeloPro.addColumn("Nombre");
        modeloPro.addColumn("Dirección");
        modeloPro.addColumn("Teléfono");
        modeloPro.addColumn("Contacto");
        tablaPro.setModel(modeloPro);
        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery(consulta);
            while (resultado.next()) {
                respuesta[0] = resultado.getString(1);
                respuesta[1] = resultado.getString(2);
                respuesta[2] = resultado.getString(3);
                respuesta[3] = resultado.getString(4);
                modeloPro.addRow(respuesta);
            } //Fin del while
            st.close();
            tablaPro.setModel(modeloPro);
        } catch (SQLException ex) {
            Logger.getLogger(ProveedoresForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Esta función se usa para modificar y borrar, lo que hace es al
     * seleccionar una fila con el boton derecho, muestra los datos en en el
     * formulario
     *
     * @return devuelve si lo ha hecho bien o no
     */
    public boolean rellenaPro() {
        int fila;
        boolean correcto;
        fila = tablaPro.getSelectedRow();
        if (fila >= 0) {
            nombrePro.setText(tablaPro.getValueAt(fila, 0).toString());
            direccionPro.setText(tablaPro.getValueAt(fila, 1).toString());
            telefonoPro.setText(tablaPro.getValueAt(fila, 2).toString());
            contactoPro.setText(tablaPro.getValueAt(fila, 3).toString());
            correcto = true;

        } else {
            JOptionPane.showMessageDialog(null, "seleccione la linea con el botón izquierdo");
            correcto = false;
        }
        return correcto;
    }

    /**
     * Activa los campos para un proveedor nuevo
     */
    private void activaCampos() {
        botonGuardar.setEnabled(true);
        botonBuscar.setEnabled(false);
        botonNuevo.setEnabled(false);
        nombrePro.setEnabled(true);
        direccionPro.setEnabled(true);
        telefonoPro.setEnabled(true);
        contactoPro.setEnabled(true);
        nombrePro.requestFocus();
    }

    /**
     * Limpia la tabla proveedores y la prepara para empezar a funcionar
     */
    private void limpiarProveedores() {
        botonNuevo.setEnabled(true);
        botonBuscar.setEnabled(true);
        botonGuardar.setEnabled(false);
        botonActualizar.setEnabled(false);
        nombrePro.setText("");
        direccionPro.setText("");
        telefonoPro.setText("");
        contactoPro.setText("");
        nombrePro.setEnabled(false);
        direccionPro.setEnabled(false);
        telefonoPro.setEnabled(false);
        contactoPro.setEnabled(false);
        tablaPro.setEnabled(true);
        tablaPro.setVisible(true);
        notaProBuscar.setText("");
        notaProModificar.setText("");
    }

    public ProveedoresForm() {

        initComponents();
        u = new Utilidades();
        setTitle("Proveedores-Desvan de Mika");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.jpg"));
        setIconImage(icon);
        buscaPro("nombre", "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuModificar = new javax.swing.JMenuItem();
        menuBorrar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        botonBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombrePro = new javax.swing.JTextField();
        direccionPro = new javax.swing.JTextField();
        telefonoPro = new javax.swing.JTextField();
        contactoPro = new javax.swing.JTextField();
        botonNuevo = new javax.swing.JButton();
        errorTel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPro = new javax.swing.JTable();
        notaProBuscar = new javax.swing.JLabel();
        notaProModificar = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JButton();
        label1 = new java.awt.Label();
        botonFicheros = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        menuModificar.setText("Modificar");
        menuModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuModificar);

        menuBorrar.setForeground(new java.awt.Color(255, 51, 51));
        menuBorrar.setText("ELIMINAR");
        menuBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBorrarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuBorrar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(167, 91, 91));

        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusLost(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jLabel2.setText("Dirección");

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Telefono");

        jLabel4.setText("Contacto");

        nombrePro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreProFocusGained(evt);
            }
        });
        nombrePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreProActionPerformed(evt);
            }
        });
        nombrePro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreProKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreProKeyReleased(evt);
            }
        });

        direccionPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionProActionPerformed(evt);
            }
        });
        direccionPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                direccionProKeyReleased(evt);
            }
        });

        telefonoPro.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                telefonoProInputMethodTextChanged(evt);
            }
        });
        telefonoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoProActionPerformed(evt);
            }
        });
        telefonoPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telefonoProKeyReleased(evt);
            }
        });

        contactoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactoProActionPerformed(evt);
            }
        });
        contactoPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contactoProKeyReleased(evt);
            }
        });

        botonNuevo.setText("Nuevo");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        errorTel.setForeground(new java.awt.Color(255, 51, 51));

        tablaPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaPro.setComponentPopupMenu(jPopupMenu1);
        tablaPro.setEnabled(false);
        jScrollPane2.setViewportView(tablaPro);

        notaProBuscar.setForeground(new java.awt.Color(0, 51, 255));

        notaProModificar.setForeground(new java.awt.Color(51, 255, 0));

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(nombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(direccionPro))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(telefonoPro))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(contactoPro)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(errorTel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(notaProBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(notaProModificar)
                        .addContainerGap())))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(botonNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19)
                        .addComponent(botonActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notaProBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(nombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(direccionPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(telefonoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorTel))
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(contactoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(notaProModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonNuevo)
                    .addComponent(botonBuscar)
                    .addComponent(botonGuardar)
                    .addComponent(botonCancelar)
                    .addComponent(botonActualizar))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proveedores", jPanel7);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(253, 181, 142));
        label1.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        label1.setForeground(new java.awt.Color(167, 91, 91));
        label1.setText("El desvan de Mika");

        botonFicheros.setText("Menú Ficheros");
        botonFicheros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFicherosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonFicheros, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(botonFicheros, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Este boton nos lleva a la pantalla anterior, a los ficheros
     *
     * 
     */
    private void botonFicherosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFicherosActionPerformed

        MenuFicheros mp = new MenuFicheros();
        mp.setLocationRelativeTo(null);
        mp.setVisible(true);
        dispose();

    }//GEN-LAST:event_botonFicherosActionPerformed

    /**
     * Este es el menu de modificar, lo que hace es coger la linea de seleccion
     * leer la clave principal y borrarla de la tabla
     *
     */
    private void menuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarActionPerformed
        if (rellenaPro()) {

            botonActualizar.setEnabled(true);
            activaCampos();
            botonGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_menuModificarActionPerformed
    /**
     * El boton nuevo lo que hace es preparar el formulario para meter los datos
     *
     */


    private void menuBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBorrarActionPerformed

        int fila;
        int respuesta;
        String nombre;
        String orden;
        fila = tablaPro.getSelectedRow();
        if (rellenaPro()) {
            nombre = tablaPro.getValueAt(fila, 0).toString();
            respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar " + nombre + "?");
            if (respuesta == 0) {
                int numtel = Integer.parseInt(telefonoPro.getText());
                p = new proveedor(nombrePro.getText(), direccionPro.getText(), numtel, contactoPro.getText());

                p.borraProveedor();
                limpiarProveedores();
                mostrarTablaPro();
                buscaPro("nombre", "");

            }
        }
    }//GEN-LAST:event_menuBorrarActionPerformed

    private void jTabbedPane1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusLost
        limpiarProveedores();
    }//GEN-LAST:event_jTabbedPane1FocusLost

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        limpiarProveedores();
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        String clave;
        String orden;
        String Telefono;
        Telefono = u.limpiaTel(telefonoPro.getText());
        if (Telefono.length() == 9) {

            if (clavePrincipalSalvada.equals("")) { //Si el campo nombre(la clave principal) no se ha tocado
                clave = nombrePro.getText();
            } else {
                clave = clavePrincipalSalvada;
            }
            int numtel = Integer.parseInt(telefonoPro.getText());
            proveedor pAct = new proveedor(nombrePro.getText(), direccionPro.getText(), numtel, contactoPro.getText());
            pAct.actualizarProveedor(clave);
            clavePrincipalSalvada = "";
            limpiarProveedores();
        } else {
            JOptionPane.showMessageDialog(null, "el telefono debe tener 9 números");
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        activaCampos();
    }//GEN-LAST:event_botonNuevoActionPerformed

    /**
     * Este metodo va buscando el texto que se ha metido en contacto, cada vez
     * que se escribe una tecla
     *
     */
    private void contactoProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactoProKeyReleased
        String texto;
        texto = contactoPro.getText().trim();

        buscaPro("persona_contacto", texto);        // TODO add your handling code here:
    }//GEN-LAST:event_contactoProKeyReleased

    private void contactoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactoProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactoProActionPerformed

    /**
     * Este metodo va buscando el texto que se ha metido en telefono, cada vez
     * que se escribe una tecla
     */
    private void telefonoProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoProKeyReleased

        String texto;
        texto = u.limpiaTel(telefonoPro.getText());
        buscaPro("telefono", texto);        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoProKeyReleased

    private void telefonoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoProActionPerformed

    private void telefonoProInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_telefonoProInputMethodTextChanged

    }//GEN-LAST:event_telefonoProInputMethodTextChanged

    /**
     * Este metodo va buscando el texto que se ha metido en direccion, cada vez
     * que se escribe una tecla
     */
    private void direccionProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionProKeyReleased
        String texto;
        texto = direccionPro.getText().trim();

        buscaPro("direccion", texto);        // TODO add your handling code here:
    }//GEN-LAST:event_direccionProKeyReleased

    private void direccionProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionProActionPerformed

    /**
     * Este metodo va buscando el texto que se ha metido en contacto, cada vez
     * que se escribe una tecla
     */
    private void nombreProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProKeyReleased
        String texto;
        texto = u.mayusculas(nombrePro.getText());

        buscaPro("nombre", texto);        // TODO add your handling code here:
    }//GEN-LAST:event_nombreProKeyReleased

    private void nombreProKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProKeyPressed

    }//GEN-LAST:event_nombreProKeyPressed

    private void nombreProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreProActionPerformed

    private void nombreProFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreProFocusGained
        if (!nombrePro.getText().equals("")) {
            clavePrincipalSalvada = nombrePro.getText();
        }
    }//GEN-LAST:event_nombreProFocusGained

    /**
     * El boton cancelar borra todo el contenido y prepara el formulario para
     * volver a empezar
     *
     */
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        limpiarProveedores();
    }//GEN-LAST:event_botonCancelarActionPerformed
    /**
     * El Boton Guardar prepara los datos, crea un objeto proveedor y manda la
     * orden guardar
     *
     */
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        String tel;
        tel = telefonoPro.getText();
        telefonoPro.setText(u.limpiaTel(tel)); //checkTel limpia la cadena de telefono y deja solo los numeros
        if (telefonoPro.getText().length() == 9) {
            errorTel.setText("");
            int numtel = Integer.parseInt(telefonoPro.getText());
            p = new proveedor(nombrePro.getText(), direccionPro.getText(), numtel, contactoPro.getText());
            p.guardarProveedor();
            limpiarProveedores();

        } else {
            errorTel.setText("<---tiene que tener 9 digitos");

        } // fin del if
    }//GEN-LAST:event_botonGuardarActionPerformed
    /**
     * El boton buscar prepara el formulario para poder buscar por campo y
     * muestra todos los datos en la tabla por si se quiere seleccionar.
     *
     */
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        botonGuardar.setEnabled(false);
        botonNuevo.setEnabled(false);
        nombrePro.setEnabled(true);
        direccionPro.setEnabled(true);
        telefonoPro.setEnabled(true);
        contactoPro.setEnabled(true);
        notaProBuscar.setText("<-- introduzca una palabra");
        notaProModificar.setText("pulse boton derecho para modificar o suprimir");
        nombrePro.requestFocus();
        mostrarTablaPro();
        buscaPro("nombre", "");
    }//GEN-LAST:event_botonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonFicheros;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JTextField contactoPro;
    private javax.swing.JTextField direccionPro;
    private javax.swing.JLabel errorTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private javax.swing.JMenuItem menuBorrar;
    private javax.swing.JMenuItem menuModificar;
    private javax.swing.JTextField nombrePro;
    private javax.swing.JLabel notaProBuscar;
    private javax.swing.JLabel notaProModificar;
    private javax.swing.JTable tablaPro;
    private javax.swing.JTextField telefonoPro;
    // End of variables declaration//GEN-END:variables
}
