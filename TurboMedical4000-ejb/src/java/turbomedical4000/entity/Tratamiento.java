/*
 * To change this template, choose Tools | Templates
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
 * @author Juan
 */
@Entity
@Table(name = "tratamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tratamiento.findAll", query = "SELECT t FROM Tratamiento t"),
    @NamedQuery(name = "Tratamiento.findByIdTratamiento", query = "SELECT t FROM Tratamiento t WHERE t.idTratamiento = :idTratamiento"),
    @NamedQuery(name = "Tratamiento.findByFechaInicio", query = "SELECT t FROM Tratamiento t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Tratamiento.findByFechaFin", query = "SELECT t FROM Tratamiento t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "Tratamiento.findByNotas", query = "SELECT t FROM Tratamiento t WHERE t.notas = :notas")})
public class Tratamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTratamiento")
    private Integer idTratamiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 130)
    @Column(name = "Notas")
    private String notas;
    @JoinColumn(name = "Paciente_numSS", referencedColumnName = "numSS")
    @ManyToOne(optional = false)
    private Paciente pacientenumSS;
    @JoinColumn(name = "Medico_numColegiado", referencedColumnName = "numColegiado")
    @ManyToOne(optional = false)
    private Medico mediconumColegiado;
    @JoinColumn(name = "Medicamento_idMedicamento", referencedColumnName = "idMedicamento")
    @ManyToOne(optional = false)
    private Medicamento medicamentoidMedicamento;

    public Tratamiento() {
    }

    public Tratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Tratamiento(Integer idTratamiento, Date fechaInicio, Date fechaFin) {
        this.idTratamiento = idTratamiento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Paciente getPacientenumSS() {
        return pacientenumSS;
    }

    public void setPacientenumSS(Paciente pacientenumSS) {
        this.pacientenumSS = pacientenumSS;
    }

    public Medico getMediconumColegiado() {
        return mediconumColegiado;
    }

    public void setMediconumColegiado(Medico mediconumColegiado) {
        this.mediconumColegiado = mediconumColegiado;
    }

    public Medicamento getMedicamentoidMedicamento() {
        return medicamentoidMedicamento;
    }

    public void setMedicamentoidMedicamento(Medicamento medicamentoidMedicamento) {
        this.medicamentoidMedicamento = medicamentoidMedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTratamiento != null ? idTratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamiento)) {
            return false;
        }
        Tratamiento other = (Tratamiento) object;
        if ((this.idTratamiento == null && other.idTratamiento != null) || (this.idTratamiento != null && !this.idTratamiento.equals(other.idTratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.Tratamiento[ idTratamiento=" + idTratamiento + " ]";
    }
    
}
