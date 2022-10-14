/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronEstrategia;

import java.sql.Connection;

/**
 *
 * @author HP
 */
public class Context {
    private Strategia strategia;

    public Context() {
        strategia = new ConexionMysql();
    }

    public void setStrategia(Strategia strategia) {
        this.strategia = strategia;
  }
    public Connection ejecutarEstrategia(){
       return this.strategia.conectar();
    }
    
    
    
}
