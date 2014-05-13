/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author Sihame
 */
@Stateless
public class PacienteFacade extends AbstractFacade<Paciente> implements PacienteFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacienteFacade() {
        super(Paciente.class);
    }

    @Override
    public Paciente findByNumSS(int numSS) {
        Paciente paciente = null;
        try{
            paciente = (Paciente) em.createNamedQuery("Paciente.findByNumSS").setParameter("numSS", numSS).getSingleResult();
        }catch(NoResultException e){
            System.out.println("No se encontró ningún resultado");
        }
        return paciente;
    }

    
    

  
    
}
