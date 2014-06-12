/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Anotacionhistorial;
import turbomedical4000.entity.Lineahistorial;

/**
 *
 * @author Juan
 */
@Local
public interface AnotacionhistorialFacadeLocal {

    void create(Anotacionhistorial anotacionhistorial);

    void edit(Anotacionhistorial anotacionhistorial);

    void remove(Anotacionhistorial anotacionhistorial);

    Anotacionhistorial find(Object id);

    List<Anotacionhistorial> findAll();

    List<Anotacionhistorial> findRange(int[] range);

    int count();

    public List<Anotacionhistorial> findByLineaHistorial(Lineahistorial lineaSeleccionada);
    
}
