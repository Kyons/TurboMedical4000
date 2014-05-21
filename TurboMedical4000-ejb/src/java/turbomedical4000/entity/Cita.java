/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorge, juan
 */
@Entity
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByIdCita", query = "SELECT c FROM Cita c WHERE c.idCita = :idCita"),
    @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cita.findByHora", query = "SELECT c FROM Cita c WHERE c.hora = :hora"),
    @NamedQuery(name = "Cita.findByUsuario", query = "SELECT c FROM Cita c WHERE c.pacientenumSS= :pacientenumSS"),
    @NamedQuery(name = "Cita.findByMedico", query = "SELECT c FROM Cita c WHERE c.mediconumColegiado= :mediconumColegiado"),
    @NamedQuery(name = "Cita.findProximasCitasPaciente", query = "SELECT c FROM Cita c WHERE c.pacientenumSS.numSS = :numSS AND c.fecha >= :fecha"),
    @NamedQuery(name = "Cita.findByLugar", query = "SELECT c FROM Cita c WHERE c.lugar = :lugar")})
public class Cita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCita")
    private Integer idCita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Lugar")
    private String lugar;
    @JoinColumn(name = "Medico_numColegiado", referencedColumnName = "numColegiado")
    @ManyToOne(optional = false)
    private Medico mediconumColegiado;
    @JoinColumn(name = "Paciente_numSS", referencedColumnName = "numSS")
    @ManyToOne(optional = false)
    private Paciente pacientenumSS;

    public Cita() {
    }

    public Cita(Integer idCita) {
        this.idCita = idCita;
    }

    public Cita(Integer idCita, Date fecha, Date hora, String lugar) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Medico getMediconumColegiado() {
        return mediconumColegiado;
    }

    public void setMediconumColegiado(Medico mediconumColegiado) {
        this.mediconumColegiado = mediconumColegiado;
    }

    public Paciente getPacientenumSS() {
        return pacientenumSS;
    }

    public void setPacientenumSS(Paciente pacientenumSS) {
        this.pacientenumSS = pacientenumSS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.Cita[ idCita=" + idCita + " ]";
    }
    
}
