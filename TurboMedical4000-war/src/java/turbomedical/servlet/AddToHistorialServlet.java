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
import turbomedical4000.ejb.LineahistorialFacadeLocal;
import turbomedical4000.ejb.MedicoFacadeLocal;
import turbomedical4000.ejb.PacienteFacadeLocal;
import turbomedical4000.entity.Lineahistorial;
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
        
        Integer usuario = Integer.valueOf(request.getParameter("usuario"));
        
         Paciente paciente = pacienteFacade.find(usuario);
         
        String date= request.getParameter("fecha");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
           try{
         Date fecha = formatter.parse(date);
           }catch(ParseException e){
               e.printStackTrace();
           }
         String hora = request.getParameter("hora"); 
         /*Dudas: 
          *1: En la tabla de lineahistorial  la hora es de tipo time 
          * pero en lineahistorial.java aparece como tipo date !!
          * 2: El id de lineahistorial es autoincrementado o lo introduce el médico??
          * ya que lo necesita el constructor 
          */
         
         String entrada= request.getParameter("entrada");
        // Lineahistorial l = new Lineahistorial()
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
