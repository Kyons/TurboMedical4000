/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbomedical4000.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "lineahistorial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineahistorial.findAll", query = "SELECT l FROM Lineahistorial l"),
    @NamedQuery(name = "Lineahistorial.findByIdLineaHistorial", query = "SELECT l FROM Lineahistorial l WHERE l.idLineaHistorial = :idLineaHistorial"),
    @NamedQuery(name = "Lineahistorial.findByFecha", query = "SELECT l FROM Lineahistorial l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "Lineahistorial.findByHora", query = "SELECT l FROM Lineahistorial l WHERE l.hora = :hora"),
    @NamedQuery(name = "Lineahistorial.findByUsuario", query = "SELECT l FROM Lineahistorial l WHERE l.pacientenumSS = :usuario"),
    @NamedQuery(name = "Lineahistorial.findByEntrada", query = "SELECT l FROM Lineahistorial l WHERE l.entrada = :entrada")})
public class Lineahistorial implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineaHistorialidLineaHistorial")
    private Collection<Anotacionhistorial> anotacionhistorialCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLineaHistorial")
    private Integer idLineaHistorial;
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
    @Column(name = "Entrada")
    private String entrada;
    @JoinColumn(name = "Medico_numColegiado", referencedColumnName = "numColegiado")
    @ManyToOne(optional = false)
    private Medico mediconumColegiado;
    @JoinColumn(name = "Paciente_numSS", referencedColumnName = "numSS")
    @ManyToOne(optional = false)
    private Paciente pacientenumSS;

    public Lineahistorial() {
    }

    public Lineahistorial(Integer idLineaHistorial) {
        this.idLineaHistorial = idLineaHistorial;
    }

    public Lineahistorial(Integer idLineaHistorial, Date fecha, Date hora, String entrada) {
        this.idLineaHistorial = idLineaHistorial;
        this.fecha = fecha;
        this.hora = hora;
        this.entrada = entrada;
    }

    public Integer getIdLineaHistorial() {
        return idLineaHistorial;
    }

    public void setIdLineaHistorial(Integer idLineaHistorial) {
        this.idLineaHistorial = idLineaHistorial;
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

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
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
        hash += (idLineaHistorial != null ? idLineaHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineahistorial)) {
            return false;
        }
        Lineahistorial other = (Lineahistorial) object;
        if ((this.idLineaHistorial == null && other.idLineaHistorial != null) || (this.idLineaHistorial != null && !this.idLineaHistorial.equals(other.idLineaHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.Lineahistorial[ idLineaHistorial=" + idLineaHistorial + " ]";
    }

    @XmlTransient
    public Collection<Anotacionhistorial> getAnotacionhistorialCollection() {
        return anotacionhistorialCollection;
    }

    public void setAnotacionhistorialCollection(Collection<Anotacionhistorial> anotacionhistorialCollection) {
        this.anotacionhistorialCollection = anotacionhistorialCollection;
    }
    
}
