/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import turbomedical4000.ejb.EspecialidadFacadeLocal;
import turbomedical4000.ejb.MedicoFacadeLocal;
import turbomedical4000.entity.Especialidad;
import turbomedical4000.entity.Medico;

/**
 *
 * @author Juan
 */
@WebServlet(name = "EditMedicosServlet", urlPatterns = {"/EditMedicosServlet"})
public class EditMedicosServlet extends HttpServlet {
    @EJB
    private EspecialidadFacadeLocal especialidadFacade;
    @EJB
    private MedicoFacadeLocal medicoFacade;

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

	// Formularios Añadir/Editar
        if(action.equals("addForm")){
            // Obtener la lista de especialidades
            List<Especialidad> especialidades;
        
            especialidades = especialidadFacade.findAll();
        
            request.setAttribute("especialidades", especialidades);
            
            RequestDispatcher rd;
        
            rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/medicoAdd.jsp");
            rd.forward(request, response);	
        
        }else if(action.equals("editForm")){
            	
            // Obtener el num del colegiado
            int numColegiado = -1;
            if(request.getParameter("numColegiado") != null){
                numColegiado = Integer.valueOf(request.getParameter("numColegiado"));
            }  
            
            //Obtener el medico de la BD
            Medico usuario = medicoFacade.find(numColegiado);
	
            // Obtener la lista de especialidades
            List<Especialidad> especialidades;
        
            especialidades = especialidadFacade.findAll();
        
            request.setAttribute("especialidades", especialidades);
            
            request.setAttribute("usuario", usuario);
			
            RequestDispatcher rd;
        
            rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/medicoEdit.jsp");
            rd.forward(request, response);
	
        // Añadir/Editar
        } else if(action.equals("add")){
            
            //Comprobar si el usuario ya existe
            // Buscar por num colegiado
            Medico usuario = null;
            try{
                usuario = medicoFacade.findByNumColegiado(Integer.valueOf(request.getParameter("numColegiado")));
            } catch (NumberFormatException e) {
                
                    // Obtener la lista de especialidades
                    List<Especialidad> especialidades;

                    especialidades = especialidadFacade.findAll();

                    request.setAttribute("especialidades", especialidades);
                
                    RequestDispatcher rd;
        
                    rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/medicoAdd.jsp?msg=Numero de colegiado incorrecto");
                    rd.forward(request, response);
                    
            }
            if(usuario == null){
                // Si no se encuentra por num colegiado, buscar por DNI
                usuario = medicoFacade.findByDni(request.getParameter("dni"));
            }
            
            // Obtener la lista de especialidades
            List<Especialidad> especialidades;

            especialidades = especialidadFacade.findAll();

            request.setAttribute("especialidades", especialidades);
            
            if(usuario != null){
                RequestDispatcher rd;
        
                rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/medicoAdd.jsp?msg=El usuario " + usuario.getNumColegiado() + " ya existe");
                rd.forward(request, response);
            }else{
                // Crear el usuario
                int nC = Integer.valueOf(request.getParameter("numColegiado"));
                usuario = new Medico(nC);

                int idEspecialidad = Integer.valueOf(request.getParameter("idEspecialidad"));
                Especialidad especialidad = especialidadFacade.find(idEspecialidad);
                usuario.setEspecialidadidEspecialidad(especialidad);

                usuario.setNombre(request.getParameter("nombre"));
                usuario.setApellidos(request.getParameter("apellidos"));

                java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
                Date fechaNac = null;
                try {
                    fechaNac = df.parse(request.getParameter("fechaNac"));
                } catch (ParseException e) {
                    
                    RequestDispatcher rd;
        
                    rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/medicoAdd.jsp?msg=Fecha incorrecta");
                    rd.forward(request, response);
                    
                }
                usuario.setFechaNac(fechaNac);

                usuario.setDni(request.getParameter("dni"));
                usuario.setDireccion(request.getParameter("direccion"));
                usuario.setLocalidad(request.getParameter("localidad"));
                usuario.setProvincia(request.getParameter("provincia"));
                usuario.setTelefono(request.getParameter("telefono"));
                usuario.setContrasena(request.getParameter("contrasena"));

                // Añadirlo a la BD
                medicoFacade.create(usuario);

                // Redirigir de nuevo al añadir usuarios
                RequestDispatcher rd;

                rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/medicoAdd.jsp?msg=Usuario " + usuario.getNumColegiado()+ " creado");
                rd.forward(request, response);
            }
            
        } else if(action.equals("edit")){
            
            // Crear el usuario modificado
            int nC = Integer.valueOf(request.getParameter("numColegiado"));

            Medico usuario = new Medico(nC);
            
            int idEspecialidad = Integer.valueOf(request.getParameter("idEspecialidad"));
            Especialidad especialidad = especialidadFacade.find(idEspecialidad);
            usuario.setEspecialidadidEspecialidad(especialidad);
            
            usuario.setNombre(request.getParameter("nombre"));
            usuario.setApellidos(request.getParameter("apellidos"));
            
            java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
            Date fechaNac = null;
            try {
                fechaNac = df.parse(request.getParameter("fechaNac"));
            } catch (ParseException e) {
                
                    RequestDispatcher rd;
        
                    rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/medicoEdit.jsp?msg=Fecha incorrecta");
                    rd.forward(request, response);
                   
            }
            usuario.setFechaNac(fechaNac);
            
            usuario.setDni(request.getParameter("dni"));
            usuario.setDireccion(request.getParameter("direccion"));
            usuario.setLocalidad(request.getParameter("localidad"));
            usuario.setProvincia(request.getParameter("provincia"));
            usuario.setTelefono(request.getParameter("telefono"));
            usuario.setContrasena(request.getParameter("contrasena"));
            
            // Editarlo en la BD
            medicoFacade.edit(usuario);

            request.setAttribute("usuario", usuario);
            
            // Obtener la lista de especialidades
            List<Especialidad> especialidades;
        
            especialidades = especialidadFacade.findAll();
        
            request.setAttribute("especialidades", especialidades);
            
            // Redirigir de nuevo a la edicion de usuarios
            RequestDispatcher rd;

            rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/medicoEdit.jsp?msg=Usuario " + usuario.getNumColegiado() + " modificado");
            rd.forward(request, response);
	
        // Eliminar
        }else if(action.equals("delete")){
            RequestDispatcher rd;

            // Obtener el num del colegiado
            int numColegiado = -1;
            if(request.getParameter("numColegiado") != null){
                numColegiado = Integer.valueOf(request.getParameter("numColegiado"));
            }  
            
            //Obtener el medico de la BD
            Medico usuario = medicoFacade.find(numColegiado);
            
            medicoFacade.remove(usuario);
               
            rd = this.getServletContext().getRequestDispatcher("/ListaMedicosServlet?msg=Usuario " + usuario.getNumColegiado() + " eliminado");

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
