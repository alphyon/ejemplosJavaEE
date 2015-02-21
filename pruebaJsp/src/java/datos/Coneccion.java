package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Coneccion {
    private final String user = "root";
    private final String host ="jdbc:mysql://localhost";
    private final String clave = "pruebas";
    
    public Connection Conectar(){
        Connection cn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(host,user,clave);
        }catch(ClassNotFoundException ex){
            
        } catch (SQLException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cn;
    }
}
