/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import turbomedical4000.ejb.MedicoFacadeLocal;
import turbomedical4000.entity.Medico;

/**
 *
 * @author jorge
 */
@WebServlet(name = "BusquedaMedicoServlet", urlPatterns = {"/BusquedaMedicoServlet"})
public class BusquedaMedicoServlet extends HttpServlet {
    @EJB
    private MedicoFacadeLocal medicoFacade;

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
        
            List<Medico> medicos;
            
            medicos = medicoFacade.filtrarMedicos(request.getParameter("numCol"), 
                    request.getParameter("especialidad"), request.getParameter("nombre"), request.getParameter("apellidos"), 
                    request.getParameter("fechaNac"), request.getParameter("dni"), request.getParameter("direcc"), request.getParameter("localidad"), 
                    request.getParameter("provincia"), request.getParameter("telefono"));
            
            request.setAttribute("lista", medicos);
        
            RequestDispatcher rd;
        
            rd = this.getServletContext().getRequestDispatcher("/medicoList.jsp");
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
