/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
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
   
    
}
