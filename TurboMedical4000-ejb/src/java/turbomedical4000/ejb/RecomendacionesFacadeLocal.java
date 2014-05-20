/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;
 
import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Recomendaciones;

/**
 *
 * @author Tomás
 */
@Local
public interface RecomendacionesFacadeLocal {

    void create(Recomendaciones recomendaciones);

    void edit(Recomendaciones recomendaciones);

    void remove(Recomendaciones recomendaciones);

    Recomendaciones find(Object id);

    List<Recomendaciones> findAll();

    List<Recomendaciones> findRange(int[] range);

    int count();
    
}
