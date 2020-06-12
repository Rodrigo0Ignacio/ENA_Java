<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="modelo.ConexionBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ConexionBD con = new ConexionBD();
    
    // incocamos los metodo para listar los usuarios
    ResultSet lista = con.datosGerente();
    ResultSet lista1 = con.datosDepartamento();
    ResultSet lista2 = con.datosAsignar();

    // capturamos la tabla 
    ResultSet tabla = (ResultSet) request.getAttribute("tabla");
    
    // capturamos los errores
    ArrayList errores = (ArrayList) request.getAttribute("errores");
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/consultar.css"/>
        <link  rel="icon" href="imagenes/form.png" type="image/png" />
         <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Cerrar Requerimiento</title>
    </head>
    <body>
        
        <form action="cerrarR" method="post">
            <table>
                <th> <h2> Cerrar Requerimiento </h2> </th>
                
                <tr><td></td><td></td></tr>
                 <td><label> Gerencia: </label></td>
                    <td>          
                        <select name="gerencia" class="form-control input-sm" >
                            <% if(lista != null){ %>
                            <option>Seleccionar</option>
                             <% while(lista.next()){ %>
                                <option> <%= lista.getString("Gerencia") %></option>    
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
                    <tr><td></td><td><td></td></tr>
                    <tr><td></td><td><input class="btn btn-primary btn-lg" type="submit" name="buscar" value="Buscar y Desplegar Tabla"></td></tr>
                    <tr><td></td><td><td></td></tr>

            </table>
                               
         <%   if(tabla != null){ %>
            <hr color="#221278" size="4">

          <input type="hidden" name="obtenID" value="">
            <table class="registro">
            <thead>
                    <th class="linia">Gerencia</th>
                    <th class="linia">Dept.</th> 
                    <th class="linia">Asignado a</th> 
                    <th class="linia">Requerimiento</th> 
                    <th class="linia">Cerrar</th>
                 
                </tr>
            </thead>
            
         
          <%  while(tabla.next()){ %>
             
            <tr class="linia">
                <td> <%= tabla.getString("Gerencia") %></td>
                <td> <%= tabla.getString("Departamento") %></td>
                <td> <%= tabla.getString("Asignacion") %></td>
                <td> <%= tabla.getString("Detalle") %></td>
                
               
                <td align="center"> 
                    
                  <a href="metodo.jsp?id=<%=tabla.getString(1)%>">
                    <img src="imagenes/cerrar.png" width="30" height="30" >
                    </a>

                </td>
            </tr>
              <% } %>
            <% } %>
            

          </table>
             <input class="btn btn-primary btn-lg" type="button" onclick="location.href='menuPrincipal.jsp';" value="Volver al Menú" />
                
          
                </form>
            
            <br>
            
      <!-- Emite un mensaje hay un error-->
             <% if(errores != null){ %>
            <form aling="center" class="errores">
                <% for(int i = 0; i < errores.size() ; i++){ %>
                <ul>
                       <li><%= errores.get(i) %> </li>
                </ul>

                <%} %>
                </form>
            <%  } %>
            
    </body>
</html>