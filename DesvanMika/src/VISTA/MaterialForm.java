package VISTA;

import static Principal.DesvanMika.cn;
import java.awt.Color;
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

/**
 * Esta clase se encarga de manejar la tabla material, que viene a ser una clase
 * abstracta ya que hay que instanciarla a traves de una de los hijos, tela,
 * fieltro, etc.
 *
 * @author Josete
 */
public class MaterialForm extends javax.swing.JFrame {

    /**
     * aux apuntara a la ventana auxiliar
     */
    private JFrame aux;  //ejemplo de polimorfismo

    /**
     * Crea la ventana materiales y prepara los botones para meter datos.
     */
    public MaterialForm() {
        initComponents();
        muestraProveedores();
        setTitle("Materiales - Desvan de Mika");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.jpg"));
        setIconImage(icon);
        bloqueaBotones();
        bloqueaCaracteristicas();
    } // fin del metodo

    /**
     * Este metodo es llamado por el boton guardar para mirar que clase de
     * material es y guardarlo en la tabla correspondiente
     *
     * @param clave este parametro indica la clave principal de Material que
     * propagamos al tipo que sea
     */
    private void subTabla(int clave) {
        StringBuffer orden = new StringBuffer("");
        switch (tipoMat.getSelectedIndex()) { // dedendiendo del tipo material elejido guarde en la tabla correspondiente
            case 1:
                orden.append("INSERT INTO abalorio (material_codmaterial, hecho_de, tamaño, forma) Values (" + String.valueOf(clave) + ",'");
                orden.append(Hechode.getSelectedItem().toString() + "', '");
                orden.append(tamaño.getSelectedItem().toString() + "', '");
                orden.append(forma.getText().toUpperCase() + "')");
                break;

            case 2:
                orden.append("INSERT INTO arcilla_polimerica (material_codmaterial, cocida) Values (" + String.valueOf(clave) + ",'");
                if (botonSi.isSelected()) {
                    orden.append("1')");
                } else {
                    orden.append("0')");
                }
                break;

            case 3:
                orden.append("INSERT INTO fieltro (material_codmaterial, grosor) Values (" + String.valueOf(clave) + ",'");
                orden.append(grosor.getText() + "')");
                break;

            case 4:
                orden.append("INSERT INTO utileria (material_codmaterial, clase) Values (" + String.valueOf(clave) + ",'");
                orden.append(utileria.getText() + "')");
                break;

            case 5:
                orden.append("INSERT INTO tela (material_codmaterial, estampado, tejido, segundocolor) Values (" + String.valueOf(clave) + ",'");
                orden.append(Estampado.getText() + "', '");
                orden.append(tejido.getText() + "', '");
                orden.append(IdColorEst.getText() + "')");
                break;
        }// fin del switch

        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(orden.toString());
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
            bloqueaBotones();
            bloqueaCaracteristicas();
            aux.dispose();
            tipoMat.setSelectedIndex(0);
        } catch (Exception ex) {
            Logger.getLogger(MaterialForm.class.getName()).log(Level.SEVERE, null, ex);
        } // fin del try-catch // fin del try-catch

    } //fin del metod

    /**
     * Este metodo solo se usa para bloquear los botones y prepara el formulario
     */
    private void bloqueaBotones() {
        jLabel3.setText("Existencias");
        jLabel4.setText("Precio unidad");
        tipoMat.setEnabled(false);
        ProSelect.setEnabled(false);
        IdColor.setText("");
        IdColor.setEnabled(false);
        IdColorEst.setText("");
        IdColorEst.setEnabled(false);
        botonNuevo.setEnabled(true);
        botonCompra.setEnabled(true);
        botonBuscar.setEnabled(true);
        botonActualizar.setEnabled(false);
        botonGuardar.setEnabled(false);
        botonMostrarColor.setEnabled(false);
        cantidad.setText("");
        cantidad.setEnabled(false);
        precio.setText("");
        precio.setEnabled(false);
        grosor.setText("");

        jLabel1.setForeground(Color.gray);
        jLabel2.setForeground(Color.gray);
        jLabel3.setForeground(Color.gray);
        jLabel4.setForeground(Color.gray);

    }

    /**
     * Con este método lo que hacemos es poner todos los letreros en negro y
     * desactivar las características de las bases de datos
     */
    private void bloqueaCaracteristicas() {
        jLabel5.setForeground(Color.gray);
        jLabel6.setForeground(Color.gray);
        jLabel7.setForeground(Color.gray);
        jLabel8.setForeground(Color.gray);
        jLabel9.setForeground(Color.gray);
        jLabel10.setForeground(Color.gray);
        jLabel11.setForeground(Color.gray);
        jLabel12.setForeground(Color.gray);
        jLabel13.setForeground(Color.gray);
        jLabel14.setForeground(Color.gray);
        jLabel15.setText("");
        jLabel16.setForeground(Color.gray);
        Hechode.setEnabled(false);
        tamaño.setEnabled(false);
        forma.setEnabled(false);
        grosor.setEnabled(false);
        botonSi.setEnabled(false);
        botonNo.setEnabled(false);
        utileria.setEnabled(false);
        tejido.setEnabled(false);
        Estampado.setEnabled(false);
        IdColorEst.setEnabled(false);
    }

    /**
     * El procedimiento, hace una consulta a la tabla proveedores y mete todos
     * los datos en el desplegable para que se pueda elegir
     */

    private void muestraProveedores() {
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select nombre from proveedor");
            while (rs.next()) {
                ProSelect.addItem(rs.getString(1));
            } //fin del while
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(MaterialForm.class.getName()).log(Level.SEVERE, null, ex);
        } // fin del try // fin del try

    } // fin del metodo

    /**
     * Este metodo lo llama un "escuchador" que cuando pierde el foco el colorID
     * busca ese dato en la tabla de colores y lo saca por pantalla
     */
    private void llenaColor() {
        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery("SELECT colorprincipal, subcolor FROM color WHERE idcolor=" + IdColor.getText());
            if (resultado.next()) {
                color.setText(resultado.getString(1) + " " + resultado.getString(2));
            } else {
                JOptionPane.showMessageDialog(null, "el color no existe");
            } // fin del if-else
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(MaterialForm.class.getName()).log(Level.SEVERE, null, ex);
        } // fin de try-catch // fin de try-catch
    } // fin del procedimiento

    /**
     * Este metodo se usa para las telas y funciona igual que llenaColor()
     *
     * @see llenaColor
     */
    private void llenaColor2() {
        try {
            Statement st = cn.createStatement();
            ResultSet resultado = st.executeQuery("SELECT colorprincipal, subcolor FROM color WHERE idcolor=" + IdColorEst.getText());
            if (resultado.next()) {
                colorEstampado.setText(resultado.getString(1) + " " + resultado.getString(2));
            } else {
                JOptionPane.showMessageDialog(null, "el color no existe");
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(MaterialForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        arcilla = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        tipoMat = new javax.swing.JComboBox<>();
        botonNuevo = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ProSelect = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        IdColor = new javax.swing.JTextField();
        color = new javax.swing.JTextField();
        botonMostrarColor = new javax.swing.JButton();
        panelAyuda = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        unidad = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Hechode = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tamaño = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        forma = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        grosor = new javax.swing.JTextField();
        botonSi = new javax.swing.JRadioButton();
        botonNo = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        utileria = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tejido = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Estampado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        IdColorEst = new javax.swing.JTextField();
        colorEstampado = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        botonCompra = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(167, 91, 91));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(253, 181, 142));
        label1.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        label1.setForeground(new java.awt.Color(167, 91, 91));
        label1.setText("El desvan de Mika");

        tipoMat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "ABALORIO", "ARCILLA_POLIMERICA", "FIELTRO", "UTILERIA", "TELA" }));
        tipoMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoMatActionPerformed(evt);
            }
        });

        botonNuevo.setText("Crear material");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonSalir.setText("Menu Ficheros");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Proveedor");

        jLabel2.setText("ID color");

        IdColor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IdColorFocusLost(evt);
            }
        });
        IdColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IdColorKeyTyped(evt);
            }
        });

        color.setEnabled(false);

        botonMostrarColor.setText("mostrar colores");
        botonMostrarColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAyudaLayout = new javax.swing.GroupLayout(panelAyuda);
        panelAyuda.setLayout(panelAyudaLayout);
        panelAyudaLayout.setHorizontalGroup(
            panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelAyudaLayout.setVerticalGroup(
            panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        jLabel3.setText("Cantidad en Existencias");

        jLabel4.setText("Precio Unidad");

        precio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                precioFocusLost(evt);
            }
        });
        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jLabel5.setText("Hecho de");

        Hechode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PLASTICO", "CRISTAL", "METAL", "OTROS" }));
        Hechode.setEnabled(false);
        Hechode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HechodeActionPerformed(evt);
            }
        });

        jLabel6.setText("Tamaño");

        tamaño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PEQUEÑO", "MEDIANO", "GRANDE" }));
        tamaño.setEnabled(false);

        jLabel7.setText("Forma");

        forma.setEnabled(false);
        forma.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formaFocusLost(evt);
            }
        });

        jLabel8.setText("Pequeño material");

        jLabel9.setText("Grosor");

        arcilla.add(botonSi);
        botonSi.setText("Si");

        arcilla.add(botonNo);
        botonNo.setText("No");
        botonNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNoActionPerformed(evt);
            }
        });

        jLabel10.setText("¿Para cocer?");

        utileria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                utileriaFocusLost(evt);
            }
        });

        jLabel11.setText("Tejido");

        tejido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tejidoFocusLost(evt);
            }
        });
        tejido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tejidoActionPerformed(evt);
            }
        });

        jLabel12.setText("Estampado");

        Estampado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EstampadoFocusLost(evt);
            }
        });

        jLabel13.setText("Color del ");

        IdColorEst.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IdColorEstFocusLost(evt);
            }
        });
        IdColorEst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IdColorEstKeyTyped(evt);
            }
        });

        colorEstampado.setEnabled(false);

        jLabel14.setText("Estampado");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonActualizar.setText("Mostrar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        jLabel15.setText("   ");

        botonCompra.setText("Meter compra");
        botonCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompraActionPerformed(evt);
            }
        });

        jLabel16.setText("mm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tejido, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(Estampado, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(IdColorEst, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(colorEstampado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(botonNuevo)
                                            .addComponent(jLabel3))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(botonCompra))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(utileria, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(unidad)
                                        .addGap(112, 112, 112)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(21, 21, 21)
                                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(19, 19, 19)
                                                .addComponent(botonActualizar))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(grosor, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel16)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(botonSi)
                                                .addGap(18, 18, 18)
                                                .addComponent(botonNo)))
                                        .addGap(18, 18, 18)
                                        .addComponent(botonCancelar))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(303, 303, 303)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(botonMostrarColor))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Hechode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tipoMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(198, 198, 198)
                                        .addComponent(forma, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ProSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(IdColor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(ProSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(IdColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonMostrarColor)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Hechode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(forma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(utileria, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(grosor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonSi)
                        .addComponent(botonNo)
                        .addComponent(jLabel10))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(tejido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(IdColorEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(colorEstampado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Estampado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unidad)
                    .addComponent(jLabel4)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonNuevo)
                    .addComponent(botonCancelar)
                    .addComponent(botonGuardar)
                    .addComponent(botonBuscar)
                    .addComponent(botonActualizar)
                    .addComponent(botonCompra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
     * Este metodo lee el tipo de material elegido, abre la ventana
     * correspondiente y prepara el formulario para meter los datos propios de
     * esa tabla
     *
     */
    private void tipoMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoMatActionPerformed
        if (aux != null) {
            aux.dispose();
        }
        switch (tipoMat.getSelectedIndex()) {
            case 0:
                bloqueaCaracteristicas();
                break;

            case 1:
                aux = new ListadoAbalorios();
                aux.setVisible(true);
                bloqueaCaracteristicas();
                jLabel5.setForeground(Color.blue);
                Hechode.setEnabled(true);
                jLabel6.setForeground(Color.blue);
                tamaño.setEnabled(true);
                jLabel7.setForeground(Color.blue);
                forma.setEnabled(true);
                jLabel15.setText("Uds.");
                break;

            case 2:
                aux = new ListadoArcilla();
                aux.setVisible(true);
                bloqueaCaracteristicas();
                jLabel10.setForeground(Color.blue);
                botonSi.setEnabled(true);
                botonNo.setEnabled(true);
                jLabel15.setText("Gr.");
                break;

            case 3:
                aux = new ListadoFieltro();
                aux.setVisible(true);
                bloqueaCaracteristicas();
                jLabel9.setForeground(Color.blue);
                grosor.setEnabled(true);
                jLabel15.setText("cm2");
                jLabel15.setForeground(Color.blue);
                jLabel16.setForeground(Color.blue);
                break;

            case 4:
                aux = new ListadoUtileria();
                aux.setVisible(true);
                bloqueaCaracteristicas();
                jLabel8.setForeground(Color.blue);
                utileria.setEnabled(true);
                break;

            case 5:
                aux = new ListadoTelas();
                aux.setVisible(true);
                bloqueaCaracteristicas();
                jLabel11.setForeground(Color.blue);
                jLabel12.setForeground(Color.blue);
                jLabel13.setForeground(Color.blue);
                jLabel14.setForeground(Color.blue);
                tejido.setEnabled(true);
                Estampado.setEnabled(true);
                IdColorEst.setEnabled(true);
                jLabel15.setText("cm2");
                break;

        } // fin del switch

    }//GEN-LAST:event_tipoMatActionPerformed
    /**
     * Este Boton cierra las ventanas auxiliares que tengamos abiertas y vuelve
     * al menu ficheros
     *
     */
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        if (aux != null) {
            aux.dispose();
        }
        MenuFicheros mp = new MenuFicheros();
        mp.setLocationRelativeTo(null);
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed
    /**
     * Este boton es una ayuda que saca una lista de colores
     *
     */
    private void botonMostrarColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarColorActionPerformed
        ListaColores lc = new ListaColores();
        this.panelAyuda.add(lc);

        lc.setEnabled(true);
        lc.setVisible(true);
        lc.toFront();
    }//GEN-LAST:event_botonMostrarColorActionPerformed

    private void IdColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdColorKeyTyped

    }//GEN-LAST:event_IdColorKeyTyped

    /**
     * El boton nuevo, unicamente prepara el formulario para poder introducir
     * datos
     *
     */
    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        botonCompra.setEnabled(false);
        tipoMat.setEnabled(true);
        tipoMat.setForeground(Color.blue);
        tipoMat.requestFocus();
        ProSelect.setEnabled(true);
        IdColor.setEnabled(true);
        botonNuevo.setEnabled(false);
        botonBuscar.setEnabled(false);
        botonActualizar.setEnabled(false);
        botonGuardar.setEnabled(true);
        botonMostrarColor.setEnabled(true);
        cantidad.setEnabled(true);
        precio.setEnabled(true);
        jLabel1.setForeground(Color.blue);
        jLabel2.setForeground(Color.blue);
        jLabel3.setForeground(Color.blue);
        jLabel4.setForeground(Color.blue);

    }//GEN-LAST:event_botonNuevoActionPerformed

    private void HechodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HechodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HechodeActionPerformed
    /**
     * Este es el listener que hace que cuando el idcolor pierda el foco,
     * comprueba si tiene algo distinto de vacio y de ser alli, llama al metodo
     * llenaColor
     *
     */
    private void IdColorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdColorFocusLost
        if (!IdColor.getText().equals("")) {
            llenaColor();
        }
    }//GEN-LAST:event_IdColorFocusLost

    private void botonNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNoActionPerformed

    private void tejidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tejidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tejidoActionPerformed
    /**
     * hace lo mismos que el otro listener pero con los colores de estampados
     *
     * @see IdColorFocusLost
     */
    private void IdColorEstFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdColorEstFocusLost
        if (!IdColorEst.getText().equals("")) {
            llenaColor2();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_IdColorEstFocusLost

    private void IdColorEstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdColorEstKeyTyped

    }//GEN-LAST:event_IdColorEstKeyTyped
    /**
     * El boton cancelar, limpia todo y prepara el formulario como si acabaramos
     * de entrar
     *
     */
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        if (aux != null) {
            aux.dispose();
        }
        bloqueaBotones();
        bloqueaCaracteristicas();
    }//GEN-LAST:event_botonCancelarActionPerformed
    /**
     * Este boton indica que se elija un material y bloquea el resto de botones
     *
     */
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        JOptionPane.showMessageDialog(null, "Seleccione un tipo de material y pulse mostrar");
        botonCompra.setEnabled(false);
        botonNuevo.setEnabled(false);
        botonGuardar.setEnabled(false);
        tipoMat.setEnabled(true);
        botonActualizar.setEnabled(true);
    }//GEN-LAST:event_botonBuscarActionPerformed

    /**
     * El Boton guardar lo que hace es crear un elemento en la tabla material
     * recupera la clave generada automaticamente, y llama al metodo subtabla
     * para que cree en la subtabla correspondiente el objeto
     */
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        StringBuffer ordenaux = new StringBuffer("INSERT INTO material (proveedor_nombre, color_idcolor, preciocoste, cantidad) VALUES ('");
        int clave = 0;
        ordenaux.append(ProSelect.getSelectedItem().toString() + "', ");
        ordenaux.append(IdColor.getText() + ", ");
        ordenaux.append(precio.getText() + ", ");
        ordenaux.append(cantidad.getText() + ")");

        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(ordenaux.toString(), java.sql.PreparedStatement.RETURN_GENERATED_KEYS);
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            clave = rs.getInt(1);
            pst.close();
            subTabla(clave);
        } catch (SQLException ex) {
            Logger.getLogger(MaterialForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al guardar, compruebe que relleno todos los daton en azul");
        }// fin del try catch// fin del try catch

    }//GEN-LAST:event_botonGuardarActionPerformed
    /**
     * Al modificar el precio, lo que hace este metodo es calcular el precio por
     * unidad teniendo en cuenta que como mínimo la unidad debe costar 1 centimo
     */
    private void precioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precioFocusLost
        double aux;
        precio.setText(precio.getText().replace(',', '.'));
        if (botonCompra.isEnabled()) {
            if (!cantidad.getText().equals("")) {

                aux = Double.parseDouble(precio.getText());
                aux /= Integer.parseInt(cantidad.getText());
                if (aux < 0.01) { // si el precio es mas pequeño que un centimo lo igualo a un centimo
                    aux = 0.01;
                } //din del if interno
                precio.setText(String.valueOf(aux));
                jLabel4.setText("Precio Unidad");
            } else {
                JOptionPane.showMessageDialog(null, "Introduzca primero las unidades");
            }// fin del segundo if
        } // fin del if mas exterior

    }//GEN-LAST:event_precioFocusLost
    /**
     *
     * Este listener lo que hace es que al perder el campo el foco, cambia
     * automaticamente lo que estaba escrito a mayusculas
     */
    private void formaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formaFocusLost
        forma.setText(forma.getText().toUpperCase());
    }//GEN-LAST:event_formaFocusLost
    /**
     *
     * Este listener lo que hace es que al perder el campo el foco, cambia
     * automaticamente lo que estaba escrito a mayusculas
     */
    private void utileriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_utileriaFocusLost
        utileria.setText(utileria.getText().toUpperCase());
    }//GEN-LAST:event_utileriaFocusLost
    /**
     *
     * Este listener lo que hace es que al perder el campo el foco, cambia
     * automaticamente lo que estaba escrito a mayusculas
     */
    private void tejidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tejidoFocusLost
        tejido.setText(tejido.getText().toUpperCase());
    }//GEN-LAST:event_tejidoFocusLost
    /**
     *
     * Este listener lo que hace es que al perder el campo el foco, cambia
     * automaticamente lo que estaba escrito a mayusculas
     */
    private void EstampadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EstampadoFocusLost
        Estampado.setText(Estampado.getText().toUpperCase());
    }//GEN-LAST:event_EstampadoFocusLost
    /**
     * Cuando va a actualizar lo primero que hace es mostrar la tabla que se va
     * a actualizar
     *
     */
    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        switch (tipoMat.getSelectedIndex()) {

            case 1:
                ListadoAbalorios la = new ListadoAbalorios();
                la.setEnabled(true);
                la.setVisible(true);
                break;

            case 2:
                ListadoArcilla lar = new ListadoArcilla();
                lar.setEnabled(true);
                lar.setVisible(true);
                break;

            case 3:
                ListadoFieltro lf = new ListadoFieltro();
                lf.setEnabled(true);
                lf.setVisible(true);
                break;

            case 4:
                ListadoUtileria lu = new ListadoUtileria();
                lu.setEnabled(true);
                lu.setVisible(true);
                break;

            case 5:
                ListadoTelas mt = new ListadoTelas();
                mt.setEnabled(true);
                mt.setVisible(true);
                break;
        } //fin del switch

        bloqueaBotones();
        bloqueaCaracteristicas();


    }//GEN-LAST:event_botonActualizarActionPerformed
    /**
     * Este boton, nos lleva al formulario que controla la compra de materiales
     *
     */
    private void botonCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCompraActionPerformed
        CompraMaterial cm = new CompraMaterial();
        cm.setLocationRelativeTo(null);
        cm.setEnabled(true);
        cm.setVisible(true);
    }//GEN-LAST:event_botonCompraActionPerformed

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Estampado;
    private javax.swing.JComboBox<String> Hechode;
    private javax.swing.JTextField IdColor;
    private javax.swing.JTextField IdColorEst;
    private javax.swing.JComboBox<String> ProSelect;
    private javax.swing.ButtonGroup arcilla;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonCompra;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonMostrarColor;
    private javax.swing.JRadioButton botonNo;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton botonSalir;
    private javax.swing.JRadioButton botonSi;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField color;
    private javax.swing.JTextField colorEstampado;
    private javax.swing.JTextField forma;
    private javax.swing.JTextField grosor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    public static javax.swing.JPanel panelAyuda;
    private javax.swing.JTextField precio;
    private javax.swing.JComboBox<String> tamaño;
    private javax.swing.JTextField tejido;
    private javax.swing.JComboBox<String> tipoMat;
    private javax.swing.JLabel unidad;
    private javax.swing.JTextField utileria;
    // End of variables declaration//GEN-END:variables
}
