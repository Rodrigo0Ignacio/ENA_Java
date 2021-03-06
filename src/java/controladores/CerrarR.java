
package controladores;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ConexionBD;

/**
 *
 * @author Rodrigo
 */
public class CerrarR extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
          ConexionBD con = new ConexionBD();
          
          String gerencia = request.getParameter("gerencia");
          String departamento = request.getParameter("depto");
          String asignar = request.getParameter("asignar");

          ArrayList errores = new ArrayList();
          ResultSet tabla = null;
        
        // valida los combobox
        if(gerencia.contentEquals("Seleccionar")){
           errores.add("El Campo \"Gerencia\" es obligatorio");   
        }
        if(departamento.contentEquals("Seleccionar")){
            errores.add("El campo \"Departamento\" es obligatorio");
        }
        if(asignar.contentEquals("Seleccionar")){
            errores.add("El campo \"Asigar a\" es obligatorio");
        }
         if( !errores.isEmpty()){
             
             request.setAttribute("errores", errores);
             request.getRequestDispatcher("cerrarRequerimiento.jsp").forward(request, response);
           
        } else
            
          
           // llamamos al metodo para buscar los requerimientos
          tabla = con.BuscarRequerimiento(gerencia, departamento, asignar);
         
           request.setAttribute("tabla", tabla);
           request.getRequestDispatcher("cerrarRequerimiento.jsp").forward(request, response);


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
