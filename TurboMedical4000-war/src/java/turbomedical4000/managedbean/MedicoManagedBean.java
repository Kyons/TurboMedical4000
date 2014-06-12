/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.managedbean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author Sihame
 */
@ManagedBean
@SessionScoped
public class MedicoManagedBean {
    @EJB
    private AnotacionhistorialFacadeLocal anotacionhistorialFacade;
    @EJB
    private LineahistorialFacadeLocal lineahistorialFacade;   
    
     HttpSession sesion= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
     Medico medico = (Medico) sesion.getAttribute("medico");
     private Paciente pacienteSeleccionado;
     private Lineahistorial lineaSeleccionada;
     private Anotacionhistorial nuevaAnotacion;
     private String fechaAnotacion;
     private String horaAnotacion;
     private String entradaAnotacion;

    public Anotacionhistorial getNuevaAnotacion() {
        return nuevaAnotacion;
    }

    public void setNuevaAnotacion(Anotacionhistorial nuevaAnotacion) {
        this.nuevaAnotacion = nuevaAnotacion;
    }
     

    public Lineahistorial getLineaSeleccionada() {
        return lineaSeleccionada;
    }

    public void setLineaSeleccionada(Lineahistorial lineaSeleccionada) {
        this.lineaSeleccionada = lineaSeleccionada;
    }

    public String getFechaAnotacion() {
        return fechaAnotacion;
    }

    public void setFechaAnotacion(String fechaAnotacion) {
        this.fechaAnotacion = fechaAnotacion;
    }

    public String getHoraAnotacion() {
        return horaAnotacion;
    }

    public void setHoraAnotacion(String horaAnotacion) {
        this.horaAnotacion = horaAnotacion;
    }

    public String getEntradaAnotacion() {
        return entradaAnotacion;
    }

    public void setEntradaAnotacion(String entradaAnotacion) {
        this.entradaAnotacion = entradaAnotacion;
    }
     

    public Paciente getPacienteSeleccionado() {
        return pacienteSeleccionado;
    }

    public void setPacienteSeleccionado(Paciente pacienteSeleccionado) {
        this.pacienteSeleccionado = pacienteSeleccionado;
    }
    
    public MedicoManagedBean() {
    }
    public List<Paciente>listaPacientes(){
        List<Paciente> lista = new ArrayList<>();
        lista.addAll(medico.getPacienteCollection());
        return lista;
    }
    public List<Lineahistorial>historialPaciente(){        
        return lineahistorialFacade.findByUsuario(pacienteSeleccionado);     
       
    }
    public String consultarHistorial(Paciente pacienteSeleccionado){
        this.pacienteSeleccionado=pacienteSeleccionado;
        return "/ConsultarHistorialMedico.jsp";
    }
     public String formularioAnotacion(Lineahistorial lineaSeleccionada){
        this.lineaSeleccionada=lineaSeleccionada;
        return "/AddAnotacion.jsp";
    }
    public String addAnotacion() throws ParseException{
         this.nuevaAnotacion = new Anotacionhistorial();
         this.nuevaAnotacion.setAnotacion(this.entradaAnotacion);
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
         SimpleDateFormat formatter2 = new SimpleDateFormat("HH:MM");
         Date date = formatter.parse(this.fechaAnotacion);
         Date time = formatter2.parse(this.horaAnotacion);
         this.nuevaAnotacion.setFecha(date);
         this.nuevaAnotacion.setHora(time);
         this.nuevaAnotacion.setLineaHistorialidLineaHistorial(lineaSeleccionada);
         this.nuevaAnotacion.setIdAnotacionHistorial(2);
         anotacionhistorialFacade.create(nuevaAnotacion);
        return "/ConsultarHistorialMedico.jsp";
    }
   
}
