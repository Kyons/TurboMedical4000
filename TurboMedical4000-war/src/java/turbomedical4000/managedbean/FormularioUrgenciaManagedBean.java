/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.managedbean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable; 
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import turbomedical4000.ejb.FormulariourgenciaFacadeLocal;
import turbomedical4000.ejb.LineahistorialFacadeLocal;
import turbomedical4000.ejb.PacienteFacadeLocal;
import turbomedical4000.entity.Formulariourgencia;
import turbomedical4000.entity.Lineahistorial;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author Juan
 */
@Named(value = "formularioUrgenciaManagedBean")
@SessionScoped
public class FormularioUrgenciaManagedBean implements Serializable {
    @EJB
    private LineahistorialFacadeLocal lineahistorialFacade;
    @EJB
    private PacienteFacadeLocal pacienteFacade;
    @EJB
    private FormulariourgenciaFacadeLocal formulariourgenciaFacade;
    
    private Medico medico;
    private List<Formulariourgencia> listaFormUrg;
    private Formulariourgencia formularioSeleccionado;
    private Formulariourgencia nuevoFormulario;
    private int pacienteAsociado;

    public int getPacienteAsociado() {
        return pacienteAsociado;
    }

    public void setPacienteAsociado(int pacienteAsociado) {
        this.pacienteAsociado = pacienteAsociado;
    }

    public Formulariourgencia getNuevoFormulario() {
        return nuevoFormulario;
    }

    public void setNuevoFormulario(Formulariourgencia nuevoFormulario) {
        this.nuevoFormulario = nuevoFormulario;
    }

    public Formulariourgencia getFormularioSeleccionado() {
        return formularioSeleccionado;
    }

    public void setFormularioSeleccionado(Formulariourgencia formularioSeleccionado) {
        this.formularioSeleccionado = formularioSeleccionado;
    }

    public List<Formulariourgencia> getListaFormUrg() {
        return listaFormUrg;
    }

    public void setListaFormUrg(List<Formulariourgencia> listaFormUrg) {
        this.listaFormUrg = listaFormUrg;
    }
    
    /**
     * Creates a new instance of FormularioUrgenciaManagedBean
     */
    public FormularioUrgenciaManagedBean() {
    }
    
    @PostConstruct
    public void create(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(true);
        medico = (Medico) sesion.getAttribute("medico");
        
        //medico = new Medico(1);
        listaFormUrg = this.formulariourgenciaFacade.findAll();
    }
    
    public String campoAsociado(int asociado){
        String campo;
        
        if(asociado == 0){
            campo = "<span class=\"noAsociado\">No</span> ";
        }else{
            campo = "<span class=\"siAsociado\">Si</span> ";
        }
        
        return campo;
    }
    
    public String asociarFormulario(Formulariourgencia formularioSeleccionado){
        this.formularioSeleccionado = formularioSeleccionado;
        pacienteAsociado = 0;
        return "AsociarFormularioUrgencia.jsf";
    }
    
    public SelectItem[] getListaPacientes(){
        SelectItem[] pacientes = null;
        
        List<Paciente> lista = pacienteFacade.findAll();

        int i = 0;
        pacientes = new SelectItem[lista.size() + 1];
            
        SelectItem paciente = new SelectItem(0, "No identificado");
        pacientes[i++] = paciente;
        
        if (lista != null && lista.size() > 0){
            for (Paciente p : lista){
                SelectItem item = new SelectItem(p.getNumSS(), p.getNumSS() + " (" + p.getApellidos() + ", " + p.getNombre() + ")");
                pacientes[i++] = item;
            }
        }

        return pacientes;
    }
    
    public void asociaYCreaHistorial(int tipo){
        int asoc = 0;
        
        if(pacienteAsociado != 0){
            asoc = 1;
            Formulariourgencia form;
            
            if(tipo == 0){ // Edicion
                form = formularioSeleccionado;
            }else{ // Creación
                form = nuevoFormulario;
            } 
            
            String entradaLineaHist = "Urgencias (ID: " + form.getIdFormularioUrgencia() + ")";
            Lineahistorial lineaHist = new Lineahistorial(1, form.getFecha(), form.getHora(), entradaLineaHist);
            
            lineaHist.setPacientenumSS(pacienteFacade.find(pacienteAsociado));
            lineaHist.setMediconumColegiado(medico);        
            lineahistorialFacade.create(lineaHist);
        }

        if(tipo == 0){ // Edicion
                formularioSeleccionado.setAsociado(asoc);
        }else{ // Creación
                nuevoFormulario.setAsociado(asoc);
        }   
    }
    
    public String asociar(){
        asociaYCreaHistorial(0);
        formulariourgenciaFacade.edit(formularioSeleccionado);
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Formulario " + formularioSeleccionado.getIdFormularioUrgencia() + " asociado a un paciente."); 
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, mensaje);
        return "ListaFormulariosUrgencia.jsf";
    }
    
    public String crearFormulario(){
        nuevoFormulario = new Formulariourgencia();
        pacienteAsociado = 0;
        return "addFormularioUrgencia.jsf";
    }
    
    public String crear(){
        nuevoFormulario.setMediconumColegiado(medico);
        nuevoFormulario.setFecha(new Date());
        nuevoFormulario.setHora(new Date());
        formulariourgenciaFacade.create(nuevoFormulario);
        asociaYCreaHistorial(1);
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Formulario " + nuevoFormulario.getIdFormularioUrgencia() + " creado."); 
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, mensaje);
        return null;
    }
}
