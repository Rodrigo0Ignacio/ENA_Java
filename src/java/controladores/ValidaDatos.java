
package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ConexionBD;

/**
 *
 * @author Rodrigo
 */
public class ValidaDatos extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // creamos una instancia de la clase con la conexion a la BD
        ConexionBD conBD = new ConexionBD();
        
        // capturamos las variables de index,jsp
        String nombre = request.getParameter("usuario");
        String password = request.getParameter("password");
        String enviaraMenu = request.getParameter("ingresar");
        
        int retorna;
           // le pasamos nombre y password al metodo ValidarSesion
            retorna = conBD.ValidarSesion(nombre, password);
            
           // devuelve un 1 si el usuario esta registrado de lo contrario devuelve un 0
            String envia = String.valueOf(retorna);
        
            // si retorna es igual a 0 envia datos.
        if(retorna == 0){

           request.setAttribute("envia", envia);
           request.getRequestDispatcher("index.jsp").forward(request, response);
   
        }else{
            // de lo contrario redireciona al menu principal
       
           request.setAttribute("enviaraMenu", enviaraMenu);
           request.getRequestDispatcher("menuPrincipal.jsp").forward(request, response);
        }
                   
                
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
