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
import turbomedical4000.entity.Lineahistorial;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author jorge
 */
@Stateless
public class LineahistorialFacade extends AbstractFacade<Lineahistorial> implements LineahistorialFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineahistorialFacade() {
        super(Lineahistorial.class);
    }

    @Override
    public List<Lineahistorial> findByUsuario(Paciente usuario) {
        return em.createNamedQuery("Lineahistorial.findByUsuario").setParameter("usuario", usuario).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
