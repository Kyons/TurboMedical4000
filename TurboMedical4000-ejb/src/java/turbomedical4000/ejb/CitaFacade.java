/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Cita;

/**
 *
 * @author jorge
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
    public Cita findCitaProxima(int numSS) {
        List<Cita> listaCitas = em.createNamedQuery("Cita.findCitaProxima").setParameter("numSS", numSS).getResultList();
    
        Cita cita;
                
        if(!listaCitas.isEmpty()){
           cita = listaCitas.get(0);
        }else{
            cita = new Cita(-1);
        }
        
        return cita;
    }
}
