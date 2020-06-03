
package com.sinfloo.config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class conexion {
       Connection con;
    public conexion(){
        try {
             Class.forName("com.mysql.jdbc.Driver");
             con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcarritocompras", "root", "");
            
            
        }catch (Exception e){
            System.err.println("Error"+e);
        }
    }
    public Connection getConnection(){
        return con;
    }
}

