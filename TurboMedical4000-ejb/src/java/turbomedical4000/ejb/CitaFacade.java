/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.ejb;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import turbomedical4000.entity.Cita;
import turbomedical4000.entity.Medico;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author jorge, juan, tomas
 */
@Stateless
public class CitaFacade extends AbstractFacade<Cita> implements CitaFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitaFacade() {
        super(Cita.class);
    }
    
    @Override
    public Cita findProximasCitasPaciente(int numSS) {
        List<Cita> proximasCitas = (List<Cita>) em.createNamedQuery("Cita.findProximasCitasPaciente").setParameter("numSS", numSS).getResultList();
        
        Cita cita = null;
        if(!proximasCitas.isEmpty()){
            cita = proximasCitas.get(0);
        }

        return cita;
    }
    
     @Override
     public List<Cita> findByUsuario(Paciente usuario) {
          return em.createNamedQuery("Cita.findByUsuario").setParameter("pacientenumSS", usuario).getResultList(); 
     }

    @Override
    public List<Cita> findByMedico(Medico mediconumColegiado) {
        return em.createNamedQuery("Cita.findByMedico").setParameter("mediconumColegiado", mediconumColegiado).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cita> filtrarCitasPaciente(String fechaP, String horaP, String lugarP, String medicoP, Paciente paciente) {
        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
        Date fecha;
        try {
                fecha = df.parse(fechaP);
        } catch (ParseException e) {
                fecha = null;
        } 
        df = new java.text.SimpleDateFormat("hh:mm:ss");
        Date hora;
        try {
                hora = df.parse(fechaP);
        } catch (ParseException e) {
                hora = null;
        } 
        String lugar = lugarP == null ? "" : lugarP;
        String medico = medicoP == null ? "" : medicoP;
        
        String likeFecha = (fecha == null) ? "" : " (c.fecha = :fecha) AND ";
        String likeHora = (hora == null) ? "" : " (c.hora = :hora) AND ";
        String likeLugar = (lugar.equals("")) ? "" : " (c.lugar LIKE '%" + lugar + "%') AND ";
        String likeMedico = (medico.equals("")) ? "" : " (c.mediconumColegiado.nombre LIKE '%" + medico + "%') AND ";
        
        if(fecha!=null && hora!=null){
            return (List<Cita>) em.createQuery("SELECT c FROM Cita c "
                    + "where " + likeFecha + likeHora + likeLugar + likeMedico + 
                    " c.pacientenumSS.numSS = :paciente").setParameter("fecha", fecha).setParameter("hora",
                            hora).setParameter("paciente", paciente.getNumSS()).getResultList();
        }else if(fecha!=null){
            return (List<Cita>) em.createQuery("SELECT c FROM Cita c "
                    + "where " + likeFecha + likeHora + likeLugar + likeMedico + 
                    " c.pacientenumSS.numSS = :paciente").setParameter("fecha", 
                            fecha).setParameter("paciente", paciente.getNumSS()).getResultList();
        }else if(hora!=null){
            return (List<Cita>) em.createQuery("SELECT c FROM Cita c "
                    + "where " + likeFecha + likeHora + likeLugar + likeMedico + 
                    " c.pacientenumSS.numSS = :paciente").setParameter("hora",
                            hora).setParameter("paciente", paciente.getNumSS()).getResultList();
        }else{
            return (List<Cita>) em.createQuery("SELECT c FROM Cita c "
                    + "where " + likeFecha + likeHora + likeLugar + likeMedico + 
                    " c.pacientenumSS.numSS = :paciente").setParameter("paciente", paciente.getNumSS()).getResultList();
        }
    }
    
    @Override
    public List<Cita> filtrarCitasMedico(String fechaP, String horaP, String lugarP, String pacienteP, Medico medico) {
        java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
        Date fecha;
        try {
                fecha = df.parse(fechaP);
        } catch (ParseException e) {
                fecha = null;
        } 
        df = new java.text.SimpleDateFormat("hh:mm:ss");
        Date hora;
        try {
                hora = df.parse(fechaP);
        } catch (ParseException e) {
                hora = null;
        } 
        String lugar = lugarP == null ? "" : lugarP;
        String paciente = pacienteP == null ? "" : pacienteP;
        
        String likeFecha = (fecha == null) ? "" : " (c.fecha = :fecha) AND ";
        String likeHora = (hora == null) ? "" : " (c.hora = :hora) AND ";
        String likeLugar = (lugar.equals("")) ? "" : " (c.lugar LIKE '%" + lugar + "%') AND ";
        String likePaciente = (paciente.equals("")) ? "" : " (c.pacientenumSS.nombre LIKE '%" + paciente + "%') AND ";
        
        if(fecha!=null && hora!=null){
            return (List<Cita>) em.createQuery("SELECT c FROM Cita c "
                    + "where " + likeFecha + likeHora + likeLugar + likePaciente + 
                    " c.mediconumColegiado.numColegiado = :medico").setParameter("fecha", fecha).setParameter("hora",
                            hora).setParameter("medico", medico.getNumColegiado()).getResultList();
        }else if(fecha!=null){
            return (List<Cita>) em.createQuery("SELECT c FROM Cita c "
                    + "where " + likeFecha + likeHora + likeLugar + likePaciente + 
                    " c.mediconumColegiado.numColegiado = :medico").setParameter("fecha", 
                            fecha).setParameter("medico", medico.getNumColegiado()).getResultList();
        }else if(hora!=null){
            return (List<Cita>) em.createQuery("SELECT c FROM Cita c "
                    + "where " + likeFecha + likeHora + likeLugar + likePaciente + 
                    " c.mediconumColegiado.numColegiado = :medico").setParameter("hora",
                            hora).setParameter("medico", medico.getNumColegiado()).getResultList();
        }else{
            return (List<Cita>) em.createQuery("SELECT c FROM Cita c "
                    + "where " + likeFecha + likeHora + likeLugar + likePaciente + 
                    " c.mediconumColegiado.numColegiado = :medico").setParameter("medico", medico.getNumColegiado()).getResultList();
        }
    }

}
