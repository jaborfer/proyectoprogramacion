package Clases;

import Procedimientos.Utilidades;
import Principal.DesvanMika;
import VISTA.ProveedoresForm;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Esta es la clase par gestionar el objeto proveedor y sus metodos
 *
 * @author Josete
 */
public class proveedor implements Imprimible {

    private String nombre;
    private String direccion;
    private int telefono;
    private String Contacto;
    Utilidades u = new Utilidades(); // Al igual que en Clientes creamos la utilidad sólo para usar sus metodos

    /**
     * En el creador es donde usamos las funciones para formatear los objetos
     *
     * @param nombre
     * @param direccion
     * @param telefono
     * @param Contacto
     */
    public proveedor(String nombre, String direccion, int telefono, String Contacto) {
        this.nombre = u.mayusculas(nombre);
        this.direccion = direccion.toUpperCase();
        this.telefono = telefono;
        this.Contacto = u.mayusculas(Contacto);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    /**
     *
     * Este metodo es llamado desde proveedoresForm y sirve para guardar el
     * objeto cliente desde el que ha sido llamado en la base de datos
     */
    public void guardarProveedor() {
        try {
            PreparedStatement pps = DesvanMika.cn.prepareStatement("INSERT INTO proveedor(nombre, direccion, telefono, persona_contacto) VALUES(?,?,?,?)");
            pps.setString(1, this.getNombre());
            pps.setString(2, this.getDireccion());
            pps.setInt(3, this.getTelefono());
            pps.setString(4, this.getContacto());
            pps.executeUpdate();
            pps.close();
            JOptionPane.showMessageDialog(null, "Guardado con exito");

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Ese proveedor ya existe");

        } catch (SQLException ex) {
            Logger.getLogger(ProveedoresForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al guardar");
        } // fin del try -catch
    } // fin del metodo

    /**
     *
     * Este metodo es llamado desde proveedoresForm y sirve para borrar el
     * objeto cliente desde el que ha sido llamado en la base de datos
     */
    public void borraProveedor() {
        String orden;
        orden = "DELETE FROM proveedor WHERE nombre='" + this.nombre + "'";
        try {
            PreparedStatement comando = DesvanMika.cn.prepareStatement(orden);
            comando.executeUpdate();
            comando.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProveedoresForm.class.getName()).log(Level.SEVERE, null, ex);
        } //Fin del try-catch
    } // Fin del metodo

    /**
     *
     * Este metodo es llamado desde proveedoresForm y sirve para actualizar el
     * objeto cliente desde el que ha sido llamado en la base de datos
     */
    public void actualizarProveedor(String clave) {
        String orden;
        orden = "UPDATE proveedor SET nombre='" + this.getNombre() + "',direccion='" + this.getDireccion() + "',telefono='" + this.getTelefono() + "',persona_contacto='" + this.getContacto() + "' where nombre='" + clave + "'";
        try {
            PreparedStatement stm = (PreparedStatement) DesvanMika.cn.prepareStatement(orden);
            stm.executeUpdate();
            stm.close();
            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(ProveedoresForm.class.getName()).log(Level.SEVERE, null, ex);
        } // fin del try-catch
    }// fin del metodo

    @Override
    public String formato() {
        String lineaPro;
        StringBuilder linea = new StringBuilder("");
        linea.append(String.format("%1$-25s", this.nombre)).append("\t");
        linea.append(String.format("%1$-30s", this.direccion)).append("\t");
        linea.append(String.format("%1$-10s", this.telefono)).append("\t");
        linea.append(String.format("%1$-20s", this.Contacto)).append("\r\n");
        lineaPro = new String(linea);
        return (lineaPro);
    }

} // fin de la clase
