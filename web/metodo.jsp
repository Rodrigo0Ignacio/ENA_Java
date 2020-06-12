
<%@page import="modelo.ConexionBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    /*
    -- NOTA --
    Esta pagina sirve como "metodo" para capturar los id de la tabla 
    a eliminar, ya que no es posible enviar una variable de ipervinculo al sertvlet
    */
    
    // capturamos la variable de ipervinculo "id"
    String idPuente = (String) request.getParameter("id");
    
    
    // intanciamos la clase conexion
    ConexionBD con = new ConexionBD();
    // pasamos la variable capturada de String a entero
    int idnum = Integer.parseInt(idPuente);
      
    // preguntamos si la variavle contiene datos 
 if(idnum != 0){

    // incovamos el metodo para eliminar un registro de la tabla
    boolean  mensajeD = con.EliminarRegistro(idnum);
   // String md=String.valueOf(mensajeD);  

   
    // redirecciona a la pagina "cerrar Requerimiento.jsp"
    request.getRequestDispatcher("cerrarRequerimiento.jsp").forward(request, response);

}

%>
 



    
