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
public class Manualidad {
private String Nombre;
private int Tiempo;
private String fichero;
private String observaciones;

    public Manualidad(String Nombre, int Tiempo, String fichero, String observaciones) {
        this.Nombre = Nombre;
        this.Tiempo = Tiempo;
        this.fichero = fichero;
        this.observaciones = observaciones;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getTiempo() {
        return Tiempo;
    }

    public void setTiempo(int Tiempo) {
        this.Tiempo = Tiempo;
    }

    public String getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = fichero;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
