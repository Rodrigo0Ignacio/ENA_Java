package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import modelo.ConexionBD;

public final class cerrarRequerimiento_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    ConexionBD con = new ConexionBD();
    
    // incocamos los metodo para listar los usuarios
    ResultSet lista = con.datosGerente();
    ResultSet lista1 = con.datosDepartamento();
    ResultSet lista2 = con.datosAsignar();
    
    
    // mensaje de delete requerimiento
   String mensajeDelete = (String)request.getAttribute("mensajeD");
    // capturamos la tabla 
    ResultSet tabla = (ResultSet) request.getAttribute("tabla");
    
    // capturamos los errores
    ArrayList errores = (ArrayList) request.getAttribute("errores");
    
   
   


      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/consultar.css\"/>\n");
      out.write("        <link  rel=\"icon\" href=\"imagenes/form.png\" type=\"image/png\" />\n");
      out.write("         <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Cerrar Requerimiento</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <form action=\"cerrarR\" method=\"post\">\n");
      out.write("            <table>\n");
      out.write("                <th> <h2> Cerrar Requerimiento </h2> </th>\n");
      out.write("                \n");
      out.write("                <tr><td></td><td></td></tr>\n");
      out.write("                 <td><label> Gerencia: </label></td>\n");
      out.write("                    <td>          \n");
      out.write("                        <select name=\"gerencia\" class=\"form-control input-sm\" >\n");
      out.write("                            ");
 if(lista != null){ 
      out.write("\n");
      out.write("                            <option>Seleccionar</option>\n");
      out.write("                             ");
 while(lista.next()){ 
      out.write("\n");
      out.write("                                <option> ");
      out.print( lista.getString("Gerencia") );
      out.write("</option>    \n");
      out.write("                               ");
 } 
      out.write("\n");
      out.write("                               ");
 } 
      out.write("\n");
      out.write("   \n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr><td></td><td></td></tr>\n");
      out.write("                <td><label> Depto.: </label></td>\n");
      out.write("                    <td>          \n");
      out.write("                        <select name=\"depto\" class=\"form-control input-sm\" >\n");
      out.write("                            \n");
      out.write("                            ");
 if(lista1 != null){ 
      out.write("\n");
      out.write("                            <option>Seleccionar</option>\n");
      out.write("                             ");
 while(lista1.next()){ 
      out.write("\n");
      out.write("                                <option> ");
      out.print( lista1.getString("Departamento") );
      out.write("</option>    \n");
      out.write("                               ");
 } 
      out.write("\n");
      out.write("                               ");
 } 
      out.write("\n");
      out.write("                            \n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr><td></td><td></td></tr>\n");
      out.write("                <td><label> Asignar a: </label></td>\n");
      out.write("                    <td>          \n");
      out.write("                        <select name=\"asignar\" class=\"form-control input-sm\" >\n");
      out.write("                            ");
 if(lista2 != null){ 
      out.write("\n");
      out.write("                            <option>Seleccionar</option>\n");
      out.write("                             ");
 while(lista2.next()){ 
      out.write("\n");
      out.write("                                <option> ");
      out.print( lista2.getString("Asignacion") );
      out.write("</option>    \n");
      out.write("                               ");
 } 
      out.write("\n");
      out.write("                               ");
 } 
      out.write("\n");
      out.write("                            \n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                    <tr><td></td><td><td></td></tr>\n");
      out.write("                    <tr><td></td><td><input class=\"btn btn-primary btn-lg\" type=\"submit\" name=\"buscar\" value=\"Buscar y Desplegar Tabla\"></td></tr>\n");
      out.write("                    <tr><td></td><td><td></td></tr>\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("            <hr color=\"#221278\" size=\"4\">\n");
      out.write("\n");
      out.write("          <input type=\"hidden\" name=\"obtenID\" value=\"\">\n");
      out.write("            <table class=\"registro\">\n");
      out.write("            <thead>\n");
      out.write("                    <th class=\"linia\">Gerencia</th>\n");
      out.write("                    <th class=\"linia\">Dept.</th> \n");
      out.write("                    <th class=\"linia\">Asignado a</th> \n");
      out.write("                    <th class=\"linia\">Requerimiento</th> \n");
      out.write("                    <th class=\"linia\">Cerrar</th>\n");
      out.write("                 \n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            \n");
      out.write("            ");
   if(tabla != null){ 
      out.write("\n");
      out.write("          ");
  while(tabla.next()){ 
      out.write("\n");
      out.write("             \n");
      out.write("            <tr class=\"linia\">\n");
      out.write("                <td> ");
      out.print( tabla.getString("Gerencia") );
      out.write("</td>\n");
      out.write("                <td> ");
      out.print( tabla.getString("Departamento") );
      out.write("</td>\n");
      out.write("                <td> ");
      out.print( tabla.getString("Asignacion") );
      out.write("</td>\n");
      out.write("                <td> ");
      out.print( tabla.getString("Detalle") );
      out.write("</td>\n");
      out.write("                \n");
      out.write("               \n");
      out.write("                <td align=\"center\"> \n");
      out.write("                    \n");
      out.write("                  <a href=\"puente.jsp?id=");
      out.print(tabla.getString(1));
      out.write("\">\n");
      out.write("                    <img src=\"imagenes/cerrar.png\" width=\"30\" height=\"30\" >\n");
      out.write("                    </a>\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("              ");
 } 
      out.write("\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("          </table>\n");
      out.write("             <input class=\"btn btn-primary btn-lg\" type=\"button\" onclick=\"location.href='menuPrincipal.jsp';\" value=\"Volver al Menú\" />\n");
      out.write("                \n");
      out.write("          \n");
      out.write("                </form>\n");
      out.write("            \n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("      <!-- Emite un mensaje hay un error-->\n");
      out.write("             ");
 if(errores != null){ 
      out.write("\n");
      out.write("            <form aling=\"center\" class=\"errores\">\n");
      out.write("                ");
 for(int i = 0; i < errores.size() ; i++){ 
      out.write("\n");
      out.write("                <ul>\n");
      out.write("                       <li>");
      out.print( errores.get(i) );
      out.write(" </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("                ");
} 
      out.write("\n");
      out.write("                </form>\n");
      out.write("            ");
  } 
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("          \n");
      out.write("                               \n");
      out.write("     \n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
