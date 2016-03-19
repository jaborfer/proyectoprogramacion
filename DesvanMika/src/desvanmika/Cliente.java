/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desvanmika;

/**
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

    public Cliente(int idCliente, String Nombre, String Apellido, String Direccion, int telefono, boolean whatsup, String Email) {
        this.idCliente = idCliente;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.telefono = telefono;
        this.whatsup = whatsup;
        this.Email = Email;
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


}
