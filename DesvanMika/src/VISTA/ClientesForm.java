package VISTA;

import Clases.Cliente;
import Procedimientos.Utilidades;
import static Principal.DesvanMika.cn;
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
 * Esta clase se encarga de gestionar el formulario de los clientes, usando el
 * objeto cliente de la clase Cliente
 *
 * @author Josete
 */
public class ClientesForm extends javax.swing.JFrame {

    private Utilidades u;
    public String clavePrincipalSalvada = ""; // esta es una variable auxiliar que vale para todas las actualizaciones de datos

    /**
     * Constructor que crea el objeto utilidades y pone nombre e icono
     */
    public ClientesForm() {

        initComponents();
        u = new Utilidades();
        setTitle("Clientes-Desvan de Mika");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.jpg"));
        setIconImage(icon);
        buscaCli("nombre", "");
    }

    /**
     * Este método activa o desactiva las casillas y botones necesarias para un
     * nuevo cliente
     */
    private void activaNuevo() {
        botonGuardar.setEnabled(true);
        botonBuscar.setEnabled(false);
        botonNuevo.setEnabled(false);
        nombreCli.setEnabled(true);
        direccionCli.setEnabled(true);
        telefonoCli.setEnabled(true);
        apellidosCli.setEnabled(true);
        emailCli.setEnabled(true);
        nombreCli.requestFocus();
        errorTel.setText("");
    }

    /**
     * este metodo solo activa y desactiva los botones y cajas de texto para la
     * busqueda
     *
     */
    private void activaEdicion() {
        botonGuardar.setEnabled(false);
        botonNuevo.setEnabled(false);
        nombreCli.setEnabled(true);
        direccionCli.setEnabled(true);
        telefonoCli.setEnabled(true);
        apellidosCli.setEnabled(true);
        emailCli.setEnabled(true);
        errorTel.setText("");
    }

    /**
     * Este metodo muestra el esqueleto de la tabla clientes
     *
     * @param modeloCli el nombre de la tabla
     */
    private void muestraCuerpoTabla(DefaultTableModel modeloCli) {
        modeloCli.addColumn("Nº Cli");
        modeloCli.addColumn("Nombre");
        modeloCli.addColumn("Apellidos");
        modeloCli.addColumn("Dirección");
        modeloCli.addColumn("Teléfono");
        modeloCli.addColumn("Whatsup");
        modeloCli.addColumn("Email");
        tablaCli.setModel(modeloCli);
    }

    /**
     * Al pulsar el boton busqueda de proveedores, prepara la tabla para ver los
     * resultados
     */
    private void mostrarTablaCli() {
        tablaCli.setEnabled(true);
        tablaCli.setVisible(true);
        DefaultTableModel modeloCli = new DefaultTableModel();
        muestraCuerpoTabla(modeloCli);

    }

    /**
     * Es una busqueda en la base de datos que dado un campo y el texto a buscar
     * mete todas las filas que coincidan en la tabla clientes, se usa para las
     * funciones de buscar y para que vaya buscando en tiempo real según se
     * escribe
     *
     * @param campo indica el campo de la base de datos en el que queremos
     * buscar
     * @param texto el texto que queremos buscar
     */
    private void buscaCli(String campo, String texto) {
        String consulta;
        String respuesta[] = new String[7];
        consulta = "SELECT * FROM cliente WHERE " + campo + " like'%" + texto + "%'";

        DefaultTableModel modeloCli = new DefaultTableModel();
        muestraCuerpoTabla(modeloCli);
        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery(consulta);
            while (resultado.next()) {
                respuesta[0] = resultado.getString(1);
                respuesta[1] = resultado.getString(2);
                respuesta[2] = resultado.getString(3);
                respuesta[3] = resultado.getString(4);
                respuesta[4] = resultado.getString(5);
                if (resultado.getString(6).equals("0")) // cambia la respuesta de base de datos a español
                {
                    respuesta[5] = "No";
                } else {
                    respuesta[5] = "Si";
                } //fin del if-else
                respuesta[6] = resultado.getString(7);
                modeloCli.addRow(respuesta);
            } //Fin del while
            tablaCli.setModel(modeloCli);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesForm.class.getName()).log(Level.SEVERE, null, ex);
        } // fin del try-catch

    } // fin del metodo

    /**
     * Limpia la tabla proveedores y la prepara para empezar a funcionar
     */
    private void limpiarClientes() {
        botonNuevo.setEnabled(true);
        botonBuscar.setEnabled(true);
        botonGuardar.setEnabled(false);
        botonActualizar.setEnabled(false);
        nombreCli.setText("");
        direccionCli.setText("");
        telefonoCli.setText("");
        apellidosCli.setText("");
        nombreCli.setEnabled(false);
        direccionCli.setEnabled(false);
        telefonoCli.setEnabled(false);
        apellidosCli.setEnabled(false);
        tablaCli.setEnabled(true);
        tablaCli.setVisible(true);
        errorTel.setText("");
        notaCliModificar.setText("");
        noWhat.setSelected(true);
        emailCli.setText("");
        emailCli.setEnabled(false);

    }

    /**
     * rellena todos los campos del formulario cuando se ha seleccionado una
     * fila de la tabla
     *
     * @param fila es el numero de fila que se ha seleccionado en la tabla
     */
    private void llenaCampos(int fila) {
        nombreCli.setText(tablaCli.getValueAt(fila, 1).toString());
        apellidosCli.setText(tablaCli.getValueAt(fila, 2).toString());
        direccionCli.setText(tablaCli.getValueAt(fila, 3).toString());
        telefonoCli.setText(tablaCli.getValueAt(fila, 4).toString());
        emailCli.setText(tablaCli.getValueAt(fila, 6).toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        opcionModificar = new javax.swing.JMenuItem();
        opcionBorrar = new javax.swing.JMenuItem();
        whatsup = new javax.swing.ButtonGroup();
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
        nombreCli = new javax.swing.JTextField();
        direccionCli = new javax.swing.JTextField();
        telefonoCli = new javax.swing.JTextField();
        apellidosCli = new javax.swing.JTextField();
        botonNuevo = new javax.swing.JButton();
        errorTel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCli = new javax.swing.JTable();
        notaCliModificar = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        siWhat = new javax.swing.JRadioButton();
        noWhat = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        emailCli = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();

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

        opcionModificar.setText("Modificar");
        opcionModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(opcionModificar);

        opcionBorrar.setForeground(new java.awt.Color(255, 51, 51));
        opcionBorrar.setText("ELIMINAR");
        opcionBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionBorrarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(opcionBorrar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabel4.setText("Apellidos");

        nombreCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreCliFocusGained(evt);
            }
        });
        nombreCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreCliActionPerformed(evt);
            }
        });
        nombreCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreCliKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreCliKeyReleased(evt);
            }
        });

        direccionCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionCliActionPerformed(evt);
            }
        });
        direccionCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                direccionCliKeyReleased(evt);
            }
        });

        telefonoCli.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                telefonoCliInputMethodTextChanged(evt);
            }
        });
        telefonoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoCliActionPerformed(evt);
            }
        });
        telefonoCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telefonoCliKeyReleased(evt);
            }
        });

        apellidosCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidosCliActionPerformed(evt);
            }
        });
        apellidosCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                apellidosCliKeyReleased(evt);
            }
        });

        botonNuevo.setText("Nuevo");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        errorTel.setForeground(new java.awt.Color(255, 51, 51));

        tablaCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCli.setComponentPopupMenu(jPopupMenu1);
        tablaCli.setEnabled(false);
        jScrollPane2.setViewportView(tablaCli);

        notaCliModificar.setForeground(new java.awt.Color(0, 0, 204));

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        jLabel5.setText("Whatsup");

        whatsup.add(siWhat);
        siWhat.setText("Si");
        siWhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siWhatActionPerformed(evt);
            }
        });

        whatsup.add(noWhat);
        noWhat.setText("No");

        jLabel6.setText("Email");

        emailCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailCliFocusLost(evt);
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
                                .addComponent(nombreCli, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(direccionCli))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(telefonoCli)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(siWhat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(noWhat))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(65, 65, 65)))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(apellidosCli, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                                    .addComponent(emailCli))
                                .addGap(74, 74, 74))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(notaCliModificar)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(errorTel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nombreCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(direccionCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(emailCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(apellidosCli, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(telefonoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(siWhat)
                    .addComponent(noWhat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorTel)
                .addGap(4, 4, 4)
                .addComponent(notaCliModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonNuevo)
                    .addComponent(botonBuscar)
                    .addComponent(botonGuardar)
                    .addComponent(botonCancelar)
                    .addComponent(botonActualizar))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes", jPanel7);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(253, 181, 142));
        label1.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        label1.setForeground(new java.awt.Color(167, 91, 91));
        label1.setText("El desvan de Mika");

        jButton1.setText("Menú Ficheros");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
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
     * Responde al boton menú ficheros volviendo al menu anterior
     *
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        MenuFicheros mp = new MenuFicheros();
        mp.setLocationRelativeTo(null);
        mp.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed


    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        limpiarClientes();

    }//GEN-LAST:event_jTabbedPane1FocusGained


    private void jTabbedPane1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusLost
        limpiarClientes();
    }//GEN-LAST:event_jTabbedPane1FocusLost
    /**
     * Primera opción del menu emergente, es la opción modificar, primero
     * detecta si hay alguna linea seleccionada (si no da un mensaje para
     * seleccionarla) despues salva la clave principal y rellena el formulario
     * con los campos de la fila y lo prepara todo para poder modificar en la
     * base de datos
     *
     */

    private void opcionModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionModificarActionPerformed
        int fila;
        fila = tablaCli.getSelectedRow();

        if (fila >= 0) {
            clavePrincipalSalvada = tablaCli.getValueAt(fila, 0).toString();
            llenaCampos(fila);
            activaEdicion();

            if (tablaCli.getValueAt(fila, 5).toString().equals("Si")) {
                siWhat.setSelected(true);
            } else {
                noWhat.setSelected(true);
            } // fin del if-else interior

            botonActualizar.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(null, "seleccione la linea con el botón izquierdo");
        } // fin del if-else exterior
    }//GEN-LAST:event_opcionModificarActionPerformed

    /**
     * Segunda opción del menu emergente, es la opción borrar, primero detecta
     * si hay alguna linea seleccionada (si no da un mensaje para seleccionarla)
     * despues salva la clave principal y rellena el formulario con los campos
     * de la fila comprueba si es la que se quiere borrar y crea el objeto y
     * manda la orden de borrado
     *
     */
    private void opcionBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionBorrarActionPerformed
        int fila;
        int respuesta;
        String nombre;
        String orden;
        int clave;
        fila = tablaCli.getSelectedRow();

        if (fila >= 0) {
            nombre = tablaCli.getValueAt(fila, 1).toString();
            clavePrincipalSalvada = tablaCli.getValueAt(fila, 0).toString();
            clave = Integer.parseInt(clavePrincipalSalvada);
            llenaCampos(fila);
            respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar a " + nombre + "?");
            if (respuesta == 0) {
                Cliente cliBorr = new Cliente(clave, nombreCli.getText(), apellidosCli.getText(), direccionCli.getText(), Integer.parseInt(telefonoCli.getText()), siWhat.isSelected(), emailCli.getText());
                cliBorr.BorraCliente();
                mostrarTablaCli();
                buscaCli("nombre", "");
                limpiarClientes();
            } //fin de if-else interior
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila pinchando con el boton izq");
        } //fin del if-else exterior
    }//GEN-LAST:event_opcionBorrarActionPerformed


    private void siWhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siWhatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siWhatActionPerformed
    /**
     * Al pulsar el boton actualizar primero comprueba que el teléfono cumple el
     * standard usando el objeto de la clasa utilidades y despues crea el objeto
     * y le da la orden de actualizar
     *
     */
    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        int clave;
        String Telefono;

        clave = Integer.parseInt(clavePrincipalSalvada);
        Telefono = u.limpiaTel(telefonoCli.getText());
        if (Telefono.length() == 9) {
            Cliente cliAct = new Cliente(clave, nombreCli.getText(), apellidosCli.getText(), direccionCli.getText(), Integer.parseInt(telefonoCli.getText()), siWhat.isSelected(), emailCli.getText());
            cliAct.actualizaCliente();
            clavePrincipalSalvada = "";
            limpiarClientes();
        } else {
            JOptionPane.showMessageDialog(null, "el telefono debe tener 9 digitos");
        } // fin del if else
    }//GEN-LAST:event_botonActualizarActionPerformed

    /**
     * Al pulsar el boton nuevo, activa los campos necesarios para meter un
     * nuevo cliente
     *
     */
    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        activaNuevo();
    }//GEN-LAST:event_botonNuevoActionPerformed

    /**
     * usando el metodo buscacli, cuando el usuario pulsa una tecla buca en vivo
     * todos los apellidos que tienen esa cadena
     */
    private void apellidosCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidosCliKeyReleased
        String texto;
        texto = apellidosCli.getText().trim();

        buscaCli("apellido", texto);
    }//GEN-LAST:event_apellidosCliKeyReleased

    private void apellidosCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidosCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidosCliActionPerformed

    /**
     * usando el metodo buscacli, cuando el usuario pulsa una tecla buca en vivo
     * todos los telefonos que tienen esa cadena
     */
    private void telefonoCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoCliKeyReleased
        String texto;
        texto = u.limpiaTel(telefonoCli.getText());
        buscaCli("telefono", texto);        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoCliKeyReleased

    private void telefonoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoCliActionPerformed

    private void telefonoCliInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_telefonoCliInputMethodTextChanged

    }//GEN-LAST:event_telefonoCliInputMethodTextChanged

    /**
     * usando el metodo buscacli, cuando el usuario pulsa una tecla buca en vivo
     * todos las direcciones que tienen esa cadena
     */
    private void direccionCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionCliKeyReleased
        String texto;
        texto = direccionCli.getText().trim();

        buscaCli("direccion", texto);
    }//GEN-LAST:event_direccionCliKeyReleased

    private void direccionCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionCliActionPerformed

    /**
     * usando el metodo buscacli, cuando el usuario pulsa una tecla buca en vivo
     * todos los nombres que tienen esa cadena
     */
    private void nombreCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreCliKeyReleased
        String texto;
        texto = nombreCli.getText().trim();

        buscaCli("nombre", texto);        // TODO add your handling code here:
    }//GEN-LAST:event_nombreCliKeyReleased

    private void nombreCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreCliKeyPressed

    }//GEN-LAST:event_nombreCliKeyPressed

    private void nombreCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreCliActionPerformed

    private void nombreCliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreCliFocusGained

    }//GEN-LAST:event_nombreCliFocusGained
    /**
     * Al pulsar el boton cancelar se limpian todos los campos y activan los
     * botones
     *
     */
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        limpiarClientes();
    }//GEN-LAST:event_botonCancelarActionPerformed

    /**
     * Al pulsar el boton guardar, se ccomprueba el telefojo y se crea el objeto
     * cliente y luego se manda la orden de guardar
     *
     */
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        String tel;
        tel = telefonoCli.getText();
        telefonoCli.setText(u.limpiaTel(tel)); //checkTel limpia la cadena de telefono y deja solo los numeros
        if (telefonoCli.getText().length() == 9) {
            errorTel.setText("");

            Cliente cli = new Cliente(0, nombreCli.getText(), apellidosCli.getText(), direccionCli.getText(), Integer.parseInt(telefonoCli.getText()), siWhat.isSelected(), emailCli.getText());
            nombreCli.setText(cli.getNombre()); //recupera los datos formateados y los pone en el formulario
            apellidosCli.setText(cli.getApellido());
            direccionCli.setText(cli.getDireccion());

            cli.guardaCliente();
            limpiarClientes();
            buscaCli("nombre", "");
        } else {
            errorTel.setText("<---tiene que tener 9 digitos");

        } // fin del if-else
    }//GEN-LAST:event_botonGuardarActionPerformed

    /**
     * Al pulsar el boton buscar activa los campos y la tabla llama al metodo
     * buscaCli para que aparezcan todos los registros
     */
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        activaEdicion();

        notaCliModificar.setText("pulse boton derecho para modificar o suprimir");
        nombreCli.requestFocus();
        mostrarTablaCli();
        buscaCli("nombre", "");
    }//GEN-LAST:event_botonBuscarActionPerformed

    /**
     * una vez escrito algo, comprueba si es un email correcto con la clase
     * utilidades
     *
     */
    private void emailCliFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailCliFocusLost
        if (!emailCli.getText().equals("") && !u.chkMail(emailCli.getText())) { //Si no esta vacio es por que hay algo y si ese algo no es correcto . . .
            JOptionPane.showMessageDialog(rootPane, "El email no es correcto");
            emailCli.requestFocus();
        }
    }//GEN-LAST:event_emailCliFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidosCli;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JTextField direccionCli;
    private javax.swing.JTextField emailCli;
    private javax.swing.JLabel errorTel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private javax.swing.JRadioButton noWhat;
    private javax.swing.JTextField nombreCli;
    private javax.swing.JLabel notaCliModificar;
    private javax.swing.JMenuItem opcionBorrar;
    private javax.swing.JMenuItem opcionModificar;
    private javax.swing.JRadioButton siWhat;
    private javax.swing.JTable tablaCli;
    private javax.swing.JTextField telefonoCli;
    private javax.swing.ButtonGroup whatsup;
    // End of variables declaration//GEN-END:variables
}
