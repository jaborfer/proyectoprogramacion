/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import static Principal.DesvanMika.cn;
import Procedimientos.Utilidades;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase se encarga de manejar las manualidades
 *
 * @author Josete
 */
public class ManualidadForm extends javax.swing.JFrame {

    /**
     * Creamos un flujo para el tema de la foto y la longitud y la
     * claveprincipal que usamos para salvar la clave de la tabla.
     */
    private FileInputStream fotoBlob = null;
    private int longitudBytes = 0;
    String ClavePrincipal;
    Utilidades u;

    /**
     * El creador, crea la ventana y le cambia el título y el equipo
     */
    public ManualidadForm() {
        u = new Utilidades();
        initComponents();

        setTitle("Manualidades-Desvan de Mika");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.jpg"));
        setIconImage(icon);
        rutaFoto.setEnabled(false);
    }

    /**
     * Muestra el esqueleto de la tabla manualidades
     */
    private void mostrarTablaMan(DefaultTableModel modeloMan) {
        tablaMan.setEnabled(true);
        tablaMan.setVisible(true);
        modeloMan.addColumn("id Manualidad");
        modeloMan.addColumn("Nombre");
        modeloMan.addColumn("Tiempo");
        modeloMan.addColumn("Observaciones");
        tablaMan.setModel(modeloMan);

    } // fin del procedimiento

    /**
     * Procedimiento al que se le pasa el nombre de un campo y un texto que
     * queremos que busque en ese campo y lo muestra en la tabla
     *
     * @param campo String que representa el nombre del campo
     * @param texto String que representa el texto que queremos buscar
     */
    private void buscaMan(String campo, String texto) {
        String consulta;
        String respuesta[] = new String[4];
        consulta = "SELECT * FROM manualidad WHERE " + campo + " like'%" + texto + "%'";
        DefaultTableModel modeloMan = new DefaultTableModel();
        mostrarTablaMan(modeloMan);
        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery(consulta);
            while (resultado.next()) {
                respuesta[0] = resultado.getString(1);
                respuesta[1] = resultado.getString(2);
                respuesta[2] = resultado.getString(3);
                respuesta[3] = resultado.getString(5);
                modeloMan.addRow(respuesta);
            } //Fin del while
            st.close();
            tablaMan.setModel(modeloMan);
        } catch (SQLException ex) {
            Logger.getLogger(ManualidadForm.class.getName()).log(Level.SEVERE, null, ex);
        } //fin del try-catch

    } // fin del procedimiento

    /**
     * Este metodo carga desde la base de datos el objeto blob que es una imagen
     * por medio de un flujo
     *
     * @param clave es un entero que es la clave del objeto a buscar
     */
    private void traerFoto(String clave) {
        String consulta = "SELECT foto FROM manualidad WHERE codmanualidad=" + clave;
        InputStream imagenLeida = null;
        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery(consulta);
            if (resultado.next()) {
                imagenLeida = resultado.getBinaryStream(1);
                BufferedImage aux = ImageIO.read(imagenLeida);

                // aux.getScaledInstance(fotoMan.getWidth(), fotoMan.getHeight(), Image.SCALE_DEFAULT);
                if (aux != null) {
                    fotoMan.setIcon(new ImageIcon(aux.getScaledInstance(fotoMan.getWidth(), fotoMan.getHeight(), Image.SCALE_DEFAULT)));
                } else {
                    fotoMan.setIcon(null);
                }//fin del if interno

                fotoMan.updateUI();
            }// fin del if externo
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManualidadForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManualidadForm.class.getName()).log(Level.SEVERE, null, ex);
        } //fin del try-catch

    } //fin del metodo

    /**
     * Limpia el formulario manualidades y la prepara para empezar a funcionar
     */
    private void limpiarManualidades() {
        botonNuevo.setEnabled(true);
        botonBuscar.setEnabled(true);
        botonGuardar.setEnabled(false);
        botonActualizar.setEnabled(false);
        nombreMan.setText("");
        tiempoMan.setText("");
        rutaFoto.setText("");
        ObservacionesMan.setText("");
        nombreMan.setEnabled(false);
        tiempoMan.setEnabled(false);
        rutaFoto.setEnabled(false);
        ObservacionesMan.setEnabled(false);
        tablaMan.setEnabled(true);
        tablaMan.setVisible(true);
        notaManBuscar.setText("");
        notaManModificar.setText("");
        botonFoto.setEnabled(false);
        fotoMan.setIcon(null);

    }//fin del metodo

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
        opcionModificar = new javax.swing.JMenuItem();
        opcionBorrar = new javax.swing.JMenuItem();
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
        nombreMan = new javax.swing.JTextField();
        tiempoMan = new javax.swing.JTextField();
        rutaFoto = new javax.swing.JTextField();
        ObservacionesMan = new javax.swing.JTextField();
        botonNuevo = new javax.swing.JButton();
        errorTel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMan = new javax.swing.JTable();
        notaManBuscar = new javax.swing.JLabel();
        notaManModificar = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JButton();
        marcoFoto = new javax.swing.JPanel();
        fotoMan = new javax.swing.JLabel();
        botonFoto = new javax.swing.JButton();
        label1 = new java.awt.Label();
        botonAtras = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

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

        jLabel2.setText("Tiempo (min)");

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("foto");

        jLabel4.setText("Observaciones");

        nombreMan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreManFocusGained(evt);
            }
        });
        nombreMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreManActionPerformed(evt);
            }
        });
        nombreMan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreManKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreManKeyReleased(evt);
            }
        });

        tiempoMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiempoManActionPerformed(evt);
            }
        });
        tiempoMan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tiempoManKeyReleased(evt);
            }
        });

        rutaFoto.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                rutaFotoInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        rutaFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutaFotoActionPerformed(evt);
            }
        });
        rutaFoto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rutaFotoKeyReleased(evt);
            }
        });

        ObservacionesMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObservacionesManActionPerformed(evt);
            }
        });
        ObservacionesMan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ObservacionesManKeyReleased(evt);
            }
        });

        botonNuevo.setText("Nuevo");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        errorTel.setForeground(new java.awt.Color(255, 51, 51));

        tablaMan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaMan.setComponentPopupMenu(jPopupMenu1);
        tablaMan.setEnabled(false);
        jScrollPane2.setViewportView(tablaMan);

        notaManBuscar.setForeground(new java.awt.Color(0, 51, 255));

        notaManModificar.setForeground(new java.awt.Color(51, 255, 0));

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        marcoFoto.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout marcoFotoLayout = new javax.swing.GroupLayout(marcoFoto);
        marcoFoto.setLayout(marcoFotoLayout);
        marcoFotoLayout.setHorizontalGroup(
            marcoFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        marcoFotoLayout.setVerticalGroup(
            marcoFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoMan, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        botonFoto.setText("Seleccionar foto");
        botonFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(notaManModificar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(botonNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(184, 184, 184)
                        .addComponent(errorTel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(nombreMan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(tiempoMan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(rutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(botonFoto))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ObservacionesMan, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notaManBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(marcoFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(305, 305, 305))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(marcoFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notaManBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nombreMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tiempoMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonFoto))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ObservacionesMan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(errorTel))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonNuevo)
                            .addComponent(botonBuscar)
                            .addComponent(botonGuardar)
                            .addComponent(botonCancelar)
                            .addComponent(botonActualizar))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notaManModificar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manualidades", jPanel7);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(253, 181, 142));
        label1.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        label1.setForeground(new java.awt.Color(167, 91, 91));
        label1.setText("El desvan de Mika");

        botonAtras.setText("Menú Ficheros");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(639, Short.MAX_VALUE)
                .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
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
     * Este es el boton que nos devulve al menú de archivos
     *
     */
    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed

        MenuFicheros mp = new MenuFicheros();
        mp.setLocationRelativeTo(null);
        mp.setVisible(true);
        dispose();

    }//GEN-LAST:event_botonAtrasActionPerformed

    /**
     * El metodo modificar, primero comprueba que hay una fila seleccionada,
     * luego carga en el formulario desde la base de datos y se prepara para
     * modificar.
     *
     */
    private void opcionModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionModificarActionPerformed
        int fila;
        fila = tablaMan.getSelectedRow();
        if (fila >= 0) {

            ClavePrincipal = tablaMan.getValueAt(fila, 0).toString();
            nombreMan.setText(tablaMan.getValueAt(fila, 1).toString());
            tiempoMan.setText(tablaMan.getValueAt(fila, 2).toString());
            ObservacionesMan.setText(tablaMan.getValueAt(fila, 3).toString());
            traerFoto(ClavePrincipal);
            botonActualizar.setEnabled(true);
            botonFoto.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(null, "seleccione la linea con el botón izquierdo");
        }// fin del if-else 
    }//GEN-LAST:event_opcionModificarActionPerformed
    /**
     * El metodo borrar, primero comprueba que hay una fila seleccionada, luego
     * carga en el formulario desde la base de datos y se pregunta si queremos
     * borrarlo, si estamos de acuerdo lo borra
     */
    private void opcionBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionBorrarActionPerformed
        int fila;
        int respuesta;
        String clave;
        String nombre;
        String orden;
        fila = tablaMan.getSelectedRow();
        if (fila >= 0) {
            clave = tablaMan.getValueAt(fila, 0).toString();
            nombre = tablaMan.getValueAt(fila, 1).toString();
            respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar " + nombre + "?");
            if (respuesta == 0) {
                orden = "DELETE FROM manualidad WHERE codmanualidad=" + clave;
                try {
                    java.sql.PreparedStatement comando = cn.prepareStatement(orden);
                    comando.executeUpdate();
                    comando.close();
                    DefaultTableModel modeloMan = new DefaultTableModel();
                    mostrarTablaMan(modeloMan);
                    buscaMan("nombre", "");

                } catch (SQLException ex) {
                    Logger.getLogger(ManualidadForm.class.getName()).log(Level.SEVERE, null, ex);
                } //fin del try-catch

            } // fin del if interno
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila pinchando con el boton izq");
        } //fin del if externo
    }//GEN-LAST:event_opcionBorrarActionPerformed
    /**
     *
     *
     */
    private void jTabbedPane1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusLost
        limpiarManualidades();
    }//GEN-LAST:event_jTabbedPane1FocusLost

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        limpiarManualidades();
    }//GEN-LAST:event_jTabbedPane1FocusGained
    /**
     * Este boton crea un filtro de archivo para que solo salgan las imagenes
     * con jfilechooser cargo la imagen y a traves de un flujo y de la clase
     * Image la imprimo en pantalla
     *
     */
    private void botonFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFotoActionPerformed
        File archivo;
        int respuesta;
        FileNameExtensionFilter imagenes = new FileNameExtensionFilter("Sólo fotos", "jpg", "jpeg", "png");
        JFileChooser abrirArchivo = new JFileChooser();
        abrirArchivo.setFileFilter(imagenes);
        respuesta = abrirArchivo.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            archivo = abrirArchivo.getSelectedFile();
            rutaFoto.setText(archivo.getAbsolutePath());

            try {
                this.fotoBlob = new FileInputStream(archivo);
                this.longitudBytes = (int) archivo.length();

                Image foto = getToolkit().getImage(rutaFoto.getText());
                foto = foto.getScaledInstance(fotoMan.getWidth(), fotoMan.getHeight(), Image.SCALE_DEFAULT);
                fotoMan.setIcon(new ImageIcon(foto));
                fotoMan.updateUI();

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al capturar el archivo");
            } //fin del try catch
        } //fin del if
    }//GEN-LAST:event_botonFotoActionPerformed
    /**
     * Boton actualizar modifica el objeto con la clave principal, los nuevos
     * datos que hemos introducido por el formulario
     *
     */
    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed

        int resultado;
        StringBuffer aux = new StringBuffer("");
        String orden;
        aux.append("UPDATE manualidad SET ");
        aux.append("nombre='" + u.mayusculas(nombreMan.getText()) + "', ");
        aux.append("tiempo=" + tiempoMan.getText() + ", ");
        aux.append("observaciones='" + ObservacionesMan.getText().toUpperCase() + "'");
        if (!rutaFoto.getText().equals("")) {
            aux.append(", Foto=?");
        } //fin del if que comprueba si se ha hecho algun cambio en la foto
        aux.append(" where codmanualidad=" + ClavePrincipal);
        orden = aux.toString();
        try {
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(orden);
            if (!rutaFoto.getText().equals("")) {
                ps.setBinaryStream(1, fotoBlob, longitudBytes);
            } //fin del if que introduce la nueva foto en la base de datos

            resultado = ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Actualizado con Exito");
            ManualidadComponentes mc = new ManualidadComponentes(Integer.valueOf(ClavePrincipal), nombreMan.getText().toUpperCase());
            mc.setLocationRelativeTo(null);
            mc.setEnabled(true);
            mc.setVisible(true);
            limpiarManualidades();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } //fin del try-catch

    }//GEN-LAST:event_botonActualizarActionPerformed
    /**
     * El boton nuevo prepara el formulario para introducir los objetos
     *
     */
    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        botonGuardar.setEnabled(true);
        botonBuscar.setEnabled(false);
        botonNuevo.setEnabled(false);
        nombreMan.setEnabled(true);
        tiempoMan.setEnabled(true);
        rutaFoto.setEnabled(true);
        ObservacionesMan.setEnabled(true);
        botonFoto.setEnabled(true);
        nombreMan.requestFocus();
    }//GEN-LAST:event_botonNuevoActionPerformed
    /**
     * Este "escuchador" se ejecuta al soltar una tecla y lo que hace es quitar
     * los espacios inutiles de observaciones
     *
     */
    private void ObservacionesManKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ObservacionesManKeyReleased
        String texto;
        texto = ObservacionesMan.getText().trim();

        buscaMan("observaciones", texto);        // TODO add your handling code here:
    }//GEN-LAST:event_ObservacionesManKeyReleased

    private void ObservacionesManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObservacionesManActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ObservacionesManActionPerformed

    private void rutaFotoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rutaFotoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_rutaFotoKeyReleased

    private void rutaFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutaFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutaFotoActionPerformed

    private void rutaFotoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_rutaFotoInputMethodTextChanged

    }//GEN-LAST:event_rutaFotoInputMethodTextChanged

    private void tiempoManKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tiempoManKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tiempoManKeyReleased

    private void tiempoManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiempoManActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tiempoManActionPerformed
    /**
     * Este evento busca lo que se va escribiendoen el campo nombre y lo busca
     * por
     *
     */
    private void nombreManKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreManKeyReleased
        String texto;
        texto = u.mayusculas(nombreMan.getText());

        buscaMan("nombre", texto);        // TODO add your handling code here:
    }//GEN-LAST:event_nombreManKeyReleased

    private void nombreManKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreManKeyPressed

    }//GEN-LAST:event_nombreManKeyPressed

    private void nombreManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreManActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreManActionPerformed

    private void nombreManFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreManFocusGained

    }//GEN-LAST:event_nombreManFocusGained

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        limpiarManualidades();
    }//GEN-LAST:event_botonCancelarActionPerformed
    /**
     * boton guardar lo que hace preparar los datos para el insert y los inserta
     *
     */
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        int clave;
        int resultado;
        String orden;
        orden = "INSERT INTO manualidad (nombre, tiempo, foto, observaciones) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(orden, java.sql.PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, u.mayusculas(nombreMan.getText()));
            ps.setString(2, tiempoMan.getText());
            ps.setBlob(3, fotoBlob, longitudBytes);
            ps.setString(4, ObservacionesMan.getText().toUpperCase());
            resultado = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            clave = rs.getInt(1);
            ps.close();
            JOptionPane.showMessageDialog(null, "Guardado con Exito");
            fotoBlob.close();
            ManualidadComponentes mc = new ManualidadComponentes(clave, nombreMan.getText().toUpperCase());
            mc.setLocationRelativeTo(null);
            mc.setEnabled(true);
            mc.setVisible(true);
            limpiarManualidades();
           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(ManualidadForm.class.getName()).log(Level.SEVERE, null, ex);
        } //fin del try-catch

    }//GEN-LAST:event_botonGuardarActionPerformed
    /**
     * El Boton buscar prepara todos los botones para poder buscar
     *
     */
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        botonGuardar.setEnabled(false);
        botonNuevo.setEnabled(false);
        nombreMan.setEnabled(true);
        tiempoMan.setEnabled(true);
        rutaFoto.setEnabled(true);
        ObservacionesMan.setEnabled(true);
        notaManBuscar.setText("<-- introduzca una palabra");
        notaManModificar.setText("pulse boton derecho para modificar o suprimir");
        nombreMan.requestFocus();
        DefaultTableModel modeloMan = new DefaultTableModel();
        mostrarTablaMan(modeloMan);
        buscaMan("nombre", "");
    }//GEN-LAST:event_botonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ObservacionesMan;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonFoto;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JLabel errorTel;
    private javax.swing.JLabel fotoMan;
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
    private javax.swing.JPanel marcoFoto;
    private javax.swing.JTextField nombreMan;
    private javax.swing.JLabel notaManBuscar;
    private javax.swing.JLabel notaManModificar;
    private javax.swing.JMenuItem opcionBorrar;
    private javax.swing.JMenuItem opcionModificar;
    private javax.swing.JTextField rutaFoto;
    private javax.swing.JTable tablaMan;
    private javax.swing.JTextField tiempoMan;
    // End of variables declaration//GEN-END:variables
}
