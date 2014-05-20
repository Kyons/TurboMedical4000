/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Alertas;

/**
 *
 * @author Tomás
 */
@Stateless
public class AlertasFacade extends AbstractFacade<Alertas> implements AlertasFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlertasFacade() {
        super(Alertas.class);
    }
    
}
