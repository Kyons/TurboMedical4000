/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Administrador;

/**
 *
 * @author jorge
 */
@Stateless
public class AdministradorFacade extends AbstractFacade<Administrador> implements AdministradorFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdministradorFacade() {
        super(Administrador.class);
    }

    @Override
    public Administrador findByUsuario(String nombre) {
        Administrador administrador = null;
        try{
            administrador = (Administrador) em.createNamedQuery("Administrador.findByUsuario").setParameter("usuario", nombre).getSingleResult();
        }catch(NoResultException e){
            System.out.println("No se encontró ningún resultado");
        }
        return administrador;
    }
    
}
