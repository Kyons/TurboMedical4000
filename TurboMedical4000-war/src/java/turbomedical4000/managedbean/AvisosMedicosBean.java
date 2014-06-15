/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.managedbean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import turbomedical4000.ejb.AvisomedicoFacadeLocal;
import turbomedical4000.ejb.TipoavisoFacadeLocal;
import turbomedical4000.entity.Avisomedico;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Tratamiento;

/**
 *
 * @author Tomás
 */
@ManagedBean
@RequestScoped
public class AvisosMedicosBean {
    @EJB
    private AvisomedicoFacadeLocal avisoMedico;    
    @EJB
    private TipoavisoFacadeLocal tipoAviso;
    
    private List<Avisomedico> avisos;
    private Medico medico;
    
    @PostConstruct
    public void init(){
        avisos=this.avisoMedico.findAll();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(true);
        medico = (Medico) sesion.getAttribute("medico"); //con esto ya tengo el medico
        
        
    }
    
    /**
     * Creates a new instance of AvisosMedicosBean
     */
    public AvisosMedicosBean() {
    }

    public AvisomedicoFacadeLocal getAvisoMedico() {
        return avisoMedico;
    }

    public void setAvisoMedico(AvisomedicoFacadeLocal avisoMedico) {
        this.avisoMedico = avisoMedico;
    }

    public TipoavisoFacadeLocal getTipoAviso() {
        return tipoAviso;
    }

    public void setTipoAviso(TipoavisoFacadeLocal tipoAviso) {
        this.tipoAviso = tipoAviso;
    }

    public List<Avisomedico> getAvisos() {
        return avisos;
    }

    public void setAvisos(List<Avisomedico> avisos) {
        this.avisos = avisos;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    
    
}
