/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turbomedical4000.entity;

import java.io.Serializable;
import java.util.Collection;
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
 * @author Sihame
 */
@Entity
@Table(name = "tipoformulario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoformulario.findAll", query = "SELECT t FROM Tipoformulario t"),
    @NamedQuery(name = "Tipoformulario.findByIdTipoFormulario", query = "SELECT t FROM Tipoformulario t WHERE t.idTipoFormulario = :idTipoFormulario"),
    @NamedQuery(name = "Tipoformulario.findByTipo", query = "SELECT t FROM Tipoformulario t WHERE t.tipo = :tipo")})
public class Tipoformulario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoFormulario")
    private Integer idTipoFormulario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoFormularioidTipoFormulario")
    private Collection<Formulario> formularioCollection;

    public Tipoformulario() {
    }

    public Tipoformulario(Integer idTipoFormulario) {
        this.idTipoFormulario = idTipoFormulario;
    }

    public Tipoformulario(Integer idTipoFormulario, String tipo) {
        this.idTipoFormulario = idTipoFormulario;
        this.tipo = tipo;
    }

    public Integer getIdTipoFormulario() {
        return idTipoFormulario;
    }

    public void setIdTipoFormulario(Integer idTipoFormulario) {
        this.idTipoFormulario = idTipoFormulario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Formulario> getFormularioCollection() {
        return formularioCollection;
    }

    public void setFormularioCollection(Collection<Formulario> formularioCollection) {
        this.formularioCollection = formularioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoFormulario != null ? idTipoFormulario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoformulario)) {
            return false;
        }
        Tipoformulario other = (Tipoformulario) object;
        if ((this.idTipoFormulario == null && other.idTipoFormulario != null) || (this.idTipoFormulario != null && !this.idTipoFormulario.equals(other.idTipoFormulario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.Tipoformulario[ idTipoFormulario=" + idTipoFormulario + " ]";
    }
    
}
