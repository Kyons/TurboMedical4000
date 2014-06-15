/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Avisomedico;

/**
 *
 * @author Tomás
 */
@Local
public interface AvisomedicoFacadeLocal {

    void create(Avisomedico avisomedico);

    void edit(Avisomedico avisomedico);

    void remove(Avisomedico avisomedico);

    Avisomedico find(Object id);

    List<Avisomedico> findAll();

    List<Avisomedico> findRange(int[] range);

    int count();
    
}
