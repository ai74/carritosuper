
package com.sinfloo.controlador;

import com.sinfloo.modelo.Producto;
import com.sinfloo.modelo.ProductoDAO;
import com.sinfloo.modelo.carrito;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class controlador extends HttpServlet {

    ProductoDAO pdao=new ProductoDAO();
    Producto p=new Producto();
    List<Producto> productos=new ArrayList<>();
    
    List<carrito> listarCarrito=new ArrayList<>();
    int item;
    double totalPagar=0.0;
    int cantidad=1;
    int contador=0;
 int ipd;
 carrito car;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException _{
               String accion=request.getParameter("accion");
               productos=pdao.listar();
               switch (accion){
               
                   case "AgregarCarrito":
                       int idp=Integer.parseInt(request.getParameter("id"));
                       p=pdao.listarId(idp);
                       item=item+1;
                       carrito car=new carrito();
                       car.setItem(item);
                       car.setIdProducto(p.getId());
                       car.setNombres(p.getNombre());
                       car.setDescripcion(p.getDescripcion());
                       car.setPrecioCompra(p.getPrecio());
                       car.setCantidad(cantidad);
                       car.setSubTotal(cantidad*p.getPrecio());
                       listarCarrito.add(car);                      
                       request.setAttribute("contador", listarCarrito.size());
                       request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
                                               
                      break;
                   
                   case "carrito":   
                       totalPagar=0.0;
                       request.setAttribute("carrito", listarCarrito);
                       request.getRequestDispatcher("carrito.jsp").forward(request, response);
                       
                       break;
                    default:
                    request.setAttribute("productos", productos);
                        for (int i = 0; i < listarCarrito.size(); i++) {
                            totalPagar=totalPagar+listarCarrito.get(i).getSubTotal();
                        }
                        request.setAttribute("totalPagar", totalPagar);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
               }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
