/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Dvehiculo;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Nvehiculo {
    
    
    private Dvehiculo dvehiculo;
    
    public Nvehiculo(){
             dvehiculo= new Dvehiculo();
	}
    
     public void agregar(String nro_placa, String modelo,String marca, String color, String cantAyudantes, String tipoVehiculo, String ciC){
            this.dvehiculo.setNro_placa(nro_placa);
            this.dvehiculo.setModelo(modelo);
            this.dvehiculo.setMarca(marca);
            this.dvehiculo.setColor(color);
            this.dvehiculo.setCantAyudantes(cantAyudantes);
            this.dvehiculo.setTipoVehiculo(tipoVehiculo);
            this.dvehiculo.setCiC(ciC);
            this.dvehiculo.agregar();
            }
     
     public ArrayList listar(){
       return this.dvehiculo.listar();
     }
    
}
