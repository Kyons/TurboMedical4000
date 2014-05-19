/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
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

    
    
}
