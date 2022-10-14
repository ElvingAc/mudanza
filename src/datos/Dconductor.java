/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Dconductor {
    
    private String ci;
    private String nombre;
    private String direccion;
    private String telefono;
     private conexion conexion;
    private Connection con =null;

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
        public ArrayList listar(){
            conexion = new conexion();
            con=conexion.getConnection();
            ArrayList<Object[]> gen = new ArrayList<>();
            String query= "SELECT *FROM conductor";
            PreparedStatement ps= null;
            try {
                ps= con.prepareStatement(query);
                ResultSet r;
                r= ps.executeQuery();
                
                while(r.next()){
                    gen.add( new Object[]{
                    r.getString(1),//ci
                    r.getString(2),//nombre
                    r.getString(3),//direccion
                    r.getString(4),//telefono
                    
                    });
                }
                System.out.println("listando conductor.. ");
            } catch (Exception e) {
                System.out.println("Error al listar...." + e);
                return null;
            }
            return gen;
	}
                
        public void agregar(){
            conexion = new conexion();
            con= conexion.getConnection();
            PreparedStatement ps =null;
            String sql = "INSERT INTO conductor (ci,nombre,direccion,telefono) VALUES(?,?,?,?);";
            try {
                ps=con.prepareStatement(sql);
                ps.setString(1, this.ci);
                ps.setString(2, this.nombre);
                ps.setString(3, this.direccion);
                ps.setString(4, this.telefono);
                ps.execute();
                
                System.out.println("Conductor Insertado exitosamente..");
            } catch (Exception e) {
                System.out.println(" Error al Insertar conductor "+ e.getMessage());
            } finally{
                try {
                    con.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

	}
    
}
