/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import com.mysql.jdbc.PreparedStatement;
import desvanmika.Conectar;
import desvanmika.proveedor;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase se encarga de gestionar la venana principal
 * declaramos las claves de conexion para que se pueda conectar y desconectar
 * en cualquier momento.
 * @author Josete
 */
public class Principal extends javax.swing.JFrame {
    public Conectar cc;
    public Connection cn;
    public String clavePrincipalSalvada=""; // esta es una variable auxiliar que vale para todas las actualizaciones de datos
    /**
     * 
     * @param telefono
     * Recibe un texto que pretende ser un telefono y lo que hace el metodo
     * es limpiar de cualquier caracter.
     */
    private String checkTel (String telefono){
        
        StringBuffer telLimpio = new StringBuffer("");
        for (int aux=0;aux<telefono.length();aux++){
            if (telefono.charAt(aux)>='0' && telefono.charAt(aux)<='9'){
                telLimpio.append(""+telefono.charAt(aux));
            }//fin del if
            
        } //fin del for
    return(telLimpio.toString());
} //fin del metodo
    
    /**
     * Cambia el texto a mayusculas sin acentos ni signos ni espacios
     * @param texto
     * @return 
     */
     public String mayusculas (String texto){
    char letra;
    String palabra;
    StringBuffer textoFinal = new StringBuffer("");
    StringTokenizer aux= new StringTokenizer(texto.trim());
    while (aux.hasMoreTokens()){
        palabra=aux.nextToken().toUpperCase();
        for(int cont=0; cont<palabra.length();cont++){
            letra =palabra.charAt(cont);
            if (letra>='A' && letra<='Z'){
                textoFinal.append(letra);
            } else {
                switch (letra){
                    case 'Á': textoFinal.append('A');break;
                    case 'É': textoFinal.append('E');break;
                    case 'Í': textoFinal.append('I');break;
                    case 'Ó': textoFinal.append('O');break;
                    case 'Ú': textoFinal.append('U');break;
                    case 'Ñ': textoFinal.append('Ñ');break;
                    }// fin case
                    
                    }//Fin del if-else
            
        }//Fin del For
        textoFinal.append(" ");
    }//fin del while
    return (textoFinal.toString().trim());
}//fin del procedimiento
     
     /**
      * Al pulsar el boton busqueda de proveedores, prepara la tabla para ver los resultados
      */
     private void mostrarTablaPro(){
        tablaPro.setEnabled(true);
        tablaPro.setVisible(true);
         DefaultTableModel modeloPro = new DefaultTableModel();
         modeloPro.addColumn("Nombre");
         modeloPro.addColumn("Dirección");
         modeloPro.addColumn("Teléfono");
         modeloPro.addColumn("Contacto");
         tablaPro.setModel(modeloPro);
         
         
     }
     
     private void buscaPro(String campo, String texto){
         String consulta;
         String respuesta[] = new String[4];
         consulta= "SELECT * FROM PROVEEDOR WHERE "+campo+" like'%"+texto+"%'";
         DefaultTableModel modeloPro = new DefaultTableModel();
         modeloPro.addColumn("Nombre");
         modeloPro.addColumn("Dirección");
         modeloPro.addColumn("Teléfono");
         modeloPro.addColumn("Contacto");
         tablaPro.setModel(modeloPro);
        try {
            Statement st = cn.createStatement();
            ResultSet resultado =st.executeQuery(consulta);
            while(resultado.next()){
                respuesta[0]=resultado.getString(1);
                respuesta[1]=resultado.getString(2);
                respuesta[2]=resultado.getString(3);
                respuesta[3]=resultado.getString(4); 
                modeloPro.addRow(respuesta);
            } //Fin del while
            tablaPro.setModel(modeloPro);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         
         
         
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
    
    public Principal() {
        
        initComponents();
        cc =new Conectar();
        cn=cc.conexion();
        setTitle("Principal-Desvan de Mika");
        Image icon = new ImageIcon(getClass().getResource("/Formularios/icono.jpg")).getImage();
        setIconImage(icon);
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
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
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

        jMenuItem1.setText("Modificar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setForeground(new java.awt.Color(255, 51, 51));
        jMenuItem2.setText("ELIMINAR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(167, 91, 91));

        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Clientes", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Pedidos", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Manualidades", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Componentes", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Materiales", jPanel6);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Listados", jPanel8);

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
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notaProBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jButton1.setText("Desconectar y salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(411, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    cc.cerrar();
        try {
        cn.close();    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error en la desconexión", 5);
        }
        
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

   
    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        limpiarProveedores();
     
    }//GEN-LAST:event_jTabbedPane1FocusGained

    

    private void jTabbedPane1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusLost
       limpiarProveedores();
    }//GEN-LAST:event_jTabbedPane1FocusLost
//la accion1 es modificar
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int fila;
        fila=tablaPro.getSelectedRow();
        if (fila>=0) {
            nombrePro.setText(tablaPro.getValueAt(fila, 0).toString());
            direccionPro.setText(tablaPro.getValueAt(fila, 1).toString());
            telefonoPro.setText(tablaPro.getValueAt(fila,2).toString());
            contactoPro.setText(tablaPro.getValueAt(fila,3).toString());
            botonActualizar.setEnabled(true);
            
        } else {
            JOptionPane.showMessageDialog(null, "seleccione la linea con el botón izquierdo");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        botonGuardar.setEnabled(true);
        botonBuscar.setEnabled(false);
        botonNuevo.setEnabled(false);
        nombrePro.setEnabled(true);
        direccionPro.setEnabled(true);
        telefonoPro.setEnabled(true);
        contactoPro.setEnabled(true);
        nombrePro.requestFocus();
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void contactoProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactoProKeyReleased
        String texto;
        texto=contactoPro.getText().trim();

        buscaPro("persona_contacto",texto);        // TODO add your handling code here:
    }//GEN-LAST:event_contactoProKeyReleased

    private void contactoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactoProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactoProActionPerformed

    private void telefonoProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoProKeyReleased
        String texto;
        texto=checkTel(telefonoPro.getText());
        buscaPro("telefono",texto);        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoProKeyReleased

    private void telefonoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoProActionPerformed

    private void telefonoProInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_telefonoProInputMethodTextChanged

    }//GEN-LAST:event_telefonoProInputMethodTextChanged

    private void direccionProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionProKeyReleased
        String texto;
        texto=direccionPro.getText().trim();

        buscaPro("direccion",texto);        // TODO add your handling code here:
    }//GEN-LAST:event_direccionProKeyReleased

    private void direccionProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionProActionPerformed

    private void nombreProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProKeyReleased
        String texto;
        texto=nombrePro.getText().trim();

        buscaPro("nombre",texto);        // TODO add your handling code here:
    }//GEN-LAST:event_nombreProKeyReleased

    private void nombreProKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProKeyPressed

    }//GEN-LAST:event_nombreProKeyPressed

    private void nombreProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreProActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        limpiarProveedores();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        String tel;
        tel=telefonoPro.getText();
        telefonoPro.setText(this.checkTel(tel)); //checkTel limpia la cadena de telefono y deja solo los numeros
        if (telefonoPro.getText().length()==9){
            errorTel.setText("");
            // la funcion mayusculas devuelve el texto sin simbolos y en mayusculas
            proveedor p= new proveedor(mayusculas(nombrePro.getText()),mayusculas(direccionPro.getText()),Integer.parseInt(telefonoPro.getText()),mayusculas(contactoPro.getText()));
            nombrePro.setText(p.getNombre());
            direccionPro.setText(p.getDireccion());
            contactoPro.setText(p.getContacto());

            try {
                java.sql.PreparedStatement pps = cn.prepareStatement("INSERT INTO proveedor(nombre, direccion, telefono, persona_contacto) VALUES(?,?,?,?)");
                pps.setString(1, p.getNombre());
                pps.setString(2, p.getDireccion());
                pps.setInt(3, p.getTelefono());
                pps.setString(4,p.getContacto());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado con exito");
                limpiarProveedores();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }

        } else
        { errorTel.setText("<---tiene que tener 9 digitos");

        } // fin del if
    }//GEN-LAST:event_botonGuardarActionPerformed

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
        buscaPro("nombre","");

    }//GEN-LAST:event_botonBuscarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int fila;
        int respuesta;
        String nombre;
        String orden;
        fila=tablaPro.getSelectedRow();
        if (fila<=0){
            nombre = tablaPro.getValueAt(0,fila).toString();
        respuesta=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar "+nombre+"?");
        if (respuesta==0){
            orden="DELETE FROM proveedor WHERE nombre='"+nombre+"'";
                try {
                    java.sql.PreparedStatement comando= cn.prepareStatement(orden);
                    comando.executeUpdate();
                    mostrarTablaPro();
                    buscaPro("nombre","");
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila pinchando con el boton izq");
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void nombreProFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreProFocusGained
        if (! nombrePro.getText().equals("")){
            clavePrincipalSalvada=nombrePro.getText();
        }
    }//GEN-LAST:event_nombreProFocusGained

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        String clave;
        String orden;
        if (clavePrincipalSalvada.equals("")){ //Si el campo nombre(la clave principal) no se ha tocado
            clave=nombrePro.getText();
        } else
        {
            clave=clavePrincipalSalvada;
        }
        orden="UPDATE proveedor SET nombre='"+nombrePro.getText()+"',direccion='"+direccionPro.getText()+"',telefono='"+telefonoPro.getText()+"',persona_contacto='"+contactoPro.getText()+"' where nombre='"+clave+"'";
        try {
            PreparedStatement stm = (PreparedStatement) cn.prepareStatement(orden);
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        clavePrincipalSalvada="";
        limpiarProveedores();
       
    }//GEN-LAST:event_botonActualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JTextField contactoPro;
    private javax.swing.JTextField direccionPro;
    private javax.swing.JLabel errorTel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private javax.swing.JTextField nombrePro;
    private javax.swing.JLabel notaProBuscar;
    private javax.swing.JLabel notaProModificar;
    private javax.swing.JTable tablaPro;
    private javax.swing.JTextField telefonoPro;
    // End of variables declaration//GEN-END:variables
}
