package turbomedical.servlet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import turbomedical4000.ejb.CitaFacadeLocal;
import turbomedical4000.entity.Cita;
import turbomedical4000.entity.Medico;

/**
 *
 * @author Tomás
 */
@WebServlet(urlPatterns = {"/SolicitarCitaServlet"})
public class SolicitarCitaServlet extends HttpServlet {

     @EJB
     private CitaFacadeLocal CitaFacade;
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
        
        
        int numMedico= Integer.valueOf(request.getParameter("numCol"));
        String lug= request.getParameter("lugar");
        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
        Date fech = null;
        try {
            fech = df.parse(request.getParameter("fecha"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.text.DateFormat dh = new java.text.SimpleDateFormat("00:00");
        Date hor = null;
         try {
             hor = dh.parse(request.getParameter("hora"));
         } catch (ParseException ex) {
              ex.printStackTrace();
         }
        
        
        Cita cita = new Cita(Integer.SIZE, fech, hor, lug);
               
        Medico med = new Medico(numMedico);       
        cita.setMediconumColegiado(med);        
        cita.getPacientenumSS();
        
        CitaFacade.create(cita);
        // Redirigir de nuevo al añadir cita
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("ConsultarCitas.jsp?msg=cita " + cita.getIdCita() + " creada");
        rd.forward(request, response);
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
