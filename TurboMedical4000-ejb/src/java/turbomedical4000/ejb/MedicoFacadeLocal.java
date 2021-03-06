/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Medico;

/**
 *
 * @author Sihame
 */
@Local
public interface MedicoFacadeLocal {

    void create(Medico medico);

    void edit(Medico medico);

    void remove(Medico medico);

    Medico find(Object id);

    List<Medico> findAll();

    List<Medico> findRange(int[] range);

    int count();
    
    
    List<Medico> filtrarMedicos(String numColP, String especialidadP, String nombreP,
            String apellidosP, String fechaNacP,  String dniP,
                    String direccionP, String localidadP, String provinciaP, 
                            String telefonoP);
   
    public Medico findByDni(String dni);
        
}
