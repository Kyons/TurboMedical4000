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
import turbomedical4000.entity.Paciente;
import turbomedical4000.entity.Tratamiento;

/**
 *
 * @author jorge
 */
@Stateless
public class TratamientoFacade extends AbstractFacade<Tratamiento> implements TratamientoFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TratamientoFacade() {
        super(Tratamiento.class);
    }

    @Override
    public List<Tratamiento> findActualesbyUsuario(Paciente paciente) {
        return em.createNamedQuery("Tratamiento.findActuales").setParameter("paciente", paciente).getResultList();
    }
    
}
