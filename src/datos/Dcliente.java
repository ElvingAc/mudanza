
package datos;

import PatronEstrategia.ConexionMysql;
import PatronEstrategia.Context;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Dcliente {
       private String ci;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
   // conexion con = new conexion();
         private conexion conexion;
        private Connection con =null;
    private Context contexto;

    public Dcliente() {
        
            contexto = new Context();
    }
    
    
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public ArrayList listar(){
            contexto.setStrategia(new ConexionMysql());
            con = contexto.ejecutarEstrategia();
            ArrayList<Object[]> gen = new ArrayList<>();
            String query= "SELECT *FROM cliente";
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
                    r.getString(5)//correo
                    
                    });
                }
                System.out.println("listando cliente.. ");
            } catch (Exception e) {
                System.out.println("Error al listar...." + e);
                return null;
            }
            return gen;
	}
    
    public void agregar(){

            contexto.setStrategia(new ConexionMysql());
            con = contexto.ejecutarEstrategia();
            
            PreparedStatement ps =null;
            String sql = "INSERT INTO cliente (ci,nombre,direccion,telefono,correo) VALUES(?,?,?,?,?);";
            try {
                ps=con.prepareStatement(sql);
                ps.setString(1, this.ci);
                ps.setString(2, this.nombre);
                ps.setString(3, this.direccion);
                ps.setString(4, this.telefono);
                ps.setString(5, this.correo);
                ps.execute();
                
                System.out.println("Cliente Insertado exitosamente..");
            } catch (Exception e) {
                System.out.println(" Error al Insertar cliente "+ e.getMessage());
            } finally{
                try {
                    con.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

	}
    
    public void modificar(){
            conexion = new conexion();
            con= conexion.getConnection();
             PreparedStatement ps= null;
             String sql= "UPDATE cliente SET nombre=?, direccion=?, telefono=?, correo=? WHERE ci="+this.ci;
             try {
                ps= con.prepareStatement(sql);
                
                ps.setString(1, this.nombre);
                ps.setString(2, this.direccion);
                ps.setString(3, this.telefono);
                ps.setString(4, this.correo);
                ps.execute();
                ps.close();
                 System.out.println("modificador exitosamente");
            } catch (Exception e) {
                 System.out.println("error al modificar.."+e.getMessage());
            }

	}
    
    
    public void eliminar(String ci){
            conexion = new conexion();
            con= conexion.getConnection();
            PreparedStatement ps=null;
            String sql="DELETE FROM cliente WHERE ci="+this.ci;
            try {
                ps=con.prepareStatement(sql);
                
                ps.execute();
                ps.close();
                System.out.println("Cliente Elminado exitosamente...");
            } catch (Exception e) {
                System.out.println("Error Elimiinar Cliente..." + e);
            }

	}
    
    
}
