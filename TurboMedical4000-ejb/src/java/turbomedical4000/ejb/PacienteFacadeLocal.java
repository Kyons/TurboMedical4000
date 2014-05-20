/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author Sihame
 */
@Local
public interface PacienteFacadeLocal {

    void create(Paciente paciente);

    void edit(Paciente paciente);

    void remove(Paciente paciente);

    Paciente find(Object id);

    List<Paciente> findAll();

    List<Paciente> findRange(int[] range);

    int count();
    
    public Paciente findByNumSS(int numSS);
    
    List<Paciente> filtrarPacientes(String numSSP, String dniP, String nombreP,
            String apellidosP, String fechaNacP, String direccionP,
                    String localidadP, String provinciaP, String telefonoP);
    
    public Paciente findByDni(String dni);
    
}
