/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical.servlet;
 
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import turbomedical4000.ejb.AlertasFacadeLocal;
import turbomedical4000.ejb.MedicoFacadeLocal;
import turbomedical4000.ejb.PacienteFacadeLocal;
import turbomedical4000.entity.Alertas;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author Tomás
 */
@WebServlet(name = "CrearAlertasServlet", urlPatterns = {"/CrearAlertasServlet"})
public class CrearAlertasServlet extends HttpServlet {
    @EJB 
    private AlertasFacadeLocal alertaFacade;
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
        Alertas al =new Alertas();
        List<Alertas> alerta=null;
        
        int paciente = Integer.valueOf(request.getParameter("paciente"));
        Paciente pacien=pacienteFacade.find(paciente);
        if( pacien!= null){
            al.setNumSS(pacien.getNumSS());
        }
        
        int numColegiado = Integer.valueOf(request.getParameter("numCol"));
        Medico medico = medicoFacade.find(numColegiado);
        if (medico != null){
            al.setNumColegiado(medico.getNumColegiado());
        }

        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = df.parse(request.getParameter("fecha"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        al.setFechaAlerta(fecha);
        
        df = new java.text.SimpleDateFormat("HH:mm");
        Date hora = null;
        try {
            hora = df.parse(request.getParameter("hora"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        al.setHora(hora);
        
        al.setTexto(request.getParameter("texto"));
        
        alertaFacade.create(al);
        
        //la creo y después la listo junto a las demás...       
        
        if(pacien!=null){
            alerta= (List<Alertas>) alertaFacade.find(pacien.getNumSS());
        }
        
        request.setAttribute("alerta", alerta);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ConsultarAlertasMedico.jsp");
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
