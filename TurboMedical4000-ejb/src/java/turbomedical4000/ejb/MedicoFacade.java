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
public class MedicoFacade extends AbstractFacade<Medico> implements MedicoFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicoFacade() {
        super(Medico.class);
    }

    @Override
    public Medico findByNumColegiado(int numColegiado) {
         Medico medico = null;
        try{
            medico = (Medico) em.createNamedQuery("Medico.findByNumColegiado").setParameter("numColegiado", numColegiado).getSingleResult();
        }catch(NoResultException e){
            System.out.println("No se encontró ningún resultado");
        }
        return medico;
    }

    
    }
    

