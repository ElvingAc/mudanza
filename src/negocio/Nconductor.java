
package negocio;


import datos.Dconductor;
import java.util.ArrayList;


public class Nconductor {
    
    private Dconductor dconductor;

     public Nconductor(){
            dconductor = new Dconductor();

	}
     
      public void agregar(String ci, String nombre, String direccion, String telefono){
            this.dconductor.setCi(ci);
            this.dconductor.setNombre(nombre);
            this.dconductor.setDireccion(direccion);
            this.dconductor.setTelefono(telefono);          
            dconductor.agregar();
	}
    
    
    
    
     public ArrayList listar(){
            return this.dconductor.listar();
                    
	}
}
