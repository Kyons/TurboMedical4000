/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.managedbean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import turbomedical4000.ejb.TratamientoFacadeLocal;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;
import turbomedical4000.entity.Tratamiento;

/**
 *
 * @author jorge
 */
@ManagedBean
@RequestScoped
public class ConsultarTratamientosManagedBean {
    @EJB
    private TratamientoFacadeLocal tratamientoFacade;

    List<Tratamiento> tratamientosActuales;

    public List<Tratamiento> getTratamientosActuales() {
        return tratamientosActuales;
    }

    public void setTratamientosActuales(List<Tratamiento> tratamientosActuales) {
        this.tratamientosActuales = tratamientosActuales;
    }
    /**
     * Creates a new instance of ConsultarTratamientos
     */
    public ConsultarTratamientosManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(true);
        Paciente pac = (Paciente) sesion.getAttribute("paciente");
        tratamientosActuales = this.tratamientoFacade.findActualesbyUsuario(pac);
    }
    
}
