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
public abstract class Material {
    private String nombre;
    private String Color;
    private String Subcolor;
    private String proveedor_nom; // Clave agena de proveedor

    public Material(String nombre, String Color, String Subcolor, String proveedor_nom) {
        this.nombre = nombre;
        this.Color = Color;
        this.Subcolor = Subcolor;
        this.proveedor_nom = proveedor_nom;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getSubcolor() {
        return Subcolor;
    }

    public void setSubcolor(String Subcolor) {
        this.Subcolor = Subcolor;
    }

    public String getProveedor_nom() {
        return proveedor_nom;
    }

    public void setProveedor_nom(String proveedor_nom) {
        this.proveedor_nom = proveedor_nom;
    }
    
    
    
}
