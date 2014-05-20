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
import javax.persistence.Id;
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
@Table(name = "recomendaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recomendaciones.findAll", query = "SELECT r FROM Recomendaciones r"),
    @NamedQuery(name = "Recomendaciones.findByIdReco", query = "SELECT r FROM Recomendaciones r WHERE r.idReco = :idReco"),
    @NamedQuery(name = "Recomendaciones.findByNumSS", query = "SELECT r FROM Recomendaciones r WHERE r.numSS = :numSS"),
    @NamedQuery(name = "Recomendaciones.findByNumColegiado", query = "SELECT r FROM Recomendaciones r WHERE r.numColegiado = :numColegiado"),
    @NamedQuery(name = "Recomendaciones.findByFechaReco", query = "SELECT r FROM Recomendaciones r WHERE r.fechaReco = :fechaReco"),
    @NamedQuery(name = "Recomendaciones.findByTexto", query = "SELECT r FROM Recomendaciones r WHERE r.texto = :texto"),
    @NamedQuery(name = "Recomendaciones.findByHora", query = "SELECT r FROM Recomendaciones r WHERE r.hora = :hora")})
public class Recomendaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idReco")
    private Integer idReco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numSS")
    private int numSS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numColegiado")
    private int numColegiado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaReco")
    @Temporal(TemporalType.DATE)
    private Date fechaReco;
    @Size(max = 45)
    @Column(name = "Texto")
    private String texto;
    @Column(name = "Hora")
    @Temporal(TemporalType.TIME)
    private Date hora;

    public Recomendaciones() {
    }

    public Recomendaciones(Integer idReco) {
        this.idReco = idReco;
    }

    public Recomendaciones(Integer idReco, int numSS, int numColegiado, Date fechaReco) {
        this.idReco = idReco;
        this.numSS = numSS;
        this.numColegiado = numColegiado;
        this.fechaReco = fechaReco;
    }

    public Integer getIdReco() {
        return idReco;
    }

    public void setIdReco(Integer idReco) {
        this.idReco = idReco;
    }

    public int getNumSS() {
        return numSS;
    }

    public void setNumSS(int numSS) {
        this.numSS = numSS;
    }

    public int getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(int numColegiado) {
        this.numColegiado = numColegiado;
    }

    public Date getFechaReco() {
        return fechaReco;
    }

    public void setFechaReco(Date fechaReco) {
        this.fechaReco = fechaReco;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReco != null ? idReco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recomendaciones)) {
            return false;
        }
        Recomendaciones other = (Recomendaciones) object;
        if ((this.idReco == null && other.idReco != null) || (this.idReco != null && !this.idReco.equals(other.idReco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.Recomendaciones[ idReco=" + idReco + " ]";
    }
    
}
