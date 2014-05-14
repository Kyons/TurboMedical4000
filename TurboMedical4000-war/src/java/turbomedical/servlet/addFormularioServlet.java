/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import turbomedical4000.ejb.FormularioFacadeLocal;
import turbomedical4000.ejb.TipoformularioFacadeLocal;
import turbomedical4000.entity.Formulario;
import turbomedical4000.entity.Paciente;
import turbomedical4000.entity.Tipoformulario;


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
 *
 * @author Juan
 */
@WebServlet(name = "addFormularioServlet", urlPatterns = {"/addFormularioServlet"})
public class addFormularioServlet extends HttpServlet {
    @EJB
    private FormularioFacadeLocal formularioFacade;
    @EJB
    private TipoformularioFacadeLocal tipoformularioFacade;

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
        
        // Obtener el paciente de la sesion
        HttpSession session = request.getSession();
        Paciente paciente = (Paciente) session.getAttribute("paciente");
        
        // Obtener la lista de tipos de formulario
        List<Tipoformulario> tiposFormulario;
        
        tiposFormulario = tipoformularioFacade.findAll();
        
        request.setAttribute("tiposFormulario", tiposFormulario);

        // Crea un nuevo formulario
        int idTF = Integer.valueOf(request.getParameter("idTipoFormulario"));
        Tipoformulario tipoFormulario = tipoformularioFacade.find(idTF);
        String entrada = request.getParameter("entrada");
        
        // New Date() devuelve un objeto con la fecha y hora actuales
        Date fechaHora = new Date();

        // Da igual el id que le demos, porque es autoincremental en la BD
        Formulario formulario = new Formulario(1, entrada, fechaHora, fechaHora);
        
        formulario.setPacientenumSS(paciente);
        formulario.setTipoFormularioidTipoFormulario(tipoFormulario);

        // Añadirlo a la BD
        formularioFacade.create(formulario);

        // Redirigir de nuevo al enviar formularios
        RequestDispatcher rd;

        rd = this.getServletContext().getRequestDispatcher("/formularioAdd.jsp?msg=Formulario enviado");
        rd.forward(request, response);
    
    }
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
