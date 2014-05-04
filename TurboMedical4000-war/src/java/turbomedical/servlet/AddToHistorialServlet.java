/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.PrintWriter;
import javax.ejb.EJB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import turbomedical4000.ejb.LineahistorialFacadeLocal;
import turbomedical4000.ejb.MedicoFacadeLocal;
import turbomedical4000.ejb.PacienteFacadeLocal;
import turbomedical4000.entity.Lineahistorial;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author Sihame
 */
@WebServlet(name = "AddToHistorialServlet", urlPatterns = {"/AddToHistorialServlet"})
public class AddToHistorialServlet extends HttpServlet {
    @EJB
    private LineahistorialFacadeLocal lineahistorialFacade;
    @EJB
    private MedicoFacadeLocal medicoFacade;
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
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/AddToHistorial.jsp");
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
         HttpSession session = request.getSession();
         Medico medico = (Medico) session.getAttribute("medico");
         Integer usuario = Integer.valueOf(request.getParameter("usuario"));
        
         Paciente paciente = pacienteFacade.find(usuario);
         
        String date= request.getParameter("fecha");
        String entrada= request.getParameter("entrada");
         String time = request.getParameter("hora"); 
        
         //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         //SimpleDateFormat formatter2 = new SimpleDateFormat("HH:MM:SS");
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
         SimpleDateFormat formatter2 = new SimpleDateFormat("HH:MM");
           try{
           Date fecha = formatter.parse(date);
           Date hora = formatter2.parse(time);
           Lineahistorial l = new Lineahistorial(5); 
           l.setFecha(fecha);
           l.setEntrada(entrada);
           l.setHora(hora);
           l.setPacientenumSS(paciente);
           l.setMediconumColegiado(medico);
           lineahistorialFacade.create(l);
           }catch(ParseException e){
               e.printStackTrace();
           }
           
        
       // processRequest(request, response);
        response.sendRedirect(request.getContextPath() + "/menuMedico.jsp");
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
