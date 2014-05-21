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
import turbomedical4000.ejb.MedicoFacadeLocal;
import turbomedical4000.ejb.PacienteFacadeLocal;
import turbomedical4000.ejb.PacienteHasMedicoFacadeLocal;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;
import turbomedical4000.entity.PacienteHasMedico;
import turbomedical4000.entity.PacienteHasMedicoPK;

/**
 *
 * @author Sihame
 */
@WebServlet(name = "EditMedicoPacienteServet", urlPatterns = {"/EditMedicoPacienteServet"})
public class EditMedicoPacienteServet extends HttpServlet {
    @EJB
    private MedicoFacadeLocal medicoFacade;
    @EJB
    private PacienteFacadeLocal pacienteFacade;
    @EJB
    private PacienteHasMedicoFacadeLocal pacienteHasMedicoFacade;
     
    
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
          String accion = request.getParameter("do");
          if(accion.equals("add")){
            RequestDispatcher rd;
            rd = this.getServletContext().getRequestDispatcher("/GestionUsuarios/MedicoPacienteAdd.jsp");
            rd.forward(request, response);
          }else if(accion.equals("delete")){
           Integer numC = Integer.valueOf(request.getParameter("numc"));
          
           Integer numSS = Integer.valueOf(request.getParameter("numss"));
           List<PacienteHasMedico> lista = pacienteHasMedicoFacade.findAll();
           for(PacienteHasMedico phm : lista){
               if(phm.getMedico().getNumColegiado().equals(numC)){
                   if(phm.getPaciente().getNumSS().equals(numSS)){
                       pacienteHasMedicoFacade.remove(phm);
                   }
               }
           }
            
            RequestDispatcher rd;
            rd = this.getServletContext().getRequestDispatcher("/ListaMedicoPaciente");
            rd.forward(request, response);
          }
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
        
           Integer numC = Integer.valueOf(request.getParameter("medico"));
          
           Integer numSS = Integer.valueOf(request.getParameter("paciente"));
           
           Medico medico = (Medico)medicoFacade.find(numC);
           Paciente paciente = (Paciente)pacienteFacade.find(numSS);
           PacienteHasMedico pm = new PacienteHasMedico();
           pm.setPacienteHasMedicoPK(new PacienteHasMedicoPK(numSS,numC));
           
      
           pm.setPaciente(paciente);
           pm.setMedico(medico);
          
           pacienteHasMedicoFacade.create(pm);
           
            RequestDispatcher rd;
            rd = this.getServletContext().getRequestDispatcher("/ListaMedicoPaciente");
            rd.forward(request, response);
           
           
    
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
