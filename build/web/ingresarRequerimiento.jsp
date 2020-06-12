
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.ConexionBD"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
ConexionBD con = new ConexionBD();

// metodos de la Clase ConexionBD
ResultSet lista = con.datosGerente();
ResultSet lista1 = con.datosDepartamento();
ResultSet lista2 = con.datosAsignar();
ResultSet lista3 = con.datosEncargados();


// capturamos los mensajes de errores
ArrayList errores = (ArrayList) request.getAttribute("errores");

String alerta  = (String) request.getAttribute("alerta");


%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/ingresa.css" rel="stylesheet">
        <link  rel="icon" href="imagenes/form.png" type="image/png" />
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Ingresar Requerimiento</title>
    </head>
    <body>


        <form action="ingresarR" method="post">
            <table>
                <th> <h2> Ingresar Requerimiento </h2> </th>
                <tr><td></td><td></td></tr>
                <td><label> Gerencia: </label></td>
                <td>          
                    
               
                    
                    <select name="gerencia" class="form-control input-sm" >
                        <% if(lista != null){ %>
                        <option>Seleccionar</option>
                        <% while(lista.next()){ %>


                        <option><%= lista.getString("Gerencia")%></option>
                        <% } %>
                        <% } %>

                    </select>
                </td>
                </tr>
                <tr><td></td><td></td></tr>
                <td><label> Depto.: </label></td>
                <td>          
                    <select name="depto" class="form-control input-sm" >

                        <% if(lista1 != null){ %>
                        <option>Seleccionar</option>
                        <% while(lista1.next()){ %>
                        <option> <%= lista1.getString("Departamento") %></option>    
                        <% } %>
                        <% } %>

                    </select>
                </td>
                </tr>
                <tr><td></td><td></td></tr>
                <td><label> Asignar a: </label></td>
                <td>          
                    <select name="asignar" class="form-control input-sm" >
                        <% if(lista2 != null){ %>
                        <option>Seleccionar</option>
                        <% while(lista2.next()){ %>
                        <option> <%= lista2.getString("Asignacion") %></option>    
                        <% } %>
                        <% } %>

                    </select>
                </td>
                </tr>
                <tr><td></td><td></td></tr>
                <td><label> Encargado: </label></td>
                <td>          
                    <select name="encargado" class="form-control input-sm" >
                        <% if(lista3 != null){ %>
                        <option>Seleccionar</option>
                        <% while(lista3.next()){ %>
                        <option> <%= lista3.getString("Encargado") %></option>    
                        <% } %>
                        <% } %>

                    </select>
                </td>
                </tr>
                <tr><td></td><td></td></tr>
                <tr><td>Requerimiento:</td><td><textarea name="requerimiento" rows="3" cols="40" placeholder="Ingrese descripción del requerimiento. " ></textarea></td></tr>
                <tr><td></td><td></td></tr> 

                <tr><td><input class="btn btn-primary btn-lg" type="submit" name="guardar" value="Guardar"></td>
                    <td><input class="btn btn-primary btn-lg" type="button" onclick="location.href = 'menuPrincipal.jsp';" value="Volver al Menú" /></td></tr>
                <tr><td></td><td></td></tr>

                
                
            </table>
        </form>

        <% if(errores != null){ %>
        <form aling="center" class="errores">
            <% for(int i = 0; i < errores.size() ; i++){ %>
            <ul>
                <li><%= errores.get(i) %> </li>
            </ul>

            <%} %>
        </form>
        <%  } %>

        <% if(alerta != null){ %>
        <form aling="center" class="alerta">
            <ul>
                <%= alerta%> 
            </ul>

        </form>
        <%} %>









    </body>

</html>
