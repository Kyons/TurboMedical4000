/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Lineahistorial;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author jorge
 */
@Local
public interface LineahistorialFacadeLocal {

    void create(Lineahistorial lineahistorial);

    void edit(Lineahistorial lineahistorial);

    void remove(Lineahistorial lineahistorial);

    Lineahistorial find(Object id);

    List<Lineahistorial> findAll();
    List<Lineahistorial> findByUsuario(Paciente usuario);

    List<Lineahistorial> findRange(int[] range);

    int count();
    
    List<Lineahistorial> filtrarHistorialPaciente (String fechaP, String horaP, String entradaP, Paciente paciente);
    
}
