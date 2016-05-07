/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import static Principal.DesvanMika.cn;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Esta es la clase que controla los pedidos, y maneja varias tablas a la vez
 *
 * @author Josete
 */
public class PedidoForm extends javax.swing.JFrame {

    /**
     * Crea la ventana pedido, limpiar todo y bloquea cambia iconos y titulo
     */
    public PedidoForm() {

        initComponents();
        limpiar();

        setTitle("Pedidos-Desvan de Mika");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.jpg"));
        setIconImage(icon);
        bloquearTodo();
        botonNuevo.requestFocus();
    }

    /**
     * Este metodo lo que hace es limpiar el formulario
     *
     */
    private void limpiar() {
        pedidoN.setEnabled(false);
        pedidoN.setText("");
        lineas.setEnabled(false);
        buscarCliBoton.setEnabled(true);
        cliApellidos.setEnabled(false);
        cliApellidos.setText("");
        cliDirecc.setEnabled(false);
        cliDirecc.setText("");
        cliNombre.setEnabled(false);
        cliNombre.setText("");
        cliTelefono.setEnabled(false);
        cliTelefono.setText("");
        clienteN.setEnabled(true);
        clienteN.setText("");
        botonBuscar.setEnabled(true);

    }

    /**
     * Este metodo lo que hace es dada la clave principal recupera los datos del
     * cliente de no encontrarlo daria el error no existe
     */
    private void llenacliente() {
        String consulta;
        consulta = "SELECT nombre, apellido, direccion, telefono FROM cliente where idcliente=" + clienteN.getText();
        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery(consulta);
            resultado.next();
            cliNombre.setText(resultado.getString(1));
            cliApellidos.setText(resultado.getString(2));
            cliDirecc.setText(resultado.getString(3));
            cliTelefono.setText(resultado.getString(4));
            st.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El cliente no exite");
        }//try-catch
    }// fin del procedimiento

    /**
     * muestra la tabla de pedidos
     */
    private void muestraTablaPedido() {
        String consulta;
        String respuesta[] = new String[4];

        tablaPedidos.setEnabled(true);
        tablaPedidos.setVisible(true);
        DefaultTableModel tcm = new DefaultTableModel();
        tcm.addColumn("Pedido");
        tcm.addColumn("Cod. Manualidad");
        tcm.addColumn("Nombre");
        tcm.addColumn("Cantidad");
        tablaPedidos.setModel(tcm);

        consulta = "select lineaspedido.PEDIDO_Npedido, lineaspedido.MANUALIDAD_codManualidad, manualidad.Nombre, lineaspedido.cantidad\n"
                + "from lineaspedido, manualidad\n"
                + "where  (manualidad.codManualidad=lineaspedido.MANUALIDAD_codManualidad)";

        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery(consulta);
            while (resultado.next()) {
                respuesta[0] = resultado.getString(1);
                respuesta[1] = resultado.getString(2);
                respuesta[2] = resultado.getString(3);
                respuesta[3] = resultado.getString(4);

                tcm.addRow(respuesta);
            }// fin del while
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ColoresForm.class.getName()).log(Level.SEVERE, null, ex);
        } // fin del try-catch

    } // fin del procedimiento

    /**
     * Este metodo simplemente bloquea todo
     */
    public void bloquearTodo() {
        pedidoN.setEnabled(false);
        clienteN.setEnabled(false);
        fechaPedido.setEnabled(false);
        FechaEntrega.setEnabled(false);
        entregado.setEnabled(false);
        precio.setEnabled(false);
        buscarCliBoton.setEnabled(false);
    }

    /**
     * Este metodo simplemente desbloquea todo
     */
    public void desbloquearTodo() {

        clienteN.setEnabled(true);
        fechaPedido.setEnabled(true);
        FechaEntrega.setEnabled(true);
        entregado.setEnabled(true);
        precio.setEnabled(true);
        buscarCliBoton.setEnabled(true);
        lineas.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        clienteN = new javax.swing.JTextField();
        pedidoN = new javax.swing.JTextField();
        buscarCliBoton = new java.awt.Button();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cliNombre = new javax.swing.JTextField();
        cliApellidos = new javax.swing.JTextField();
        cliTelefono = new javax.swing.JTextField();
        cliDirecc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        botonNuevo = new javax.swing.JButton();
        entregado = new javax.swing.JCheckBox();
        lineas = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        fechaPedido = new com.toedter.calendar.JDateChooser();
        FechaEntrega = new com.toedter.calendar.JDateChooser();
        panelAyuda = new javax.swing.JPanel();
        menuBoton = new javax.swing.JButton();
        panelPedido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();

        jMenuItem1.setForeground(new java.awt.Color(255, 0, 0));
        jMenuItem1.setText("BORRAR");
        jMenuItem1.setComponentPopupMenu(jPopupMenu1);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(167, 91, 91));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(253, 181, 142));
        label1.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        label1.setForeground(new java.awt.Color(167, 91, 91));
        label1.setText("El desvan de Mika");

        jLabel1.setText("Pedido número");

        jLabel2.setText("Cliente número:");

        clienteN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                clienteNFocusLost(evt);
            }
        });
        clienteN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                clienteNKeyTyped(evt);
            }
        });

        pedidoN.setText("0");

        buscarCliBoton.setLabel("Buscar Cliente");
        buscarCliBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCliBotonActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellidos");

        jLabel5.setText("Telefono");

        jLabel6.setText("Direccion");

        cliNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliNombreActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha Pedido");

        jLabel8.setText("Entrega");

        jLabel9.setText("Precio Presupuestado");

        botonNuevo.setText("Nuevo Pedido");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        entregado.setText("Entregado");

        lineas.setText("Introducir lineas pedido");
        lineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineasActionPerformed(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lineas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pedidoN, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cliNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                    .addComponent(cliTelefono)
                                    .addComponent(fechaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cliDirecc))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(clienteN, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(buscarCliBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cliApellidos)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(FechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(20, 20, 20)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(entregado)))))))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buscarCliBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(pedidoN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clienteN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(cliNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cliApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(cliTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cliDirecc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(entregado)
                            .addComponent(FechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(fechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(precio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(lineas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelAyudaLayout = new javax.swing.GroupLayout(panelAyuda);
        panelAyuda.setLayout(panelAyudaLayout);
        panelAyudaLayout.setHorizontalGroup(
            panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
        );
        panelAyudaLayout.setVerticalGroup(
            panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        menuBoton.setText("Menú Principal");
        menuBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBotonActionPerformed(evt);
            }
        });

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaPedidos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tablaPedidos);

        javax.swing.GroupLayout panelPedidoLayout = new javax.swing.GroupLayout(panelPedido);
        panelPedido.setLayout(panelPedidoLayout);
        panelPedidoLayout.setHorizontalGroup(
            panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panelPedidoLayout.setVerticalGroup(
            panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(menuBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(menuBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Este boton saca un listado de clientes y le devuelve el foco al clienteN
     *
     */
    private void buscarCliBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCliBotonActionPerformed
        ListaClientes lc = new ListaClientes();
        PedidoForm.panelAyuda.add(lc);

        lc.setEnabled(true);
        lc.setVisible(true);
        lc.toFront();
        clienteN.requestFocus();


    }//GEN-LAST:event_buscarCliBotonActionPerformed

    private void cliNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cliNombreActionPerformed


    private void clienteNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clienteNKeyTyped

    }//GEN-LAST:event_clienteNKeyTyped

    /**
     * Al pulsar el boton Nuevo, prepara el formulario
     *
     */
    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        desbloquearTodo();
        buscarCliBoton.requestFocus();
        pedidoN.setText("NUEVO");
        botonBuscar.setEnabled(false);

    }//GEN-LAST:event_botonNuevoActionPerformed

    /**
     * Cierra la ventana
     *
     */
    private void menuBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBotonActionPerformed

        dispose();
    }//GEN-LAST:event_menuBotonActionPerformed
    /**
     * Al perder el foco llena el cliente col los datos
     *
     */
    private void clienteNFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clienteNFocusLost
        llenacliente();
    }//GEN-LAST:event_clienteNFocusLost

    private void lineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineasActionPerformed

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            StringBuffer orden = new StringBuffer("INSERT INTO pedido (cliente_idcliente, fecha_pedido, fecha_entrega, precio, entregado) VALUES ('");
            int clave = 0;
            orden.append(clienteN.getText() + "', '");
            orden.append(sdf.format(fechaPedido.getDate()) + "', '");
            orden.append(sdf.format(FechaEntrega.getDate()) + "', ");
            orden.append(precio.getText() + ", ");
            int convierteEntero = (entregado.isSelected()) ? 1 : 0;
            orden.append(convierteEntero + ")");

            try {
                PreparedStatement pst = (PreparedStatement) cn.prepareStatement(orden.toString(), java.sql.PreparedStatement.RETURN_GENERATED_KEYS);
                pst.executeUpdate();
                ResultSet rs = pst.getGeneratedKeys();
                rs.next();
                clave = rs.getInt(1);
                pst.close();
                pedidoN.setText(String.valueOf(clave));
                ListadoManualidades lm = new ListadoManualidades();
                lm.setEnabled(true);
                lm.setVisible(true);
                LineasPedido lp = new LineasPedido(clave);
                lp.setLocationRelativeTo(null);
                lp.setEnabled(true);
                lp.setVisible(true);
                limpiar();

            } catch (SQLException ex) {
                Logger.getLogger(MaterialForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al guardar, compruebe que relleno todos los daton en azul");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(rootPane, "Introduzca todos los datos");
            desbloquearTodo();
        }


    }//GEN-LAST:event_lineasActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed

        muestraTablaPedido();
    }//GEN-LAST:event_botonBuscarActionPerformed


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int fila; ///////////////////////////////modificar/////////////////////////////////////////////
        int respuesta;
        String nombre;
        String orden;
        fila = tablaPedidos.getSelectedRow();

        if (fila >= 0) {
            nombre = "la manualidad " + tablaPedidos.getValueAt(fila, 1).toString() + " del pedido " + tablaPedidos.getValueAt(fila, 0).toString();
            String clavePrincipalSalvada = tablaPedidos.getValueAt(fila, 0).toString() + "," + tablaPedidos.getValueAt(fila, 1).toString();
            respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar a " + nombre + "?");
            if (respuesta == 0) {
                orden = "delete from lineaspedido where (PEDIDO_Npedido,MANUALIDAD_codManualidad) = (" + clavePrincipalSalvada + ")";
                try {
                    java.sql.PreparedStatement comando = cn.prepareStatement(orden);
                    comando.executeUpdate();
                    comando.close();
                    muestraTablaPedido();

                } catch (SQLException ex) {
                    Logger.getLogger(ClientesForm.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila pinchando con el boton izq");
        }
        muestraTablaPedido();
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaEntrega;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonNuevo;
    private java.awt.Button buscarCliBoton;
    private javax.swing.JTextField cliApellidos;
    private javax.swing.JTextField cliDirecc;
    private javax.swing.JTextField cliNombre;
    private javax.swing.JTextField cliTelefono;
    private javax.swing.JTextField clienteN;
    private javax.swing.JCheckBox entregado;
    private com.toedter.calendar.JDateChooser fechaPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JButton lineas;
    private javax.swing.JButton menuBoton;
    public static javax.swing.JPanel panelAyuda;
    private javax.swing.JPanel panelPedido;
    private javax.swing.JTextField pedidoN;
    private javax.swing.JTextField precio;
    private javax.swing.JTable tablaPedidos;
    // End of variables declaration//GEN-END:variables
}
