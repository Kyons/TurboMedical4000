/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Avisomedico;

/**
 *
 * @author Tomás
 */
@Stateless
public class AvisomedicoFacade extends AbstractFacade<Avisomedico> implements AvisomedicoFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AvisomedicoFacade() {
        super(Avisomedico.class);
    }
    
}
