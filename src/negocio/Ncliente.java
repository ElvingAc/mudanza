
package negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import datos.Dcliente;
import java.util.ArrayList;
import presentacion.Pcliente;



public class Ncliente{
    
    private Dcliente dcliente;
	public Ncliente(){
            dcliente = new Dcliente();

	}
    
    public void agregar(String ci, String nombre, String direccion, String telefono, String correo){
            this.dcliente.setCi(ci);
            this.dcliente.setNombre(nombre);
            this.dcliente.setDireccion(direccion);
            this.dcliente.setTelefono(telefono);
            this.dcliente.setCorreo(correo);          
            dcliente.agregar();
	}
    
    public void modificar(String ci, String nombre, String direccion, String telefono, String correo ){
            this.dcliente.setCi(ci);
            this.dcliente.setNombre(nombre);
            this.dcliente.setDireccion(direccion);
            this.dcliente.setTelefono(telefono);
            this.dcliente.setCorreo(correo);
            this.dcliente.modificar();
	}
    
    
    public void eliminar(String ci){
            this.dcliente.setCi(ci);
            this.dcliente.eliminar(ci);

	}

    
    public ArrayList listar(){
            return this.dcliente.listar();
                    
	}
}
    


