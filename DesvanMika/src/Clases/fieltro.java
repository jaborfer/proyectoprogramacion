
package Clases;

/**
 * Esta clase extiende material y tambien es teorica por que no se usa en el programa
 * 
 * @author Josete
 */
public class fieltro extends material{
private int grosor;    
    public fieltro(int codMaterial, String Proveedor_Nombre, int idColor, double precioCoste, int cantidad, int grosor) {
        super(codMaterial, Proveedor_Nombre, idColor, precioCoste, cantidad);
        this.grosor=grosor;
    }

    public int getGrosor() {
        return grosor;
    }

    public void setGrosor(int grosor) {
        this.grosor = grosor;
    }
    
    
}
