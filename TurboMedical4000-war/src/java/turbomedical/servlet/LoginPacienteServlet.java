package turbomedical.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import turbomedical4000.ejb.PacienteFacadeLocal;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author jorge
 */
@WebServlet(urlPatterns = {"/LoginPacienteServlet"})
public class LoginPacienteServlet extends HttpServlet {
    @EJB
    private PacienteFacadeLocal pacienteFacade;

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
        if(session.getAttribute("paciente")!=null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("ConsultarPerfilUsuarioServlet");
            dispatcher.forward(request, response);
	}else{
            boolean userNum = true ;
            Paciente paciente = null;
            try{
                paciente = pacienteFacade.find(Integer.parseInt(request.getParameter("usuario")));
            }catch(NumberFormatException n){
                userNum = false;
            }
            if(paciente!= null && userNum && paciente.getContrasena().equals(request.getParameter("contrasena"))){
                session.setAttribute("paciente", paciente);
                //RequestDispatcher dispatcher = request.getRequestDispatcher("menuPaciente.jsp");
                RequestDispatcher dispatcher = request.getRequestDispatcher("ConsultarPerfilUsuarioServlet");
                dispatcher.forward(request, response);
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("loginPacientes.jsp?msg=Usuario y/o contraseña incorrectos");
                dispatcher.forward(request, response);
            }
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
