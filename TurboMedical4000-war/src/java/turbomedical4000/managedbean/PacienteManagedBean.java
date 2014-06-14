/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.managedbean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import turbomedical4000.ejb.AnotacionhistorialFacadeLocal;
import turbomedical4000.ejb.LineahistorialFacadeLocal;
import turbomedical4000.entity.Anotacionhistorial;
import turbomedical4000.entity.Lineahistorial;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author Sihame
 */
@ManagedBean
@SessionScoped
public class PacienteManagedBean {
    @EJB
    private LineahistorialFacadeLocal lineahistorialFacade;
    @EJB
    private AnotacionhistorialFacadeLocal anotacionhistorialFacade;
    private Lineahistorial lineaSeleccionada;

    public Lineahistorial getLineaSeleccionada() {
        return lineaSeleccionada;
    }

    public void setLineaSeleccionada(Lineahistorial lineaSeleccionada) {
        this.lineaSeleccionada = lineaSeleccionada;
    }
    
    
     HttpSession sesion= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
     Paciente paciente = (Paciente) sesion.getAttribute("paciente");

    /**
     * Creates a new instance of PacienteManagedBean
     */
    public PacienteManagedBean() {
    }
    public String consultarHistorial(){       
        return "/ConsultarHistorialPersonal.jsf";
    }
    
    public List<Lineahistorial>historialPersonal(){
        return lineahistorialFacade.findByUsuario(paciente);
    }
     public String consultarAnotaciones(Lineahistorial lineaSeleccionada){
        this.lineaSeleccionada=lineaSeleccionada;
        return "/ConsultarAnotacionesPersonales.jsf";
    }
    public List<Anotacionhistorial> anotacionesPersonales(){
        return anotacionhistorialFacade.findByLineaHistorial(this.lineaSeleccionada);
    }
}
