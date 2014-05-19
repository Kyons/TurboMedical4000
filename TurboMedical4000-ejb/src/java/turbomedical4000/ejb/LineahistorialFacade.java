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
import turbomedical4000.entity.Lineahistorial;
import turbomedical4000.entity.Paciente;

/**
 *
 * @author jorge
 */
@Stateless
public class LineahistorialFacade extends AbstractFacade<Lineahistorial> implements LineahistorialFacadeLocal {
    @PersistenceContext(unitName = "TurboMedical4000-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineahistorialFacade() {
        super(Lineahistorial.class);
    }

    @Override
    public List<Lineahistorial> findByUsuario(Paciente usuario) {
        return em.createNamedQuery("Lineahistorial.findByUsuario").setParameter("usuario", usuario).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lineahistorial> filtrarHistorialPaciente(String fechaP, String horaP, String entradaP, Paciente paciente) {
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
        String entrada = entradaP == null ? "" : entradaP;
        
        String likeFecha = (fecha == null) ? "" : " (l.fecha = :fecha) AND ";
        String likeHora = (hora == null) ? "" : " (l.hora = :hora) AND ";
        String likeEntrada = (entrada.equals("")) ? "" : " (l.entrada LIKE '%" + entrada + "%') AND ";
        
        if(fecha!=null && hora!=null){
            return (List<Lineahistorial>) em.createQuery("SELECT l FROM Lineahistorial l "
                    + "where " + likeFecha + likeHora + likeEntrada + 
                    " l.pacientenumSS.numSS = :paciente").setParameter("fecha", fecha).setParameter("hora",
                            hora).setParameter("paciente", paciente.getNumSS()).getResultList();
        }else if(fecha!=null){
            return (List<Lineahistorial>) em.createQuery("SELECT l FROM Lineahistorial l "
                    + "where " + likeFecha + likeHora + likeEntrada + 
                    " l.pacientenumSS.numSS = :paciente").setParameter("fecha", 
                            fecha).setParameter("paciente", paciente.getNumSS()).getResultList();
        }else if(hora!=null){
            return (List<Lineahistorial>) em.createQuery("SELECT l FROM Lineahistorial l "
                    + "where " + likeFecha + likeHora + likeEntrada + 
                    " l.pacientenumSS.numSS = :paciente").setParameter("hora",
                            hora).setParameter("paciente", paciente.getNumSS()).getResultList();
        }else{
            return (List<Lineahistorial>) em.createQuery("SELECT l FROM Lineahistorial l "
                    + "where " + likeFecha + likeHora + likeEntrada + 
                    " l.pacientenumSS.numSS = :paciente").setParameter("paciente", paciente.getNumSS()).getResultList();
        }
    }
    
}
