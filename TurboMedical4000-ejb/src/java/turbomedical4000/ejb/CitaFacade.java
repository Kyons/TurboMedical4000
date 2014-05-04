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
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author jorge, juan, tomas
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
    public Cita findProximasCitasPaciente(int numSS) {
        List<Cita> proximasCitas = (List<Cita>) em.createNamedQuery("Cita.findProximasCitasPaciente").setParameter("numSS", numSS).getResultList();
        
        Cita cita = null;
        if(!proximasCitas.isEmpty()){
            cita = proximasCitas.get(0);
        }

        return cita;
    }
    
     @Override
     public List<Cita> findByUsuario(Paciente usuario) {
          return em.createNamedQuery("Cita.findByUsuario").setParameter("pacientenumSS", usuario).getResultList(); 
     }

    @Override
    public List<Cita> findByMedico(Medico mediconumColegiado) {
        return em.createNamedQuery("Cita.findByMedico").setParameter("mediconumColegiado", mediconumColegiado).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

}
