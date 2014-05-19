/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Medico;

/**
 *
 * @author Sihame
 */
@Stateless
public class MedicoFacade extends AbstractFacade<Medico> implements MedicoFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicoFacade() {
        super(Medico.class);
    }

    @Override
    public Medico findByNumColegiado(int numColegiado) {
         Medico medico = null;
        try{
            medico = (Medico) em.createNamedQuery("Medico.findByNumColegiado").setParameter("numColegiado", numColegiado).getSingleResult();
        }catch(NoResultException e){
            System.out.println("No se encontró ningún resultado");
        }
        return medico;
    }

    @Override
    public List<Medico> filtrarMedicos(String numColP, String especialidadP, String nombreP, 
            String apellidosP, String fechaNacP, String dniP, 
                    String direccionP, String localidadP, String provinciaP, 
                            String telefonoP) {
        String numCol = numColP == null ? "" : numColP;
        String especialidad = especialidadP == null ? "" : especialidadP;
        String nombre = nombreP == null ? "" : nombreP;
        String apellidos = apellidosP == null ? "" : apellidosP;
//        java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy/MM/dd");
//        Date fechaNac = null;
//        try {
//                fechaNac = (Date) (fechaNacP == null ? "" : df.parse(fechaNacP));
//        } catch (ParseException e) {
//                fechaNac = null;
//        }     
//        System.out.println(fechaNac);
        String fechaNac = fechaNacP == null ? "" : fechaNacP;
        String dni = dniP == null ? "" : dniP;
        String direccion = direccionP == null ? "" : direccionP;
        String localidad = localidadP == null ? "" : localidadP;
        String provincia = provinciaP == null ? "" : provinciaP;
        String telefono = telefonoP == null ? "" : telefonoP;
        
        String likeNumCol = (numCol.equals("")) ? "" : " (m.numColegiado LIKE '%" + numCol + "%') AND ";
        String likeEspecialidad = (especialidad.equals("")) ? "" : " (m.especialidadidEspecialidad.descripcion LIKE '%" + especialidad + "%') AND ";
        String likeNombre = (nombre.equals("")) ? "" : " (m.nombre LIKE '%" + nombre + "%') AND ";
        String likeApellidos = (apellidos.equals("")) ? "" : " (m.apellidos LIKE '%" + apellidos + "%') AND ";
        String likeFechaNac= (fechaNac.equals("")) ? "" : " (m.fechaNac LIKE '" + fechaNac + "') AND ";
        String likeDNI = (dni.equals("")) ? "" : " (m.dni LIKE '%" + dni + "%') AND ";
        String likeDireccion = (direccion.equals("")) ? "" : " (m.direccion LIKE '%" + direccion + "%') AND ";
        String likeLocalidad = (localidad.equals("")) ? "" : " (m.localidad LIKE '%" + localidad + "%') AND ";
        String likeProvincia = (provincia.equals("")) ? "" : " (m.provincia LIKE '%" + provincia + "%') AND ";
        String likeTelefono = (telefono.equals("")) ? "" : " (m.telefono LIKE '%" + telefono + "%') AND ";
        
        return (List<Medico>) em.createQuery("SELECT m FROM Medico m "
                + "where " + likeNumCol + likeEspecialidad + likeNombre + likeApellidos + likeFechaNac + likeDNI +
                likeDireccion + likeLocalidad + likeProvincia + likeTelefono+ " TRUE = TRUE").getResultList();

    }

    
    }
    

