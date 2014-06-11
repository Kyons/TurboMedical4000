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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "formulariourgencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formulariourgencia.findAll", query = "SELECT f FROM Formulariourgencia f"),
    @NamedQuery(name = "Formulariourgencia.findByIdFormularioUrgencia", query = "SELECT f FROM Formulariourgencia f WHERE f.idFormularioUrgencia = :idFormularioUrgencia"),
    @NamedQuery(name = "Formulariourgencia.findByFecha", query = "SELECT f FROM Formulariourgencia f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Formulariourgencia.findByHora", query = "SELECT f FROM Formulariourgencia f WHERE f.hora = :hora"),
    @NamedQuery(name = "Formulariourgencia.findByAsociado", query = "SELECT f FROM Formulariourgencia f WHERE f.asociado = :asociado")})
public class Formulariourgencia implements Serializable {
    @JoinColumn(name = "Medico_numColegiado", referencedColumnName = "numColegiado")
    @ManyToOne(optional = false)
    private Medico mediconumColegiado;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFormularioUrgencia")
    private Integer idFormularioUrgencia;
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
    @Column(name = "asociado")
    private int asociado;

    public Formulariourgencia() {
    }

    public Formulariourgencia(Integer idFormularioUrgencia) {
        this.idFormularioUrgencia = idFormularioUrgencia;
    }

    public Formulariourgencia(Integer idFormularioUrgencia, Date fecha, Date hora, int asociado) {
        this.idFormularioUrgencia = idFormularioUrgencia;
        this.fecha = fecha;
        this.hora = hora;
        this.asociado = asociado;
    }

    public Integer getIdFormularioUrgencia() {
        return idFormularioUrgencia;
    }

    public void setIdFormularioUrgencia(Integer idFormularioUrgencia) {
        this.idFormularioUrgencia = idFormularioUrgencia;
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

    public int getAsociado() {
        return asociado;
    }

    public void setAsociado(int asociado) {
        this.asociado = asociado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormularioUrgencia != null ? idFormularioUrgencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulariourgencia)) {
            return false;
        }
        Formulariourgencia other = (Formulariourgencia) object;
        if ((this.idFormularioUrgencia == null && other.idFormularioUrgencia != null) || (this.idFormularioUrgencia != null && !this.idFormularioUrgencia.equals(other.idFormularioUrgencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.Formulariourgencia[ idFormularioUrgencia=" + idFormularioUrgencia + " ]";
    }

    public Medico getMediconumColegiado() {
        return mediconumColegiado;
    }

    public void setMediconumColegiado(Medico mediconumColegiado) {
        this.mediconumColegiado = mediconumColegiado;
    }
    
}
