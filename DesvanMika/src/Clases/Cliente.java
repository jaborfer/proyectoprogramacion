package Clases;

import Procedimientos.Utilidades;
import Principal.DesvanMika;
import VISTA.ClientesForm;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Esta clase es la que maneja el objeto cliente y sus procedimientos
 *
 * @author Josete
 */
public class Cliente {

    private int idCliente;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private int telefono;
    private boolean whatsup;
    private String Email;

    Utilidades u = new Utilidades(); // Creamos un objeto u, unicamente para usar los metodos

    /**
     * El constructor usa la clase utilidades para formatear todos los
     * parametros
     *
     */
    public Cliente(int idCliente, String Nombre, String Apellido, String Direccion, int telefono, boolean whatsup, String Email) {
        this.idCliente = idCliente;
        this.Nombre = u.mayusculas(Nombre);
        this.Apellido = u.mayusculas(Apellido);
        this.Direccion = Direccion.toUpperCase();
        this.telefono = telefono;
        this.whatsup = whatsup;
        this.Email = Email.toUpperCase();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isWhatsup() {
        return whatsup;
    }

    public void setWhatsup(boolean whatsup) {
        this.whatsup = whatsup;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * Este metodo es llamado desde clientesForm y sirve para guardar el objeto
     * cliente desde el que ha sido llamado en la base de datos
     *
     */
    public void guardaCliente() {
        try {
            PreparedStatement pps = DesvanMika.cn.prepareStatement("INSERT INTO cliente (nombre, apellido, direccion, telefono, whatsup, email ) VALUES(?,?,?,?,?,?)");
            pps.setString(1, this.getNombre());
            pps.setString(2, this.getApellido());
            pps.setString(3, this.getDireccion());
            pps.setInt(4, this.getTelefono());
            pps.setBoolean(5, this.isWhatsup());
            pps.setString(6, this.getEmail());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Guardado con exito");
            pps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClientesForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al guardar");
        } // fin del catch// fin del try
    } //fin del metodo

    /**
     * Este metodo es llamado desde clientesForm y sirve para actualizar el
     * objeto cliente desde el que ha sido llamado en la base de datos
     */
    public void actualizaCliente() {
        StringBuffer orden = new StringBuffer("");
        orden.append("UPDATE cliente SET nombre='" + this.Nombre + "',apellido='" + this.Apellido + "',direccion='" + this.Direccion + "',telefono='" + this.telefono);
        if (this.whatsup) {
            //comprueba si esta marcado si o no, y le pone 1 o 0 para que le servidor lo entienda
            orden.append("',whatsup=1");
        } else {
            orden.append("',whatsup=0");
        } //fin del else-if
        orden.append(" ,email='" + this.Email + "' where idcliente=" + this.idCliente);
        try {
            PreparedStatement stm = (PreparedStatement) DesvanMika.cn.prepareStatement(orden.toString());
            stm.executeUpdate();
            stm.close();
            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(ClientesForm.class.getName()).log(Level.SEVERE, null, ex);
        } //fin del try-catch
    } //fin de la clase

    /**
     * Este metodo es llamado desde clientesForm y sirve para borrar el objeto
     * cliente desde el que ha sido llamado en la base de datos
     */
    public void BorraCliente() {
        String orden;
        orden = "DELETE FROM cliente WHERE idCLIENTE=" + this.idCliente;
        try {
            PreparedStatement comando = DesvanMika.cn.prepareStatement(orden);
            comando.executeUpdate();
            comando.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClientesForm.class.getName()).log(Level.SEVERE, null, ex);
        } //fin del try-catch
    } //fin del metodo

} //fin de la clase
