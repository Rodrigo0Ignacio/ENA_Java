
package controladores;

import java.io.IOException;
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
public class IngresarR extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
               // instanciamos la clase de conexion
        ConexionBD con = new ConexionBD();
        // instanciamos la clase de ArrayList para guardar los errores
        ArrayList errores = new ArrayList();
        
        // capturamos las variables de los combobox
        String gerencia = request.getParameter("gerencia");
        String departamento = request.getParameter("depto");
        String asignacion = request.getParameter("asignar");
        String encargado = request.getParameter("encargado");
        String detalle = request.getParameter("requerimiento");

        
         /*
          Preguntar si los datos fueron seleccionados correctamente
         */
         if(gerencia.equalsIgnoreCase("Seleccionar")){
             errores.add("El Campo \"Gerencia\" es obligatorio");
             
         }
         if(departamento.equalsIgnoreCase("Seleccionar")){
             errores.add("El campo \"Departamento\" es obligatorio");
             
         }
         if(asignacion.equalsIgnoreCase("Seleccionar")){
             errores.add("El campo \"Asigar a\" es obligatorio");
             
         }
         if(encargado.equalsIgnoreCase("Seleccionar")){
             errores.add("El campo \"Encargado\" es obligatorio");
             
         }
         if(detalle.length() == 0){
             errores.add("El campo \"Requerimiento\" es obligatorio");
             
         }
         // revisa si el ArrayList esta vacio, de lo contrario se enviara
         if(! errores.isEmpty()){
             
             request.setAttribute("errores", errores);
             request.getRequestDispatcher("ingresarRequerimiento.jsp").forward(request, response);
             
         } else{
             
           // llamamos al metodo y le pasamos los datos para que guarde los requerimientos  
         String alerta = con.IngresarNuevoRequerimiento(detalle,gerencia,
                  asignacion,encargado,departamento);
         
             request.setAttribute("alerta", alerta);
             request.getRequestDispatcher("ingresarRequerimiento.jsp").forward(request, response);
         
           
             
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

