package Procedimientos;

import Clases.usuario;
import java.sql.*;
import javax.swing.JOptionPane;
import VISTA.VistaConexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase crea un objeto conexión que luego se usara en el resto de la
 * aplicación
 *
 * @author Josete
 */
public class Conectar implements ActionListener {

    VistaConexion ventana = new VistaConexion();
    public Connection conect = null;
    private usuario u;

    public Connection getConect() {
        return conect;
    }

    /**
     * es la función que realiza la conexion con mysql
     *
     * @return devuelve el objeto conexión
     */
    private void conectarConUsuario() {
        if (conect == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conect = DriverManager.getConnection("jdbc:mysql://localhost/elDesvanDeMika?autoReconnect=true&useSSL=false", u.getUser(), u.getPass());
                ventana.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 1" + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 2" + ex.getMessage());
            }// fin de los try-catch
        } // fin del if

    }

    public Conectar() {

        ventana.setEnabled(true);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.jButton1.addActionListener(this);

        ventana.usuario.requestFocus();

    }

    /**
     * Metodo para cerrar la conexión
     */
    public void cerrar() {
        try {
            if (conect != null) {
                conect.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String us = ventana.usuario.getText();
        String con = new String(ventana.contraseña.getPassword());
        u = new usuario(us, con);
        conectarConUsuario();

    }
}
