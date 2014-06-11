/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Formulariourgencia;

/**
 *
 * @author Juan
 */
@Local
public interface FormulariourgenciaFacadeLocal {

    void create(Formulariourgencia formulariourgencia);

    void edit(Formulariourgencia formulariourgencia);

    void remove(Formulariourgencia formulariourgencia);

    Formulariourgencia find(Object id);

    List<Formulariourgencia> findAll();

    List<Formulariourgencia> findRange(int[] range);

    int count();
    
}
