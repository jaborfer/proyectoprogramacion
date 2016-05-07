
package Clases;

/**
 *Esta es una clase teorica (que no se usa en el programa) para demostrar junto con la clase fieltro
 * como se implementa una clase abstracta
 * @author Josete
 */
public abstract class material {
private int codMaterial;
private String Proveedor_Nombre;
private int idColor;
private double precioCoste;
private int cantidad;

    public material(int codMaterial, String Proveedor_Nombre, int idColor, double precioCoste, int cantidad) {
        this.codMaterial = codMaterial;
        this.Proveedor_Nombre = Proveedor_Nombre;
        this.idColor = idColor;
        this.precioCoste = precioCoste;
        this.cantidad = cantidad;
    }

    public int getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(int codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getProveedor_Nombre() {
        return Proveedor_Nombre;
    }

    public void setProveedor_Nombre(String Proveedor_Nombre) {
        this.Proveedor_Nombre = Proveedor_Nombre;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public double getPrecioCoste() {
        return precioCoste;
    }

    public void setPrecioCoste(double precioCoste) {
        this.precioCoste = precioCoste;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }



}
