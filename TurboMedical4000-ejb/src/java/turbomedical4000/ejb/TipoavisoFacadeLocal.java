/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Tipoaviso;

/**
 *
 * @author Tomás
 */
@Local
public interface TipoavisoFacadeLocal {

    void create(Tipoaviso tipoaviso);

    void edit(Tipoaviso tipoaviso);

    void remove(Tipoaviso tipoaviso);

    Tipoaviso find(Object id);

    List<Tipoaviso> findAll();

    List<Tipoaviso> findRange(int[] range);

    int count();
    
}
