/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Paciente;
import turbomedical4000.entity.Tratamiento;

/**
 *
 * @author jorge
 */
@Local
public interface TratamientoFacadeLocal {

    void create(Tratamiento tratamiento);

    void edit(Tratamiento tratamiento);

    void remove(Tratamiento tratamiento);

    Tratamiento find(Object id);

    List<Tratamiento> findAll();

    List<Tratamiento> findRange(int[] range);

    int count();
    
    List<Tratamiento> findActualesbyUsuario(Paciente paciente);
    
    List<Tratamiento> findPasadosbyUsuario(Paciente paciente);
    
}
