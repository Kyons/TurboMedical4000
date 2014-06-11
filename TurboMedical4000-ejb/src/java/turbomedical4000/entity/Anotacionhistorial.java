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
@Table(name = "anotacionhistorial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anotacionhistorial.findAll", query = "SELECT a FROM Anotacionhistorial a"),
    @NamedQuery(name = "Anotacionhistorial.findByIdAnotacionHistorial", query = "SELECT a FROM Anotacionhistorial a WHERE a.idAnotacionHistorial = :idAnotacionHistorial"),
    @NamedQuery(name = "Anotacionhistorial.findByFecha", query = "SELECT a FROM Anotacionhistorial a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Anotacionhistorial.findByHora", query = "SELECT a FROM Anotacionhistorial a WHERE a.hora = :hora"),
    @NamedQuery(name = "Anotacionhistorial.findByAnotacion", query = "SELECT a FROM Anotacionhistorial a WHERE a.anotacion = :anotacion")})
public class Anotacionhistorial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAnotacionHistorial")
    private Integer idAnotacionHistorial;
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
    @Size(min = 1, max = 130)
    @Column(name = "Anotacion")
    private String anotacion;
    @JoinColumn(name = "LineaHistorial_idLineaHistorial", referencedColumnName = "idLineaHistorial")
    @ManyToOne(optional = false)
    private Lineahistorial lineaHistorialidLineaHistorial;

    public Anotacionhistorial() {
    }

    public Anotacionhistorial(Integer idAnotacionHistorial) {
        this.idAnotacionHistorial = idAnotacionHistorial;
    }

    public Anotacionhistorial(Integer idAnotacionHistorial, Date fecha, Date hora, String anotacion) {
        this.idAnotacionHistorial = idAnotacionHistorial;
        this.fecha = fecha;
        this.hora = hora;
        this.anotacion = anotacion;
    }

    public Integer getIdAnotacionHistorial() {
        return idAnotacionHistorial;
    }

    public void setIdAnotacionHistorial(Integer idAnotacionHistorial) {
        this.idAnotacionHistorial = idAnotacionHistorial;
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

    public String getAnotacion() {
        return anotacion;
    }

    public void setAnotacion(String anotacion) {
        this.anotacion = anotacion;
    }

    public Lineahistorial getLineaHistorialidLineaHistorial() {
        return lineaHistorialidLineaHistorial;
    }

    public void setLineaHistorialidLineaHistorial(Lineahistorial lineaHistorialidLineaHistorial) {
        this.lineaHistorialidLineaHistorial = lineaHistorialidLineaHistorial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnotacionHistorial != null ? idAnotacionHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anotacionhistorial)) {
            return false;
        }
        Anotacionhistorial other = (Anotacionhistorial) object;
        if ((this.idAnotacionHistorial == null && other.idAnotacionHistorial != null) || (this.idAnotacionHistorial != null && !this.idAnotacionHistorial.equals(other.idAnotacionHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.Anotacionhistorial[ idAnotacionHistorial=" + idAnotacionHistorial + " ]";
    }
    
}
