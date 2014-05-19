/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import turbomedical4000.ejb.FormularioFacadeLocal;
import turbomedical4000.ejb.TipoformularioFacadeLocal;
import turbomedical4000.entity.Formulario;
import turbomedical4000.entity.Tipoformulario;

/**
 *
 * @author Juan
 */
@WebServlet(name = "GenerarInformeServlet", urlPatterns = {"/GenerarInformeServlet"})
public class GenerarInformeServlet extends HttpServlet {
    @EJB
    private FormularioFacadeLocal formularioFacade;
    @EJB
    private TipoformularioFacadeLocal tipoformularioFacade;

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
        
        // Obtener los tipos de formulario a incluir
        String[] idTiposFormulario = request.getParameterValues("idTiposFormulario");
        
        // Obtener fecha 1 y fecha 2
        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
        Date fecha1 = null;
        try {
            fecha1 = df.parse(request.getParameter("fecha1"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date fecha2 = null;
        try {
            fecha2 = df.parse(request.getParameter("fecha2"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        /*
         * Al tener el campo hidden con valor -1 en el formulario, siempre tendremos
         * al menos un valor aunque no se seleccione ningun tipo, lo que facilita el
         * control al evitar acceso a punteros nulos y demás
         */
        if (idTiposFormulario.length == 1){ // Si no se ha seleccionado algún tipo de fomrulario
            request.setAttribute("ninguno", true);
        }else{ // Si se ha seleccionado algun tipo
            request.setAttribute("ninguno", false);

            // Se crea un mapa para almacenar las listas de formularios
            Map<Tipoformulario,List<Formulario>> formularios = new HashMap<Tipoformulario,List<Formulario>>();
            
            for (String id: idTiposFormulario) {
                int numId = Integer.valueOf(id);
                if(numId != -1){
                    // Obtener el tipo de formulario
                    Tipoformulario tipo = tipoformularioFacade.find(numId);
                
                    List<Formulario> listaFormul = formularioFacade.findByDateAndIdTipo(fecha1,fecha2,numId);
                    formularios.put(tipo, listaFormul);
                }
            }
            
            request.setAttribute("formularios",formularios);
        }
        
        request.setAttribute("fecha1", fecha1);
        request.setAttribute("fecha2", fecha2);
        
        // Redirigir a la página que muestra el informe
        RequestDispatcher rd;
        
        rd = this.getServletContext().getRequestDispatcher("/mostrarInforme.jsp");
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
