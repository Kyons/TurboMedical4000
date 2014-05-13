/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Especialidad;

/**
 *
 * @author Sihame
 */
@Local
public interface EspecialidadFacadeLocal {

    void create(Especialidad especialidad);

    void edit(Especialidad especialidad);

    void remove(Especialidad especialidad);

    Especialidad find(Object id);

    List<Especialidad> findAll();

    List<Especialidad> findRange(int[] range);

    int count();
    
}
