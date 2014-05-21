/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;
import turbomedical4000.entity.PacienteHasMedico;

/**
 *
 * @author Sihame
 */
@Stateless
public class PacienteHasMedicoFacade extends AbstractFacade<PacienteHasMedico> implements PacienteHasMedicoFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacienteHasMedicoFacade() {
        super(PacienteHasMedico.class);
    }

    @Override
    public List<PacienteHasMedico> filtrarPacMed(String pacienteP, String numSSP, String medicoP, String numColP) {
        String paciente = pacienteP == null ? "" : pacienteP;
        String numSS = numSSP == null ? "" : numSSP;
        String medico = medicoP == null ? "" : medicoP;
        String numCol = numColP == null ? "" : numColP;
        
        String likePaciente = (paciente.equals("")) ? "" : " (p.paciente.nombre LIKE '%" + paciente + "%') AND ";
        String likeNumSS = (numSS.equals("")) ? "" : " (p.paciente.numSS LIKE '%" + numSS + "%') AND ";
        String likeMedico = (medico.equals("")) ? "" : " (p.medico.nombre LIKE '%" + medico + "%') AND ";
        String likeNumCol = (numCol.equals("")) ? "" : " (p.medico.numColegiado LIKE '%" + numCol + "%') AND ";
        
        return (List<PacienteHasMedico>) em.createQuery("SELECT p FROM PacienteHasMedico p "
                + "where " + likePaciente + likeNumSS + likeMedico + likeNumCol + " TRUE = TRUE").getResultList();
    }
    
    @Override
    public List<Paciente> filtrarPacientesDelMedico(String numSSP, String dniP, String nombreP, 
            String apellidosP, String fechaNacP, String direccionP, 
                    String localidadP, String provinciaP, String telefonoP, Medico medico) {
        
        String numSS = numSSP == null ? "" : numSSP;
        String dni = dniP == null ? "" : dniP;
        String nombre = nombreP == null ? "" : nombreP;
        String apellidos = apellidosP == null ? "" : apellidosP;
        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
        Date fechaNac;
        try {
                fechaNac = df.parse(fechaNacP);
        } catch (ParseException e) {
                fechaNac = null;
        }     

        String direccion = direccionP == null ? "" : direccionP;
        String localidad = localidadP == null ? "" : localidadP;
        String provincia = provinciaP == null ? "" : provinciaP;
        String telefono = telefonoP == null ? "" : telefonoP;
        
        String likeNumSS = (numSS.equals("")) ? "" : " (p.paciente.numSS LIKE '%" + numSS + "%') AND ";
        String likeDNI = (dni.equals("")) ? "" : " (p.paciente.dni LIKE '%" + dni + "%') AND ";
        String likeNombre = (nombre.equals("")) ? "" : " (p.paciente.nombre LIKE '%" + nombre + "%') AND ";
        String likeApellidos = (apellidos.equals("")) ? "" : " (p.paciente.apellidos LIKE '%" + apellidos + "%') AND ";
        String likeFechaNac= (fechaNac == null) ? "" : " (p.paciente.fechaNac = :fechaNac) AND ";
        String likeDireccion = (direccion.equals("")) ? "" : " (p.paciente.direccion LIKE '%" + direccion + "%') AND ";
        String likeLocalidad = (localidad.equals("")) ? "" : " (p.paciente.localidad LIKE '%" + localidad + "%') AND ";
        String likeProvincia = (provincia.equals("")) ? "" : " (p.paciente.provincia LIKE '%" + provincia + "%') AND ";
        String likeTelefono = (telefono.equals("")) ? "" : " (p.paciente.telefono LIKE '%" + telefono + "%') AND ";
        
        List<PacienteHasMedico> lista;
        if(fechaNac!=null){
                
            lista = (List<PacienteHasMedico>) em.createQuery("SELECT p FROM PacienteHasMedico p " 
                    + "where " + likeNumSS + likeDNI + likeNombre + likeApellidos + likeFechaNac + 
                    likeDireccion + likeLocalidad + likeProvincia + likeTelefono+ 
                    " p.medico.numColegiado = :medico").setParameter("medico", medico.getNumColegiado()).setParameter("fechaNac", fechaNac).getResultList();    
        }else{
            lista = (List<PacienteHasMedico>) em.createQuery("SELECT p FROM PacienteHasMedico p " 
                    + "where " + likeNumSS + likeDNI + likeNombre + likeApellidos + likeFechaNac + 
                    likeDireccion + likeLocalidad + likeProvincia + likeTelefono+ 
                    " p.medico.numColegiado = :medico").setParameter("medico", medico.getNumColegiado()).getResultList();             
        }
        
        List<Paciente> pacientes = new ArrayList<>();
        for(PacienteHasMedico p:lista){
            pacientes.add(p.getPaciente());
        }
        
        return pacientes;
    }
    
    @Override
    public List<Medico> medicosDelPaciente(Paciente pac){
        List<PacienteHasMedico> lista = (List<PacienteHasMedico>) em.createNamedQuery("PacienteHasMedico.findByPacientenumSS").setParameter("pacientenumSS", pac.getNumSS()).getResultList();
        
        List<Medico> medicos = new ArrayList<>();
        for(PacienteHasMedico p:lista){
            medicos.add(p.getMedico());
        }
        
        return medicos;
    }   
}
