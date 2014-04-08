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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByNumSS", query = "SELECT p FROM Paciente p WHERE p.numSS = :numSS"),
    @NamedQuery(name = "Paciente.findByDni", query = "SELECT p FROM Paciente p WHERE p.dni = :dni"),
    @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paciente.findByFechaNac", query = "SELECT p FROM Paciente p WHERE p.fechaNac = :fechaNac"),
    @NamedQuery(name = "Paciente.findByDireccion", query = "SELECT p FROM Paciente p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Paciente.findByLocalidad", query = "SELECT p FROM Paciente p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Paciente.findByProvincia", query = "SELECT p FROM Paciente p WHERE p.provincia = :provincia"),
    @NamedQuery(name = "Paciente.findByTelefono", query = "SELECT p FROM Paciente p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Paciente.findByContrasena", query = "SELECT p FROM Paciente p WHERE p.contrasena = :contrasena")})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numSS")
    private Integer numSS;
    @Size(max = 45)
    @Column(name = "Dni")
    private String dni;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "FechaNac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Size(max = 45)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "Localidad")
    private String localidad;
    @Size(max = 45)
    @Column(name = "Provincia")
    private String provincia;
    @Size(max = 45)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "Contrasena")
    private String contrasena;
    @JoinTable(name = "paciente_has_medico", joinColumns = {
        @JoinColumn(name = "Paciente_numSS", referencedColumnName = "numSS")}, inverseJoinColumns = {
        @JoinColumn(name = "Medico_numColegiado", referencedColumnName = "numColegiado")})
    @ManyToMany
    private Collection<Medico> medicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientenumSS")
    private Collection<Cita> citaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientenumSS")
    private Collection<Lineahistorial> lineahistorialCollection;

    public Paciente() {
    }

    public Paciente(Integer numSS) {
        this.numSS = numSS;
    }

    public Integer getNumSS() {
        return numSS;
    }

    public void setNumSS(Integer numSS) {
        this.numSS = numSS;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @XmlTransient
    public Collection<Medico> getMedicoCollection() {
        return medicoCollection;
    }

    public void setMedicoCollection(Collection<Medico> medicoCollection) {
        this.medicoCollection = medicoCollection;
    }

    @XmlTransient
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Collection<Cita> citaCollection) {
        this.citaCollection = citaCollection;
    }

    @XmlTransient
    public Collection<Lineahistorial> getLineahistorialCollection() {
        return lineahistorialCollection;
    }

    public void setLineahistorialCollection(Collection<Lineahistorial> lineahistorialCollection) {
        this.lineahistorialCollection = lineahistorialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSS != null ? numSS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.numSS == null && other.numSS != null) || (this.numSS != null && !this.numSS.equals(other.numSS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turbomedical4000.entity.Paciente[ numSS=" + numSS + " ]";
    }
    
}
