/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Dproducto;
import java.util.ArrayList;


/**
 *
 * @author HP
 */
public class Nproducto {
    
    private Dproducto dproducto;
    
    public Nproducto(){
             dproducto= new Dproducto();
	}
    
    
   
    public void agregar(int idproducto, String descripcion, int idtipop){
            this.dproducto.setIdproducto(idproducto);
            this.dproducto.setDescripcion(descripcion);
            this.dproducto.setId_tipoP(idtipop);
            this.dproducto.agregar();
            

	}
    
        public void modificar(int id_producto, String descripcion, int idtipop ){
            this.dproducto.setIdproducto(id_producto);
            this.dproducto.setDescripcion(descripcion);
            this.dproducto.setId_tipoP(idtipop);
            this.dproducto.modificar();
	}
    
           public void eliminar(int idproducto){
            this.dproducto.setIdproducto(idproducto);
            this.dproducto.eliminar(idproducto);

	}
    
    public ArrayList listar(){
            return this.dproducto.listar();
    }
   
    
  
    
}
