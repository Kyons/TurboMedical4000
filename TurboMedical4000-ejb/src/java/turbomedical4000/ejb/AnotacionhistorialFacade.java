/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Anotacionhistorial;
import turbomedical4000.entity.Lineahistorial;

/**
 *
 * @author Juan
 */
@Stateless
public class AnotacionhistorialFacade extends AbstractFacade<Anotacionhistorial> implements AnotacionhistorialFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnotacionhistorialFacade() {
        super(Anotacionhistorial.class);
    }

    @Override
    public List<Anotacionhistorial> findByLineaHistorial(Lineahistorial lineaSeleccionada) {
        return em.createNamedQuery("Anotacionhistorial.findByLineaHistorial").setParameter("lineaHistorialidLineaHistorial", lineaSeleccionada).getResultList();
    }
    
}
