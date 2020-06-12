
package modelo;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Rodrigo
 */

public class ConexionBD {
    
    /*
    Creamos las variable para la conexion a la BD
    */
    private final String url = "jdbc:mysql://localhost:3306/Requerimientos";
    private final String user = "root";
    private final String password = "";
    private final String driver = "com.mysql.jdbc.Driver";
    Connection con; 
    Statement st; 
    ResultSet rs; 

// esteme metodo conecta a la base de datos
     public ConexionBD(){
         
          
     try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url,user,password);
            
            if(con != null){
                System.out.println("Conexion establecida");
            }
            
            
        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar: "+e);
            
        }
            
        }
     
     // este metodo sirve para buscar las credenciales de usuario y mas tarde procesarlas en el servlet
     
     public int ValidarSesion(String nombre, String pass){
         int resultado = 0;
         
         try{

             String query = "SELECT * FROM usuarios WHERE Nombre = '"+nombre+"' AND Contraseña = "+pass+"";
             st = con.createStatement();
             rs = st.executeQuery(query);
             
             if(rs.next()){
                 
                 resultado = 1;
    
             } else{
                 resultado = 0;
             }
             
            } catch(SQLException e){
             
         }
        return resultado;
     }
     
    // sirve para listar combobox
     public ResultSet datosGerente(){
 

         try{
             String query = "SELECT gerencia from gerencia";
             st = con.createStatement();
             rs = st.executeQuery(query);

    
         } catch(SQLException e){
              
         }
        return rs;
     }
     
     public ResultSet datosDepartamento(){

         try{
             String query = "SELECT  departamento FROM departamento";
             st = con.createStatement();
             rs = st.executeQuery(query);

    
         } catch(SQLException e){
                
         }
        return rs;
     }
     
     public ResultSet datosAsignar(){

         try{
             String query = "SELECT asignacion FROM asignacion";
             st = con.createStatement();
             rs = st.executeQuery(query);

    
         } catch(SQLException e){
                
         }
        return rs;
     }
     
     public ResultSet datosEncargados(){

         try{
             String query = "SELECT encargado FROM encargado";
             st = con.createStatement();
             rs = st.executeQuery(query);

    
         } catch(SQLException e){
                
         }
        return rs;
     }
     
     // Ingresamos un nuevo requerimiento
     public String IngresarNuevoRequerimiento(String detalle, String gerencia, String asigar,
             String encargado, String departamento){
         String mensaje = "El requerimiento se a guardado exitosamente. " ;

         try{
             String query = "INSERT INTO requerimientos VALUES (NULL,'"+detalle+"','"+gerencia+"','"+asigar+"','"+encargado+"'"
                     + ",'"+departamento+"')";
             st = con.createStatement();
             st.executeUpdate(query);
             
         } catch(SQLException e){
             
             mensaje = "Error al guardar Requerimiento. "+e;
             
         }
        return mensaje;

     }
     // busca un registro
     public ResultSet BuscarRequerimiento(String gerencia, String departamento, String Asignacion){
         
         try{
             String query = "SELECT DISTINCT * FROM requerimientos WHERE Gerencia = '"+gerencia+"' AND Departamento = '"+departamento+"' AND Asignacion = '"+Asignacion+"' AND Detalle = Detalle";
             st = con.createStatement();
             rs = st.executeQuery(query);
             
    
         } catch(SQLException e){
                
         }
        return rs;  
     }
    
     // elimina un registro
      public boolean EliminarRegistro(int id){
          boolean mensaje;
         try{
             String query = "DELETE FROM requerimientos WHERE ID_Requerimiento = "+id+"";
             st = con.createStatement();
             st.executeUpdate(query);
             mensaje = true;
    
         } catch(SQLException e){
             mensaje = false;
                
         }
        return mensaje;  
     }
    
     }
     
   
     
      
      
      
      
     
    

 
        
        
   
    
   
   
   
