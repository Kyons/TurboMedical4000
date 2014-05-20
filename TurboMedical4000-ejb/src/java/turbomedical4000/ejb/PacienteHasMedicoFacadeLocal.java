/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;
import turbomedical4000.entity.PacienteHasMedico;

/**
 *
 * @author Sihame
 */
@Local
public interface PacienteHasMedicoFacadeLocal {

    void create(PacienteHasMedico pacienteHasMedico);

    void edit(PacienteHasMedico pacienteHasMedico);

    void remove(PacienteHasMedico pacienteHasMedico);

    PacienteHasMedico find(Object id);

    List<PacienteHasMedico> findAll();

    List<PacienteHasMedico> findRange(int[] range);

    int count();
    
    List<PacienteHasMedico> filtrarPacMed(String pacienteP, String numSSP, String medicoP, String numColP);
   
   public List<Paciente> filtrarPacientesDelMedico(String numSSP, String dniP, String nombreP, 
            String apellidosP, String fechaNacP, String direccionP, 
                    String localidadP, String provinciaP, String telefonoP, Medico medico);
}
