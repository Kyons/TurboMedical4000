/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import turbomedical4000.ejb.PacienteFacadeLocal;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author Juan
 */
@WebServlet(name = "EditPacientesServlet", urlPatterns = {"/EditPacientesServlet"})
public class EditPacientesServlet extends HttpServlet {
    @EJB
    private PacienteFacadeLocal pacienteFacade;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener la acción a a realizar del parámetro do
	String action = request.getParameter("do");
	
        // Obtener el id del administrador
        int numSS = -1;
	if(request.getParameter("numSS") != null){
            numSS = Integer.valueOf(request.getParameter("numSS"));
        }  

	// Formularios Añadir/Editar
        if(action.equals("addForm")){
            RequestDispatcher rd;
        
            rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/pacienteAdd.jsp");
            rd.forward(request, response);	
        
        }else if(action.equals("editForm")){
            //Obtener el paciente de la BD
            Paciente usuario = pacienteFacade.find(numSS);
	
            request.setAttribute("usuario", usuario);
			
            RequestDispatcher rd;
        
            rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/pacienteEdit.jsp");
            rd.forward(request, response);
	
        // Añadir/Editar
        } else if(action.equals("add")){
            
            //Comprobar si el usuario ya existe
            Paciente usuario = pacienteFacade.findByNumSS(Integer.valueOf(request.getParameter("numSS")));
            if(usuario != null){
                RequestDispatcher rd;
        
                rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/pacienteAdd.jsp?msg=El usuario " + usuario.getNumSS() + " ya existe");
                rd.forward(request, response);
            }else{
                // Crear el usuario
                int nSS = Integer.valueOf(request.getParameter("numSS"));
                usuario = new Paciente(nSS);

                usuario.setNombre(request.getParameter("nombre"));
                usuario.setApellidos(request.getParameter("apellidos"));

                java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
                Date fechaNac = null;
                try {
                    fechaNac = df.parse(request.getParameter("fechaNac"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                usuario.setFechaNac(fechaNac);

                usuario.setDni(request.getParameter("dni"));
                usuario.setDireccion(request.getParameter("direccion"));
                usuario.setLocalidad(request.getParameter("localidad"));
                usuario.setProvincia(request.getParameter("provincia"));
                usuario.setTelefono(request.getParameter("telefono"));
                usuario.setContrasena(request.getParameter("contrasena"));

                // Añadirlo a la BD
                pacienteFacade.create(usuario);

                // Redirigir de nuevo al añadir usuarios
                RequestDispatcher rd;

                rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/pacienteAdd.jsp?msg=Usuario " + usuario.getNumSS() + " creado");
                rd.forward(request, response);
            }
        } else if(action.equals("edit")){
            // Crear el usuario modificado
            int nSS = Integer.valueOf(request.getParameter("numSS"));
            Paciente usuario = new Paciente(nSS);
            
            usuario.setNombre(request.getParameter("nombre"));
            usuario.setApellidos(request.getParameter("apellidos"));
            
            java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
            Date fechaNac = null;
            try {
                fechaNac = df.parse(request.getParameter("fechaNac"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            usuario.setFechaNac(fechaNac);
            
            usuario.setDni(request.getParameter("dni"));
            usuario.setDireccion(request.getParameter("direccion"));
            usuario.setLocalidad(request.getParameter("localidad"));
            usuario.setProvincia(request.getParameter("provincia"));
            usuario.setTelefono(request.getParameter("telefono"));
            usuario.setContrasena(request.getParameter("contrasena"));
            
            // Editarlo en la BD
            pacienteFacade.edit(usuario);

            request.setAttribute("usuario", usuario);

            // Redirigir de nuevo a la edicion de usuarios
            RequestDispatcher rd;

            rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/pacienteEdit.jsp?msg=Usuario " + usuario.getNumSS() + " modificado");
            rd.forward(request, response);
	
        // Eliminar
        }else if(action.equals("delete")){
            RequestDispatcher rd;
            
            //Obtener el medico de la BD
            Paciente usuario = pacienteFacade.find(numSS);
            
            pacienteFacade.remove(usuario);
               
            rd = this.getServletContext().getRequestDispatcher("/ListaPacientesServlet?msg=Usuario " + usuario.getNumSS() + " eliminado");

            rd.forward(request, response);
	}
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
