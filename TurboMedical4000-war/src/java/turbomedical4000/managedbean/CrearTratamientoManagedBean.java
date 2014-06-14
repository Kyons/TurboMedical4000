/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.managedbean;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import turbomedical4000.ejb.MedicamentoFacadeLocal;
import turbomedical4000.ejb.PacienteFacadeLocal;
import turbomedical4000.ejb.TratamientoFacadeLocal;
import turbomedical4000.entity.Medicamento;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;
import turbomedical4000.entity.Tratamiento;

/**
 *
 * @author jorge
 */
@ManagedBean
@ViewScoped
public class CrearTratamientoManagedBean {
    @EJB
    private PacienteFacadeLocal pacienteFacade;
    @EJB
    private MedicamentoFacadeLocal medicamentoFacade;
    @EJB
    private TratamientoFacadeLocal tratamientoFacade;
    

    private List<Medicamento> medicamentos;
    private int medicamentoSeleccionado;
    private List<Paciente> pacientes;
    private int pacienteSeleccionado;
    private Tratamiento tratamiento;
    private Medico medico;

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public int getPacienteSeleccionado() {
        return pacienteSeleccionado;
    }

    public void setPacienteSeleccionado(int pacienteSeleccionado) {
        this.pacienteSeleccionado = pacienteSeleccionado;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    

    public int getMedicamentoSeleccionado() {
        return medicamentoSeleccionado;
    }

    public void setMedicamentoSeleccionado(int medicamentoSeleccionado) {
        this.medicamentoSeleccionado = medicamentoSeleccionado;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
    /**
     * Creates a new instance of CrearTratamientoManagedBean
     */
    public CrearTratamientoManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        medicamentos = this.medicamentoFacade.findAll();
        tratamiento = new Tratamiento();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(true);
        medico = (Medico) sesion.getAttribute("medico");
        pacientes = medico.getPacienteList();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        if(request.getParameter("id") != null){
            this.pacienteSeleccionado = Integer.parseInt(request.getParameter("id"));
        }
    }
    
    public void crearTratamiento(){
        if(tratamiento.getFechaInicio().before(tratamiento.getFechaFin()) && tratamiento.getFechaInicio().after(new Date())){
            tratamiento.setMedicamentoidMedicamento(this.medicamentoFacade.find(this.medicamentoSeleccionado));
            tratamiento.setMediconumColegiado(this.medico);
            tratamiento.setPacientenumSS(this.pacienteFacade.find(this.pacienteSeleccionado));

            this.tratamientoFacade.create(tratamiento);

            tratamiento = new Tratamiento();

            String message = "Tratamiento creado con éxito";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
        }else{
            String message; 
            if(!tratamiento.getFechaInicio().after(new Date())){
                message = "La fecha de inicio no puede ser una fecha ya pasada";
                
            }else{
                message = "La fecha de fin tiene que ser posterior a la de inicio";
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
        }
    }
    

}
