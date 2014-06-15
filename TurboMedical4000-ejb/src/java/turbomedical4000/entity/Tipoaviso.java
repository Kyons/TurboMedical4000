/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tomás
 */
@Entity
@Table(name = "tipoaviso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoaviso.findAll", query = "SELECT t FROM Tipoaviso t"),
    @NamedQuery(name = "Tipoaviso.findByIdTipoAviso", query = "SELECT t FROM Tipoaviso t WHERE t.idTipoAviso = :idTipoAviso"),
    @NamedQuery(name = "Tipoaviso.findByTipo", query = "SELECT t FROM Tipoaviso t WHERE t.tipo = :tipo")})
public class Tipoaviso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoAviso")
    private Integer idTipoAviso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAvisoidTipoAviso")
    private List<Avisomedico> avisomedicoList;

    public Tipoaviso() {
    }

    public Tipoaviso(Integer idTipoAviso) {
        this.idTipoAviso = idTipoAviso;
    }

    public Tipoaviso(Integer idTipoAviso, String tipo) {
        this.idTipoAviso = idTipoAviso;
        this.tipo = tipo;
    }

    public Integer getIdTipoAviso() {
        return idTipoAviso;
    }

    public void setIdTipoAviso(Integer idTipoAviso) {
        this.idTipoAviso = idTipoAviso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Avisomedico> getAvisomedicoList() {
        return avisomedicoList;
    }

    public void setAvisomedicoList(List<Avisomedico> avisomedicoList) {
        this.avisomedicoList = avisomedicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAviso != null ? idTipoAviso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoaviso)) {
            return false;
        }
        Tipoaviso other = (Tipoaviso) object;
        if ((this.idTipoAviso == null && other.idTipoAviso != null) || (this.idTipoAviso != null && !this.idTipoAviso.equals(other.idTipoAviso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.Tipoaviso[ idTipoAviso=" + idTipoAviso + " ]";
    }
    
}
