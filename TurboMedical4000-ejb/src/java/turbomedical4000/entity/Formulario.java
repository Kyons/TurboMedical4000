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
 * @author Sihame
 */
@Entity
@Table(name = "formulario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formulario.findAll", query = "SELECT f FROM Formulario f"),
    @NamedQuery(name = "Formulario.findByIdFormulario", query = "SELECT f FROM Formulario f WHERE f.idFormulario = :idFormulario"),
    @NamedQuery(name = "Formulario.findByEntrada", query = "SELECT f FROM Formulario f WHERE f.entrada = :entrada"),
    @NamedQuery(name = "Formulario.findByFecha", query = "SELECT f FROM Formulario f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Formulario.findByDateAndIdTipo", query = "SELECT f FROM Formulario f WHERE f.fecha >= :fecha1 AND f.fecha <= :fecha2 AND f.tipoFormularioidTipoFormulario.idTipoFormulario = :idTipoFormulario"),
    @NamedQuery(name = "Formulario.findByHora", query = "SELECT f FROM Formulario f WHERE f.hora = :hora")})
public class Formulario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFormulario")
    private Integer idFormulario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Entrada")
    private String entrada;
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
    @JoinColumn(name = "Paciente_numSS", referencedColumnName = "numSS")
    @ManyToOne(optional = false)
    private Paciente pacientenumSS;
    @JoinColumn(name = "TipoFormulario_idTipoFormulario", referencedColumnName = "idTipoFormulario")
    @ManyToOne(optional = false)
    private Tipoformulario tipoFormularioidTipoFormulario;

    public Formulario() {
    }

    public Formulario(Integer idFormulario) {
        this.idFormulario = idFormulario;
    }

    public Formulario(Integer idFormulario, String entrada, Date fecha, Date hora) {
        this.idFormulario = idFormulario;
        this.entrada = entrada;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Integer getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Integer idFormulario) {
        this.idFormulario = idFormulario;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
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

    public Paciente getPacientenumSS() {
        return pacientenumSS;
    }

    public void setPacientenumSS(Paciente pacientenumSS) {
        this.pacientenumSS = pacientenumSS;
    }

    public Tipoformulario getTipoFormularioidTipoFormulario() {
        return tipoFormularioidTipoFormulario;
    }

    public void setTipoFormularioidTipoFormulario(Tipoformulario tipoFormularioidTipoFormulario) {
        this.tipoFormularioidTipoFormulario = tipoFormularioidTipoFormulario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormulario != null ? idFormulario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulario)) {
            return false;
        }
        Formulario other = (Formulario) object;
        if ((this.idFormulario == null && other.idFormulario != null) || (this.idFormulario != null && !this.idFormulario.equals(other.idFormulario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.Formulario[ idFormulario=" + idFormulario + " ]";
    }
    
}
