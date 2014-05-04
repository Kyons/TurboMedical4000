/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import turbomedical4000.ejb.AdministradorFacadeLocal;
import turbomedical4000.entity.Administrador;

/**
 *
 * @author Juan
 */
@WebServlet(name = "EditAdministradoresServlet", urlPatterns = {"/EditAdministradoresServlet"})
public class EditAdministradoresServlet extends HttpServlet {
    @EJB
    private AdministradorFacadeLocal administradorFacade;

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
        int idAdministrador = -1;
	if(request.getParameter("idAdministrador") != null){
            idAdministrador = Integer.valueOf(request.getParameter("idAdministrador"));
        }  

	// Formularios Añadir/Editar
        if(action.equals("addForm")){
            RequestDispatcher rd;
        
            rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/administradorAdd.jsp");
            rd.forward(request, response);	
        
        }else if(action.equals("editForm")){
            //Obtener el administrador de la BD
            Administrador usuario = administradorFacade.find(idAdministrador);
			
            request.setAttribute("usuario", usuario);
			
            RequestDispatcher rd;
        
            rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/administradorEdit.jsp");
            rd.forward(request, response);
	
        // Añadir/Editar
        } else if(action.equals("add")){
            //Comprobar si el usuario ya existe
            Administrador usuario = administradorFacade.findByUsuario(request.getParameter("usuario"));
            if(usuario != null){
                RequestDispatcher rd;
        
                rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/administradorAdd.jsp?msg=El usuario " + usuario.getUsuario() + " ya existe");
                rd.forward(request, response);
            }else{
                // Crear el usuario
                // Da igual el id que le demos, porque es autoincremental en la BD
                String u = request.getParameter("usuario");
                String c = request.getParameter("contrasena");
                usuario = new Administrador(1, u, c);
                // Añadirlo a la BD
                administradorFacade.create(usuario);
        
                // Redirigir de nuevo al añadir usuarios
                RequestDispatcher rd;
        
                rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/administradorAdd.jsp?msg=Usuario " + request.getParameter("usuario") + " creado");
                rd.forward(request, response);
            }
        } else if(action.equals("edit")){
            // Crear el usuario modificado
            int i = Integer.valueOf(request.getParameter("idAdministrador"));
            String u = request.getParameter("usuario");
            String c = request.getParameter("contrasena");
            Administrador usuario = new Administrador(i, u, c);
            
            request.setAttribute("usuario", usuario);
            
            //Comprobar si el usuario ya existe
            Administrador usuarioExis = administradorFacade.findByUsuario(request.getParameter("usuario"));
            if(usuarioExis != null){
                RequestDispatcher rd;

                rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/administradorEdit.jsp?msg=El usuario " + usuarioExis.getUsuario() + " ya existe");
                rd.forward(request, response);
            }else{
                // Editarlo en la BD
                administradorFacade.edit(usuario);

                // Redirigir de nuevo a la edicion de usuarios
                RequestDispatcher rd;

                rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/administradorEdit.jsp?msg=Usuario " + u + " modificado");
                rd.forward(request, response);
            }
        // Eliminar
        }else if(action.equals("delete")){
            // Comprobar que el administrador a eliminar no es el que esta en la sesión
            HttpSession session = request.getSession();
            Administrador administrador =(Administrador) session.getAttribute("administrador");
            
            RequestDispatcher rd;
            
            // El administrador no puede borrarse a si mismo
            if (idAdministrador == administrador.getIdAdministrador()){
                rd = this.getServletContext().getRequestDispatcher("/ListaAdministradoresServlet?msg=No puede eliminarse a usted mismo");
            }else{
                //Obtener el administrador de la BD
                Administrador usuario = administradorFacade.find(idAdministrador);
            
                administradorFacade.remove(usuario);
                
                rd = this.getServletContext().getRequestDispatcher("/ListaAdministradoresServlet?msg=Usuario " + usuario.getUsuario() + " eliminado");
            }

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
