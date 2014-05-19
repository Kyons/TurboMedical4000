/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.ejb;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author Sihame
 */
@Stateless
public class PacienteFacade extends AbstractFacade<Paciente> implements PacienteFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacienteFacade() {
        super(Paciente.class);
    }

    @Override
    public Paciente findByNumSS(int numSS) {
        Paciente paciente = null;
        try{
            paciente = (Paciente) em.createNamedQuery("Paciente.findByNumSS").setParameter("numSS", numSS).getSingleResult();
        }catch(NoResultException e){
            System.out.println("No se encontró ningún resultado");
        }
        return paciente;
    }

    @Override
    public List<Paciente> filtrarPacientes(String numSSP, String dniP, String nombreP, 
            String apellidosP, String fechaNacP, String direccionP, 
                    String localidadP, String provinciaP, String telefonoP) {
        String numSS = numSSP == null ? "" : numSSP;
        String dni = dniP == null ? "" : dniP;
        String nombre = nombreP == null ? "" : nombreP;
        String apellidos = apellidosP == null ? "" : apellidosP;
        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
        Date fechaNac = null;
        try {
                fechaNac = df.parse(fechaNacP);
        } catch (ParseException e) {
                fechaNac = null;
        }     

        //String fechaNac = fechaNacP == null ? "" : fechaNacP;
        String direccion = direccionP == null ? "" : direccionP;
        String localidad = localidadP == null ? "" : localidadP;
        String provincia = provinciaP == null ? "" : provinciaP;
        String telefono = telefonoP == null ? "" : telefonoP;
        
        String likeNumSS = (numSS.equals("")) ? "" : " (p.numSS LIKE '%" + numSS + "%') AND ";
        String likeDNI = (dni.equals("")) ? "" : " (p.dni LIKE '%" + dni + "%') AND ";
        String likeNombre = (nombre.equals("")) ? "" : " (p.nombre LIKE '%" + nombre + "%') AND ";
        String likeApellidos = (apellidos.equals("")) ? "" : " (p.apellidos LIKE '%" + apellidos + "%') AND ";
        String likeFechaNac= (fechaNac == null) ? "" : " (p.fechaNac = :fechaNac) AND ";
        String likeDireccion = (direccion.equals("")) ? "" : " (p.direccion LIKE '%" + direccion + "%') AND ";
        String likeLocalidad = (localidad.equals("")) ? "" : " (p.localidad LIKE '%" + localidad + "%') AND ";
        String likeProvincia = (provincia.equals("")) ? "" : " (p.provincia LIKE '%" + provincia + "%') AND ";
        String likeTelefono = (telefono.equals("")) ? "" : " (p.telefono LIKE '%" + telefono + "%') AND ";
        
        if(fechaNac!=null){
                
            return (List<Paciente>) em.createQuery("SELECT p FROM Paciente p " 
                    + "where " + likeNumSS + likeDNI + likeNombre + likeApellidos + likeFechaNac + 
                    likeDireccion + likeLocalidad + likeProvincia + likeTelefono+ " TRUE = TRUE").setParameter("fechaNac", fechaNac).getResultList();    
        }else{
              return (List<Paciente>) em.createQuery("SELECT p FROM Paciente p " 
                    + "where " + likeNumSS + likeDNI + likeNombre + likeApellidos + likeFechaNac + 
                    likeDireccion + likeLocalidad + likeProvincia + likeTelefono+ " TRUE = TRUE").getResultList();             
        }
    }

}
