
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class conexion {

    public static final String URL = "jdbc:mysql://localhost:3306/mudanza";
    public static final String usuario = "root";
    public static final String contraseña = "";
 
      public Connection getConnection(){
      Connection conextion = null;
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
         conextion = DriverManager.getConnection(URL,usuario,contraseña);
         //JOptionPane.showMessageDialog(null,"Conectado");
          
      } catch (Exception e) {
          System.out.println("Error," + e);
          JOptionPane.showMessageDialog(null,e);
      }
      return conextion;
  }
    
}
    

