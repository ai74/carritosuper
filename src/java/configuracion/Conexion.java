
package configuracion;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    Connection con;
    
    public Conexion (){     //En esta parte se publica la varialbe para que se pueda 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcarritocompras", "root", "");
                    // para que se pueda conetar con en base de datos es la direccion donde esta el gestor de base de datos
                    //
        } catch (Exception e) {
            System.err.println("Error"+e); // para dar un aviso si esta conectado con la base de datos
        }
        
    }
    public Connection getConnection(){
        return con;
    }
    
}