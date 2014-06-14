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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import turbomedical4000.ejb.TratamientoFacadeLocal;
import turbomedical4000.entity.Paciente;
import turbomedical4000.entity.Tratamiento;

/**
 *
 * @author jorge
 */
@ManagedBean
@ViewScoped
public class ConsultarTratamientosManagedBean {
    @EJB
    private TratamientoFacadeLocal tratamientoFacade;

    private List<Tratamiento> tratamientosActuales;
    private List<Tratamiento> tratamientosPasados;
    private boolean mostrarTratamientosPasados;
    private String mostrarOcultar;

    public String getMostrarOcultar() {
        return mostrarOcultar;
    }

    public void setMostrarOcultar(String mostrarOcultar) {
        this.mostrarOcultar = mostrarOcultar;
    }

    public boolean isMostrarTratamientosPasados() {
        return mostrarTratamientosPasados;
    }

    public void setMostrarTratamientosPasados(boolean mostrarTratamientosPasados) {
        this.mostrarTratamientosPasados = mostrarTratamientosPasados;
    }

    public List<Tratamiento> getTratamientosPasados() {
        return tratamientosPasados;
    }

    public void setTratamientosPasados(List<Tratamiento> tratamientosPasados) {
        this.tratamientosPasados = tratamientosPasados;
    }

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
        tratamientosPasados = this.tratamientoFacade.findPasadosbyUsuario(pac);
        mostrarTratamientosPasados = false;
    }
    
    public void mostrarPasados(){
        mostrarTratamientosPasados = !mostrarTratamientosPasados;
    }
    
}
