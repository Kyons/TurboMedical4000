/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

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

    
    
}
