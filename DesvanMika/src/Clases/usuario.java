
package Clases;

/**
 * Esta clase crea un objeto usuario para la conexion
 * para que en caso de desconexion se reintente la conexion con estos datos
 * @author Josete
 */
public class usuario {
  private String user;
   private String pass;

    public usuario(String user, String pass) {
        if (user.equals(""))
        {this.user="desvan"; //Simplemente por "vagueria" para poder entrar con intro intro
        } else {
        this.user = user;    
        } // fin del if-else 
        
        if (pass.equals("")){ 
            this.pass="mika"; // mas de la misma "vagueria"
        }else {
        this.pass = pass;    
        } // fin del if-else
        
        
    } //fin del creador

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
   

} // fin de la clase
