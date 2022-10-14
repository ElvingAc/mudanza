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
public class Dvehiculo {
    
        private String nro_placa;
	private String modelo;
	private String marca;
	private String color;
	private String cantAyudantes;
	private String tipoVehiculo;
	private String ciC;

        private Connection con;
        private conexion conexion;
        
        
            public Dvehiculo(){
            conexion = new conexion();
            con= conexion.getConnection();            
	}
        
        
    public String getNro_placa() {
        return nro_placa;
    }

    public void setNro_placa(String nro_placa) {
        this.nro_placa = nro_placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCantAyudantes() {
        return cantAyudantes;
    }

    public void setCantAyudantes(String cantAyudantes) {
        this.cantAyudantes = cantAyudantes;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getCiC() {
        return ciC;
    }

    public void setCiC(String ciC) {
        this.ciC = ciC;
    }
        
        
    public void agregar(){
       conexion = new conexion();
       con= conexion.getConnection();
       PreparedStatement ps=null;
       String sql="INSERT INTO vehiculo (nro_placa,modelo,marca,color,cantAyudantes,tipoVehiculo,ciC) VALUES(?,?,?,?,?,?,?);";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, this.nro_placa);
            ps.setString(2, this.modelo);
            ps.setString(3, this.marca);
            ps.setString(4, this.color);
            ps.setString(5, this.cantAyudantes);
            ps.setString(6, this.tipoVehiculo);              
            ps.setString(7, this.ciC);
  
             ps.execute();
             ps.close();
             System.out.println("Vehiculo Insertado Exitosamente");
         } catch (Exception e) {
             System.out.println(" Error insertar Vehiculo "+e);
            }

	}
        
      public ArrayList listar(){
            conexion = new conexion();
            con= conexion.getConnection();
            
            ArrayList<Object[]> pro= new ArrayList<>();
            PreparedStatement ps= null;
            String query= "SELECT *FROM vehiculo";
            try {
                ps= con.prepareStatement(query);
                ResultSet r;
                r= ps.executeQuery();
                while (r.next()) {                    
                   pro.add( new Object[]{
                    r.getString(1),//codigo
                    r.getString(2),//titulo
                    r.getString(3),//titulo
                    r.getString(4),//titulo
                    r.getString(5),//titulo
                    r.getString(6),//titulo
                    r.getString(7)//idgenero
                   });
                }
                System.out.println("listado Vehiculos....");
            } catch (Exception e) {
                System.out.println("Errror al listar Vehiculos..");
                return null;
            }
            return pro;
	}
    
}
