/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical.servlet;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import turbomedical4000.ejb.PacienteHasMedicoFacadeLocal;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author jorge
 */
@WebServlet(name = "BusquedaPacienteAsignadoServlet", urlPatterns = {"/BusquedaPacienteAsignadoServlet"})
public class BusquedaPacienteAsignadoServlet extends HttpServlet {
    @EJB
    private PacienteHasMedicoFacadeLocal pacienteHasMedicoFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Paciente> pacientes;
            
        pacientes = pacienteHasMedicoFacade.filtrarPacientesDelMedico(request.getParameter("numSS"), 
                request.getParameter("dni"), request.getParameter("nombre"), request.getParameter("apellidos"), 
                request.getParameter("fechaNac"), request.getParameter("direcc"), request.getParameter("localidad"), 
                request.getParameter("provincia"), request.getParameter("telefono"), (Medico) session.getAttribute("medico"));

        request.setAttribute("lista", pacientes);

        RequestDispatcher rd;

        rd = this.getServletContext().getRequestDispatcher("/pacienteAsignadoList.jsp");
        rd.forward(request, response);
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
