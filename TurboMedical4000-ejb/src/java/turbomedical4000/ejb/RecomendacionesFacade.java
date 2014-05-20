/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;
  
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Recomendaciones;

/**
 *
 * @author Tomás
 */
@Stateless
public class RecomendacionesFacade extends AbstractFacade<Recomendaciones> implements RecomendacionesFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecomendacionesFacade() {
        super(Recomendaciones.class);
    }
    
}
