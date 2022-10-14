
package negocio;
import datos.DtipoP;
import java.util.ArrayList;


public class NtipoP {
    
     private DtipoP dtipoP;
	public NtipoP(){
            dtipoP = new DtipoP();

	}

        public void agregar(int id,String descripcion){
            this.dtipoP.setId(id);
            this.dtipoP.setDescripcion(descripcion);
            dtipoP.agregar();
	}
        
        public ArrayList listar(){
            return this.dtipoP.listar();
                    
	}

    
}
