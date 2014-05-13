/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Tipoformulario;

/**
 *
 * @author Sihame
 */
@Local
public interface TipoformularioFacadeLocal {

    void create(Tipoformulario tipoformulario);

    void edit(Tipoformulario tipoformulario);

    void remove(Tipoformulario tipoformulario);

    Tipoformulario find(Object id);

    List<Tipoformulario> findAll();

    List<Tipoformulario> findRange(int[] range);

    int count();
    
}
