/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Cita;

/**
 *
 * @author jorge
 */
@Local
public interface CitaFacadeLocal {

    void create(Cita cita);

    void edit(Cita cita);

    void remove(Cita cita);

    Cita find(Object id);

    List<Cita> findAll();

    List<Cita> findRange(int[] range);

    int count();
    
    public Cita findCitaProxima(int numSS);
}
