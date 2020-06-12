

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
String paso = (String) request.getAttribute("enviaraMenu");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/menu.css" rel="stylesheet">
        <link  rel="icon" href="imagenes/form.png" type="image/png" />
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Menu Principal</title>
    </head>
    <body>
        <form action="" method="post">
            <table>
                <th> <h2> Menú Principal </h2> </th>
             
                <tr><td><li><input class="botonM" type="button" onclick="location.href='ingresarRequerimiento.jsp';" value="Ingresar Requerimiento" /> </li></td></tr>
                <tr><td></td><td></td></tr>
                <tr><td><li><input class="botonM" type="button" onclick="location.href='consultarRequerimiento.jsp';"  Value="Consultar Requerimiento"> </li></td</tr>
                <tr><td></td><td></td></tr>
                
                <tr><td><li><input class="botonM" type="button" onclick="location.href='cerrarRequerimiento.jsp';"  Value="Cerrar Requerimiento" > </li></td></tr>
               
            </table>
        </form>
    </body>
</html>
