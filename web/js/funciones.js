$(document).ready(function (){
    $("tr #btnDelete").click(function (){
        var idp=$(this).parent().find("#idp").val();
        swal({
            title: "Esta seguro de Eliminar?",
            text: "Once deleted, Usted puede agregar de nuevo!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }) .then((willDelete) => {              
            if (willDelete) {
                eliminar(idp);
                swal("Poof! Your imaginary file has been deleted!", {
                icon: "success",
            }).then((willDelete)=>{
                if(willDelete){
                    parent.location.href="Controlador?accion=Carrito";
                }
            });
            } else {
                 swal("Registro no eliminado!");
            }
            }); 
       
    });
    function eliminar (idp){
        var url="Controlador?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp="+ipd,
            success: function (data, textStatus, jqXHR){
                parent.location.href="Controlador?accion=Carrito";              
            }
        });
    }
    
    $("tr #Cantidad").click(function () {
        var idp=$(this).parent().find("#idpro").val();
        var cantidad=$(this).parent().find("#Cantidad").val();
        var url="Controlador?accion=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp="+idp+"&Cantidad" + cantidad,
            success: function (data, textStatus, jqXHR) {
                parent.location.href="Controlador?accion=Carrito";    
            }
        })
    });
});

