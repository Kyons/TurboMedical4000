/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Cita;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author jorge, juan, tomas
 */
@Local
public interface CitaFacadeLocal {

    void create(Cita cita);

    void edit(Cita cita);

    void remove(Cita cita);

    Cita find(Object id);

    List<Cita> findAll();
    
    List<Cita> findByUsuario(Paciente usuario);

    List<Cita> findRange(int[] range);

    int count();
    
    public Cita findProximasCitasPaciente(int numSS);
    
    List<Cita> findByMedico (Medico mediconumColegiado);
    
    List<Cita> filtrarCitasPaciente (String fechaP, String horaP, String lugarP, String medicoP, Paciente paciente);
    
    List<Cita> filtrarCitasMedico (String fechaP, String horaP, String lugarP, String pacienteP, Medico medico);
}
