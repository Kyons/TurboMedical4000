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
@Table(name = "alertas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alertas.findAll", query = "SELECT a FROM Alertas a"),
    @NamedQuery(name = "Alertas.findByIdAlerta", query = "SELECT a FROM Alertas a WHERE a.idAlerta = :idAlerta"),
    @NamedQuery(name = "Alertas.findByNumSS", query = "SELECT a FROM Alertas a WHERE a.numSS = :numSS"),
    @NamedQuery(name = "Alertas.findByNumColegiado", query = "SELECT a FROM Alertas a WHERE a.numColegiado = :numColegiado"),
    @NamedQuery(name = "Alertas.findByFechaAlerta", query = "SELECT a FROM Alertas a WHERE a.fechaAlerta = :fechaAlerta"),
    @NamedQuery(name = "Alertas.findByTexto", query = "SELECT a FROM Alertas a WHERE a.texto = :texto"),
    @NamedQuery(name = "Alertas.findByHora", query = "SELECT a FROM Alertas a WHERE a.hora = :hora")})
public class Alertas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAlerta")
    private Integer idAlerta;
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
    @Column(name = "FechaAlerta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlerta;
    @Size(max = 45)
    @Column(name = "Texto")
    private String texto;
    @Column(name = "Hora")
    @Temporal(TemporalType.TIME)
    private Date hora;

    public Alertas() {
    }

    public Alertas(Integer idAlerta) {
        this.idAlerta = idAlerta;
    }

    public Alertas(Integer idAlerta, int numSS, int numColegiado, Date fechaAlerta) {
        this.idAlerta = idAlerta;
        this.numSS = numSS;
        this.numColegiado = numColegiado;
        this.fechaAlerta = fechaAlerta;
    }

    public Integer getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Integer idAlerta) {
        this.idAlerta = idAlerta;
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

    public Date getFechaAlerta() {
        return fechaAlerta;
    }

    public void setFechaAlerta(Date fechaAlerta) {
        this.fechaAlerta = fechaAlerta;
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
        hash += (idAlerta != null ? idAlerta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alertas)) {
            return false;
        }
        Alertas other = (Alertas) object;
        if ((this.idAlerta == null && other.idAlerta != null) || (this.idAlerta != null && !this.idAlerta.equals(other.idAlerta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.Alertas[ idAlerta=" + idAlerta + " ]";
    }
    
}
