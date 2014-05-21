/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical.servlet;

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
import javax.servlet.http.HttpSession;
import turbomedical4000.ejb.CitaFacadeLocal;
import turbomedical4000.ejb.MedicoFacadeLocal;
import turbomedical4000.entity.Cita;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author Tomás
 */
@WebServlet(name = "SolicitarCitaServlet", urlPatterns = {"/SolicitarCitaServlet"})
public class SolicitarCitaServlet extends HttpServlet {
    @EJB
    private MedicoFacadeLocal medicoFacade;
    @EJB
    private CitaFacadeLocal citaFacade;

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
        
        System.out.println("Este mensaje es para comprobar si se llega de forma correcta a este servlet");
        
        Cita cita = new Cita(1);

        HttpSession session = request.getSession();
        Paciente paciente =(Paciente) session.getAttribute("paciente");
        cita.setPacientenumSS(paciente);
        
        int numColegiado = Integer.valueOf(request.getParameter("numCol"));
        Medico medico = medicoFacade.find(numColegiado);
        if (medico != null){
            cita.setMediconumColegiado(medico);
        }

        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = df.parse(request.getParameter("fecha"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cita.setFecha(fecha);
        
        df = new java.text.SimpleDateFormat("HH:mm");
        Date hora = null;
        try {
            hora = df.parse(request.getParameter("hora"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cita.setHora(hora);
        
        //cita.setLugar(request.getParameter("lugar"));
        cita.setLugar("-");
        
        citaFacade.create(cita);

        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/ConsultarCitasServlet?msg=Cita " + cita.getIdCita() + " creada");
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
