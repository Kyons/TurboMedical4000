/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Cita;

/**
 *
 * @author jorge, juan
 */
@Stateless
public class CitaFacade extends AbstractFacade<Cita> implements CitaFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitaFacade() {
        super(Cita.class);
    }
    
    @Override
    public Cita findProximaCitaPaciente(int numSS) {
        Cita cita = null;
        try{
            cita = (Cita) em.createNamedQuery("Cita.findProximaCitaPaciente").setParameter("numSS", numSS).getSingleResult();
        }catch(NoResultException e){
            System.out.println("No se encontró ningún resultado");
        }        
        return cita;
    }
}
