
package com.sinfloo.modelo;

import com.sinfloo.config.conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;public class ProductoDAO {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Producto listarId(int id){
        String sql="select * from producto where idProducto="+id;
        Producto p=new Producto();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setDescripcion(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                
                
                
            }
        } catch (Exception e) {
        }
       return p;
    }
    
    
    public List listar(){
        List<Producto>productos=new ArrayList();
        String sql="Select * from producto";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Producto p=new Producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setDescripcion(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getByte(6));
                productos.add(p);
            }
        } catch (Exception e) {
        }
        return productos;
    }
    public void listarImg(int id, HttpServletResponse response) throws IOException, SQLException{
        int nBytes = 0;  
        String sql="select foto from producto where idProducto"+id;
            InputStream inputStream =null;
            OutputStream outputStream=null;
            BufferedInputStream bufferedInputStream=null;
            BufferedOutputStream bufferedOutputStream=null;
        try {
            outputStream =response.getOutputStream();
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next()) {
                 inputStream=rs.getBinaryStream("foto");
             }
           bufferedInputStream=new BufferedInputStream(inputStream);
           bufferedOutputStream=new BufferedOutputStream(outputStream);
           int i=0;
            while ((i=bufferedInputStream.read())!=-1) {                
                bufferedOutputStream.write(i);
            }
            
        } catch (Exception e) {
        }
                    
      }
    
}
