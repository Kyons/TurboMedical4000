/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;
 
import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Alertas;

/**
 *
 * @author Tomás
 */
@Local
public interface AlertasFacadeLocal {

    void create(Alertas alertas);

    void edit(Alertas alertas);

    void remove(Alertas alertas);

    Alertas find(Object id);

    List<Alertas> findAll();

    List<Alertas> findRange(int[] range);

    int count();
    
}
