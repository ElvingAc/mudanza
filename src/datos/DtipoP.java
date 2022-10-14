
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class DtipoP {
    
        private int id_tipoP;
	private String descripcion;
        private conexion conexion;
        private Connection con =null;

    public int getId() {
        return id_tipoP;
    }

    public void setId(int id_tipoP) {
        this.id_tipoP = id_tipoP;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
      
       	
	public void agregar(){
            conexion = new conexion();
            con= conexion.getConnection();
            PreparedStatement ps =null;
            String sql = "INSERT INTO tipop (id_tipoP,descripcion) VALUES(?,?);";
            try {
                ps=con.prepareStatement(sql);
                ps.setInt(1, this.id_tipoP);
                ps.setString(2, this.descripcion);
                ps.execute();
                System.out.println("tipoP Insertado exitosamente..");
            } catch (Exception e) {
                System.out.println(" Error al Insertar tipoP "+ e.getMessage());
            } finally{
                try {
                    con.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

	}
        
        public ArrayList listar(){
            conexion = new conexion();
            con=conexion.getConnection();
            ArrayList<Object[]> gen = new ArrayList<>();
            String query= "SELECT *FROM tipoP";
            PreparedStatement ps= null;
            try {
                ps= con.prepareStatement(query);
                ResultSet r;
                r= ps.executeQuery();
                
                while(r.next()){
                    gen.add( new Object[]{
                    r.getInt(1),//id
                    r.getString(2)//descripcion
                    
                    });
                }
                System.out.println("listando tipoP.. ");
            } catch (Exception e) {
                System.out.println("Error al listar....");
                return null;
            }
            return gen;
	}
 
        
}
