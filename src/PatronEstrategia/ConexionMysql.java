/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronEstrategia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class ConexionMysql implements Strategia{
     private Connection con;
    private String pass="";
    private String URL="jdbc:mysql://localhost:3306/mudanza";
    private String user="root"; 
    
    
//    private String pass="admin";
//    private String URL="jdbc:postgresql://127.0.0.1/tallerMec_arquitectura_db";
//    private String user="postgres"; 
//    
//    private Connection con;
//    private String pass="y6QdzaV34ubPzEb7zagE";
//    private String URL="jdbc:postgresql://127.0.0.1/tallerMec_arquitectura_db";
//    private String user="u1hxzi9chroh7sp9pw7j"; 

    public ConexionMysql() {
    }
     @Override
    public Connection conectar(){
        try {
            //Class.forName("org.postgresql.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(URL,this.user,this.pass);
        } catch (ClassNotFoundException | SQLException e) {
                            System.out.println("Error conectar Mysql... "+e.getMessage());
        }
        return con;
    }
    
}
