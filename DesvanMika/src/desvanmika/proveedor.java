/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desvanmika;

import java.util.StringTokenizer;




/**
 *
 * @author Josete
 */
public class proveedor {
private String nombre;
private String direccion;
private int telefono;
private String Contacto;
/**
 * 
 * @param texto
 * @return devuelve el texto formateaado
 */


    public proveedor(String nombre, String direccion, int telefono, String Contacto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.Contacto = Contacto;
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

        
}
