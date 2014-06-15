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
 * @author Tomás
 */
@Entity
@Table(name = "avisomedico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avisomedico.findAll", query = "SELECT a FROM Avisomedico a"),
    @NamedQuery(name = "Avisomedico.findByIdAvisoMedico", query = "SELECT a FROM Avisomedico a WHERE a.idAvisoMedico = :idAvisoMedico"),
    @NamedQuery(name = "Avisomedico.findByNumColegiado", query = "SELECT a FROM Avisomedico a WHERE a.numColegiado = :numColegiado"),
    @NamedQuery(name = "Avisomedico.findByFechaAviso", query = "SELECT a FROM Avisomedico a WHERE a.fechaAviso = :fechaAviso"),
    @NamedQuery(name = "Avisomedico.findByTexto", query = "SELECT a FROM Avisomedico a WHERE a.texto = :texto"),
    @NamedQuery(name = "Avisomedico.findByHora", query = "SELECT a FROM Avisomedico a WHERE a.hora = :hora")})
public class Avisomedico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAvisoMedico")
    private Integer idAvisoMedico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numColegiado")
    private int numColegiado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaAviso")
    @Temporal(TemporalType.DATE)
    private Date fechaAviso;
    @Size(max = 45)
    @Column(name = "Texto")
    private String texto;
    @Column(name = "Hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "TipoAviso_idTipoAviso", referencedColumnName = "idTipoAviso")
    @ManyToOne(optional = false)
    private Tipoaviso tipoAvisoidTipoAviso;

    public Avisomedico() {
    }

    public Avisomedico(Integer idAvisoMedico) {
        this.idAvisoMedico = idAvisoMedico;
    }

    public Avisomedico(Integer idAvisoMedico, int numColegiado, Date fechaAviso) {
        this.idAvisoMedico = idAvisoMedico;
        this.numColegiado = numColegiado;
        this.fechaAviso = fechaAviso;
    }

    public Integer getIdAvisoMedico() {
        return idAvisoMedico;
    }

    public void setIdAvisoMedico(Integer idAvisoMedico) {
        this.idAvisoMedico = idAvisoMedico;
    }

    public int getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(int numColegiado) {
        this.numColegiado = numColegiado;
    }

    public Date getFechaAviso() {
        return fechaAviso;
    }

    public void setFechaAviso(Date fechaAviso) {
        this.fechaAviso = fechaAviso;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Tipoaviso getTipoAvisoidTipoAviso() {
        return tipoAvisoidTipoAviso;
    }

    public void setTipoAvisoidTipoAviso(Tipoaviso tipoAvisoidTipoAviso) {
        this.tipoAvisoidTipoAviso = tipoAvisoidTipoAviso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvisoMedico != null ? idAvisoMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avisomedico)) {
            return false;
        }
        Avisomedico other = (Avisomedico) object;
        if ((this.idAvisoMedico == null && other.idAvisoMedico != null) || (this.idAvisoMedico != null && !this.idAvisoMedico.equals(other.idAvisoMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.Avisomedico[ idAvisoMedico=" + idAvisoMedico + " ]";
    }
    
}
