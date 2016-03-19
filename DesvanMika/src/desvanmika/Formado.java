/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desvanmika;

/**
 * Esta es la tabla de la relación NM entre Material y componente
 * @author Josete
 */
public class Formado {
    private String Material_nom;
    private String Material_col;
    private String MAterial_sub;
    private String Componente_nom;
    private int cantidad;

    public Formado(String Material_nom, String Material_col, String MAterial_sub, String Componente_nom, int cantidad) {
        this.Material_nom = Material_nom;
        this.Material_col = Material_col;
        this.MAterial_sub = MAterial_sub;
        this.Componente_nom = Componente_nom;
        this.cantidad = cantidad;
    }

    public String getMaterial_nom() {
        return Material_nom;
    }

    public void setMaterial_nom(String Material_nom) {
        this.Material_nom = Material_nom;
    }

    public String getMaterial_col() {
        return Material_col;
    }

    public void setMaterial_col(String Material_col) {
        this.Material_col = Material_col;
    }

    public String getMAterial_sub() {
        return MAterial_sub;
    }

    public void setMAterial_sub(String MAterial_sub) {
        this.MAterial_sub = MAterial_sub;
    }

    public String getComponente_nom() {
        return Componente_nom;
    }

    public void setComponente_nom(String Componente_nom) {
        this.Componente_nom = Componente_nom;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
