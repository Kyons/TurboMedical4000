/*
 * To change this template, choose Tools | Templates
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
import turbomedical4000.ejb.AlertasFacadeLocal;
import turbomedical4000.entity.Alertas;
import turbomedical4000.entity.Paciente;

/**
 * @me devuelve la lista de alertas que tenga un paciente. 
 * @author Tomás
 */
@WebServlet(name = "ConsultarAlertasServlet", urlPatterns = {"/ConsultarAlertasServlet"})
public class ConsultarAlertasServlet extends HttpServlet {

    @EJB
    private AlertasFacadeLocal alertaFacade;
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
        
        HttpSession session = request.getSession();
        Paciente paciente = (Paciente) session.getAttribute("paciente");
        List<Alertas> alerta;
        alerta= (List<Alertas>) alertaFacade.find(paciente);
       
        request.setAttribute("alerta", alerta);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ConsultarAlertas.jsp");
        dispatcher.forward(request, response);
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
