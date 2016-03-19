/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desvanmika;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conectar {
   public Connection conect = null;
   
   public Connection conexion() 
   {    if (conect ==null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/elDesvanDeMika", "desvan", "mika");
            JOptionPane.showMessageDialog(null, "\t\tConectado \n por favor use el boton salir\n para desconectarse de la Base de Datos");
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "ERROR 1"+ex.getMessage());
           ;
         } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 2"+ex.getMessage());
         }}
      
      return conect;
   }
   public void cerrar() {
        try {
      if (conect != null) {
         conect.close();
         JOptionPane.showMessageDialog(null, "Desonectado");
      }
      } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "ERROR "+ex.getMessage());
   }
}
}