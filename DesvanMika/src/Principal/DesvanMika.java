package Principal;

import Procedimientos.Conectar;
import VISTA.Bienvenido;
import java.sql.Connection;

/**
 * Clase principar que lo unico que hace es abrir las conexiones y llamar al
 * formulario principal
 *
 * @author Josete
 */
public class DesvanMika {

    public static Conectar cc;
    public static Connection cn;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cc = new Conectar();
        while (cn == null) {
            cn = cc.getConect();
        }
        Bienvenido bv = new Bienvenido();
        bv.setLocationRelativeTo(null);
        bv.setResizable(false);
        bv.setVisible(true);

    }

}
