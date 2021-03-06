/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Local;
import turbomedical4000.entity.Administrador;

/**
 *
 * @author jorge
 */
@Local
public interface AdministradorFacadeLocal {

    void create(Administrador administrador);

    void edit(Administrador administrador);

    void remove(Administrador administrador);

    Administrador find(Object id);
    
    Administrador findByUsuario(String nombre);
    
    List<Administrador> filtrarAdministrador(String nombreP);

    List<Administrador> findAll();

    List<Administrador> findRange(int[] range);

    int count();
    
}
