
<%@page import="modelo.ConexionBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    // captura la variable del controlador
String mensaje = (String) request.getAttribute("envia");

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/index.css" rel="stylesheet">
        <link  rel="icon" href="imagenes/form.png" type="image/png" />
         <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Autentificacìon</title>
    </head>
 
    <body>
      
   <!-- este formulario se muestra en el navegador y captura los datos-->
        <form action="validaDatos" method="post">
            <table>
                <th> <h2> Autentificacìon </h2> </th>
                
                <tr><td>Usuario </td><td><input class="cajon" type="text" name="usuario" placeholder="digite su usuario" > </td></tr>
                <tr><td></td><td></td></tr>
                <tr><td>Password </td><td><input class="cajon" type="password" name="password" placeholder=" digite su contraseña"></td></tr>
                <tr><td></td><td></td></tr>
                <tr><td></td><td></td></tr>
                <tr><td></td><td><input type="checkbox" name="recordar" size="20"> recordar</td></tr>
                <tr><td></td><td></td></tr>
                <tr><td></td><td><input class="btn btn-primary btn-lg" type="submit" Value="Ingresar" name="ingresar" ></td></tr>
                <tr><td></td><td></td></tr>

            </table>
        </form>
        <!-- verifica que la varible venda vacia de lo contrario imprimira en la pagina los mensajes de errores-->
        <% if (mensaje != null){ 
         if(mensaje.equalsIgnoreCase("0")){ %>
         <script src="js/Alarm.js"></script>
         <div class="errores">
         <h5> Datos incorrectos, intentalo denuevo </h5>
         </div>
        

        <% } %>
        <% } %>       
<!-- inportacion de JS-->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="js/alarm.js"></script>



    </body>
</html>
