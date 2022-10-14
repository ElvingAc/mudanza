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
public class ConexionPostgres implements Strategia{
    private Connection con;
//    public static final String URL = "jdbc:mysql://localhost:3306/mudanza";
//    public static final String usuario = "root";
//    public static final String contraseña = "";
// private String pass="admin";
    private String contraseña="admin";
    private String URL="jdbc:postgresql://127.0.0.1/tallerMec_arquitectura_db";
    private String usuario="postgres"; 
    @Override
    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
//            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(URL,this.usuario,this.contraseña);
        } catch (ClassNotFoundException | SQLException e) {
                            System.out.println("Error conectar Mysql... "+e.getMessage());
        }
        return con;
    }
    
}
