/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Formulariourgencia;

/**
 *
 * @author Juan
 */
@Stateless
public class FormulariourgenciaFacade extends AbstractFacade<Formulariourgencia> implements FormulariourgenciaFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormulariourgenciaFacade() {
        super(Formulariourgencia.class);
    }
    
}
