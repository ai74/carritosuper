<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>JSP Page</title>
       
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
         <link href="css/Estilos.css" rel="stylesheet" type="text/css"/> //esta parte seria el encabezado, para diseñar el formulario se tutiliza el bootstrap
    </head>                                                                // y para los iconos en sonabezon
    <body>
        <nav class="navbar navbar-expand-lg navbar-red bg-red">
            <a class="navbar-brand" href="#">Producos Informatico</a>       //permite crear el encabezado de la web
                 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                 </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                     <a class="nav-link" href="Controlador?accion=home">Inicio Web <span class="sr-only">(current)</span></a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link" href="#">Oferta del Dia</a>
                </li>
     
                <li class="nav-item">
                    <a class="nav-link" href="Controlador?accion=Carrito">(<label style="color: gray>${contador}</label>)Carrito</a>
                </li>
            </ul>
            
            <form class="form-inline my-2 my-lg-0>
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Search</button>
            </form>
            
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     Iniciar Session
                    </a>
                    
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
            </ul>
        </div>
        </nav>
        
        <div class="container mt-2">
            <div class="row">
                
                <c:forEach var="p" items="${productos}"> 
                    <div class="col-sm-4">
                        <div class="card">
                            <div class="card-header">
                                <label>${p.getNombres()}</label>                          
                            </div>
                            <div class="card-body">
                                <i>${p.getPrecio()}</i>
                                    <img src="ControladorImg?id=${p.getId()}" width="200" height="180">
                            </div>
                            <div class="card-footer text-center ">                          
                                <label>${p.getDescripcion()}</label>                            
                            
                            <div> 
                                <a href="Controlador?accion=AgregarCarrito&id=${p.getId()}" class="btn btn-outline-info">Agregar a Carrito</a>
                               
                                <a href="Controlador?accion=Comprar&id=${p.getId()}" class="btn btn-danger">Comprar</a>
                            </div>
                        </div>
                    </div>    
                   </div>         
                </c:forEach>
                
            
        </div>
     </div>       
        
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>        //se relacionan los tipos de trabajos,los marcos de trabajos
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>