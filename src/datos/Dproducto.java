
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Dproducto {
    
        private int idproducto;
	private String descripcion;
	private int id_tipoP;
        private Connection con;
        private conexion conexion;
        
        public Dproducto(){
            conexion = new conexion();
            con= conexion.getConnection();            
	}

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_tipoP() {
        return id_tipoP;
    }

    public void setId_tipoP(int id_tipoP) {
        this.id_tipoP = id_tipoP;
    }
	
        
    
    	public void agregar(){
            conexion = new conexion();
            con= conexion.getConnection();
            PreparedStatement ps=null;
            String sql="INSERT INTO producto (id_producto, descripcion, id_tipoP) VALUES(?,?,?);";
            try {
                ps=con.prepareStatement(sql);
                ps.setInt(1, this.idproducto);
                ps.setString(2, this.descripcion);              
                ps.setInt(3, this.id_tipoP);
                
                
                ps.execute();
                ps.close();
                System.out.println("Producto Insertado Exitosamente");
            } catch (Exception e) {
                System.out.println(" Error insertar Producto ");
            }

	}
        
        public ArrayList listar(){
            conexion = new conexion();
            con= conexion.getConnection();
            
            ArrayList<Object[]> pro= new ArrayList<>();
            PreparedStatement ps= null;
            String query= "SELECT *FROM producto";
            try {
                ps= con.prepareStatement(query);
                ResultSet r;
                r= ps.executeQuery();
                while (r.next()) {                    
                   pro.add( new Object[]{
                    r.getInt(1),//codigo
                    r.getString(2),//titulo
                    r.getInt(3)//idgenero
                   });
                }
                System.out.println("listado Productos....");
            } catch (Exception e) {
                System.out.println("Errror al listar Productos..");
                return null;
            }
            return pro;
	}
        public void modificar(){}
        public void eliminar(){}
    
}
