/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Formulario;

/**
 *
 * @author Sihame
 */
@Stateless
public class FormularioFacade extends AbstractFacade<Formulario> implements FormularioFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormularioFacade() {
        super(Formulario.class);
    }
    
    @Override
    public List<Formulario> findByDateAndIdTipo(Date fecha1, Date fecha2, int idTipoFormulario) {
        return em.createNamedQuery("Formulario.findByDateAndIdTipo").setParameter("fecha1", fecha1).
                  setParameter("fecha2", fecha2).setParameter("idTipoFormulario", idTipoFormulario).
                  getResultList();
    }
    
}
